package ua.com.goit.gojava7.salivon.dao;

import ua.com.goit.gojava7.salivon.beans.Quote;

public interface QuoteDao {

    public void addQuote(Quote quote);

    public Quote getRandomQuote();
}
