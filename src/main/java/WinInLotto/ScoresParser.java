package WinInLotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ScoresParser {

    private static String lottoDataPath = "http://www.mbnet.com.pl/dl.txt";
    private static List<String> dayScores = new ArrayList<>();
    private static String lineOfData;

    static List<String> parseScores () {

        try (BufferedReader scoresDataStream = new BufferedReader(new InputStreamReader(new URL(lottoDataPath).openStream()))) {

            while((lineOfData = scoresDataStream.readLine()) != null) {
                dayScores.add(lineOfData.replaceAll("[\\d]*. [\\d]{2}.[\\d]{2}.[\\d]{4} ","").trim());
            }

        } catch (IOException e) {
            System.out.println("Something went wrong with Lotto scores file.\n");
            e.printStackTrace();
        }

        return dayScores;
    }

    static int getNewestScoreIndex () {

        return ScoresParser.parseScores().size()-1;

    }

}
