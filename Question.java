/**
 * 
 */
package exam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author super
 * Date: 11-01-2018
 * QUestion:	In this programming challenge, you will create a simple trivia game for two players.
			 *  The program will work like this: 
			 *  •	Starting	with	player	1,	each	player	gets	a	turn	at	answering	5	trivia	questions.	
			 *  (There	are 10 questions, 5 for each player.) *  When a question is displayed, four possible answers are also displayed. 
			 *  Only one of the answers is correct, and if the player selects the correct answer, he or she earns a point. 
			 *  •	After	answers	have	been	selected	for	all	of	the	questions,	the	program	displays * 
			 *  the	number of points earned by each player and declares the player with the highest number of points the winner.
			 *
 *
 *Procudeure: 
		Starting with player 1, each player gets a turn at answering five questions.
		When a question is displayed, four possible answers choice are also displayed. 
		if the player selects the correct answer he or she earns one point.
		After answers have been selected for all of the questions,
	    the program displays the number of points earned by each player and declares 
	    the player with the highest number of points the winner.
		
 */
public class Question {


	public Question() throws IOException {
		// TODO Auto-generated constructor stub
		System.out.print("\t\t\t\t\t\tWelcome to the Trivia Game\n\n");
		System.out.print("\t\t*******************************Player 1 Game Started*****************************\n\n");
		String QuestionArray[]=readFileToArray();
		playerone(QuestionArray);
		playerTwo(QuestionArray);
		printresult();
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	static 		int ScorePlayer1=0;
	static 		int ScorePlayer2=0;

	static Scanner KeyInput=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		try {
			Question WelcomeMessage=new Question();
	
			

	}	
catch(InputMismatchException e)			// Error handeling
		{
	System.out.print("Invalid input! Game Restarted \n");
	KeyInput.nextLine();
	main(args);
	
		}
		catch(FileNotFoundException e) {
			System.out.print("Question File is missing, \nCheck the file location and try again: ");
		}	
		
	}	
		
		/*
		 * THis method read the file with the question and answer then save to the array and return it.
		 */
	public static String[] readFileToArray() throws IOException
	{
	
			
		FileReader fileReader = new FileReader("Questionfile.txt");			//read the filename
        BufferedReader bufferedReader = new BufferedReader(fileReader);		// read file to bufferreader
        List<String> lines = new ArrayList<String>();						//create a list 
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {				//read untill the line ends on the file.
            lines.add(line);
            lines.add("\n");
            
        }
        bufferedReader.close();
         String []filetoarray=lines.toArray(new String[lines.size()]);		//Add the list item to the array 	
         return filetoarray;												//return the array
	
	}
	
	/*
	 * THis method loop within the array from question 1 to 5 for player 1
	 */
	public static void playerone(String[] test)
	{
		int limit=0;
		for(int i=0;i<5;i++) {
			questionPrinter(test, limit,i);
			limit=limit+12;
		}
		System.out.println("\n\t*****************Player 2 Game Started*************************\n");
	}
	
	/*
 	 * THis method loop withing the array from question 6 to 10 for player 2
	 */
	public static void playerTwo(String[] test)
	{
		int numrange=60;
		for(int i=5;i<10;i++) {
			questionPrinter(test, numrange,i);
			numrange = numrange+12;
		}

	}
	/*
	 * this method takes the userinput from the method userAnswer then compare with the true answer and print the score everytime a question is answered
	 */
	public static void scoreCounter(int QuestioNO,int UserAnswer)
	{
		
		if(QuestioNO==0 && UserAnswer==4) ScorePlayer1++;
		else if (QuestioNO==1 && UserAnswer==4) ScorePlayer1++;
		else if (QuestioNO==2 && UserAnswer==1) ScorePlayer1++;
		else if (QuestioNO==3 && UserAnswer==2) ScorePlayer1++;
		else if (QuestioNO==4 && UserAnswer==1) ScorePlayer1++;
		else if (QuestioNO==5 && UserAnswer==1) ScorePlayer2++;
		else if (QuestioNO==6 && UserAnswer==2) ScorePlayer2++;
		else if (QuestioNO==7 && UserAnswer==2) ScorePlayer2++;
		else if (QuestioNO==8 && UserAnswer==3) ScorePlayer2++;
		else if (QuestioNO==9 && UserAnswer==1) ScorePlayer2++;
		else System.out.print(" Wrong Answer ");
		
		System.out.print("\n\n\t\tPlayer 1 Score is "+ScorePlayer1+"\n");
		System.out.print("\t\tPlayer 2 score is "+ScorePlayer2+"\n");
	}
	
	/*
	 * THis method compare the score of the player 1 and player 2 then print the winner.
	 */
	public static void printresult()
	{
		
		if(ScorePlayer1>ScorePlayer2) System.out.print("\n\t\t\t\tPlayer 1 win the game");
		else System.out.print("\n\t\t\t\tPlayer 2 win the game");
	}
	
	
	/*
	 * This method will take the user input as well as check if the user input is in range of 1 to 4 and return the user input if it is on range.
	 */
	
	public static int userAnswer()
	{
		
		int statcheck=-1;
		int userChoice = -1;
		while(!(statcheck==1))		/// THis loop will check if the user input is within the valid range
		{	
			System.out.print("Enter your Choice(1 or 2 or 3 or 4): ");
			 userChoice=KeyInput.nextInt();		
		if(userChoice>=1 && userChoice<=4) statcheck=1; 
		else System.out.print("Input out of range! \n1 to 4 is the valid range:");
		}
		
		return userChoice;
	}
		
	
		/*
		 * THis method print the question from the array
		 * THe method will take the array range of the question and the number of question as argument.
		 */
	public static void questionPrinter(String[] passedarray,int NoRange,int Nolimit)
	{
		int i;
		
		for( i = NoRange;i<NoRange+12;i++)
		{	System.out.print(passedarray[i]);
		}
		int UserChoice=userAnswer();
		
		scoreCounter(Nolimit, UserChoice);
	}


}
