package survey.dao;

import survey.model.Member;

import java.util.ArrayList;
import java.util.List;

public class GetMembers {

    private static final String FILE_PATH = "src/main/resources/survey/OO - 2 - Members.csv";


    public List<Member> getMembers(){
        List<Member> members = new ArrayList<>();


        List<String> lines = GeneralFileReader.readLines(FILE_PATH);

        //skip the first line
        for (int i = 1; i < lines.size() ; i++) {
            Member m = getMember(lines.get(i));
            members.add(m);
        }

        return members;
    }

    private Member getMember(String line){
        String[] row = line.split(",");

        return new Member(Integer.parseInt(row[0]), row[1], row[2], row[3].equals("1"));
    }

}
