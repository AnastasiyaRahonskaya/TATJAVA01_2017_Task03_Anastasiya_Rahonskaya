package by.epam.catalog.dao.impl;

import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Class is for parsing given xml file
 */
public class CatalogParser {
  /**
   * method is for adding elements to the list
   *
   * @param eElement - element
   * @return elements' list
   */
  public ArrayList<String> addToList(Element eElement) {
    String CATEGORY = "category";
    String TITLE = "title";
    String AUTHOR = "author";
    String DATE = "date";
    ArrayList<String> list = new ArrayList<>();
    String category = eElement.getAttribute(CATEGORY);
    String title = eElement.getElementsByTagName(TITLE).item(0).getTextContent();
    String author = eElement.getElementsByTagName(AUTHOR).item(0).getTextContent();
    String date = eElement.getElementsByTagName(DATE).item(0).getTextContent();
    list.add("Category: " + category);
    list.add("Title: " + title);
    list.add("Author: " + author);
    list.add("Date: " + date);
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i) + " ");
    }
    return list;
  }
}
