package wordle;

import javax.swing.*;
import java.awt.*;

/**
 * projectName: Mini Project
 * className: Title
 * description: This class is create the game title
 * createDate: 2022-05-30
 * @author: Yunxi Wang
 */

public class Title extends JPanel {
    public Title() {
        JLabel title=new JLabel("Wordle Game");
        title.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        Font font = new Font("Calibri", Font.PLAIN, 30);
        title.setFont(font);
        this.add(title);

        this.setSize(480,300);
    }
}
