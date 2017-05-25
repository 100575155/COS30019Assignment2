package solver;

import java.util.ArrayList;

public class BackwardsChaining {

	private Problem problem;
	private ArrayList<String> returns;
	public BackwardsChaining(Problem a){
		problem = a;
		returns = new ArrayList<String>();
	}
	public Boolean RunBackwardsChaining(String query){
		
		for (int i =0; i< problem.assertions.size(); i++){						//checks if the query matches an assertion
			if (query == problem.assertions.get(i).getOperand()){
				System.out.println(problem.assertions.get(i).getOperand());
				returns.add(problem.assertions.get(i).getOperand());
				return true;
			}
		}
		for (int i =0; i< problem.rules.size(); i++){							//checks if query is not the result of a rule
			if (query == problem.rules.get(i).getRightOperand()){
				System.out.println(problem.rules.get(i));
				RunBackwardsChaining(problem.rules.get(i).getLeftOperand());
			}
		}
		return false;
	}
	public void PrintBackwardsChain(){

			System.out.println(returns);
		
	}

}
