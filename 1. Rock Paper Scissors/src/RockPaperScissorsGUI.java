import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class RockPaperScissorsGUI extends JFrame implements ActionListener{
    JLabel computerChoice;
    JLabel playerScoreLabel,computerScoreLabel;
    JButton RockButton ,PaperButton ,ScissorssButton;
    RockPaperScissor rockPaperScissor;
    public RockPaperScissorsGUI(){
        super("Rock Paper Scissors");
        setSize(450,574);
        setLayout(null);
        setLocationRelativeTo(null);
        addGUIComponents();
        rockPaperScissor = new RockPaperScissor();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void addGUIComponents(){
        
        computerScoreLabel=new JLabel("Computer:0");
        computerScoreLabel.setBounds(0,43,450,30);
        computerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        computerChoice=new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        playerScoreLabel=new JLabel("player:0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog",Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        RockButton = new JButton("Rock");
        RockButton.setBounds(40,387,105,81);
        RockButton.setFont(new Font("Dialog",Font.PLAIN,16));
        RockButton.addActionListener(this);
        add(RockButton);

        PaperButton = new JButton("Paper");
        PaperButton.setBounds(165,387,105,81);
        PaperButton.setFont(new Font("Dialog",Font.PLAIN,16));
        PaperButton.addActionListener(this);
        add(PaperButton);

        ScissorssButton = new JButton("Scissors");
        ScissorssButton.setBounds(290,387,105,81);
        ScissorssButton.setFont(new Font("Dialog",Font.PLAIN,16));
        ScissorssButton.addActionListener(this);
        add(ScissorssButton);
        //showDialog("Test Message");
    }
    private void showDialog(String message){
        JDialog resultDialog = new JDialog(this,"Result",true);
        resultDialog.setSize(227,124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(true);
        
        JLabel resultLabel=new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,10));
        resultLabel.setVerticalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel,BorderLayout.CENTER);// KNOW MORE ABOUT BORDER LAYOUT
        
        JButton tryAgainButton=new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                computerChoice.setText("?");
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String playerChoice=e.getActionCommand().toString();
        String result=rockPaperScissor.playRockPaperScissor(playerChoice);
        computerChoice.setText(rockPaperScissor.getComputerChoice());
        computerScoreLabel.setText("Computer:"+rockPaperScissor.getcomputerScore());
        playerScoreLabel.setText("Player:"+rockPaperScissor.getplayerScore());
        showDialog(result);
    }
}
