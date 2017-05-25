package solver;
public class Rule {

	private String operator;
	private String leftOperand;
	private String rightOperand;
	
	public Rule (String input){
		
			String[] strArray =  input.split("=>");
			//Test
			/*
			for (int i=0; i < strArray.length;i++){
				System.out.println("i: "+strArray[i]);
			}
			*/
			operator = "=>";
			leftOperand = strArray[0];
			rightOperand = strArray[1];
			//System.out.println(strArray[0]);
			//System.out.println(strArray[1]);
	}
	
	public String getLeftOperand(){
		return this.leftOperand;
	}
	public String getRightOperand(){
		return this.rightOperand;
	}
	public String getOperator(){
		return this.operator;
	}
}
