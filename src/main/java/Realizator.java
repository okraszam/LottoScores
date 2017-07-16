import WinInLotto.WinInLotto;

public class Realizator {

    static {
        System.out.println("Najpopularniejsze liczby w historii Dużego Lotka to: \n");
    }

    public static void main(String[] args) {

        System.out.println(WinInLotto.lottoScoreProbability(6));

    }

}
