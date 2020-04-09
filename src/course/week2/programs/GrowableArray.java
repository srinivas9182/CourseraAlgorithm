package course.week2.programs;

import java.util.Arrays;

public class GrowableArray {

	private Object[] objArray = new Object[10];
	private int arrSize = 0;

	public void add(Object obj) {
		if (arrSize == objArray.length) {
			this.updateArraySize();
		}
		objArray[arrSize] = obj;
		arrSize++;
	}

	private void updateArraySize() {
		Object[] newArray = new Object[arrSize * 2];
		for (int i = 0; i < objArray.length; i++) {
			newArray[i] = objArray[i];
		}
		objArray = newArray;
		System.gc();
	}
	
	public int size() {
		return objArray.length;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(objArray);
	}

}
