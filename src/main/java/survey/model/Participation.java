package survey.model;

public class Participation {
    private int memberId;
    private int surveyId;
    private int status;
    private int length;

    public Participation(int memberId, int surveyId, int status, int length) {
        this.memberId = memberId;
        this.surveyId = surveyId;
        this.status = status;
        this.length = length;
    }

    @Override
    public String toString() {
        return  memberId +
                ", surveyId=" + surveyId +
                ", status=" + status +
                ", length=" + length ;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(int surveyId) {
        this.surveyId = surveyId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
