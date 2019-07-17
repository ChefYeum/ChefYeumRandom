public class BinaryWff{
	
	private PropVar left;
	private PropVar right;
	private Operator operator;


	public BinaryWff(PropVar left, PropVar right){
		this.left = left;
		this.right = right;	
	}
	
	public void setOp(Operator op){
		this.operator = op;		
	}
	
	public Operator getOp(){
		return this.operator;
	}

	public PropVar getLeft(){
		return this.left;
	}
	
	public PropVar getRight(){
		return this.right;
	}
	
	public String toString(){
		return (this.left.toString() + this.operator.toString() + this.right.toString());
	}

}
