import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;

public final class RollingDiceGUI extends JFrame {        // why final? remove yellow line from addGUIComponents
    public RollingDiceGUI(){
        super("Rolling Double Dice");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(700,700));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        addGUIComponents();
    }
    public void addGUIComponents(){
        JPanel JPanel=new JPanel();
        JPanel.setLayout(null);

        JLabel bannerImg=ImgService.loadImage("banner.png");
        bannerImg.setBounds(43,-130,600,400);
        JPanel.add(bannerImg);
        this.getContentPane().add(JPanel);

        JLabel dice1Img=ImgService.loadImage("dice1.png");
        dice1Img.setBounds(100,200,200,200);
        JPanel.add(dice1Img);
        this.getContentPane().add(JPanel);

        JLabel dice2Img=ImgService.loadImage("dice2.png");
        dice2Img.setBounds(390,200,200,200);
        JPanel.add(dice2Img);
        this.getContentPane().add(JPanel);

        Random rand=new Random();
        JButton RollButton=new JButton("Roll Dice");
        RollButton.setBounds(250,550,200,50);
        RollButton.addActionListener((ActionEvent e) -> {             
            RollButton.setEnabled(false);
            
            long startTime=System.currentTimeMillis();
            Thread rollThread=new Thread(new Runnable(){
                @Override
                public void run(){
                    long endTime=System.currentTimeMillis();
                    try {
                        while((endTime-startTime)/1000F<1){
                            
                            int dice1=rand.nextInt(1,7);
                            int dice2=rand.nextInt(1,7);
                            
                            ImgService.updateImage(dice1Img,"dice"+dice1+".png");
                            ImgService.updateImage(dice2Img,"dice"+dice2+".png");
                            repaint();
                            revalidate();
                            Thread.sleep(60);
                            endTime=System.currentTimeMillis();
                        }
                        RollButton.setEnabled(true);
                    } catch (InterruptedException e) {
                        System.out.println("Threading Error:"+e);
                    }
                }
            });
            rollThread.start();
        });
        JPanel.add(RollButton);
        this.getContentPane().add(JPanel);
    }
}
