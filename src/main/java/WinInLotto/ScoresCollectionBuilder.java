package WinInLotto;

import java.util.ArrayList;
import java.util.List;

public class ScoresCollectionBuilder {

    private static List<String[]> scoresCollection = new ArrayList<>();

    static List<String[]> buildScoresCollection (List<String> dayScores) {

        dayScores.forEach(dayScore -> scoresCollection.add(dayScore.split(",")));

        return scoresCollection;
    }

}
