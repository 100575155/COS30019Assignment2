package solver;
import java.util.*;

public class ForwardsChaining {

	public static List<String> rules; // Temporary, will change once problem is implemented.
	public static List<String> assertions; // Temporary, will change once problem is implemented.
	public static List<String> entails;
	public static List<Integer> count;
	public static String KB;
	public static String query;
	
	public ForwardsChaining(String q, String kb){ 	// currently takes in query and kb directly, will be changed to problem
		rules = new ArrayList<String>();			// once bugs in sanitation and data structure have been ironed out.
		assertions = new ArrayList<String>();
		entails = new ArrayList<String>();
		count = new ArrayList<Integer>();
		KB = kb;
		query = q;
		
		PopulateLists(KB); // will not be necessary once problem is implemented.
	}
 
	// populates lists (similar to create problem but lacks sanitation, will be changed once bugs have been fixed.)
	public static void PopulateLists(String KB){ 
		String[] clausesList = KB.split(";");
		int i = 0;
		
		while ( i < clausesList.length){
			if (!clausesList[i].contains("=>")){ 
				rules.add(clausesList[i]);
			}
			else
			{
				assertions.add(clausesList[i]);
				count.add(clausesList[i].split("&").length);
			}
			i = i + 1;
		}
	}
 
	// forward chaining
	public boolean RunForwardsChaining(){
		while(rules.size() > 0){
			String r = rules.remove(0);
			entails.add(r);
			int i = 0;
			
			while ( i < assertions.size() ){
				if (CheckQueryExists(assertions.get(i), r)){
					int temp = count.get(i);
					count.set(i, temp = temp - 1);
					if (count.get(i) == 0){ // Checks conjunction
						String rightOperand = assertions.get(i).split("=>")[1];
						if (rightOperand.equals(query)){ // Checks query entailment
							return true;
						}
						rules.add(rightOperand);					
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
			
			while (i < entails.size()){
				result = result + " " + entails.get(i) + ",";
				i = i + 1;
			}
			result = result + " " + query;
		}
		else
		{
			result = "NO";
		}
		return result;		
	}
}
