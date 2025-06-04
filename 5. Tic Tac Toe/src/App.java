import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TicTacToeGui().setVisible(true);
        });
    }
}