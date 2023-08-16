package wordle;

/**
 * projectName: Mini Project
 * className: Answer
 * description: This class is used to set the answer
 * createDate: 2022-05-28
 * @author: Yunxi Wang
 */


public class Answer {
    private String answer;

    public Answer(){
        WordList wordList=new WordList();//get the word list
        int size = WordList.wordList.size();
        int ansIndex = (int) (Math.random()*size) ;//get a random index
        answer=WordList.wordList.get(ansIndex);
    }

    public String getAnswer(){
        return answer;
    }
}
