package survey.dao;

import survey.model.Survey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetSurveys {

    private static final String FILE_PATH = "src/main/resources/survey/OO - 2 - Surveys.csv";


    public Map<Integer, Survey> getSurveys(){
        Map<Integer, Survey> surveys = new HashMap<>();

        List<String> lines = GeneralFileReader.readLines(FILE_PATH);

        //skip the first line
        for (int i = 1; i < lines.size() ; i++) {
            Survey survey = getSurvey(lines.get(i));
            surveys.put(survey.id,survey);
        }

        return surveys;
    }

    private Survey getSurvey(String line){
        String[] row = line.split(",");

        return new Survey(Integer.parseInt(row[0]), row[1], Integer.parseInt(row[2]),Integer.parseInt(row[3]),
                Integer.parseInt(row[4]));
    }



}
