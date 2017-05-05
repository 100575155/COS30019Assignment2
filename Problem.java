import java.util.*;
public class Problem {

	private List<String> clauses;	//List of clauses
	private String query;
	
	public Problem (String query) 			//NOTE: Query passed into the datastructure at construction
	{
		this.query = query;
		clauses = new ArrayList<String>();
	}
	public void AddClause(String clause)		//Does what is says
	{
		clauses.add(clause);
	}
	//Getters and setters
	public String getQuery() 
	{
		return query;
	}
	public List<String> getClauses() 
	{
		return clauses;
	}

}
