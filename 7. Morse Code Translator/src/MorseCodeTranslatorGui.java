import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;//Suggestion due to the error in the code Red line under  MorseCodeTranslatorGUi

public final class MorseCodeTranslatorGui extends JFrame implements KeyListener{//KeyListener is used here so that I can Listen to Key presses(Typing)

    private final MorseCodeController morseCodeController;
    
    //textInputArea- userinput (text to be translated)
    //morseCodeArea- output (translated text into morse code)
    private JTextArea textInputArea,morseCodeArea;
    
    public MorseCodeTranslatorGui(){
        super("Morse Code Translator"); // basically adds text to the title bar
        setSize(new Dimension(540,760));
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("25520451"));
        setLocationRelativeTo(null);
        morseCodeController=new MorseCodeController();
        addGuiComponents();
    }

    public void addGuiComponents(){

        //Title label
        JLabel titleLabel=new JLabel("Morse Code Translator");
        titleLabel.setBounds(0,0,540,100);
        titleLabel.setFont(new Font("Dialog",Font.BOLD,32));//changes the font size for the Label and the font weight
        titleLabel.setForeground(Color.WHITE);//changes the Font Color of the text to white 
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);//centers text (relative to its cointainer's width)

        //Text Input 
        JLabel textInputLabel=new JLabel("TEXT:");
        textInputLabel.setBounds(20,100,200,30);
        textInputLabel.setFont(new Font("Dialog",Font.BOLD,16));
        textInputLabel.setForeground(Color.WHITE);

        textInputArea=new JTextArea();
        textInputArea.setBounds(20,150,500,100);    
        textInputArea.setFont(new Font("Dialog",Font.PLAIN,18));
        textInputArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));//simulates padding of 10px in the text area
        textInputArea.setLineWrap(true);//make it so that word wrap to the next line after reaching the end of the text area
        textInputArea.setWrapStyleWord(true);// make it so that when the words do get wrap,the word doesn't split off
        textInputArea.addKeyListener(this);//make it so that we are listening to key presses whenever we are typing in this text area

        //add Scrolling ability to input text area
        JScrollPane  textInputScroll=new JScrollPane(textInputArea);
        textInputScroll.setBounds(20,132,484,236);

        //Morse Code input
        JLabel morseCodeInputLabel=new JLabel("Morse Code:");
        morseCodeInputLabel.setFont(new Font("Dialog",Font.PLAIN,16));
        morseCodeInputLabel.setForeground(Color.WHITE);
        morseCodeInputLabel.setBounds(20,390,200,30);

        morseCodeArea=new JTextArea();
        morseCodeArea.setFont(new Font("Dialog",Font.PLAIN,18));
        morseCodeArea.setEditable(false);
        morseCodeArea.setLineWrap(true);
        morseCodeArea.setWrapStyleWord(true);
        morseCodeArea.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        //add Scrolling ability to morse code input text area
        JScrollPane  morseCodeScroll=new JScrollPane(morseCodeArea);// this was wrong earlier JScrollPane  morseCodeScroll=new JScrollPane(morseCodeInputLabel);
        morseCodeScroll.setBounds(20,430,484,236);

        //play sound button
        JButton playSoundButton =new JButton("Play Sound");
        playSoundButton.setBounds(210,680,100,30);
        playSoundButton.addActionListener((ActionEvent e) -> {
            playSoundButton.setEnabled(false);//disable the play button (prevents the sound from getting interrupted)
            // Create a new thread for sound playback
            Thread playMorseCodeThread = new Thread(() -> {
                //attempt to play the morse code sound
                try {
                    // Retrieve the Morse code text and split it into an array
                    String[] morseCodeMessage = morseCodeArea.getText().split(" ");
                    
                    // Play the Morse code sounds
                    morseCodeController.playSound(morseCodeMessage);
                } catch (LineUnavailableException lineUnavailableException) {
                    // Handle audio system errors
                    System.out.println("Error: Audio system unavailable.");
                } catch (InterruptedException interruptedException) {
                    // Handle thread interruption errors
                    System.out.println("Error: Playback interrupted.");
                } finally {
                    // Re-enable the button after playback is complete
                    playSoundButton.setEnabled(true);
                }
            });
            
            // Start the thread
            playMorseCodeThread.start();
        });

        
        add(titleLabel);
        add(textInputLabel);
        add(textInputScroll);
        add(morseCodeInputLabel);
        add(morseCodeScroll);
        add(playSoundButton);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //ignore shift key press
        if (e.getKeyCode()!=KeyEvent.VK_SHIFT){
            //retrieve text input 
            String inputText=textInputArea.getText();
            //update the GUI with the translated text
            morseCodeArea.setText(morseCodeController.translateToMorse(inputText));
        }
    }
}
