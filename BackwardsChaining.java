
public class BackwardsChaining {

	private Problem problem;
	public BackwardsChaining(Problem a){
		problem = a;
	}
	public Boolean RunBackwardsChaining(String query){
		boolean result;
		for (int i =0; i< problem.assertions.size(); i++){						//checks if the query matches one of the assertions
			if (query == problem.assertions.get(i).getOperand()){
				System.out.println(problem.assertions.get(i).getOperand());
				return true;
			}
		}
		for (int i =0; i< problem.rules.size(); i++){							//checks if query is not the result of a rule
			if (query != problem.rules.get(i).getRightOperand()){
				result = false;
			}else{
				
			}
		}
	}
	private void PrintBackwardsChain(){
		
	}

}
