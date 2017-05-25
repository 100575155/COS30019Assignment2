package solver;
public class Assertion {

	private String operand;
	public Assertion(String input){
		operand = input;
		//System.out.println(operand);
	}
	public String getOperand(){
		return this.operand;
	}
}
