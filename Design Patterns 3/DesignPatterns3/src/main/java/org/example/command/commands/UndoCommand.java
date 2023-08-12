package org.example.command.commands;

import org.example.command.Application;
import org.example.command.Editor;

public class UndoCommand extends Command {

    public UndoCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        app.undo();
    }
}
