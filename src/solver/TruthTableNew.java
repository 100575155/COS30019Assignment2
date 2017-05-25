
public class TruthTableNew{

  private String[] sybols;
  private boolean[][] truthTable;
  private String makeFunction(String input){

  }
  private String[] getSymbols(String input){
    String[] strArray =  input.split(); //Regex to split at "=>"+";"+"&"
    Set<String> mySet = new HashSet<String>(Arrays.asList(strArray));
    return mySet
  }
  public void TruthTable(){

  }
  private static void printTruthTable(int n) {    //Taken from : https://stackoverflow.com/questions/10723168/generating-truth-tables-in-java
        int rows = (int) Math.pow(2,sybols.size());
        truthTable = new boolean[rows][rows -1];
        for (int i=0; i<rows; i++) {
            for (int j=n-1; j>=0; j--) {
              truthTable[i][j]= (boolean)(i/(int) Math.pow(2, j))%2;
            }
        }
    }
    public static void main(String[] args) {
        printTruthTable(3); //enter any natural int
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
}
