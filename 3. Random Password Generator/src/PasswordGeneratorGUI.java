import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class PasswordGeneratorGUI extends JFrame {
    private final PasswordGenerator passwordGenerator;
    public PasswordGeneratorGUI(){
        super("Password Generator");
        setSize(540,570);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        passwordGenerator=new PasswordGenerator();
        addGUIComponents();
    }
    private void addGUIComponents() {
        JLabel titleLabel=new JLabel("Password Generator");
        titleLabel.setFont(new Font("Dialog",Font.BOLD,32));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(0,10,540,39);
        add(titleLabel);

        JTextArea passwordOutput=new JTextArea();
        passwordOutput.setEditable(false);
        passwordOutput.setFont(new Font("Dialog",Font.BOLD,32));
        JScrollPane passwordOutputPane=new JScrollPane(passwordOutput);
        passwordOutputPane.setBounds(25,97,479,70);
        passwordOutputPane.setBounds(25,97,479,70);
        passwordOutputPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(passwordOutputPane);

        JTextArea passwordLengthInputArea =new JTextArea();
        passwordLengthInputArea.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthInputArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        passwordLengthInputArea.setBounds(310,215,192,39);
        add(passwordLengthInputArea);
        
        JLabel passwordLengthLabel=new JLabel("Password Length");
        passwordLengthLabel.setFont(new Font("Dialog",Font.PLAIN,32));
        passwordLengthLabel.setBounds(25,215,272,39);
        add(passwordLengthLabel);

        JToggleButton upperCaseToggle=new JToggleButton("Upper Case");
        upperCaseToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        upperCaseToggle.setBounds(25,302,225,56);
        add(upperCaseToggle);

        JToggleButton lowerCaseToggle=new JToggleButton("Lower Case");
        lowerCaseToggle.setBounds(282,302,225,56);
        lowerCaseToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        add(lowerCaseToggle);

        JToggleButton numbersToggle=new  JToggleButton("Numbers");
        numbersToggle.setBounds(25,373,225,56);
        numbersToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        add(numbersToggle);

        JToggleButton symbolsToggle=new JToggleButton("Symbols");
        symbolsToggle.setFont(new Font("Dialog",Font.PLAIN,32));
        symbolsToggle.setBounds(282,373,225,56);
        add(symbolsToggle);

        JButton generateButton=new JButton("Generate");
        generateButton.setFont(new Font("Dialog",Font.PLAIN,32));
        generateButton.setBounds(155,477,222,41);
        generateButton.addActionListener((ActionEvent e) -> {
            if(passwordLengthInputArea.getText().length()<=0) return;
            boolean anyToggleSelected=lowerCaseToggle.isSelected()||upperCaseToggle.isSelected()||numbersToggle.isSelected()||numbersToggle.isSelected()||symbolsToggle.isSelected();
            
            int passwordLength=Integer.parseInt(passwordLengthInputArea.getText());
            if(anyToggleSelected){
                String generatePassword=passwordGenerator.generatePassword(passwordLength,upperCaseToggle.isSelected(),lowerCaseToggle.isSelected(),numbersToggle.isSelected(),symbolsToggle.isSelected());
                passwordOutput.setText(generatePassword);
            }
        });
        add(generateButton);
    }


}
