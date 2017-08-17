package WinInLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScoresOrganizer {

    private static int smallestNumber = 1;
    private static int biggestNumber = 49;
    private static List<Integer> collectionOfNumbers = new ArrayList<>();
    private static List<Integer> scoresProbability = new ArrayList<>();
    private static List<String> sortedProbabilityTemp = new ArrayList<>();
    private static List<String> sortedProbability = new ArrayList<>();
    private static List<String> bestOfTheBest = new ArrayList<>();

    public static List<String> showMostFrequentNumbers (int numberBetween1and49) {

        sortedProbability.addAll(ScoresOrganizer.numbersProbabilityOrganizer(ScoresCollectionBuilder
                                                                                .buildScoresCollection(ScoresParser
                                                                                                                 .parseScores())));
        if(numberBetween1and49 > biggestNumber || numberBetween1and49 < smallestNumber) {
            bestOfTheBest.add("Please choose different number.");
            return bestOfTheBest;
        } else {
            for (int i = 0; i < numberBetween1and49; i++) {
                bestOfTheBest.add(sortedProbabilityTemp.get(i));
            }
            return bestOfTheBest;
        }
    }

    private static List<String> numbersProbabilityOrganizer (List<String[]> scoresCollection) {

        for(String[] scoreArray : scoresCollection) {
            for(String number : scoreArray) {
                collectionOfNumbers.add(Integer.valueOf(number));
            }
        }

        for(int i = 0; i < 49; i++) {
            scoresProbability.add(i, Collections.frequency(collectionOfNumbers, i+1));
        }

        for(int i = 0; i < 49; i++) {
            sortedProbabilityTemp.add(i, i+1 + " -> " + String.valueOf(scoresProbability.get(i)));
        }

        sortedProbabilityTemp.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int firstOccurency = Integer.valueOf(o1.replaceAll("[\\d]* -> ", ""));
                int secondOccurency = Integer.valueOf(o2.replaceAll("[\\d]* -> ", ""));

                if(firstOccurency < secondOccurency) {
                    return 1;
                } else if (firstOccurency > secondOccurency) {
                    return -1;
                } else return 0;
            }
        });

        return sortedProbabilityTemp;
    }

}
