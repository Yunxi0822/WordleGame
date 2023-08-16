package wordle;
import java.io.*;
import java.util.*;

/**
 * projectName: Mini Project
 * className: WordList
 * description: This class is used to read and save the words list
 * createDate: 2022-05-28
 * @author: Yunxi Wang
 */


public class WordList {
    static ArrayList<String> wordList;//静态列表 单词表

    public WordList() {
        try {
            //File file=new File("D:\\BUPT-Javacode\\MiniPro\\src\\wordle\\words.txt");
            //System.out.println(file.getPath());
            File file=new File("src/wordle/words.txt");
            //System.out.println(file.getPath());
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            wordList = new ArrayList<>();
            String wordLine = bufferedReader.readLine();
            while (wordLine != null) {
                wordList.add(wordLine);
                wordLine = bufferedReader.readLine();
            }
            fileReader.close();

        } catch (IOException ex1) {
            System.out.println("Errors1");
            System.exit(1);
        }
    }

}

