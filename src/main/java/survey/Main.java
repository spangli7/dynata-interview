package survey;

import survey.controller.SurveyController;

public class Main {
    public static void main(String[] args) {

        SurveyController controller = new SurveyController();

        controller.getSurveyParticipant(7);

        controller.getSurveyCompletedByMember(6);

        controller.getPointsByMember(7);

    }
}
