package solver;

import java.util.ArrayList;

public class BackwardsChaining {

	public Problem problem;
	private ArrayList<String> returns;
	public BackwardsChaining(Problem a){
		problem = a;
		returns = new ArrayList<String>();
	}
	public Boolean RunBackwardsChaining(String query){
		
		for (int i =0; i< problem.assertions.size(); i++){						//checks if the query matches an assertion
			if (problem.query == problem.assertions.get(i).getOperand()){
				System.out.println(problem.assertions.get(i).getOperand());
				returns.add(problem.assertions.get(i).getOperand());
				return true;
			}
		}
		for (int i =0; i< problem.rules.size(); i++){							//checks if query is not the result of a rule
			if (problem.query == problem.rules.get(i).getRightOperand()){
				returns.add(problem.rules.get(i).getLeftOperand()+ problem.rules.get(i).getOperator()+ problem.rules.get(i).getRightOperand());
				RunBackwardsChaining(problem.rules.get(i).getLeftOperand());
			}
		}
		return false;
	}
	public void PrintBackwardsChain(){
		int i = 0;
		String result = "";
		
		if (returns.size() > 0){
			
			while (i < returns.size()){
				result = result + " " + returns.get(i) + ",";
				i = i + 1;
			}
			System.out.println("YES: " + result + problem.query);
		}
		else
		{
			System.out.println("NO");
		}
		
	}
	
}
