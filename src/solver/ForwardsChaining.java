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
		KB = kb.replaceAll("\\s+","");
		query = q;
		
		PopulateLists(KB);
	}
 
	// populates lists (similar to create problem but lacks sanitation, will be changed once bugs have been fixed.)
	public static void PopulateLists(String KB){ 
		String[] clausesList = KB.split(";");
	   
		for (int i = 0; i < clausesList.length; i = i + 1){
			if (!clausesList[i].contains("=>")){ 
				rules.add(clausesList[i]);
			}
			else
			{
				assertions.add(clausesList[i]);
				count.add(clausesList[i].split("&").length);
			}
		}
	}
 
	// forward chaining
	public boolean RunForwardsChaining(){
		while(!rules.isEmpty()){
			String r = rules.remove(0);
			entails.add(r);
			
			for (int i = 0; i < assertions.size(); i = i + 1){
				if (CheckQueryExists(assertions.get(i), r)){
					Integer temp = count.get(i);
					count.set(i, temp = temp - 1);
					if (count.get(i) == 0){
						String rightOperand = assertions.get(i).split("=>")[1];
						if (rightOperand.equals(query)){ // Checks query entailment
							return true;
						}
						rules.add(rightOperand);					
					}
				}	
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
	
	// creates and returns result
	public String GetResult(){
		String result = "";
		
		if (RunForwardsChaining()){ // checks if forward chaining is possible
			result = "YES: ";
			
			for (int i = 0; i < entails.size(); i = i + 1){
				result += " " + entails.get(i) + ",";
			}
			result += " " + query;	
		}
		else
		{
			result = "NO";
		}
		return result;		
	}
}
