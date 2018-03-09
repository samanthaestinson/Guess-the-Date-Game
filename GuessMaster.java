package GuessMaster;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
*<h1>Guess Master!</h1>
*The goal of the game is to correctly guess the birthday of a named entity. 
*I.e. A celebrity, country or prominent leader.
*Follow the template: month / day  / year. 
* <p>
* 
*279 Assignment 1
* @author  Samantha Stinson 20009335
* @version 1.0
* @since   2018-02-11 
*/

public class GuessMaster {
	//instance variables
	private int numberOfCandidateEntities;
	private Entity[] entities = new Entity[10];
	//boolean variable to determine if the game should quit
	public boolean quit=false;
	
	
	//Constructor: initialize
	public GuessMaster() {
		setNumCand(0);
	}
	
	//Constructor: sets values
	public GuessMaster(int numCandidate,Entity[] ent) {
		entities = ent;
		numberOfCandidateEntities= numCandidate;
	}
	
	//Accessor 
	public int getNumCand() {
		return numberOfCandidateEntities;
	}
	
	//Mutator
	public void setNumCand(int value) {
		this.numberOfCandidateEntities= value;
	}

   /**
   * This method adds a new entity into entities.
   * @param entity The object that is added to the list of entities
   * @return none
   */
	public void addEntity(Entity entity) {
		entities[numberOfCandidateEntities]=entity;
		numberOfCandidateEntities++;
		
	}
	
   /**
   * This method begins the game.
   * Given an entity, it plays the guessing game with regard to that entity.
   * @param entity The object that is used as the answer
   * @return none
   */
	public void playGame(Entity entity) {
		//begining statement
		System.out.println("\nYour Entity is:\n"+ entity.getName() + "");
		System.out.println("\nGuess:");
		
		//takes keyboard input
		while (quit!=true) {
			Scanner keyboard= new Scanner(System.in);
			String guess = keyboard.nextLine();

			//checks if the user wants to quit
			if (guess.equals("quit") || guess.equals("Quit") || guess.equals("QUIT") || guess.equals("quits")) {
				System.out.println("\nExiting game... \nGAME OVER.");
				quit=true;
				System.exit(0);
			}
			
			//now can set date
			Date guessDate= new Date(guess);
			
			//compares the entity to the guess
			if (guessDate.equals(entity.getBorn())) {
				System.out.println("You guessed correctly! Congrats you win!");
				playGame();
			}
			
			else if (guessDate.precedes(entity.getBorn())) 
			{
				System.out.println("Incorrect. Please try a later date.");
				//retry
				playGame(entity);
			}
			else
			{
				System.out.println("Incorrect. Please try an earlier date");
				//retry
				playGame(entity);
			}
		}
	}

   /**
   * This method looks at the given index value
   * The method invokes the public void playGame(Entity entity) defined above.
   * @param entityInd The integer for the entity index in the list entities
   * @return none
   */
	public void playGame(int entityInd) {
		Entity currentEntity = entities[entityInd];
		playGame(currentEntity);
	}
	
   /**
   * This method will call the function to generate a random number as long as the user wants to play.
   * Which will be then used to randomly pick an entity from entities.
   * The method then invokes public void playGame(int entityInd) to play a game.
   * @param none
   * @return none
   */
	public void playGame() {
		while(quit==false) {
			int index=genRandomEntityInd();
			playGame(index);
		}
	}

   /**
   * This method will generate a random number.
   * It is private because it is only being called in the class by specific method
   * @param none
   * @return ind This integer is the random index value for the list of entities
   */
	private int genRandomEntityInd() {
		Random rnd= new Random();
		int ind= rnd.nextInt(numberOfCandidateEntities);
		return ind;
	}
		
	//main method
	public static void main(String[] args) {
		//creating empty list for 3 entities
		Entity[] list = new Entity[3];
		
		//Setting entities
		Entity trudeau = new Entity("Justin Trudeau", new Date("December", 25, 1971));
		Entity dion = new Entity("Celine Dion", new Date("March", 30, 1968)); 
		Entity usa = new Entity("United States", new Date("July", 14, 1776));
		
		GuessMaster gm1 = new GuessMaster(); 
		GuessMaster gm2 = new GuessMaster(0,list); 
		
		//adding entities
		gm1.addEntity(trudeau); 
		gm1.addEntity(dion); 
		gm1.addEntity(usa); 
		
		
		//greeting and instructions
		System.out.println("Enter Player Name:");
		Scanner keyboard= new Scanner(System.in);
		String nameOfPlayer = keyboard.nextLine();
		System.out.println("\nHello "+ nameOfPlayer+".");
		System.out.println("\n Lets play \"Guess That Date\"!\n The goal of the game is to correctly guess the birthday of a named entity. \n I.e. A celebrity, country or prominent leader.");
		System.out.println(" Follow the template: month / day  / year.");
		
		//starting game
		//works with either gm1 or gm2
		gm1.playGame();	
				
	}
}


