package survey.model;

public class Participation {
    public int memberId;
    public int surveyId;
    public int status;
    public int length;

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
}
