public class Main {

    public static void main(String[] args){
        task2();
        task3();
        task4();
    }

    public static void task2(){
        System.out.println("Start task 2");

        StandartSuit diamonds = new StandartSuit(StandartSuit.Suits.DIAMONDS);
        Rank queen = new StandardRank(StandardRank.Ranks.QUEEN);
        Rank cuckoo = new HafunadaRank(HafunadaRank.Ranks.CUCKOO);
        Card two_of_diamonds = new Card(diamonds);
        Card queen_of_diamonds = new Card(queen, diamonds);
        Card king_of_diamonds = new Card(diamonds);
        Rank ace = new StandardRank(StandardRank.Ranks.ACE);
        Card ace_of_hearts = new Card(ace, new StandartSuit(StandartSuit.Suits.HEARTS));
        Card cuckoo_of_hearts = new Card(cuckoo, new StandartSuit(StandartSuit.Suits.HEARTS));

        System.out.println(two_of_diamonds.getRank() + " OF " + two_of_diamonds.getSuit());
        System.out.println(queen_of_diamonds.getRank() + " OF " + queen_of_diamonds.getSuit());
        System.out.println(king_of_diamonds.getRank() + " OF " + king_of_diamonds.getRank() );
        System.out.println(ace_of_hearts.getRank() + " OF " + ace_of_hearts.getSuit());
        System.out.println(cuckoo_of_hearts);

        System.out.println("End task 2");
    }

    public static void task3(){
        System.out.println("Start task 3");

        StandartSuit diamond = new StandartSuit(StandartSuit.Suits.DIAMONDS);
        StandartSuit hearts = new StandartSuit(StandartSuit.Suits.HEARTS);
        Rank queen = new StandardRank(StandardRank.Ranks.QUEEN);
        Rank queen2 = new StandardRank(StandardRank.Ranks.QUEEN);
        Rank king = new StandardRank(StandardRank.Ranks.KING);

        Card queen_of_diamonds = new Card(queen, diamond);
        Card queen_of_diamonds2 = new Card(queen2, diamond);
        Card king_of_diamonds = new Card(king, diamond);
        Card queen_of_hearts = new Card(queen, hearts);
        Card crane_and_sun_of_diamonds = new Card(new HafunadaRank(HafunadaRank.Ranks.CRANE_AND_SUN), diamond);

        //toString
        System.out.println(queen_of_diamonds); // QUEEN OF DIAMONDS
        System.out.println(king_of_diamonds); // KING OF DIAMONDS
        //equals
        System.out.println("queen_of_diamonds equal queen_of_diamonds2 ? " +
                queen_of_diamonds.equals(queen_of_diamonds2)); // true
        System.out.println("queen_of_diamonds equal king_of_diamonds ? " +
                queen_of_diamonds.equals(king_of_diamonds)); // false

        System.out.println("queen_of_diamonds equal queen_of_hearts ? " +
                queen_of_diamonds.equals(queen_of_hearts)); // false

        // первые два хэш кода совпадают
        System.out.println(queen_of_diamonds.hashCode() + " and " + queen_of_diamonds2.hashCode() +
                " and " + queen_of_hearts.hashCode());

        //stronger
        System.out.println("queen_of_diamonds stronger queen_of_diamonds2 ? " +
                queen_of_diamonds.stronger(queen_of_diamonds2)); // false
        System.out.println("king_of_diamonds stronger queen_of_diamonds ? " +
                king_of_diamonds.stronger(queen_of_diamonds)); // True

        // compareTo
        System.out.println(king_of_diamonds.compareTo(queen_of_diamonds) );// 1
        System.out.println(king_of_diamonds.compareTo(queen_of_hearts) );// -2
        System.out.println(queen_of_diamonds.compareTo(queen_of_diamonds2) );// 0
        System.out.println(Card.compareTo(queen_of_diamonds, queen_of_diamonds2) );// 0

        // Нельзя сравнивать различные типы рангов
        System.out.println(king_of_diamonds.compareTo(crane_and_sun_of_diamonds) );//  0

        //isStandardCard
        System.out.println(king_of_diamonds.isStandardCard());// true
        System.out.println(crane_and_sun_of_diamonds.isStandardCard());// false

        System.out.println("End task 3");
    }

    public static void task4(){
        System.out.println("Start task 2");
        Deck deck = Deck.create(true);
        System.out.println("deck = " + deck);
        //random card
        System.out.println("random card = " + Deck.getRandomCard());

        //Раздаём карты
        Card card1 = deck.popBack();
        Card card2 = deck.popBack();
        Card card3 = deck.popBack();
        Card card4 = deck.popBack();
        System.out.println("card1 = " + card1 + " card2 = " + card2 + " card3 = " + card3 + " card4 = " + card4 );
        //Добавляем обратно
        deck.pushBack(card1);
        deck.pushBack(card1);
        deck.pushBack(card3);
        System.out.println("deck = " + deck);

        //shuffled
        deck.suffle();
        System.out.println("shuffled deck = " + deck);

        //sorted
        deck.sort();
        System.out.println("sorted deck = " + deck);

        while(!deck.isEmpty())
            deck.popBack();

        System.out.println("empty deck = " + deck);
        System.out.println("End task 4");
    }
}
