
public class TruthTableNew{
  private String makeFunction(String input){

  }
  private String[] getSymbols(String input){
    String[] strArray =  input.split(); //Regex to split at "=>"+";"+"&"
    Set<String> mySet = new HashSet<String>(Arrays.asList(strArray));
    return mySet
  }

}
