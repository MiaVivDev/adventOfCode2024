package dev.miaviv.adventOfCode2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class DayOne {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = Paths.get("src/main/resources/dayOneInput.txt").toFile();
        Scanner inputScanner = new Scanner(inputFile);

        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        while (inputScanner.hasNext()) {
            String currentLine = inputScanner.nextLine();
            String[] splitLine = currentLine.split("   ");
            firstList.add(Integer.valueOf(splitLine[0]));
            secondList.add(Integer.valueOf(splitLine[1]));
        }

        long sumPartOne = compareTwoLists(firstList, secondList);
        System.out.println("Final Sum for Part One: " + sumPartOne);

        Map<Integer, Integer> similarityScoreMap = new HashMap<>();
        for (Integer i : firstList) {
            similarityScoreMap.put(i, Collections.frequency(secondList, i));
        }

        long sumPartTwo = getTotalSimilarityScore(firstList, similarityScoreMap);
        System.out.println("Final Sum for Part Two: " + sumPartTwo);
    }


    public static long compareTwoLists(List<Integer> firstList, List<Integer> secondList) {
        long sum = 0;

        Collections.sort(firstList);
        Collections.sort(secondList);

        for (int i = 0; i < firstList.size(); i++) {
            sum += Math.abs(firstList.get(i) - secondList.get(i));
        }

        return sum;
    }


    public static long getTotalSimilarityScore(List<Integer> firstList, Map<Integer, Integer> similarityMap) {
        long sum = 0;

        for(Integer i : firstList) {
            sum = sum + (long) i * similarityMap.get(i);
        }

        return sum;
    }


}