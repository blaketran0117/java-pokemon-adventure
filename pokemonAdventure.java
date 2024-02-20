/******************************************************************************

Name : Blake Tran 
Date : Feb 19, 2024

Description: The goal of this assignment was to create a text-based Pokémon Adventure game in Java that allows a player to choose a starting Pokémon, explore different areas, and attempt to capture wild Pokémon. The program's inputs include the player's name, 
choice of Pokémon, and decisions to attempt captures or move between areas. 
The outputs include game status updates, results of capture attempts, and a final summary of the player's adventure. 
Error handling was required to manage invalid inputs from the user during the game.

*******************************************************************************/
import java.util.Scanner;
import java.util.Random;


public class pokemonAdventure{
 // Initilize all the variables that need to be keep track of throughout the game
    
    static Scanner scanner = new Scanner(System.in);
	static String[] pokemons={"Bulbasar","Charmander","Squirtle"};
    static int userChoice = -1;
    static int numSteps = 6;
    static int totalCapture = 0;
    
// 	 Method to get the player name :
    public static String getPlayerName(Scanner scanner){
        System.out.println("Enter your name to get start:");
		String playername=scanner.nextLine();
		System.out.println("Welcome to pokemon adventure! " + playername);
		return playername;
    }
    
// Method to display menu and let the user choose pokemon:
	 public static void choosePokemon(Scanner scanner){
	     System.out.println("Choose your starter pokemon:");
	     for ( int i = 0; i < pokemons.length;++i){
	         System.out.printf("   %d. %s %n ",i + 1, pokemons[i]);
	     }
	     userChoice = scanner.nextInt();
	     while(userChoice < 1 || userChoice > pokemons.length){
	         System.out.println("Invalid input!, please enter a number from 1 - " + pokemons.length);
	         userChoice =scanner.nextInt();
	         
	     }
	     System.out.println("You chose " + pokemons[userChoice - 1]);
	  }
	  
    // Simulating random capturing chance:
    public static boolean captureAttempt() {
        Random random = new Random(); 
        int captureChance = random.nextInt(100); 


    // Let's assume a 50% success rate for simplicity
        if (captureChance < 50) { 
            return true; 
        } else {
            return false; 
        }
    }

    
	 
    // Method to start the game loop:
    public static void gameStart(){
        System.out.println("You're now ready to start your adventure");
        
        for ( int area = 1; area <= 3 ; area++){
            int areaEncouters = 0;
            System.out.println(" ** You are now in area " + area + " **");
            boolean continueGame = true;
            while(continueGame){
                for ( int i = 1; i <= 6; i++){
                    if( i == 1){
                        System.out.println("You took a step");
                    }
                        System.out.printf("You took %d steps %n",i);
                    }   
                    System.out.println("A Wild Pokemon appeared!");
                    System.out.println("    1. Try to catch it");
                    System.out.println("    2. Run away");
                    areaEncouters++;
                    int Choice = scanner.nextInt();
        	        while(Choice < 1 || Choice > 2){
        	            System.out.println("Invalid input!, please enter a number from 1 - 2");
        	            Choice = scanner.nextInt();
        	        }
        	        if (Choice == 1){
        	            boolean captureSuccess = captureAttempt();
        	            if (captureSuccess){
        	                System.out.println("You've caught the Pokemon");
        	                totalCapture ++;
        	            } else {
        	                System.out.println("Oh no! The pokemon got away");
        	            }
        	        } else{
        	            System.out.println("You chose to run away from the pokemon");
        	        }
        	        System.out.println("You've encounter " + areaEncouters + " wild pokemons in this arena and caught " + totalCapture + " pokemon(s)");
        	        System.out.println("Would you like to...");
        	        System.out.printf("    1. Continue exploring area %d %n",area);
                    System.out.println(".  2. Go to the next area");
                    int exploreOrNot;
                    do{
                        exploreOrNot= scanner.nextInt();
                        if (exploreOrNot < 1 || exploreOrNot > 2){
                            System.out.println("Invalid input, try again.");
                        }
                    }
                    while(exploreOrNot < 1 || exploreOrNot > 2);
        	        
                    if(exploreOrNot == 1){
                        if(areaEncouters == 5){
                            System.out.println("You've encountered 5 wild pokemons here, let move on to the next arena");
                            continueGame = false;
                        }else{
                            continue;
                        }
                    } 
                    System.out.println("You have chosen to leave this area");
                    continueGame=false;
                    
        	}
        }
    }

    public static void gameEnd(){
        System.out.printf("You and %s have finish your adventure!, %n You caught %d pokemons", pokemons[userChoice-1],totalCapture);
    }
    public static void main(String[] args) {
	    getPlayerName(scanner);
	    choosePokemon(scanner);
	    gameStart();    
	    gameEnd();
	    
	}
}
