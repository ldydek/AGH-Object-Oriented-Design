package org.example.command.commands;

import org.example.command.Application;
import org.example.command.Editor;

public class CopyCommand extends Command {

    public CopyCommand(Application app, Editor editor) {
        super(app, editor);
    }

    @Override
    public void execute() {
        app.clipboard = editor.getSelection();
    }
}
