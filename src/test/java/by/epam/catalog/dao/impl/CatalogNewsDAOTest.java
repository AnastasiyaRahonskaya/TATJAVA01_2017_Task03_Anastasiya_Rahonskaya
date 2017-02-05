package by.epam.catalog.dao.impl;

import by.epam.catalog.bean.News;
import by.epam.catalog.dao.exception.DAOException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/**
 * Unit-tests
 */
public class CatalogNewsDAOTest {
  private CatalogNewsDAO fileNewsDAO;
  private ArrayList<String> list;
  private ArrayList<String> newList;
  private News newNews;
  private News news;

  @BeforeMethod
  public void setUp() throws DAOException {
    fileNewsDAO = new CatalogNewsDAO();
    newList = new ArrayList<>();
    newList.add("Category: Film");
    newList.add("Title: Terminator");
    newList.add("Author: Jane");
    newList.add("Date: 26.10.1984");
    newNews = new News("Book", "Gone with the wind", "Margaret", "30.06.1936");
  }

  @Test
  public void testAddNew() throws DAOException {
    news = new News("Book", "Gone with the wind", "Margaret", "30.06.1936");
    news = fileNewsDAO.addNew(news);
    assertEquals(news, newNews);
  }

  @Test
  public void testFindByCategoryNotNull() throws Exception {
    String category = "Film";
    list = fileNewsDAO.findByCategory(category);
    assertNotNull(list);
  }

  @Test
  public void testFindByTitleNotNull() throws DAOException {
    String title = "Anna Karenina";
    list = fileNewsDAO.findByTitle(title);
    assertNotNull(list);
  }

  @Test
  public void testFindByAuthorNotNull() throws DAOException {
    String author = "Ray";
    list = fileNewsDAO.findByAuthor(author);
    assertNotNull(list);
  }

  @Test
  public void testFindDateNotNull() throws DAOException {
    String date = "06.08.1877";
    list = fileNewsDAO.findByDate(date);
    assertNotNull(list);
  }

  @Test
  public void testFindByCategory() throws DAOException {
    String category = "Film";
    list = fileNewsDAO.findByCategory(category);
    assertEquals(list, newList);
  }

  @Test
  public void testFindByTitle() throws DAOException {
    String title = "Terminator";
    list = fileNewsDAO.findByTitle(title);
    assertEquals(list, newList);
  }

  @Test
  public void testFindByAuthor() throws DAOException {
    String author = "Jane";
    list = fileNewsDAO.findByAuthor(author);
    assertEquals(list, newList);
  }

  @Test
  public void testFindByDate() throws DAOException {
    String date = "26.10.1984";
    list = fileNewsDAO.findByDate(date);
    assertEquals(list, newList);
  }

  @DataProvider(name = "DataProviderValidateInputDataAddNew")
  public Object[][] createDataForAddNew() {
    return new Object[][]{
        {new News("", "La La Land", "Emma", "09.01.2017")},
        {new News("Film", "", "Emma", "09.01.2017")},
        {new News("Film", "La La Land", "", "09.01.2017")},
        {new News("Film", "La La Land", "Emma", "")},
        {new News("", "", "", "")}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputDataAddNew", expectedExceptions = DAOException.class)
  public void testAddNewNegative(News news) throws DAOException {
    fileNewsDAO.addNew(news);
  }

  @DataProvider(name = "DataProviderValidateInputDataFindByCategory")
  public Object[][] createDataForFindByCategory() {
    return new Object[][]{
        {new String("Filmm")},
        {new String("")}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputDataFindByCategory", expectedExceptions = DAOException.class)
  public void testFindByCategoryNegative(String category) throws DAOException {
    fileNewsDAO.findByCategory(category);
  }

  @DataProvider(name = "DataProviderValidateInputDataFindByTitle")
  public Object[][] createDataForFindByTitle() {
    return new Object[][]{
        {new String("Anna Kareninaa")},
        {new String("")}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputDataFindByTitle", expectedExceptions = DAOException.class)
  public void testFindByTitleNegative(String category) throws DAOException {
    fileNewsDAO.findByCategory(category);
  }

  @DataProvider(name = "DataProviderValidateInputDataFindByAuthor")
  public Object[][] createDataForFindByAuthor() {
    return new Object[][]{
        {new String("Rayy")},
        {new String("")}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputDataFindByAuthor", expectedExceptions = DAOException.class)
  public void testFindByAuthorNegative(String category) throws DAOException {
    fileNewsDAO.findByCategory(category);
  }

  @DataProvider(name = "DataProviderValidateInputDataFindByDate")
  public Object[][] createDataForFindByDate() {
    return new Object[][]{
        {new String("07.07.2009")},
        {new String("")}
    };
  }

  @Test(dataProvider = "DataProviderValidateInputDataFindByDate", expectedExceptions = DAOException.class)
  public void testFindByDateNegative(String category) throws DAOException {
    fileNewsDAO.findByCategory(category);
  }
}