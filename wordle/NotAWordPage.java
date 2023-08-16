package wordle;

import javax.swing.*;
import java.awt.*;

/**
 * projectName: Mini Project
 * className: NotAWordPage
 * description: This class is used to create the frame that helps the user
 * createDate: 2022-05-30
 * @author: Yunxi Wang
 */


public class NotAWordPage extends JFrame {
    public NotAWordPage() {
        this.setTitle("This is a worning");
        this.setSize(300, 200);
        JLabel warning =new JLabel("This is not a word!");

        warning.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        Font font = new Font("Calibri", Font.PLAIN, 30);
        warning.setFont(font);

        this.getContentPane().add(BorderLayout.CENTER,warning);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
