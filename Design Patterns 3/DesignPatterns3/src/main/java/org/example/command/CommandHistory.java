package org.example.command;

import org.example.command.commands.Command;

import java.util.LinkedList;

public class CommandHistory {

    private final LinkedList<Command> history = new LinkedList<>();

    public void push(Command command) {
        history.push(command);
    }

    public Command pop() {
        return history.pop();
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
