package tn.m1pdam.forkids;

public class QuizQuestions {
    private String question;
    private String[] options;
    private String correctAnswer;

    public QuizQuestions(String question, String[] options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

