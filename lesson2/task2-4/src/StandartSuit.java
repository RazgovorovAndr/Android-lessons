
public class StandartSuit extends Suit{

    StandartSuit(StandartSuit.Suits _suit){
        suitObj = _suit;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        Suits suit = (Suits)suitObj;
        result = prime * result + suit.hashCode();
        return result;
    }

    @Override
    public int compareTo(Suit obj){
        StandartSuit objSuit = (StandartSuit)obj;
        Suits outerSuit = (Suits)objSuit.getSuitObj();
        Suits suit = (Suits)suitObj;
        return suit.compareTo(outerSuit);
    }

    public enum Suits{
        CLUBS,
        DIAMONDS,
        SPADES,
        HEARTS;
    }

}
