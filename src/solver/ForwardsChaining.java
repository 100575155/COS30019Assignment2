package solver;
import java.util.*;

public class ForwardsChaining {

	public static List<String> assertions;
	public static List<String> rules;
	public static List<String> returns;
	public static List<Integer> count;
	public Problem problem;
	
	public ForwardsChaining(Problem a){
		assertions = new ArrayList<String>();
		rules = new ArrayList<String>();
		returns = new ArrayList<String>();
		count = new ArrayList<Integer>();
		problem = a;
		PopulateLists();
	}
 
	// populates lists
	public void PopulateLists(){ 
		int i = 0;
		int n = 0;
		
		while (n < problem.assertions.size()){
			assertions.add(problem.assertions.get(n).getOperand());
			n = n + 1;
		}
		
		while ( i < problem.rules.size()){
			rules.add(problem.rules.get(i).getLeftOperand() + problem.rules.get(i).getOperator() + problem.rules.get(i).getRightOperand());
			count.add(problem.rules.get(i).getLeftOperand().split("&").length);
			i = i + 1;
		}
	}
 
	// forward chaining
	public boolean RunForwardsChaining(){
		while(assertions.size() > 0){
			String r = assertions.remove(0);
			returns.add(r);
			int i = 0;
			
			while ( i < rules.size() ){
				if (CheckQueryExists(rules.get(i), r)){
					int tempcount = count.get(i);
					count.set(i, tempcount = tempcount - 1);
					if (count.get(i) == 0){ // Checks conjunction
						String rightOperand = problem.rules.get(i).getRightOperand();
						if (rightOperand.equals(problem.query)){
							return true;
						}
						assertions.add(rightOperand);					
					}
				}
				i = i + 1;
			}
		}
		return false; // forward chaining is not possible
	}
	
	// checks to see if r exists in clause
	public static boolean CheckQueryExists(String clause, String r){
		String leftOperand = clause.split("=>")[0];
		String[] conjunction = leftOperand.split("&");
	
		if (conjunction.length == 1){
			return leftOperand.equals(r);
		}
		else
		{
			return Arrays.asList(conjunction).contains(r);
		}
	}
	
	// creates and returns result as string
	public String GetResult(){
		String result = "";
		
		if (RunForwardsChaining()){ // checks if forward chaining is possible
			result = "YES: ";
			int i = 0;
			
			while (i < returns.size()){
				result = result + " " + returns.get(i) + ",";
				i = i + 1;
			}
			result = result + " " + problem.query;
		}
		else
		{
			result = "NO";
		}
		return result;		
	}
}
