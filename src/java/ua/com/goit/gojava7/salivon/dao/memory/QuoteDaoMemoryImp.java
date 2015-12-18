package ua.com.goit.gojava7.salivon.dao.memory;

import java.util.List;
import java.util.Random;
import ua.com.goit.gojava7.salivon.beans.Quote;
import ua.com.goit.gojava7.salivon.dao.QuoteDao;
import ua.com.goit.gojava7.salivon.stores.StoreQuotes;

public class QuoteDaoMemoryImp implements QuoteDao {

    private StoreQuotes storeQuotes = new StoreQuotes();

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        List<Quote> quotes = storeQuotes.getQuotes();
        Quote quote;
        int number = (int) (random.nextDouble() * quotes.size());
        quote = quotes.get(number);
        return quote;
    }

}
