
public abstract class Rank implements Comparable<Rank>{
    protected Object rankObj;

    Rank(){}

    public final String toString(){
        return rankObj.toString();
    }
    abstract Rank GetNextMaxRank(Suit suit);

    protected final Object getRankObj(){
        return rankObj;
    }
}




