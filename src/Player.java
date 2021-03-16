import java.util.ArrayList;

public class Player {

    int score;

    ArrayList<Card> hand = new ArrayList<>();

    public Player(){

        score = 100;
    }

    public void addCard(Card card){

        hand.add(card);
    }

    public Card playCard(int cardPosition){

        return hand.get(cardPosition);
    }

    public void discardCard(int cardPosition){

        hand.remove(cardPosition);
    }

    public void newHand(){

        hand.clear();
    }

    public void addScore(int value){

        score += value;
    }

    public void subtractScore(int value){

        score -= value;
    }

    public void setScore(int value){

        score = value;
    }

    public int getScore(){

        return score;
    }

    //Black Jack Specific-----

    public int sumHand(){

        int sum = 0;

        for(Card card: hand){

            if(!card.getRank().equals("A")){

                sum += card.getValue();
            }
        }

        for(Card card: hand){

            if(card.getRank().equals("A")){

                if(sum + 11 <= 21){

                    sum += 11;
                }else{

                    sum += 1;
                }
            }
        }

        return sum;
    }

    public String toString(){

        String output = "";

        for(Card card: hand){

            if(card.getSuit().equals("Diamonds")){

                output += (card.toString() + "\t");
            }else{

                output += (card.toString() + "\t\t");
            }
        }

        return output;
    }
}
