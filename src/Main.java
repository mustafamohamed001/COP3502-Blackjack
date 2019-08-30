// Mustafa Mohamed - Project 1

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        Random randGen = new Random();

        //Variables
        final int ACE = 1;
        final int JACK = 11;
        final int QUEEN = 12;
        final int KING = 13;
        int gameNum = 1; //Starts game at game 1
        int gameChoice = 0; //Allows for game choosing
        int randomCard = 0; //Allows random card to be temporarily saved as a variable
        int hand = 0;
        int dealerHand = 0;
        int gameLost = 0;
        int gameWin = 0;
        int gameTie = 0;
        boolean loopQuit = true; //used to break loop


        //Two loops: one to reset game (outer loop)
        //and one for actual game and menu (inner loop)

        //Outer loop
        while (true) {
            System.out.println("START GAME #" + gameNum);
            System.out.println();
            randomCard = randGen.nextInt(13) + 1; //Random card generator //Removes 0 from generating

            //Card assignment & hand updated
            if (randomCard == ACE){
                System.out.println("Your card is an ACE!");
                randomCard = 1;
            }
            else if (randomCard == JACK){
                System.out.println("Your card is an JACK!");
                randomCard = 10;
            }
            else if (randomCard == QUEEN){
                System.out.println("Your card is an QUEEN!");
                randomCard = 10;
            }
            else if (randomCard == KING){
                System.out.println("Your card is an KING!");
                randomCard = 10;
            }
            else{
                System.out.println("Your card is a " + randomCard + "!");
            }
            hand = hand + randomCard;

            System.out.println("Your hand is: " + hand + "!");

            //Inner loop
            while (loopQuit && (hand <= 21)) {

                //Manages exceptions
                try {
                    //Menu
                    System.out.println();
                    System.out.println("1. Get another card");
                    System.out.println("2. Hold hand");
                    System.out.println("3. Print game statistics");
                    System.out.println("4. Exit");
                    System.out.println();
                    System.out.print("Choose an option: ");
                    gameChoice = userInput.nextInt();

                    //Card assignment & hand updated
                    if (gameChoice == 1) {
                        randomCard = randGen.nextInt(13) + 1; //Random card generator //Removes 0 from generating

                        if (randomCard == ACE){
                            System.out.println("Your card is an ACE!");
                            randomCard = 1;
                        }
                        else if (randomCard == JACK){
                            System.out.println("Your card is an JACK!");
                            randomCard = 10;
                        }
                        else if (randomCard == QUEEN){
                            System.out.println("Your card is an QUEEN!");
                            randomCard = 10;
                        }
                        else if (randomCard == KING){
                            System.out.println("Your card is an KING!");
                            randomCard = 10;
                        }
                        else{
                            System.out.println("Your card is a " + randomCard + "!");
                        }
                        hand = hand + randomCard;

                        System.out.println("Your hand is: " + hand + "!");
                    }
                    else if (gameChoice == 2) {

                        //Assigning dealer hand count
                        while (dealerHand <= 15){
                            randomCard = randGen.nextInt(13) + 1; //Random card generator //Removes 0 from generating
                            dealerHand = randomCard + dealerHand;
                        }

                        System.out.println("Dealer's hand: " + dealerHand);
                        System.out.println("Your hand is: " + hand);

                        //Computes different results of holding hand

                        //************
                        //** README ** -> game does not win automatically when player gets 21 if
                        //************    in case dealer also gets 21 which would then result in a tie

                        //Win
                        if (hand > dealerHand || dealerHand > 21){
                            System.out.println("You win!");
                            ++gameWin;
                            loopQuit = false; //breaks loop
                        }

                        //Lost
                        else if (dealerHand > hand){
                            System.out.println("Dealer wins!");
                            ++gameLost;
                            loopQuit = false; //breaks loop
                        }

                        //Tie
                        else if (dealerHand == hand){
                            System.out.println("It's a tie! No one wins!");
                            gameTie++;
                            loopQuit = false; //breaks loop
                        }

                    }

                    //Outputs game statistics
                    else if (gameChoice == 3) {
                        System.out.println();
                        System.out.println("Number of Player wins: " + gameWin);
                        System.out.println("Number of Dealer wins: " + gameLost);
                        System.out.println("Number of tie games: " + gameTie);
                        System.out.println("Total # of games played is: " + (gameNum - 1)); //Minus one to account for games played and not current game
                        System.out.print("Percentage of Player wins: " + (((double)(gameWin))/(gameNum - 1) * 100.0));

                    }

                    //To close game
                    else if (gameChoice == 4) {
                        return;
                    }

                    //Invalid integer outputs
                    else {
                        System.err.println("'" + gameChoice + "' is not a valid option" );
                    }

                }

                //Exception handler
                catch (InputMismatchException excpt){
                    System.err.println("Please enter integer");
                    System.out.println();
                    userInput.nextLine();
                }
            }


            //If hand goes over 21
            if (hand > 21) {
                System.out.println("You exceeded 21! You lose :(");
                gameLost++;
            }

            //Game reset stats
            hand = 0; //Resets player hand
            dealerHand = 0; //Resets dealer hand
            gameNum++; // Increases game number
            loopQuit = true; //makes loop work again
            System.out.println();
        }
    }
}

/* Prototype                //Invalid value type check
                while (true){
                    try {
                        gameChoice = userInput.nextInt();
                        break;
                    }

                    catch (InputMismatchException excpt) {
                        System.out.println();
                        System.err.println("Please enter integer");
                        userInput.;
                        break;
                    }
                }*/