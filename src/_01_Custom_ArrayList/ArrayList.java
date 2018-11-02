package _01_Custom_ArrayList;

import java.util.Stack;

@SuppressWarnings("unchecked")

public class ArrayList<T> {
	Stack<T> stacked = new Stack<>();

	public ArrayList() {

	}

	public T get(int loc) throws IndexOutOfBoundsException {
		return stacked.get(loc);
	}

	public void add(T val) {
		stacked.push(val);
	}

	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		stacked.insertElementAt(val, loc);
	}

	public void set(int loc, T val) throws IndexOutOfBoundsException {
		stacked.set(loc, val);
	}

	public void remove(int loc) throws IndexOutOfBoundsException {
		stacked.remove(loc);
	}

	public boolean contains(T val) {
		if (stacked.contains(val)) {
			return true;
		}
		return false;
	}

	public int size() {
		return stacked.size();
	}
}