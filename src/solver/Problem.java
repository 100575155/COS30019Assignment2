import java.util.*;
public class Problem {

	public List<Rule> rules;			//ie) i=>k
	public List<Assertion> assertions;		//ie) k
	public String query;
	
	public Problem (String query) 
	{
		this.query = query;
		rules = new ArrayList<Rule>();
	}
	public void AddClause(String clause)
	{
		if (clause.matches("(.*)=>(.*)")){
			rules.add(new Rule(clause));
		}else{
			assertions.add(new Assertion(clause));
		}
	}


}
