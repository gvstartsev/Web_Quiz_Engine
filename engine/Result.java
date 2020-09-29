package engine;

public class Result {
    private final String rightFeedback = "Congratulations, you're right!";
    private final String wrongFeedback = "Wrong answer! Please, try again.";
    private boolean success;
    private String feedback;

    public Result(boolean success) {
        this.success = success;
        this.feedback = success ? rightFeedback : wrongFeedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}