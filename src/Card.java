public class Card {

    int rank, suit;

    String[] rankArr = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    String[] suitArr = {"Clubs", "Hearts", "Spades", "Diamonds"};

    public Card(int rank, int suit){

        this.rank = rank;
        this.suit = suit;
    }

    public String getRank(){

        return rankArr[rank];
    }

    public String getSuit(){

        return suitArr[suit];
    }

    public int getValue(){

        if(rank >= 9){

            return 10;
        }else{

            return rank + 1;
        }
    }

    public String toString(){

        return getRank() + " of " + getSuit();
    }

}
