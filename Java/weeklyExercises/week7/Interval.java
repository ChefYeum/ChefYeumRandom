public class Interval{
	public double left;
	public double right;

	public Interval(double left, double right){
		this.left = left;
		this.right = right;		
	}

	public boolean doesContain(double x){
		return (this.left <= x) && (x <= this.right);	
	}

	public boolean isEmpty(){
		return (this.left > this.right);
	}
	public boolean intersects(Interval b){
		return (this.doesContain(b.left) || this.doesContain(b.right)) && !(this.isEmpty() || b.isEmpty());
	}
	public String toString(){
		return ("Interval: " + (this.isEmpty() ? "(EMPTY)" : "["+this.left+","+this.right+"]"));
	}
}
