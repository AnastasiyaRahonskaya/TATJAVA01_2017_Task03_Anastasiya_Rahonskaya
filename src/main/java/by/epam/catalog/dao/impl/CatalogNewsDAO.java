package by.epam.catalog.dao.impl;

import by.epam.catalog.bean.News;
import by.epam.catalog.dao.NewsDAO;
import by.epam.catalog.dao.exception.DAOException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * The inner interface implementation of the DAO layer
 */
public class CatalogNewsDAO implements NewsDAO {
  private static final String CATEGORY = "category";
  private static final String TITLE = "title";
  private static final String AUTHOR = "author";
  private static final String DATE = "date";


  /**
   * method is for adding the new
   *
   * @param news - object of the class News
   * @throws DAOException - exceptions caused by DAO layer
   */
  @Override
  public String addNew(News news) throws DAOException {
    String FILENAME = "Catalog.xml";
    String STAFF = "staff";
    String resultAdding = null;
    try {
      final String filepath = System.getProperty("user.dir")
          + File.separator + FILENAME;
      final File xmlFile = new File(filepath);
      DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document doc = db.parse(xmlFile);
      doc.normalize();
      Node catalog = doc.getFirstChild();

      Element staff = doc.createElement(STAFF);
      staff.setAttribute(CATEGORY, news.getCategory());
      catalog.appendChild(staff);

      Element title = doc.createElement(TITLE);
      title.setTextContent(news.getTitle());
      staff.appendChild(title);

      Element author = doc.createElement(AUTHOR);
      author.setTextContent(news.getAuthor());
      staff.appendChild(author);

      Element date = doc.createElement(DATE);
      date.setTextContent(news.getDate());
      staff.appendChild(date);

      Transformer transformer = TransformerFactory.newInstance()
          .newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");
      DOMSource source = new DOMSource(doc);
      StreamResult result = new StreamResult(new File(filepath));
      transformer.transform(source, result);
      resultAdding = "The new added.";
    } catch (SAXException | IOException | ParserConfigurationException
        | TransformerConfigurationException e) {
      throw new DAOException("Error while adding the new!");
    } catch (TransformerException e) {
      throw new DAOException("Error while adding the new!");
    }
    return resultAdding;
  }

  /**
   * method is for finding the new by category
   *
   * @param category - new's category
   * @throws DAOException - exceptions caused by DAO layer
   */
  @Override
  public ArrayList<String> findByCategory(String category) throws DAOException {
    CatalogReader catalogReader = new CatalogReader();
    CatalogParser catalogParser = new CatalogParser();
    ArrayList<String> list = new ArrayList<>();
    try {
      for (int i = 0; i < catalogReader.readFile().getLength(); i++) {
        Node nNode = catalogReader.readFile().item(i);
        Element eElement = (Element) nNode;
        if (eElement.getAttribute(CATEGORY).equals(category)) {
          list = catalogParser.addToList(eElement);
        }
      }
      if (list == null) {
        throw new DAOException("Unfortunately, we don't have news with this category.");
      }
    } catch (Exception e) {
      throw new DAOException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by title
   *
   * @param title - new's title
   * @throws DAOException - exceptions caused by DAO layer
   */
  @Override
  public ArrayList<String> findByTitle(String title) throws DAOException {
    CatalogReader catalogReader = new CatalogReader();
    CatalogParser catalogParser = new CatalogParser();
    ArrayList<String> list = new ArrayList<>();
    try {
      for (int i = 0; i < catalogReader.readFile().getLength(); i++) {
        Node nNode = catalogReader.readFile().item(i);
        Element eElement = (Element) nNode;
        if (eElement.getElementsByTagName(TITLE).item(0).getTextContent().equals(title)) {
          list = catalogParser.addToList(eElement);
        }
      }
      if (list == null) {
        throw new DAOException("Unfortunately, we don't have news with this title.");
      }
    } catch (Exception e) {
      throw new DAOException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by author
   *
   * @param author - new's author
   * @throws DAOException - exceptions caused by DAO layer
   */
  @Override
  public ArrayList<String> findByAuthor(String author) throws DAOException {
    CatalogReader catalogReader = new CatalogReader();
    CatalogParser catalogParser = new CatalogParser();
    ArrayList<String> list = new ArrayList<>();
    try {
      for (int i = 0; i < catalogReader.readFile().getLength(); i++) {
        Node nNode = catalogReader.readFile().item(i);
        Element eElement = (Element) nNode;
        if (eElement.getElementsByTagName(AUTHOR).item(0).getTextContent().equals(author)) {
          list = catalogParser.addToList(eElement);
        }
      }
      if (list == null) {
        throw new DAOException("Unfortunately, we don't have news with this author.");
      }
    } catch (Exception e) {
      throw new DAOException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by date
   *
   * @param date - new's date
   * @throws DAOException - exceptions caused by DAO layer
   */
  @Override
  public ArrayList<String> findByDate(String date) throws DAOException {
    CatalogReader catalogReader = new CatalogReader();
    CatalogParser catalogParser = new CatalogParser();
    ArrayList<String> list = new ArrayList<>();
    try {
      for (int i = 0; i < catalogReader.readFile().getLength(); i++) {
        Node nNode = catalogReader.readFile().item(i);
        Element eElement = (Element) nNode;
        if (eElement.getElementsByTagName(DATE).item(0).getTextContent().equals(date)) {
          list = catalogParser.addToList(eElement);
        }
      }
      if (list == null) {
        throw new DAOException("Unfortunately, we don't have news with this date.");
      }
    } catch (Exception e) {
      throw new DAOException(e);
    }
    return list;
  }
}
