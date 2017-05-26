package solver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
//import java.io.*;
//import java.util.*;

public class Main {

	private static String method;
	private static String fileName;
	private static String clauses;
	private static String query;
	
	public static void main(String[] args){

		//args contains:
		//  [0] - method name
		//  [1] - filename
		
		if(args.length < 2) { // Checks the length of the console input.
			
			System.out.println("Usage: iengine <method> <filename>.");
			System.exit(1); // Exits runtime if condition is not met.
			
		}
		
		method = args[0];
		fileName = args[1];
		System.out.println(readProblemFile(fileName));
		InitMethods();
	}
	
	private static void InitMethods()
	{
		switch(method){
			case "TT":{
				System.out.println("Truth Table"); // For testing only
				break;
			}
			case "FC":{
                ForwardsChaining Testcase = new ForwardsChaining(CreateProblem());
				System.out.println(Testcase.GetResult());
				break;
			}
			case "BC":{
				System.out.println("Backwards Chaining"); // For testing only
				BackwardsChaining Testcase = new BackwardsChaining(CreateProblem());
				Testcase.RunBackwardsChaining(Testcase.problem.query);
				Testcase.PrintBackwardsChain();
				
				break;
			}
			default : {
				System.out.println("Method not found.");
				System.exit(1); // Exits runtime if condition is not met.
			}
		}
	}
	
	private static String readProblemFile(String fileName) // this allow only one puzzle to be specified in a problem file 
	{
		
		try
		
		{
			
			//create file reading objects
			FileReader reader = new FileReader(fileName);
			BufferedReader puzzle = new BufferedReader(reader);
			String result;
			String currentLine;
			
			//checks for TELL (knowledge base)
			currentLine = puzzle.readLine();
			currentLine = currentLine.replaceAll("\\s+","");
			if(currentLine.equals("TELL")){
				
				currentLine = puzzle.readLine(); //fill in the clauses
				clauses = currentLine.replaceAll("\\s+","");
				
				currentLine = puzzle.readLine(); //checks for ASK(propositional symbol)
				currentLine = currentLine.replaceAll("\\s+","");
				if(currentLine.equals("ASK")){
					currentLine = puzzle.readLine(); //fill in the query
					query = currentLine.replaceAll("\\s+","");;
				}
				else
				{
					System.out.println("Error found in file. ASK String not found.");
					System.exit(1);
				}
				
				
				//File read confirmation
				result = "File Read Completed";
				
				puzzle.close();
				return result;
				
			}
			else
			{
				System.out.println("Error found in file. TELL String not found.");
				System.exit(1);
			}
			puzzle.close();
		}
		catch(FileNotFoundException ex)
		{
			//The file didn't exist, show an error
			System.out.println("Error: File \"" + fileName + "\" not found.");
			System.out.println("Please check the path to the file.");
			System.exit(1);
		}
		catch(IOException ex)
		{
			//There was an IO error, show and error message
			System.out.println("Error in reading \"" + fileName + "\". Try closing it and programs that may be accessing it.");
			System.out.println("If you're accessing this file over a network, try making a local copy.");
			System.exit(1);
		}
		//this code should be unreachable. This statement is simply to satisfy Eclipse.
		return null;
	}
	
	private static Problem CreateProblem(){
		Problem A = new Problem(query);
		String[] clausesList = clauses.split(";");
		int i = 0;
		
		while ( i < clausesList.length){
			//if(SanatizeInputs(clausesList[i])){
			
			A.AddClause(clausesList[i]);
			//System.out.println(clausesList[i]);
			i = i + 1;
			//}
			//else
			//{
			//	System.out.println("Input data does not match required format. " + clausesList[i]);
			//	System.exit(1);
			//}
		}
		return A;
	}
//	private static boolean SanatizeInputs(String input){
//		String regex = "([a-zA-Z0-9]?=>)?&?[a-zA-Z0-9]+;?";
//		return Pattern.matches(regex, input);
//	}
}

