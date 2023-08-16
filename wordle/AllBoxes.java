package wordle;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * projectName: Mini Project
 * className: AllBoxes
 * description: This class is used to show words in the game's main interface
 * createDate: 2022-05-28
 *
 * @author: Yunxi Wang
 */

public class AllBoxes extends JPanel {
    static SingleBox[][] wordRows = new SingleBox[6][5];
    static int row;
    static int col;
    static int correct;
    static int result;

    static String answer = null;//static answer


    public AllBoxes() {
        //initialize the variables
        row = 0;
        col = 0;
        correct = 0;
        result = 0;

        setAnswer();//set a random word as the answer

        this.setLayout(new GridLayout(6, 5, 5, 5));
        for (SingleBox B[] : wordRows) {
            for (int i = 0; i <= 4; i++) {
                B[i] = new SingleBox();
                B[i].setSize(10, 10);
                this.add(B[i]);
            }
        }
         //inside class to listen the keyboard
        class KeyInput extends KeyAdapter {
            public void keyPressed(KeyEvent e) {
                System.out.print(e.getKeyChar() + "  ");

                if ((e.getKeyCode() == KeyEvent.VK_BACK_SPACE)&&(col!=0)) {
                    col = col - 1;
                    AllBoxes.changeWord(row, col, " ");
                    System.out.println("BackSpace");
                } else if(Character.isAlphabetic(e.getKeyChar())){
                    AllBoxes.changeWord(row, col, String.valueOf(e.getKeyChar()));
                    col++;
                }

                if (col == 5) {
                    if (!(checkIsWord(row))) {
                        NotAWordPage warn = new NotAWordPage();
                        for (int i = 0; i <= 4; i++) {
                            AllBoxes.changeWord(row, i, " ");
                        }
                        col = 0;
                    } else {
                        checkIsAns(row);
                        row++;
                        col = 0;
                    }
                }

                //to check if success or not
                if ((row == 6) && correct == 0) {
                    result = -1;
                } else if (correct == 1) {
                    result = 1;
                } else {
                    result = 0;
                }

                //call the win page or lose page to tell the user the result
                if (AllBoxes.result == 1) {
                    WinPage win = new WinPage();
                } else if (AllBoxes.result == -1) {
                    LosePage lose = new LosePage();
                }
            }
        }

        this.addKeyListener(new KeyInput());//listen the keyboard
        this.setVisible(true);
    }


    private void setAnswer() {
        Answer ans = new Answer();
        this.answer = ans.getAnswer();
        System.out.println(answer);
    }

    public static void changeWord(int i, int j, String letter) {
        wordRows[i][j].changeLetter(letter);
    }


    public char[] getWord(int r) {

        char[] word = new char[5];
        for (int i = 0; i <= 4; i++) {
            word[i] = wordRows[r][i].getLetter().charAt(0);
        }
        return word;
    }


    public boolean checkIsWord(int r) {
        String users = new String(getWord(r));
        System.out.println(users);
        System.out.println(WordList.wordList.contains(users));
        return (WordList.wordList.contains(users));
    }

    public void checkIsAns(int r) {
        int count = 0;//to count the number of correct letters
        for (int i = 0; i <= 4; i++) {
            if (answer.charAt(i) == getWord(r)[i]) {
                changeWordColor(r, i, 1);
                count++;
            } else if (answer.indexOf(getWord(r)[i]) == -1) {
                changeWordColor(r, i, -1);
            } else {
                changeWordColor(r, i, 0);
            }
        }
        if (count == 5) {
            correct = 1;
        }
    }

    public static void changeWordColor(int r, int c, int set) {
        wordRows[r][c].changeColor(set);
    }
}