public class Deck {

    final int NUMCARDS = 52;

    Card[] deck = new Card[NUMCARDS];

    int deckPosition = 0;

    public Deck(){

        int slot = 0;
        for(int i = 0; i < 4; i++){

            for(int j = 0; j < 13; j++){

                deck[slot] = new Card(j, i);
                slot++;

            }
        }
    }

    public void shuffle(){

        for(int i = deck.length - 1; i > 0; i--){

            int rand = (int)(Math.random() * i);

            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
    }

    public Card dealCard(){

        if(deckPosition == NUMCARDS){

            shuffle();
            deckPosition = 0;
        }

        Card card = deck[deckPosition];
        deckPosition++;

        return card;
    }

    public String toString(){

        String output = "";
        for(Card card: deck){

            output += (card.toString() + "\n");
        }
        return output;
    }
}
