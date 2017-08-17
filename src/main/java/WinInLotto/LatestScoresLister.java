package WinInLotto;

public class LatestScoresLister {

    public static String showLatestLottoScores (int numberOfPastScores) {

        StringBuilder latestScoresBuilder = new StringBuilder();

        for(int i = 0; i < numberOfPastScores; i++) {

            latestScoresBuilder.append(ScoresParser.parseScores().get(ScoresParser.getNewestScoreIndex()-i) + "\n");

        }

        return latestScoresBuilder.toString();

    }

}
