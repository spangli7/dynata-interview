package survey.controller;

import survey.dao.GetMembers;
import survey.dao.GetParticipations;
import survey.dao.GetStatuses;
import survey.dao.GetSurveys;
import survey.model.Member;
import survey.model.Participation;
import survey.model.Survey;

import java.util.List;
import java.util.Map;

public class SurveyController {

    private GetMembers memberReader = new GetMembers();
    private GetSurveys getSurveys = new GetSurveys();
    private GetStatuses getStatuses = new GetStatuses();
    private GetParticipations getParticipations = new GetParticipations();


    private List<Member> members;
    private Map<Integer, Survey> surveys;
    private Map<Integer, String> statuses;
    private Map<Integer, List<Participation>> participations;
















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
