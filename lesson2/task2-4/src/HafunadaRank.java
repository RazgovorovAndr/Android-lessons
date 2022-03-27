import java.util.EnumMap;
import java.util.Map;

public class HafunadaRank extends Rank{
    HafunadaRank(HafunadaRank.Ranks _rank){
        rankObj = _rank;
    }

    @Override
    public final int hashCode(){
        final int prime = 31;
        int result = 1;
        Ranks rank = (Ranks)rankObj;
        result = prime * result + rank.hashCode();
        return result;
    }

    @Override
    public int compareTo(Rank obj) {
        HafunadaRank objRank = (HafunadaRank)obj;
        Ranks outerRank = (Ranks)objRank.getRankObj();
        Ranks rank = (Ranks)rankObj;
        return rank.compareTo(outerRank);
    }

    private final static Map<HafunadaSuit.Suits, Ranks> suitsMaxRanks = new EnumMap<>(HafunadaSuit.Suits.class){
        {
            put(HafunadaSuit.Suits.JANUARY, HafunadaRank.Ranks.CRANE_AND_SUN);
            put(HafunadaSuit.Suits.FEBRUARY, HafunadaRank.Ranks.BUSH_WARBLER);
            put(HafunadaSuit.Suits.MARCH, HafunadaRank.Ranks.CURTAIN);
            put(HafunadaSuit.Suits.APRIL, HafunadaRank.Ranks.CUCKOO);
            put(HafunadaSuit.Suits.MAY, HafunadaRank.Ranks.EIGHT_PLANK_BRIDGE);
            put(HafunadaSuit.Suits.JUNE, HafunadaRank.Ranks.BUTTERFLIES);
            put(HafunadaSuit.Suits.JULY, HafunadaRank.Ranks.BOAR);
            put(HafunadaSuit.Suits.AEUGUST, HafunadaRank.Ranks.FULL_MOON);
            put(HafunadaSuit.Suits.SEPTEMBER, HafunadaRank.Ranks.SAKE_CUP);
            put(HafunadaSuit.Suits.OCTOBER, HafunadaRank.Ranks.DEER);
            put(HafunadaSuit.Suits.NOVEMBER, HafunadaRank.Ranks.ONO_NO_MICHIKAZE);
            put(HafunadaSuit.Suits.DECEMBER, HafunadaRank.Ranks.CHINESE_PHOENIX);
        }
    };
    @Override
    Rank GetNextMaxRank(Suit suit){
        /*
        Тут просто возвращаем max rank, так как не было времени реализовывать max rank + 1
         */
        return new HafunadaRank(suitsMaxRanks.get(suit.getSuitObj()));
    }

    public enum Ranks{
        /*
         **
         * https://en.wikipedia.org/wiki/Hanafuda
         */
        CRANE_AND_SUN(20),
        CURTAIN(20),
        FULL_MOON(20),
        ONO_NO_MICHIKAZE(20),
        CHINESE_PHOENIX(20),
        BUSH_WARBLER(10),
        CUCKOO(10),
        EIGHT_PLANK_BRIDGE(10),
        BUTTERFLIES(10),
        BOAR(10),
        GEESE(10),
        SAKE_CUP(10),
        DEER(10),
        SWALLOW(10),
        POETRY_TANZAKU(5),
        BLUE_TANZAKU(5),
        PLAIN_TANZAKU(5),
        Kasu(1);

        int rank;
        Ranks(int _rank){
            this.rank = _rank;
        }

    }
}
