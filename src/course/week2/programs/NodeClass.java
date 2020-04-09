package course.week2.programs;

public class NodeClass {
	
	public int data;
	public NodeClass next;
	public NodeClass(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public NodeClass getNext() {
		return next;
	}
	public void setNext(NodeClass next) {
		this.next = next;
	}
	
	
	public String toString() {
		return data + " ==>> ";
	}
	
	

}
