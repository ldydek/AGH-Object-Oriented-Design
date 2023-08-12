package org.example.command.commands;

import org.example.command.Application;
import org.example.command.Editor;

public abstract class Command {

    protected Application app;
    protected Editor editor;
    protected String backup;

    public Command(Application app, Editor editor) {
        this.app = app;
        this.editor = editor;
    }

    public void saveBackup() {
        this.backup = editor.getJTextArea().getText();
    }

    public void undo() {
        this.editor.getJTextArea().setText(backup);
    }

    public abstract boolean execute();
}
