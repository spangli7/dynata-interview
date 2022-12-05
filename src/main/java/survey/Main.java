package survey;

import survey.controller.SurveyController;
import survey.model.AllPointsByMember;
import survey.model.Member;
import survey.model.Survey;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        SurveyController controller = new SurveyController();

        List<Integer> surveyParticipants = controller.getSurveyParticipant(7);
        System.out.println(surveyParticipants);

        List<Survey> surveyCompleted = controller.getSurveyCompletedByMember(6);
        System.out.println(surveyCompleted);


        AllPointsByMember memberPoints = controller.getPointsByMember(7);
        System.out.println(memberPoints);

        List<Member> members = controller.getMembersForInvite(6);
    }
}
