package solver;
public class Assertion {

	private String operand;
	public Assertion(String input){
		operand = input.replaceAll("\\s+","");
		//System.out.println(operand);
	}
	public String getOperand(){
		return this.operand;
	}
}
