import java.util.Map;
import java.util.EnumMap;

public class HafunadaSuit extends Suit{

    HafunadaSuit(HafunadaSuit.Suits _suit){
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

    public enum Suits{
        /*
         **
         * https://en.wikipedia.org/wiki/Hanafuda
         */
        JANUARY,
        FEBRUARY,
        MARCH,
        APRIL,
        MAY,
        JUNE,
        JULY,
        AEUGUST,
        SEPTEMBER,
        OCTOBER,
        NOVEMBER,
        DECEMBER
    }

    @Override
    public int compareTo(Suit obj){
        HafunadaSuit objSuit = (HafunadaSuit)obj;
        Suits outerSuit = (Suits)objSuit.getSuitObj();
        Suits suit = (Suits)suitObj;
        return suit.compareTo(outerSuit);
    }
}
