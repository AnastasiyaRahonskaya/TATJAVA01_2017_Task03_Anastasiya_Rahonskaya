package by.epam.catalog.service;

import by.epam.catalog.bean.News;
import by.epam.catalog.service.exception.ServiceException;

/**
 * Class contains interface for Service layer
 */
public interface NewsService {
    /**
     * method is for adding the new
     *
     * @param news - object of the class News
     * @throws ServiceException - exceptions caused by Service layer
     */
    void addNew(News news) throws ServiceException;

    /**
     * method is for finding the new by category
     *
     * @param category - new's category
     * @throws ServiceException - exceptions caused by Service layer
     */
    void findByCategory(String category) throws ServiceException;

    /**
     * method is for finding thw new by title
     *
     * @param title - new's title
     * @throws ServiceException - exceptions caused by Service layer
     */
    void findByTitle(String title) throws ServiceException;

    /**
     * method is for finding the news by author
     *
     * @param author - new's author
     * @throws ServiceException - exceptions caused by Service layer
     */
    void findByAuthor(String author) throws ServiceException;

    /**
     * method is for finding the news by date
     *
     * @param date - new's date
     * @throws ServiceException - exceptions caused by Service layer
     */
    void findByDate(String date) throws ServiceException;
}
