package by.epam.catalog.dao.impl;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * Class is for reading given xml file
 */
public class CatalogReader {
  private NodeList nList;

  /**
   * method is for reading file
   */
  public NodeList readFile() {
    String PATH = ".\\Catalog.xml";
    try {
      File fXmlFile = new File(PATH);
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(fXmlFile);
      doc.getDocumentElement().normalize();
      nList = doc.getElementsByTagName("staff");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nList;
  }
}
