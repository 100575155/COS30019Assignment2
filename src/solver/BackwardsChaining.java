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
		//query =  query.replaceAll("\\s+","");
		
		for (int i =0; i< problem.assertions.size(); i++){						//checks if the query matches an assertion
			
			//System.out.println(query);
			//System.out.println(problem.assertions.get(i).getOperand());
			//System.out.println(problem.query == problem.assertions.get(i).getOperand());
			if (query.equals(problem.assertions.get(i).getOperand())){
				System.out.println(problem.assertions.get(i).getOperand());
				returns.add(problem.assertions.get(i).getOperand());
				return true;
			}
		}
		for (int i =0; i< problem.rules.size(); i++){							//checks if query is not the result of a rule
			
			if (query.equals(problem.rules.get(i).getRightOperand())){
				returns.add(problem.rules.get(i).getLeftOperand());
				
				//System.out.println("Right: " +problem.rules.get(i).getRightOperand());
				//System.out.println("Left: "+problem.rules.get(i).getLeftOperand());
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
