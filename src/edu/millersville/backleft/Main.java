package edu.millersville.backleft;
package edu.millersville.backleft;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.ansi.WindowsTerminal;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Force Lanterna to avoid using Unix-like terminal settings
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();

            Screen screen = terminalFactory.createScreen();
            screen.startScreen();  // Start the screen

            MultiWindowTextGUI gui = new MultiWindowTextGUI(screen);
            BasicWindow window = new BasicWindow("UML Designer");

            Panel panel = new Panel();
            panel.setLayoutManager(new LinearLayout(Direction.VERTICAL));
            panel.addComponent(new Label("Welcome to UML Designer!"));
            panel.addComponent(new EmptySpace(new TerminalSize(0, 1))); // Spacer

            panel.addComponent(new Button("Exit", () -> {
                try {
                    screen.stopScreen();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }));

            window.setComponent(panel);
            gui.addWindowAndWait(window);

        } catch (IOException e) {
            System.err.println("An error occurred while starting the screen:");
            e.printStackTrace();
        }
    }
}

