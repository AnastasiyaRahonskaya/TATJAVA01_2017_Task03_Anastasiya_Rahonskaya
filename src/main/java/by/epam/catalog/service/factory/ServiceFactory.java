package by.epam.catalog.service.factory;

import by.epam.catalog.service.NewsService;
import by.epam.catalog.service.impl.NewsServiceImpl;

/**
 * Class contains the factory for Service layer
 */
public class ServiceFactory {
  public static final ServiceFactory instance = new ServiceFactory();
  private final NewsService newsService = new NewsServiceImpl();

  private ServiceFactory() {
  }

  /**
   * getter for instance
   *
   * @return instance
   */
  public static ServiceFactory getInstance() {
    return instance;
  }

  /**
   * getter got NewsService
   *
   * @return newsService
   */
  public NewsService getNewsService() {
    return newsService;
  }
}
