package ua.com.goit.gojava7.salivon.dao;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Faq;

public interface FaqDao {

    public void saveFaq(Faq faq);

    public List<Faq> getContextFaq(int idProject);
}
