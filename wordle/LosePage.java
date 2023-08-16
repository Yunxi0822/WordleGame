package wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * projectName: Mini Project
 * className: LosePage
 * description: This class is used to create the frame that tell user the result and ask them if or not to play again
 * createDate: 2022-06-03
 * @author: Yunxi Wang
 */

public class LosePage extends JFrame implements ActionListener {
    JButton b1 = new JButton("NO");
    JButton b2 = new JButton("YES");

    public LosePage() {

        JLabel l1=new JLabel("GAME FAILURE");
        l1.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        Font font1 = new Font("Calibri", Font.PLAIN, 40);
        l1.setFont(font1);
        l1.setForeground(new Color(118, 163, 189));

        JLabel l2=new JLabel("The answer is '"+AllBoxes.answer+"'.");
        l2.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        Font font2 = new Font("Calibri", Font.PLAIN, 25);
        l2.setFont(font2);
        l2.setForeground(new Color(43, 41, 44));

        JLabel l3=new JLabel("Do you want to play again?");
        l3.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        l3.setFont(font2);
        l3.setForeground(new Color(43, 41, 44));


        setLayout(null);
        setBounds(0, 0, 480, 320);

        Container c = getContentPane();

        b1.setBackground(new Color(112, 111, 110));
        b2.setBackground(new Color(112, 111, 110));

        l1.setBounds(0, 30, 480, 60);
        l2.setBounds(0, 100, 480, 60);
        l3.setBounds(0, 150, 480, 60);

        b1.setBounds(60, 200, 120, 30);
        b2.setBounds(300, 200, 120, 30);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(b2);
        c.add(b1);

        b1.addActionListener(this);
        b2.addActionListener(this);

        this.setResizable(false);//不允许修改窗口大小
        this.setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            //game over
            System.exit(1);
        }else if(e.getSource()==b2){
            //clear the last game so that open a new one
            AllBoxes.row=0;
            AllBoxes.col=0;
            AllBoxes.result=0;
            AllBoxes.correct = 0;
            Answer newAnswer=new Answer();
            AllBoxes.answer=newAnswer.getAnswer();
            System.out.println(AllBoxes.answer);
            for(int i=0;i<=5;i++){
                for(int j=0;j<=4;j++){
                    AllBoxes.changeWord(i,j," ");
                    AllBoxes.changeWordColor(i,j,2);

                }
            }

            this.dispose();//close this window
            //MainPage AnoNewGame = new MainPage();
        }
    }
}
