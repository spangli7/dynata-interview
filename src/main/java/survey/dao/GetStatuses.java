package survey.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStatuses {

    private static final String FILE_PATH = "src/main/resources/survey/OO - 2 - Statuses.csv";


    public Map<Integer, String> getStatuses(){
        Map<Integer, String> statuses = new HashMap<>();

        List<String> lines = GeneralFileReader.readLines(FILE_PATH);

        //skip the first line
        for (int i = 1; i < lines.size() ; i++) {
            String[] row = lines.get(i).split(",");

            statuses.put(Integer.parseInt(row[0]), row[1]);

        }

        return statuses;
    }



}
