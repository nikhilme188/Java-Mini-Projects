// //import java.awt.Component;
// import java.awt.Cursor;
// import java.awt.Font;
// import java.awt.FontFormatException;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.File;
// import java.io.IOException;
// import javax.swing.*;
// public class ToDoListGUI extends JFrame implements ActionListener {

//     //task Panel will act as the cointainer for the task component panel
//     //task component panel will store all of the taskComponentPanel;
//     private JPanel taskPanel,taskComponentPanel;

//     public ToDoListGUI(){
//     super("To Do List");
//     setDefaultCloseOperation(EXIT_ON_CLOSE);
//     setPreferredSize(CommonConstants.GUI_SIZE);
//     pack();
//     setLocationRelativeTo(null);
//     setResizable(false);
//     setLayout(null);
//     addGUIComponents();
//     }
//     private void addGUIComponents(){
//         JLabel bannerLabel=new JLabel("To Do List");
//         bannerLabel.setFont(createFont("LEMONMILK-Light.otf",36f));
//         bannerLabel.setBounds(
//             (CommonConstants.GUI_SIZE.width - bannerLabel.getPreferredSize().width)/2,
//             15,
//             CommonConstants.BANNER_SIZE.width,
//             CommonConstants.BANNER_SIZE.height
//         );
//         this.getContentPane().add(bannerLabel);

//         //taskpanel
//         taskPanel=new JPanel();


//         //taskComponentPanel
//         taskComponentPanel=new JPanel();
//         taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel,BoxLayout.Y_AXIS));
//         taskPanel.add(taskComponentPanel);
//         JScrollPane scrollPane=new JScrollPane(taskPanel);
//         scrollPane.setBounds(8,70,CommonConstants.TASKPANEL_SIZE.width,CommonConstants.TASKPANEL_SIZE.height);
//         scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
//         scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
//         scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//         scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//         this.getContentPane().add(scrollPane);

//         //change the speed of scroll bar
//         JScrollBar verticalScrollbar=scrollPane.getVerticalScrollBar();
//         verticalScrollbar.setUnitIncrement(20);

//         JButton addTaskButton=new JButton("Add Task");
//         addTaskButton.setFont(createFont("LEMONMILK-Light.otf",18f));
//         addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//         addTaskButton.setBounds(-5,CommonConstants.GUI_SIZE.height-88,
//                                  CommonConstants.ADDTASK_BUTTON_SIZE.width,
//                                  CommonConstants.ADDTASK_BUTTON_SIZE.height
//         ); 
//         this.getContentPane().add(addTaskButton);
//     }

//     private Font createFont(String resource,float size){
       
//         //get the font file path
//         String filePath=getClass().getClassLoader().getResource(resource).getPath();

//         //check to see if thge path cointain a folder with spaces in them
//         if(filePath.contains("%20")){
//             filePath=getClass().getClassLoader().getResource(resource).getPath().replaceAll("%20","");
//         }

//         //create font
//         try {
//             File customFontFile=new File(filePath);
//             Font customFont=Font.createFont(Font.TRUETYPE_FONT,customFontFile).deriveFont(size);
//             return customFont;
//         } catch (FontFormatException | IOException e) {
//             System.out.println("Error"+e);
            
//         }
//         return null;
//     }
//     @Override
//     public void actionPerformed(ActionEvent e){
//         String command=e.getActionCommand();
//         if(command.equalsIgnoreCase("ADD TASK")){
//             //create task component
//             TaskComponent taskComponent=new TaskComponent(taskComponentPanel);
//             taskComponentPanel.add(taskComponent);

//             //make the previous task appear disabled
//             if(taskComponentPanel.getComponentCount()>1){
//                 TaskComponent previousTask=(TaskComponent) taskComponentPanel.getComponent(
//                     taskComponentPanel.getComponentCount()-2 );
//                     previousTask.getTaskField().setBackground(null);
//             } 
            
//             //make the task field request focus after creation
//             taskComponent.getTaskField().requestFocus();
//             repaint();
//             revalidate();
                    

//             }
//         }
// }



import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class ToDoListGUI extends JFrame implements ActionListener {

    private JPanel taskPanel, taskComponentPanel;

    public ToDoListGUI() {
        super("To Do List");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(CommonConstants.GUI_SIZE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        addGUIComponents();
    }

    private void addGUIComponents() {
        JLabel bannerLabel = new JLabel("To Do List");
        bannerLabel.setFont(createFont("LEMONMILK-Light.otf", 36f));
        bannerLabel.setBounds(10, 10, 300, 50);
        this.getContentPane().add(bannerLabel);

        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskComponentPanel = new JPanel();
        taskComponentPanel.setLayout(new BoxLayout(taskComponentPanel, BoxLayout.Y_AXIS));
        taskPanel.add(taskComponentPanel);

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(8, 70, CommonConstants.TASKPANEL_SIZE.width, CommonConstants.TASKPANEL_SIZE.height);
        scrollPane.setBorder(BorderFactory.createLoweredBevelBorder());
        scrollPane.setMaximumSize(CommonConstants.TASKPANEL_SIZE);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.getContentPane().add(scrollPane);

        JScrollBar verticalScrollbar = scrollPane.getVerticalScrollBar();
        verticalScrollbar.setUnitIncrement(20);

        JButton addTaskButton = new JButton("Add Task");
        addTaskButton.setFont(createFont("LEMONMILK-Light.otf", 18f));
        addTaskButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addTaskButton.setBounds(-5, CommonConstants.GUI_SIZE.height - 88,
                CommonConstants.ADDTASK_BUTTON_SIZE.width,
                CommonConstants.ADDTASK_BUTTON_SIZE.height);
        addTaskButton.addActionListener(this);
        this.getContentPane().add(addTaskButton);
    }

    private Font createFont(String resource, float size) {
        try {
            File customFontFile = new File(resource);
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, customFontFile).deriveFont(size);
            return customFont;
        } catch (FontFormatException | IOException e) {
            System.out.println("Error" + e);
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equalsIgnoreCase("ADD TASK")) {
            TaskComponent taskComponent = new TaskComponent(taskComponentPanel);
            taskComponentPanel.add(taskComponent);

            if (taskComponentPanel.getComponentCount() > 1) {
                TaskComponent previousTask = (TaskComponent) taskComponentPanel.getComponent(
                        taskComponentPanel.getComponentCount() - 2);
                previousTask.getTaskField().setBackground(null);
            }

            taskComponent.getTaskField().requestFocus();
            taskComponentPanel.revalidate();
            taskComponentPanel.repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ToDoListGUI().setVisible(true);
        });
    }
}