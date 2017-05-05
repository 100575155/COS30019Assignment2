import java.util.*;
public class Problem {

	private List<String> clauses;
	private String query;
	
	public Problem (String query) 
	{
		this.query = query;
		clauses = new ArrayList<String>();
	}
	public void AddClause(String clause)
	{
		clauses.add(clause);
	}
	public String getQuery() {
		return query;
	}
	public List<String> getClauses() {
		return clauses;
	}

}
