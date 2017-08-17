import WinInLotto.LatestScoresLister;
import WinInLotto.ScoresOrganizer;

public class TerminalApp {

    public static void main(String[] args) {

        System.out.println("Najpopularniejsze liczby w historii Dużego Lotka to:");
        System.out.println(ScoresOrganizer.showMostFrequentNumbers(12) + "\n\n");

        System.out.println("Ostatnie wyniki dużego lotka to:");
        System.out.println(LatestScoresLister.showLatestLottoScores(1));

    }

}
