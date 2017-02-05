package by.epam.catalog.controller.command.impl;

import by.epam.catalog.controller.command.Command;
import by.epam.catalog.service.NewsService;
import by.epam.catalog.service.exception.ServiceException;
import by.epam.catalog.service.factory.ServiceFactory;

/**
 * Class contains overridden method FindByTitle
 */
public class FindByTitle implements Command {
  /**
   * method is for executing request
   *
   * @param request - input command
   * @return response
   */
  @Override
  public String execute(String request) {
    String response = null;
    try {
      String title = request.split("/")[1];
      ServiceFactory serviceFactory = ServiceFactory.getInstance();
      NewsService newsService = serviceFactory.getNewsService();
      newsService.findByTitle(title);
    } catch (ServiceException | ArrayIndexOutOfBoundsException e) {
      //write log
      response = "Error while finding the news by title!";
      System.out.println(response);
    }
    return response;
  }
}