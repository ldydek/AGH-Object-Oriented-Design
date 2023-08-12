package org.example.command;

import org.example.command.commands.*;

import javax.swing.*;
import java.awt.*;

public class Application {

    private final Editor activeEditor = new Editor();
    private final CommandHistory history = new CommandHistory();
    public String clipboard;

    public void createUI() {
        JFrame frame = new JFrame("Text editor (type & use buttons, Luke!)");
        JPanel content = new JPanel();
        frame.setContentPane(content);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        JTextArea textField = this.activeEditor.getJTextArea();
        textField.setLineWrap(true);
        content.add(textField);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton ctrlC = new JButton("Ctrl+C");
        JButton ctrlX = new JButton("Ctrl+X");
        JButton ctrlV = new JButton("Ctrl+V");
        JButton ctrlZ = new JButton("Ctrl+Z");
        Application application = this;

        ctrlC.addActionListener(e -> executeCommand(new CopyCommand(application, this.activeEditor)));
        ctrlX.addActionListener(e -> executeCommand(new CutCommand(application, this.activeEditor)));
        ctrlV.addActionListener(e -> executeCommand(new PasteCommand(application, this.activeEditor)));
        ctrlZ.addActionListener(e -> executeCommand(new UndoCommand(application, this.activeEditor)));

        buttons.add(ctrlC);
        buttons.add(ctrlX);
        buttons.add(ctrlV);
        buttons.add(ctrlZ);
        content.add(buttons);

        frame.setSize(450, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        if (history.isEmpty()) return;

        Command command = history.pop();
        System.out.println(command);
        if (command != null) {
            command.undo();
        }
    }
}
