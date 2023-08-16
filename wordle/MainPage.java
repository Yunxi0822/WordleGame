package wordle;
import javax.swing.*;
import java.awt.BorderLayout;

/**
 * projectName: Mini Project
 * className: MainPage
 * description: This class is used to create the game's main interface
 * createDate: 2022-05-29
 * @author: Yunxi Wang
 */

public class MainPage extends JFrame{

    public MainPage(){
        this.setTitle("WordleGame By WYX Ver1.0.");
        this.setSize(480,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);//the window cannot be resized
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        AllBoxes allBoxes=new AllBoxes();
        MainPage NewGame = new MainPage();
        NewGame.getContentPane().add(BorderLayout.NORTH,new Title());
        NewGame.getContentPane().add(BorderLayout.CENTER,allBoxes);
        allBoxes.requestFocusInWindow();//get window's focus
    }

}
