import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    ArrayList<Card> deck = new ArrayList<>();

    private Deck(boolean addJokers){
        for (StandartSuit.Suits suit : StandartSuit.Suits.values())
            for (StandardRank.Ranks rank : StandardRank.Ranks.values()){
                if( rank.equals(StandardRank.Ranks.JOKER) )
                    continue;
                deck.add(new Card(new StandardRank(rank), new StandartSuit(suit)));
            }
        if (addJokers)
        {
            deck.add(new Card(
                    new StandardRank(StandardRank.Ranks.JOKER),
                    new StandartSuit(StandartSuit.Suits.DIAMONDS)
            ));
            deck.add(new Card(
                    new StandardRank(StandardRank.Ranks.JOKER),
                    new StandartSuit(StandartSuit.Suits.HEARTS)
            ));
        }
    }

    static public Deck create(boolean addJokers){
        return new Deck(addJokers);
    }

    public void suffle(){
        Collections.shuffle(deck);
    }
    public void sort(){
        Collections.sort(deck);
    }

    @Override
    public String toString(){
        return deck.toString();
    }

    public boolean pushBack(Card card){
        if(deck.contains(card))
            return false;
        deck.add(card);
        return true;
    }

    public Card popBack(){
        return  deck.remove(deck.size() - 1);
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public static Card getRandomCard(){
        return new Deck(true).randomCard();
    }

    private Card randomCard(){
        Random rand = new Random();
        return deck.get(rand.nextInt(deck.size()));
    }

}