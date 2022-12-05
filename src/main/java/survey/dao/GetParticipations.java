package survey.dao;

import survey.model.Participation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetParticipations {

    private static final String FILE_PATH = "src/main/resources/survey/OO - 2 - Participation.csv";


    public Map<Integer, List<Participation>> getParticipations(){
        Map<Integer, List<Participation>> participations = new HashMap<>();

        List<String> lines = GeneralFileReader.readLines(FILE_PATH);

        //skip the first line
        for (int i = 1; i < lines.size() ; i++) {

            Participation survey = getParticipation(lines.get(i));
            participations.computeIfAbsent(survey.memberId,l->new ArrayList<>()).add(survey);
        }

        return participations;
    }

    private Participation getParticipation(String line){
        String[] row = line.split(",");

        int length = 0;

        if(row.length > 3){
            length = Integer.parseInt(row[3]);
        }

        return new Participation(Integer.parseInt(row[0]),Integer.parseInt(row[1]),Integer.parseInt(row[2]),
                length);
    }



}
