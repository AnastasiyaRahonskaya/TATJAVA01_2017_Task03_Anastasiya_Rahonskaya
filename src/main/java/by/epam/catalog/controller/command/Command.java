package by.epam.catalog.controller.command;

/**
 * Class contains interface for Controller layer
 */
public interface Command {
  /**
   * method is for executing request
   *
   * @param request - - input command
   * @return response
   */
  String execute(String request);
}
