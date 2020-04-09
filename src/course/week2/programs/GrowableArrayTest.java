package course.week2.programs;

public class GrowableArrayTest {
	
	public static void main(String[] args) {
		
		GrowableArray gr = new GrowableArray();
		
		for(int i= 0; i<11; i++) {
			gr.add(i);
		}
		
		System.out.println(gr);
		System.out.println(gr.size());
		
	}

}
