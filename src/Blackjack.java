import java.util.Scanner;
public class Blackjack {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        Deck deck = new Deck();
        Player p = new Player();
        Player d = new Player();
        deck.shuffle();

        int bet = 0;
        String hitOrStand;
        final int NUMCARDS = 2;

        do{
            //Place bet
            do{

                System.out.println("How much would you like to bet? You can bet up to " + p.getScore() + ". Bet 0 to exit.");
                bet = read.nextInt();
                read.nextLine();
            }while(bet > p.getScore());


            if(bet == 0){
                break;
            }else{

                p.subtractScore(bet);
                p.newHand();
                d.newHand();
            }
            //Deal
            for(int i = 0; i < NUMCARDS; i++) {

                p.addCard(deck.dealCard());
                d.addCard(deck.dealCard());
            }

            do{
                //Hit or stand(p)

                System.out.println("--------------------------------------");
                System.out.print("You have: ");
                System.out.println(p);
                System.out.print("Dealer has: ");
                System.out.println("Facedown\t\t" + d.playCard(1).toString());
                System.out.println("--------------------------------------");

                System.out.println("\n*********************************");
                System.out.println("Hand is showing: " + p.sumHand());
                System.out.println("*********************************\n");

                if(p.sumHand() == 21){

                    System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$");
                    System.out.println("21!");
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$\n");
                    hitOrStand = "s";
                }else if(p.sumHand() > 21){

                    System.out.println("\n#########################");
                    System.out.println("You bust. . .");
                    System.out.println("#########################\n");
                    hitOrStand = "s";
                }else{

                    System.out.println("Would you like to (h)it or (s)tand?");
                    hitOrStand = read.nextLine();
                }

                if(hitOrStand.equalsIgnoreCase("h")){

                    p.addCard(deck.dealCard());
                }

            }while(hitOrStand.equalsIgnoreCase("h"));

            while(d.sumHand() <= 16 && p.sumHand() <= 21){
                //Hit or stand(d)

                d.addCard(deck.dealCard());
            }

            System.out.println("\nDealer has: " + d);
            System.out.println("\n*********************************");
            System.out.println("Dealer is showing: " + d.sumHand());
            System.out.println("*********************************\n");

            //Compare p and d //Payout
            if(p.sumHand() > 21 || (d.sumHand() > p.sumHand() && d.sumHand() <= 21)){

                System.out.println("You lose. You lost your bet. Your score is now: " + p.getScore());
            }else if(p.sumHand() > d.sumHand() || d.sumHand() > 21){

                p.addScore(bet * 2);
                System.out.println("You win! You earned: " + bet * 2 + " points. Your score is now " + p.getScore());
            }else{

                p.addScore(bet);
                System.out.println("Tied score! Your score is now: " + p.getScore());
            }
        }while(bet > 0);

        System.out.println("Thank you for playing!");
        System.out.println("Your final score is: " + p.getScore());
    }
}
