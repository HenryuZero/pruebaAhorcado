package secretoAhorcado;
public class secretoAhorcado {
    private String wordIn;

    public String getWord() {
        return wordIn;
    }

    public void setWord(String word) {
        wordIn = word;
    }

    @Override
    public String toString() {
        return "secretoAhorcado{" +
                "word='" + wordIn + '\'' +
                '}';
    }
}
