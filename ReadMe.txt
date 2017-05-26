(-----------------Delete this before submission---------------------------------)
You must include a single readme.txt file with your work with the following details:
? Student Details: Your full student names, ids, and your group number (as allocated by ESP).
? Features/Bugs/Missing: Include a list of the features you have implemented. Clearly state if a
required feature has not been implemented. Failure to do this will result in penalties. Include a list of
any known bugs.
? Test cases: The test cases you have developed ton test your program. What bugs have you found?
? Acknowledgements/Resources: Include in your readme.txt file a list of the resources you have
used to create your work. A simple list of URL's is not enough. Include with each entry a basic
description of how the person or website assisted you in your work.
? Notes: Anything else you want to tell the marker, such as how to use the GUI version of your
program, and something particular about your implementation.
? Summary report: Summary of the teamwork in this assignment. You need to clearly indicate who
did what and how each team member gave feedback to other members. In this report, the overall
percentage of contribution by each student to the project has to be clearly specified and summed to
100%.
(-----------------Delete this before submission---------------------------------)


Assignment 2 Report:

Student Details:
- Name: Lachie Hines ID: 101106161
- Name: Bayley Papworth ID: 101102583
- Name: Anthony Tran ID: 100575155
Group ID:
- COS30019_A02_T032

Features/Bugs/Missing:
- Required features added:
  - Forward Chaining:
    - Forward Chaining is implemented and working as we intended. It takes in the test file
      displays the correct output.
	- Within ForwardsChaining.java there are four methods.
	- PopulateLists() adds the data, provided by the Problem data structure, into lists used in ForwardsChaining.
	- RunForwardsChaining() loops through the assertions list, checks for entailment and matches against the query. 
	- CheckQueryExists() checks for a given variable within a given clause.
	- GetResults() returns the output of RunForwardsChaining().
	- Note that a limitation of this function is that unaccounted for special characters can crash due to a lack of 
	  sanitization.

  - Backward Chaining:
    - Backwards chaining is split into two main function along with a constructor.
      - The constructor takes a problem and creates a copy within the class while also initializing
      a list that will print out the finial values.
      - The PrintBackwardsChain function prints all of the values in the returns list.
      - The RunBackwardsChaining takes a query and begins by checking that the query does not match
       any of the assertions (which are the statements that do no have an if) and seeing if they
       match the query if so that value is added to the results. Next the function examines if the
       query is equal to the right side of the rules (statements that posses an if statement) if this
       returns true then the left operand is passed into the RunBackwardsChaining function as the query.
      - Note that a limitation of this function is that "and" statements are not yet handled by the function
       and result in an incorrect answer.


- Required features missing:
  - Truth Table:
    - An attempt at truth tables was made although now working method is implemented.
      We looked at 2 possible ways to implement the Truth Table method and both ways
      are included in the ziped file. The first is the TT-Entails and TT-Check functions
      found via our research. This method looked to work tell although since we didn't
      design the code ourselves we ran into problems enhancing it and applying it to the
      problem. So ultimately we stopped working on that and started from scratch. Our
      understanding of the TT-Entails method is noted in comments in that file. We then
      started working on our second file (TruthTableNew). Having started later then desired
      on this option limited process was made into its application. Again comments are listed
      in the file to show our understanding.

- Bugs:
  - Sanitize (elaborate on bugs <------- (anyone)
  -

Test Cases: Working with different KB and Q? <----- write test cases (anyone)
- test1 (default)
  - Tell: p2=> p3; p3 => p1; c => e; b&e => f; f&g => h; p1=>d; p1&p3 => c; a; b; p2;
  - Ask: d
  - Bugs found in this test:

- test2:
  - Tell: f=> g; c&e => f; r&s => u;c;e;
  - Ask: g
  - Bugs found in this test:

- test3:
  - Tell:
  - Ask:
  - Bugs found in this test:

- test4:
  - Tell:
  - Ask:
  - Bugs found in this test:

Acknowledgements/Resources/Research:
- "Artificial Intelligence: a modern approach, third edition"
  - The textbook helped in regard to Forward and Backwards chaining methods as it listed examples
    of code to follow when implementing the methods.

- TT Entails example from GitHub:
  <https://github.com/chris-verclytte/aimaSudokuSolving/blob/master/aima-core/src/main/java/aima/core/logic/
   propositional/inference/TTEntails.java>
  - For the first attempt at Truth Tables this example helped to give an explanation on how to
    implement the Truth Table method and a good explanation of the code to follow.

- Wikipedia page on Backwards Chaining:
  <https://en.wikipedia.org/wiki/Backward_chaining>
  - Used as a reference and also used for a test case.

- external libraries
  - in the code the use of external libraries helps in implement the various methods. <------ add libraries used in code (either)

- Wikipedia page on Forwards Chaining:
  <https://en.wikipedia.org/wiki/Forward_chaining>
  - Used as a reference and also used for a test case.  
  
- Backward & Forward Chaining explanation video:
  <https://www.youtube.com/watch?v=ZhTt-GG7PiQ>
  - Helped clarify the concept of Backward and Forward Chaining.

- Forward and Backward Chaining explanation slideshow:
  <http://www.iiia.csic.es/~puyol/IAGA/Teoria/07-AgentsLogicsII.pdf>
  - Provided pseudocode for forward chaining algorithm.

Notes:
- In regards to Truth Table implementation
  - Due to time constraints and struggle to understand and find help on the implementation of Truth Table
    algorithm the final Truth Table Submission is below standard. Attempts and process of implementation
    listed above in (Missing Features)

- Anyone other notes??
  - <---------- (either)(delete this if not)

Summary:
- Work Allocation
  - Lachie (Contribution Percentage = 30%)
    - Feedback: The only feedback I gave the other group members was to ensure that their code
                followed the outline of the assignment criteria.

    - Complete work: Truth Table, Report, Main Sanitize inputs, error debugging,

  - Bayley (Contribution Percentage = 35%)
    - Feedback: Helped Lachie with the truth table designing the TruthTableNew class. Reviewed and uploaded Lachie's sanitization code.

    - Complete work: Backwards Chaining, Data Structure, Createproblem method in main, error debugging

  - Anthony (Contribution Percentage = 35%)
    - Feedback: Provided general programming advice and discussed issues with solution.

    - Complete work: Forwards Chaining, Input for File and method selection in main, fixing sanitize regex, error debugging, set up GitHub, Output for FC + BC.
