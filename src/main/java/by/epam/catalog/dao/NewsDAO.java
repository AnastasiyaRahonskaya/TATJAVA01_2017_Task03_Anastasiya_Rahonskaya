package by.epam.catalog.dao;

import by.epam.catalog.bean.News;
import by.epam.catalog.dao.exception.DAOException;

import java.util.ArrayList;

/**
 * The outer interface implementation of the DAO layer
 */
public interface NewsDAO {
  /**
   * method is for adding the new
   *
   * @param news - object of the class News
   * @throws DAOException - exceptions caused by DAO layer
   */
  News addNew(News news) throws DAOException;

  /**
   * method is for finding the new by category
   *
   * @param category - new's category
   * @throws DAOException - exceptions caused by DAO layer
   */
  ArrayList<String> findByCategory(String category) throws DAOException;

  /**
   * method is for finding thw new by title
   *
   * @param title - new's title
   * @throws DAOException - exceptions caused by DAO layer
   */
  ArrayList<String> findByTitle(String title) throws DAOException;

  /**
   * method is for finding the news by author
   *
   * @param author - new's author
   * @throws DAOException - exceptions caused by DAO layer
   */
  ArrayList<String> findByAuthor(String author) throws DAOException;

  /**
   * method is for finding the news by date
   *
   * @param date - new's date
   * @throws DAOException - exceptions caused by DAO layer
   */
  ArrayList<String> findByDate(String date) throws DAOException;
}
