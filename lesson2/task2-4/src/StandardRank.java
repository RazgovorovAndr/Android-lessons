public class StandardRank extends Rank{
    StandardRank(StandardRank.Ranks _rank){
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
        StandardRank objRank = (StandardRank)obj;
        Ranks outerRank = (Ranks)objRank.getRankObj();
        Ranks rank = (Ranks)rankObj;
        return rank.compareTo(outerRank);
    }

    @Override
    Rank GetNextMaxRank(Suit suit){
        Ranks rank = (Ranks)rankObj;
        return new StandardRank(rank.Next());
    }

    public enum Ranks{
        TWO(1),
        THREE(2),
        FOUR(3),
        FIVE(4),
        SIX(4),
        SEVEN(5),
        EIGHT(6),
        NINE(7),
        TEN(8),
        JACK(9),
        QUEEN(10),
        KING(11),
        ACE(12),
        JOKER(13);

        int rank;
        Ranks(int _rank){
            this.rank = _rank;
        }

        public Ranks Next(){
            return values()[(ordinal() + 1) % values().length];
        }

    }
}