import by.epam.catalog.controller.Controller;

import java.util.ArrayList;

/**
 * Start point of the program
 * This application  allows to keep news about films,
 * DVDs and books. Initial data for application keeps
 * in XML file. User can add the new and find the new
 * by category, by title and by author.
 */
public class Main {
  private static ArrayList<String> requestList;
  /**
   * List comes with commands and input data
   * via "/" in one string
   *
   * @param args - cmd arguments
   */
  public static void main(String[] args) {
    requestList = new ArrayList<>();
    InputDataReader inputDataReader = new InputDataReader();
    requestList = inputDataReader.readInputData();

    for (int i = 0; i < requestList.size(); i++) {
      Controller controller = new Controller();
      controller.executeTask(requestList.get(i));
    }
  }
}

