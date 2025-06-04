// import java.awt.Color;
// import java.awt.Cursor;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.awt.event.FocusEvent;
// import java.awt.event.FocusListener;
// import javax.swing.*;
// public class TaskComponent extends JPanel implements ActionListener{
//     private final JCheckBox checkBox; //final addn
//     private JTextPane taskField;
//     private final JButton deleteButton;//final addn

//     public JTextPane getTaskField(){
//         return taskField;
//     }

//     //this panel is used so that we can make updates to the task component panel when deleting tasks
//     private final JPanel parentPanel; //final addn

//     public  TaskComponent(JPanel parentPanel){
//         this.parentPanel=parentPanel;

//         //task field
//         taskField= new JTextPane();
//         taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
//         taskField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
//         taskField.setContentType("text/html");
//         taskField.addFocusListener(new FocusListener(){
//             //indiacte which task field is currently being edited
//             @Override
//             public void focusGained(FocusEvent e){
//                 taskField.setBackground(Color.WHITE);
//             }
//             @Override
//             public void focusLost(FocusEvent e){
//                 taskField.setBackground(null);
//             }
//         });

//         checkBox=new JCheckBox();
//         checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
//         checkBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//         checkBox.addActionListener(this);

//         deleteButton=new JButton("X");
//         deleteButton.setPreferredSize(CommonConstants.DELETEBUTTON_SIZE);
//         deleteButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//         deleteButton.addActionListener(this);

//         this.add(checkBox);
//         this.add(taskField);//this added
//         this.add(deleteButton);

//     }

//     @Override
//     public void actionPerformed(ActionEvent e){
//         if(checkBox.isSelected()){
            
//             //replace al;l html tags to empty tringto grab the main text
//             String taskText=taskField.getText().replaceAll("<[^>]*>","");//<[^>]*> after^ >is added

//             //add Strike through Text
//             taskField.setText("<html><s>"+taskText+"</s></html>");
//         }
//         else if(!checkBox.isSelected()){
//             String taskText=taskField.getText().replaceAll("<[^>]*","");//<[^>]*> after^ >is added

//             taskField.setText(taskText);
//         }

//         if (e.getActionCommand().equalsIgnoreCase("X")){
//             //delete this component from the parent Panel
//             parentPanel.remove(this);
//             parentPanel.repaint();
//             parentPanel.revalidate();
//         }
//     }

    
   
// }
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TaskComponent extends JPanel implements ActionListener {
    private JTextField taskField;
    private JCheckBox checkBox;
    private JPanel parentPanel;

    public TaskComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;
        this.taskField = new JTextField(20);
        this.checkBox = new JCheckBox();
        this.checkBox.addActionListener(this);

        this.add(taskField);
        this.add(checkBox);
    }

    public JTextField getTaskField() {
        return taskField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");
            taskField.setText("<html><s>" + taskText + "</s></html>");
        } else if (!checkBox.isSelected()) {
            String taskText = taskField.getText().replaceAll("<[^>]*>", "");
            taskField.setText(taskText);
        }

        if (e.getActionCommand().equalsIgnoreCase("X")) {
            parentPanel.remove(this);
            parentPanel.repaint();
            parentPanel.revalidate();
        }
    }
}