package survey.controller;

import survey.dao.GetMembers;
import survey.dao.GetParticipations;
import survey.dao.GetStatuses;
import survey.dao.GetSurveys;
import survey.model.AllPointsByMember;
import survey.model.Member;
import survey.model.Participation;
import survey.model.Survey;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SurveyController {
    private static final String COMPLETED = "Completed";
    private static final String FILTERED = "Filtered";

    private GetMembers memberReader = new GetMembers();
    private GetSurveys getSurveys = new GetSurveys();
    private GetStatuses getStatuses = new GetStatuses();
    private GetParticipations getParticipations = new GetParticipations();


    private List<Member> members;
    private Map<Integer, Survey> surveys;
    private Map<Integer, String> statuses;
    private Map<Integer, List<Participation>> participations;



    public List<Integer> getSurveyParticipant(int surveyId ){
        int statusId = getStatusId(COMPLETED);

        return getParticipations().get(surveyId).stream()
                .filter(p->p.getSurveyId() == surveyId)
                .filter(p->p.getStatus() == statusId)
                .map(Participation::getMemberId)
                .collect(Collectors.toList());
    }



    public List<Survey> getSurveyCompletedByMember(int userId){
        int id = getStatusId(COMPLETED);

        return getParticipations().get(userId).stream()
                .filter(p->p.getStatus() == id)
                .map(p-> surveys.get(p.getSurveyId()))
                .collect(Collectors.toList());
    }




    public AllPointsByMember getPointsByMember(int userId){
        Map<Integer, Survey> surveys = getSurveys();

        int filteredPointId = getStatusId(FILTERED);
        int completionPointId = getStatusId(COMPLETED);

        AllPointsByMember allPointsByMember = new AllPointsByMember(0,0);

        for (Participation participations : getParticipations().get(userId)) {

            if(participations.getStatus() == filteredPointId ){
                allPointsByMember.filteredPoints += surveys.get(participations.getSurveyId()).filteredPoints;

            } else if (participations.getStatus() == completionPointId){
                allPointsByMember.completionPoints += surveys.get(participations.getSurveyId()).completionPoints;
            }
        }
        return allPointsByMember;
    }








    private int getStatusId(String status){

        for (Map.Entry<Integer,String> statuses : getStatuses().entrySet()) {
            if (statuses.getValue().equals(status)){
                return statuses.getKey();
            }
        }
        return 0;
    } 





    private List<Member> getMembers(){
        if(members == null){
            members = memberReader.getMembers();
        }
        return members;
    }


    private Map<Integer, Survey> getSurveys(){
        if(surveys == null){
            surveys = getSurveys.getSurveys();
        }
        return surveys;
    }

    private Map<Integer, String> getStatuses(){
        if(statuses == null){
            statuses = getStatuses.getStatuses();
        }
        return statuses;
    }

    private Map<Integer, List<Participation>> getParticipations(){
        if(participations == null){
            participations = getParticipations.getParticipations();
        }
        return participations;
    }




}
