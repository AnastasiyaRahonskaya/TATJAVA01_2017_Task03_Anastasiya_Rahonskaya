package by.epam.catalog.controller;

import by.epam.catalog.controller.command.Command;
import by.epam.catalog.controller.command.commandName.CommandName;
import by.epam.catalog.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class is for access to instances of commands
 */
public class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.ADD_NEW, new AddNew());
        repository.put(CommandName.FIND_BY_CATEGORY, new FindByCategory());
        repository.put(CommandName.FIND_BY_TITLE, new FindByTitle());
        repository.put(CommandName.FIND_BY_AUTHOR, new FindByAuthor());
        repository.put(CommandName.FIND_BY_DATE, new FindByDate());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //write log
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
