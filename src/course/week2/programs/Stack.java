package course.week2.programs;

import java.util.EmptyStackException;

public class Stack {

	private int length;
	private NodeClass top;

	public Stack() {
		length = 0;
		top = null;
	}

	public void push(int data) {
		NodeClass ns = new NodeClass(data);
		ns.setNext(top);
		top = ns;
		length++;
	}

	public boolean isEmpty() {
		return (length == 0);
	}

	public int pop() throws EmptyStackException {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		int response = top.getData();
		top = top.getNext();
		length--;
		return response;
	}

	public int size() {
		return length;
	}

	public String toString() {
		String str = "";
		NodeClass ns = top;
		while (ns != null) {
			str = str + ns.toString() + " ->>";
			ns = ns.getNext();
		}
		return str;
	}

}
