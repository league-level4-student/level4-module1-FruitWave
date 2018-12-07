package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	Location head_calculated;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		// 1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
	}

	public Location getHeadLocation() {
		// 2. return the location of the snake's head
		return head.getLocation();
	}

	public void update() {
		// 1. use a switch statement to check on the currentDirection
		// of the snake and calculate its next x and y position.

		switch (currentDirection) {
		case RIGHT:
			head_calculated = new Location(head.getLocation().x + 1, head.getLocation().y);
			break;
		case LEFT:
			head_calculated = new Location(head.getLocation().x - 1, head.getLocation().y);
			break;
		case UP:
			head_calculated = new Location(head.getLocation().x, head.getLocation().y - 1);
			break;
		case DOWN:
			head_calculated = new Location(head.getLocation().x, head.getLocation().y + 1);
			break;
		default:
			break;
		}

		// 2. Iterate through the SnakeSegments in reverse order
		Location prev = head.getLocation();
		for (int i = snake.size(); i >= 0; i--) {
			Location templock = snake.get(i).getLocation();
			snake.get(i).setLocation(prev);
			prev = templock;

		}
		// 2a. Update each snake segment to the location of the segment
		// in front of it.

		// 3. set the location of the head to the new location calculated in step 1
		head.setLocation(head_calculated);
		// 4. set canMove to true
		canMove = true;
	}

	public void setDirection(Direction d) {
		// 1. set the current direction equal to the passed in Direction only if canMove
		// is true.
		if (!((currentDirection == currentDirection.UP) && (d == d.DOWN))
				&& !((currentDirection == currentDirection.DOWN) && (d == d.UP))
				&& !((currentDirection == currentDirection.LEFT) && (d == d.RIGHT))
				&& !((currentDirection == currentDirection.RIGHT) && (d == d.LEFT))) {
			if (canMove) {
				currentDirection = d;
			}
		}

		// set canMove equal to false.
		canMove = false;
		// make sure the snake cannot completely reverse directions.

	}

	public void reset(Location loc) {
		// 1. clear the snake
		snake.clear();
		// 2. set the location of the head
		head.setLocation(new Location(4, 4));
		// 3. add the head to the snake
		snake.add(head);
	}

	public boolean isOutOfBounds() {
		// 1. complete the method so it returns true if the head of the snake is outside
		// of the window
		// and false otherwise
		if ((head.getLocation().x > 15 || head.getLocation().x < 0)
				|| (head.getLocation().y > 12 || head.getLocation().y < 0)) {
			return true;
		}
		return false;
	}

	public boolean isHeadCollidingWithBody() {
		// 1. complete the method so it returns true if the head is located
		// in the same location as any other body segment
		for (SnakeSegment snakeSegment : snake) {
			if (head.getLocation() == snakeSegment.getLocation()) {
				return true;
			}
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		// 1. complete the method so it returns true if the passed in
		// location is located on the snake
		for (SnakeSegment snakeSegment : snake) {
			if (snakeSegment.getLocation() == loc) {
				return true;
			}
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			s.draw(g);
		}
	}
}
