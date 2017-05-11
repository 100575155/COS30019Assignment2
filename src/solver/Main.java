package solver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
		System.out.println(method + " " + clauses + " " + query); // For testing only
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
			
			//checks for TELL
			currentLine = puzzle.readLine();
			if(currentLine.equals("TELL")){
				
				currentLine = puzzle.readLine(); //fill in the clauses
				clauses = currentLine;
				
				currentLine = puzzle.readLine(); //checks for ASK
				if(currentLine.equals("ASK")){
					currentLine = puzzle.readLine(); //fill in the query
					query = currentLine;
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
}

