package org.example.command;

import javax.swing.*;

public class Editor {

    private final JTextArea jTextArea = new JTextArea();

    public String getSelection() {
        return this.jTextArea.getText();
    }

    public void deleteSelection() {
        this.jTextArea.setText("");
    }

    public void replaceSelection(String text) {
        this.jTextArea.append("\n");
        this.jTextArea.append(text);
    }

    public JTextArea getJTextArea() {
        return this.jTextArea;
    }
}
