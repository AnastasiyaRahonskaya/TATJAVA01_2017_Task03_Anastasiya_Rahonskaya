package by.epam.catalog.service.impl;

import by.epam.catalog.bean.News;
import by.epam.catalog.dao.NewsDAO;
import by.epam.catalog.dao.exception.DAOException;
import by.epam.catalog.dao.factory.DAOFactory;
import by.epam.catalog.service.NewsService;
import by.epam.catalog.service.exception.ServiceException;

import java.util.ArrayList;

/**
 * Class contains the implementation of the interface NewsService
 */
public class NewsServiceImpl implements NewsService {
  private ArrayList<String> list;
  /**
   * method is for adding the new
   *
   * @param news - object of the class News
   * @throws ServiceException - exceptions caused by Service layer
   */
  @Override
  public String addNew(News news) throws ServiceException {
    validation(news);
    DAOFactory daoObjectFactory = DAOFactory.getInstance();
    String resultAdding = null;
    try {
      NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
      resultAdding = newsDAO.addNew(news);
    } catch (DAOException e) {
      throw new ServiceException(e);
    }
    return resultAdding;
  }

  /**
   * method is for finding the new by category
   *
   * @param category - new's category
   * @throws ServiceException - exceptions caused by Service layer
   */
  @Override
  public ArrayList<String> findByCategory(String category) throws ServiceException {
    validation(category);
    try {
      DAOFactory daoObjectFactory = DAOFactory.getInstance();
      NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
      list = newsDAO.findByCategory(category);
    } catch (DAOException e) {
      throw new ServiceException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by title
   *
   * @param title - new's title
   * @throws ServiceException - exceptions caused by Service layer
   */
  @Override
  public ArrayList<String> findByTitle(String title) throws ServiceException {
    validation(title);
    try {
      DAOFactory daoObjectFactory = DAOFactory.getInstance();
      NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
      list = newsDAO.findByTitle(title);
    } catch (DAOException e) {
      throw new ServiceException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by author
   *
   * @param author - new's author
   * @throws ServiceException - exceptions caused by Service layer
   */
  @Override
  public ArrayList<String> findByAuthor(String author) throws ServiceException {
    validation(author);
    try {
      DAOFactory daoObjectFactory = DAOFactory.getInstance();
      NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
      list = newsDAO.findByAuthor(author);
    } catch (DAOException e) {
      throw new ServiceException(e);
    }
    return list;
  }

  /**
   * method is for finding the new by date
   *
   * @param date - new's date
   * @throws ServiceException - exceptions caused by Service layer
   */
  @Override
  public ArrayList<String> findByDate(String date) throws ServiceException {
    validation(date);
    try {
      DAOFactory daoObjectFactory = DAOFactory.getInstance();
      NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
      list = newsDAO.findByDate(date);
    } catch (DAOException e) {
      throw new ServiceException(e);
    }
    return list;
  }

  /**
   * method is for validate input data
   *
   * @param news - object of the class News
   */
  public void validation(News news) throws ServiceException {
    if (news.getCategory().isEmpty() | news.getAuthor().isEmpty() | news.getTitle().isEmpty() | news.getDate().isEmpty()) {
      throw new ServiceException("Error while adding the news!");
    }
  }

  /**
   * method is for validate input data
   *
   * @param s - input data
   */
  public void validation(String s) throws ServiceException{
    if (s.isEmpty()) {
      throw new ServiceException("Error!");
    }
  }
}
