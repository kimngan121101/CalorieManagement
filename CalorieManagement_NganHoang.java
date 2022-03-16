/*
 * Name : Ngan Hoang
 * Date : 10/3/19
 * Course : CSC110AB
 * Program Name : Calorie Management
 * Program Purpose : To build a Management for input Calorie
 */
package assignment;
import java.util.Scanner;
public class CalorieManagement_NganHoang {
	final static double soup = 280.0, sandwich = 630.0, salad = 570.0, smoothie = 230.0; // constant
	public static void main(String[] args) {
				Scanner scnr = new Scanner(System.in);
		// Declare variables
		int inputAge;
		char inputGender, inputSedentary;
		double bmr, bmr2, inputHeight, inputWeight;
		String returnValue = "";
		
		// Description of the company
		System.out.println("This program will indentify the number of calories someone \ncan consum to maintain their current weight.\nThe program will also indicate which Panera Bread Company menu\nitems someone can choose to eat based on the calories of 4 menu items\nas identified on their webisite : \n");
		System.out.println("\tCreamy Tomato soup: 280 calories\n\tFuji Apple Salad with Chicken: 570 calories\n\tNapa Almond Chicken Salad Sandwich: 630 calories\n\tSuperfruit Smoothie: 230 calories\n");
		System.out.println("--------Plesase answer the questions below.-----------------------");
		
		// User input
		System.out.println("\nWhat is the age in years?");
		inputAge = scnr.nextInt();
		System.out.println("What is the total height in inches?");
		inputHeight = scnr.nextDouble();
		System.out.println("What is the weight in pounds");
		inputWeight = scnr.nextDouble();
		System.out.println("The calorie calculation varies for a Male versus a Female.\nEnter 'M' for male calculation or 'F' for female calculation.");
		inputGender = scnr.next().charAt(0);
		System.out.println("Categorize your activity level as one of the following:");
		System.out.println("\tA. Sedentary \n\tB. Somewhat active (exercise occasionally)\n\tC. Active (exercise 3-4 days per week)\n\tD. Highly active (exercise every day)\nEnter A,B,C or D.");
		inputSedentary = scnr.next().charAt(0);
		
		
		// Code of restating Sedentary level from user's input
		switch (inputSedentary) {
		case 'A' :{
			returnValue = "Sedentary";
			break;}
		case 'B' :{
			returnValue = "Somewhat active (exercise occasionally)";
			break;}
		case 'C' :{
			returnValue = "Active (exercise 3-4 days per week";
			break;}
		case 'D' :{
			returnValue = "Highly active (exercise every day)";
			break;}
			
		
		}
		
		// Switch case between Gender's input
		switch (inputGender) {
		case 'F' : { // User's input info
			System.out.println("\n--------Thank you for answering the question.---------------------");
			System.out.println("Age: "+ inputAge);
			System.out.printf("Height: %.1f", inputHeight);
			System.out.printf("\nWeight: %.1f", inputWeight);
			System.out.println("\nGender: Female");
			System.out.println("Activity Level: "+ returnValue);
			
			// BMR Female formula
			bmr = (int)(655+(4.3 * inputWeight) + (4.7* inputHeight) - (4.7 * inputAge));
			
			// new BMR with Sedentary level
			switch (inputSedentary) {
			case 'A' : {
				bmr2= (int)(bmr * 0.2) + bmr;
				break;
			}
			case 'B' : {
				bmr2 = (int)(bmr * 0.3) + bmr;
				break;
			}
			case 'C': {
				bmr2 = (int)(bmr * 0.4) + bmr;
				break;
			}
			case 'D':{
				bmr2 = (int)(bmr * 0.5) + bmr;
				break;
			}
			default:{
				bmr2 = bmr;
				break;			
			}
			}
			System.out.printf("\nA Female with these measurements should eat %.1f per day to maintain the same weight.\n", bmr2);
			
			
			// Algorithms for calorie combination of items 
			if(bmr2>= smoothie ) {
				System.out.println("\nThe following items among the 4 listed above can be ordered:");
				do { 
				if (bmr2>= soup) {
						System.out.println("\tCreamy Tomato soup: 280 calories");
						bmr2-=280;
					}
				if (bmr2>= salad) {
					System.out.println("\tFuji Apple Salad with Chicken: 570 calories");
					bmr2-=570;
				}
				if (bmr2>= sandwich) {
				System.out.println("\tNapa Almond Chicken Salad Sandwich: 630 calories");
				bmr2-=630;
			}
				if (bmr2>= smoothie) {
					System.out.println("\tSuperfruit Smoothie: 230 calories");
					bmr2-=230;
				}
			
			    if (bmr2< smoothie && bmr2>0) {
			    	System.out.printf("\nThere are %.2f calories left, perhaps you should add a side!\n",bmr2);
			    }
			    
			} while (bmr2>= smoothie);
				System.out.println("We hope you enjoy your meal. Thank you for considering Panera Bread Company!");
			}
			else if (bmr2< smoothie && bmr2>0) {
				System.out.printf("There are %.2f calories left, perhaps you should add a side!\n",bmr2);
				System.out.println("We hope you enjoy your meal. Thank you for considering Panera Bread Company!");
			}
			else {
				System.out.println("Invalid Calculation, Please re-input correctly!");
			}
			
			break;} // End Female case
		case 'M' : {// Similar to Female case
			System.out.println("\n--------Thank you for answering the question.---------------------");
			System.out.println("Age: "+ inputAge);
			System.out.printf("Height: %.1f", inputHeight);
			System.out.printf("\nWeight: %.1f", inputWeight);
			System.out.println("\nGender: Male");
			System.out.println("Activity Level: "+ returnValue);
			
			bmr = (int)(66+ (6.3* inputWeight) + (12.9* inputHeight)- (6.8*inputAge));
			
			switch (inputSedentary) {
			case 'A' : {
				bmr2= (int)(bmr * 0.2) + bmr;
				break;
			}
			case 'B' : {
				bmr2 = (int)(bmr * 0.3) + bmr;
				break;
			}
			case 'C': {
				bmr2 = (int)(bmr * 0.4) + bmr;
				break;
			}
			case 'D':{
				bmr2 = (int)(bmr * 0.5) + bmr;
				break;
			}
			default:{
				bmr2 = bmr;
				break;			
			}
			}
			System.out.printf("\nA Male with these measurements should eat %.1f per day to maintain the same weight.\n", bmr2);
			
			if(bmr2>= smoothie) {
				System.out.println("\nThe following items among the 4 listed above can be ordered:");
				do { 
				if (bmr2>= soup) {
						System.out.println("\tCreamy Tomato soup: 280 calories");
						bmr2-=280;
					}
				if (bmr2>= salad) {
					System.out.println("\tFuji Apple Salad with Chicken: 570 calories");
					bmr2-=570;
				}
				if (bmr2>= sandwich) {
				System.out.println("\tNapa Almond Chicken Salad Sandwich: 630 calories");
				bmr2-=630;
			}
				if (bmr2>= smoothie) {
					System.out.println("\tSuperfruit Smoothie: 230 calories");
					bmr2-=230;
				}
			
			    if (bmr2<smoothie && bmr2>0) {
			    	System.out.printf("\nThere are %.2f calories left, perhaps you should add a side!\n",bmr2);
			    }
			    
			} while (bmr2>= smoothie);
				System.out.println("We hope you enjoy your meal. Thank you for considering Panera Bread Company!");
			}
			else if (bmr2< smoothie && bmr2>0) {
				System.out.printf("There are %.2f calories left, perhaps you should add a side!\n",bmr2);
				System.out.println("We hope you enjoy your meal. Thank you for considering Panera Bread Company!");
			}
			else {
				System.out.println("Invalid Calculation, Please re-input correctly!");
			}
			
			break;} // End Male case
		default : { // Invalid Gender
			System.out.println("Invalid entry for gender");
			break;}
		
		}// End switch
		scnr.close();
		
		/******************* The End ********************/
	}

}
