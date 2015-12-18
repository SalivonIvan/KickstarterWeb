package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ua.com.goit.gojava7.salivon.beans.Quote;

public class StoreQuotes {

    private static List<Quote> quotes = new ArrayList<>();

    static {
        Quote quote1 = new Quote();
        quote1.setText("Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.");
        quote1.setAuthor("Albert Einstein");
        StoreQuotes.quotes.add(quote1);
        Quote quote2 = new Quote();
        quote2.setText("Be the change that you wish to see in the world.");
        quote2.setAuthor("Mahatma Gandhi");
        StoreQuotes.quotes.add(quote2);
        Quote quote3 = new Quote();
        quote3.setText("If you tell the truth, you don't have to remember anything.");
        quote3.setAuthor("Mark Twain");
        StoreQuotes.quotes.add(quote3);

    }

    public static List<Quote> getQuotes() {
        return quotes;
    }

    public static void setQuotes(List<Quote> quotes) {
        StoreQuotes.quotes = quotes;
    }

}
