import javax.swing.*;
public class App {
    @SuppressWarnings("Convert2Lambda")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                new RollingDiceGUI().setVisible(true);
            }
        });
    }
}
