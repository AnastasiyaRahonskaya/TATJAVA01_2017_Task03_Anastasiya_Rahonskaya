package by.epam.catalog.dao.factory;

import by.epam.catalog.dao.NewsDAO;
import by.epam.catalog.dao.impl.CatalogNewsDAO;

/**
 * The outer interface implementation of the DAO layer
 */
public final class DAOFactory {
  private static final DAOFactory instance = new DAOFactory();
  private final NewsDAO fileNewsImpl = new CatalogNewsDAO();

  private DAOFactory() {
  }

  /**
   * getter for instance
   *
   * @return instance
   */
  public static DAOFactory getInstance() {
    return instance;
  }

  /**
   * getter for NewsDAO
   *
   * @return NewsDAO
   */
  public NewsDAO getNewsDAO() {
    return fileNewsImpl;
  }
}
