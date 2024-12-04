package dev.miaviv.adventOfCode2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = Paths.get("src/main/resources/dayTwoInput.txt").toFile();
        Scanner inputScanner = new Scanner(inputFile);

        int safeReportsPartOne = 0;
        int safeReportsPartTwo = 0;

        while (inputScanner.hasNext()) {
            String currentLine = inputScanner.nextLine();
            String[] splitLine = currentLine.split(" ");
            List<Integer> integerList = new ArrayList<>();

            for(String s : splitLine) {
                integerList.addLast(Integer.valueOf(s));
            }

            if(isReportSafePartOne(integerList)) safeReportsPartOne++;
            if(isReportSafePartTwo(integerList)) safeReportsPartTwo++;
        }

        System.out.println("Total amount of safe reports - Part One: " + safeReportsPartOne);
        System.out.println("Total amount of safe reports - Part Two: " + safeReportsPartTwo);
    }


    public static boolean isReportSafePartOne(List<Integer> integerList) {
        boolean listIsAscending = integerList.get(0) < integerList.get(1);

        if (listIsAscending) return checkAscendingList(integerList);
        else return checkDescendingList(integerList);
    }


    public static boolean isReportSafePartTwo(List<Integer> integerList) {
        if (isReportSafePartOne(integerList)) {
            return true;
        } else {
            for(int z = 0; z < integerList.size(); z++) {
                int temp = integerList.get(z);
                integerList.remove(z);
                if(isReportSafePartOne(integerList)) {
                    return true;
                }
                integerList.add(z, temp);
            }
            return false;
        }
    }


    public static boolean checkAscendingList(List<Integer> integerList) {
        for(int i = 0; i < integerList.size() - 1; i++) {
            if (!(integerList.get(i) < integerList.get(i+1) && integerList.get(i+1) - integerList.get(i) <= 3 && integerList.get(i+1) - integerList.get(i) >= 1)) {
                return false;
            }
        }

        return true;
    }


    public static boolean checkDescendingList(List<Integer> integerList) {
        for(int i = 0; i < integerList.size() - 1; i++) {
            if (!(integerList.get(i) > integerList.get(i+1) && integerList.get(i) - integerList.get(i+1) <= 3 && integerList.get(i) - integerList.get(i+1) >= 1)) {
                return false;
            }
        }

        return true;
    }


}
