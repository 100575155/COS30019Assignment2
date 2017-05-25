
public class TruthTableNew{
  private String makeFunction(String input){

  }
  private String[] getSymbols(String input){
    String[] strArray =  input.split(); //Regex to split at "=>"+";"+"&"
    Set<String> mySet = new HashSet<String>(Arrays.asList(strArray));
    return mySet
  }

}
// Function when => found to change to If (example X => Y)
// X if Y.... X = Y

function EqIf (Boolean x, Boolean y) // takes either side of (if/=>) and work out boolean
  if (y == true) && (x == true){
    return true;
  }
  else if (y == false) && (x == true){
    return false;
  }
  else if(y == true) && (x == false){
    return true;
  }
  else {
    return true;
  }


// Function to combine with AND/&&

function ChAnd (Boolean x, Boolean y) // takes either side of (&&/and) and works out boolean
  if (x = true) && (y == true){
    return true
  }
  else {
    return false;
  }

