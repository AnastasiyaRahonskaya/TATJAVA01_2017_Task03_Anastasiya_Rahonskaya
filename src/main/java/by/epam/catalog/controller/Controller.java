package by.epam.catalog.controller;

import by.epam.catalog.controller.command.Command;

/**
 * Class is for managing the commands
 */
public class Controller {
  private final CommandProvider provider = new CommandProvider();

  private final char paramSeparator = '/';

  /**
   * method is for executing the commands
   *
   * @param request - input command
   * @return response
   */
  public String executeTask(String request) {
    String commandName;
    Command executionCommand;
    commandName = request.substring(0, request.indexOf(paramSeparator));
    executionCommand = provider.getCommand(commandName);
    String response;
    response = executionCommand.execute(request);
    return response;
  }
}
