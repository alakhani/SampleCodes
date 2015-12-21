package expressionParser;

public class Wrapper {
	
	public Wrapper(int index, String operand) {
		this.index = index;
		this.operand = operand;
	}
	
	public int index;
	
	public String operand;
	
	public int getIndex() {
		return this.index;
	}
	
	public String getOperand () {
		return this.operand;
	}
}
