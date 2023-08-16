package wordle;
import javax.swing.*;
import java.awt.*;

/**
 * projectName: Mini Project
 * className: SingleBox
 * description: This class is used to control the single letter
 * createDate: 2022-05-28
 * @author: Yunxi Wang
 */

public class SingleBox extends JLabel{
    public SingleBox(){
        this.setText(" ");
        this.setBackground(new Color(255, 249, 239));
        this.setOpaque(true);

        this.setHorizontalAlignment(SwingConstants.CENTER);//center label text
        Font font = new Font("Calibri", Font.PLAIN, 45);
        this.setFont(font);
        this.setForeground(new Color(43, 41, 44));

    }

    public void changeColor(int set){

        this.setForeground(new Color(255, 255, 255));

        switch(set){
            case -1:
                this.setBackground(new Color(112, 111, 110));
                break;
            case 0:
                this.setBackground(new Color(252, 202, 117));
                break;
            case 1:
                this.setBackground(new Color(73, 141, 97));
                break;
            case 2://initialized case for a new game
                this.setBackground(new Color(255, 249, 239));//initialized the box color
                this.setForeground(new Color(43, 41, 44));//initialized the letter color
                break;
        }

    }

    public void changeLetter(String letter){
        this.setText(letter);

    }

    public String getLetter(){
        return this.getText();
    }

}
