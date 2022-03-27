public abstract class Suit implements Comparable<Suit>{
    protected Object suitObj;

    Suit(){}

    public final String toString(){
        return suitObj.toString();
    }

    protected final Object getSuitObj(){
        return suitObj;
    }
}