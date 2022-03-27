public class Card implements Comparable<Card>{
    private StandartSuit suit;
    private Rank rank;
    // Пусть будет по умолчанию джокером
    static private Rank last_rank = new StandardRank(StandardRank.Ranks.JOKER);

    Card(Rank _rank, StandartSuit _suit){
        suit = _suit;
        rank = _rank;
        last_rank = _rank;
    }

    Card(StandartSuit _suit){
        suit = _suit;
        rank = last_rank.GetNextMaxRank(_suit);
    }

    @Override
    public String toString(){
        return rank.toString() + " OF " + suit.toString();
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Card card = (Card)obj;
        return suit.equals(card.getSuit()) && rank.rankObj.equals(card.getRank().rankObj);
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + suit.hashCode();
        result = prime * result + rank.hashCode();
        return result;
    }

    public Suit getSuit(){
        return suit;
    }

    public Rank getRank(){
        return rank;
    }

    public boolean stronger(Card _card){
        //масть должна быть одна и та же
        // класс ранга также должен быть один и тот же
        if (!(_card.getSuit().equals(suit)) || rank.getClass() != _card.getRank().getClass())
            return false;
        if (rank.compareTo(_card.getRank() ) > 0)
            return true;
        return false;
    }

    @Override
    public int compareTo(Card card){
        Rank outRank = card.getRank();
        if( rank.getClass() != outRank.getClass() ) {
            System.out.println("Нельзя сравнивать различные типы рангов");
            return 0;
        }
        int result = suit.compareTo(card.suit);
        if( result != 0 )
            return result;
        return rank.compareTo(outRank);
    }

    static public int compareTo(Card card, Card card2){
        return card.compareTo(card2);
    }

    public boolean isStandardCard(){
        return rank.getClass() == StandardRank.class;
    }

}
