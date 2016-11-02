package word;

public class Word {
    private String initialForm;
    private String wordForm;

    public Word(String initialForm) {
        this(initialForm, null);
    }

    public Word(String initialForm, String wordForm){
        this.initialForm = initialForm;
        this.wordForm = wordForm;
    }

    public String getInitialForm() {
        return initialForm;
    }

    public String getWordForm() {
        return wordForm;
    }
}
