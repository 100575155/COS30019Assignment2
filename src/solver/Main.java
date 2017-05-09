package solver;
//import java.io.*;
//import java.util.*;

public class Main {

	private static String method;
	private static String fileName;
	
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
		System.out.println(method + " " + fileName); // For testing only
	}
}

