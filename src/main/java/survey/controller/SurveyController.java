package survey.controller;

import survey.dao.*;
import survey.model.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<Integer, List<Participation>> patricipationBySurveyId = new HashMap<>();


    // Adott kérdőívet kitöltők (Completed státuszúak) listája
    public List<Integer> getSurveyParticipant(int surveyId ){
        Map<Integer, List<Participation>> patricipationBySurveyId = getParticipationBySurveyId();

        int statusId = getStatusId(COMPLETED);

        return patricipationBySurveyId.get(surveyId).stream()
                .filter(p->p.getSurveyId() == surveyId)
                .filter(p->p.getStatus() == statusId)
                .map(Participation::getMemberId)
                .collect(Collectors.toList());
    }


    // Adott személy által kitöltött (Completed státuszú) kérdőívek listája
    public List<Survey> getSurveyCompletedByMember(int userId){
        int id = getStatusId(COMPLETED);

        return getParticipations().get(userId).stream()
                .filter(p->p.getStatus() == id)
                .map(p-> getSurveys().get(p.getSurveyId()))
                .collect(Collectors.toList());
    }



    // Adott személy által eddig gyűjtött pontok lekérdezése
    public AllPointsByMember getPointsByMember(int userId){
        Map<Integer, Survey> surveys = getSurveys();

        int filteredStatusId = getStatusId(FILTERED);
        int completionStatusId = getStatusId(COMPLETED);

        AllPointsByMember allPointsByMember = new AllPointsByMember(0,0);

        for (Participation participations : getParticipations().get(userId)) {

            if(participations.getStatus() == filteredStatusId ){
                allPointsByMember.filteredPoints += surveys.get(participations.getSurveyId()).filteredPoints;

            } else if (participations.getStatus() == completionStatusId){
                allPointsByMember.completionPoints += surveys.get(participations.getSurveyId()).completionPoints;
            }
        }
        return allPointsByMember;
    }


    // Adott kérdőívre meghívható (Még nem vett részt ebben a felmérésben és státusza aktív) személyek listázása
    public List<Member> getMembersForInvite(int surveyId ){
        Map<Integer, List<Participation>> patricipationBySurveyId = getParticipationBySurveyId();

        List<Member> members = getMembers();

        List<Integer> participants = patricipationBySurveyId.get(surveyId).stream()
                 .map(Participation::getMemberId)
                 .collect(Collectors.toList());

        return members.stream()
                .filter(Member::isActive)
                .filter(m->!participants.contains(m.getId()))
                .collect(Collectors.toList());
    }






    private Map<Integer, List<Participation>> getParticipationBySurveyId(){
        if(patricipationBySurveyId.isEmpty()){

            Map<Integer, List<Participation>> participations = getParticipations();

            for (List<Participation> participation : participations.values()) {

                for (Participation p : participation) {
                    patricipationBySurveyId.computeIfAbsent(p.getSurveyId(), n-> new ArrayList<>()).add(p);
                }
            }
        }
        return patricipationBySurveyId;
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
