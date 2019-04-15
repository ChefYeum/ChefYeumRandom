public class Field {
	private int value;
	final boolean initial; //why immutable? (final)
	
	public Field(){
		this.initial = false;
	}
	public Field(int n, boolean init) {
		this.value = n;
		this.initial = init;
		
	}
	
	public int getValue() {
		return this.value;
	}
	public void setValue(int n) {
		this.value = n;
	}
	public boolean isInitial() {
		return this.initial;
	}
	
	public String toString() {
		if (this.initial) return (this.value + "'");
		else return (Integer.toString(this.value));
	}
}
