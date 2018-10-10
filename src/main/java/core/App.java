package core;

public class App
{
    public static void main( String[] args ) {

        //Create hands for user and AI
        Hand AI = new Hand("src/main/resources/Fullhouse");
        Hand user = new Hand("src/main/resources/Straight");

        // Print initial hands for both users
        System.out.println("AIP Hand: ");
        AI.print();;
        System.out.println("");
        System.out.println("User Hand: ");
        user.print();

        // Create a full deck minus the cards in the two hands.
        Deck deck = new Deck();
        deck.removeHand(AI);
        deck.removeHand(user);

        // AI tries to improve their hand
        System.out.println("");
        System.out.println("");
        System.out.println("AIP Changing hand...");
        AI.changeHand();


        // time to compare the hands to determine the winner!
        PlayGame game = new PlayGame(AI, user);
        boolean isAIWinner = game.isBetter();

        if (isAIWinner) {
            System.out.println("");
            System.out.println("");
            System.out.println("AI is the winner!");
        }
        else {
            System.out.println("");
            System.out.println("User is the winner");
        }
        
    }
}