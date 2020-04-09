package course.week2.programs;

public class TestClass {
	
	public static void main(String[] args) {
		Stack stack = new Stack();
		
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack);
		
		System.out.println("Size:  "+stack.size());
		System.out.println("is empty:    "+stack.isEmpty());
		
		stack.pop();
		
		System.out.println(stack);
		
		System.out.println("Size:  "+stack.size());
		System.out.println("is empty:    "+stack.isEmpty());
		
		
	}

}
