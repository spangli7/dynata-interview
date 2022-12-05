package survey.controller;

import survey.dao.GetMembers;
import survey.model.Member;

import java.util.List;

public class SurveyController {

    GetMembers memberReader = new GetMembers();

    List<Member> members;

    public void reader(){
        System.out.println(getMembers());
    }



    private List<Member> getMembers(){
        if(members == null){
            members = memberReader.getMembers();
        }
        return members;
    }




}
