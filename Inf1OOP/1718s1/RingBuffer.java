/*
Buffer is used to temporarily store data while it is being moved from one place to the other
 
 RingBuffer:
 	- is filled with data by adding to the back and emptied by removing from the front
 	- wraps saved data entries around the end of the underlying array
 	- does that by keeping track of the location of the initial data entry in the buffer and the location of the last data entry
 
 
 When the buffer is empty, both Start and End markers point to the same array index. 
 The same is true if the buffer contains a single element
 */



public class RingBuffer extends Buffer {
	private int start;
	private int end;
	private int elementCount;//Amount of valid data currently stored
	public RingBuffer(int capacity) {
		super(capacity);
		this.elementCount = 0;
	}
	public RingBuffer() {
		super(10); //Default capcity of 10
		this.elementCount = 0;
	}
	
	public boolean isFull() {
		return (this.elementCount == super.buffer.length);
	}
	
	public boolean isEmpty() {
		return (this.elementCount == 0);
	}
	
	public void clear() {
		super.clear();
		this.start = 0;
		this.end = 0;
		this.elementCount = 0;
	}
	
	public void addToBuffer(int newNum) {
		if (this.isFull()) System.out.println("Buffer is full.\n");
		else if (this.end == super.buffer.length-1 || this.isEmpty()) {
			//if the end-point is at the end or if the buffer is empty, put the number at the start 
			end = 0;
			super.buffer[0] = newNum;
			this.elementCount++;
		} else {
			end++;
			super.buffer[end] = newNum;
			this.elementCount++;
		}
		
	}
	
	public int getFromBuffer() {
		if (this.isEmpty()) {
			System.out.println("Buffer is empty.\n");
			return -1;
		} else if (this.start == this.end) {
			int temp = super.buffer[start];
			super.buffer[start] = -1;
			this.elementCount--;
			return temp;
		} else if (this.start == super.buffer.length-1) {
			int temp = super.buffer[start];
			super.buffer[start] = -1;
			this.start = 0;
			this.elementCount--;
			return temp;
		} else {
			int temp = super.buffer[this.start];
			super.buffer[this.start] = -1;
			this.start++;
			this.elementCount--;
			return temp;
		}
	}
	

	
}
