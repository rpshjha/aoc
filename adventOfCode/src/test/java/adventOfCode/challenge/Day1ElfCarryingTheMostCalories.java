package adventOfCode.challenge;

import adventOfCode.utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1ElfCarryingTheMostCalories {


    public static void main(String[] args) throws IOException {

        String filename = "testdata1.csv";

        List<List<Integer>> testData = new ArrayList<>();

        List<Integer> tempList = new ArrayList<>();

        for (int index = 0; index < FileReader.readCSV(filename).size(); index++) {

            String temp = FileReader.readCSV(filename).get(index);

            if (!temp.isEmpty()) {
                tempList.add(Integer.parseInt(temp));
            } else {
                testData.add(tempList);
                tempList = new ArrayList<>();
            }

            if (index == FileReader.readCSV(filename).size() - 1) {
                testData.add(tempList);
            }

        }

        System.out.println("test data is " + testData);

        int ans = findMostCalories(testData);

        System.out.println("ans is " + ans);
    }


    static int findMostCalories(List<List<Integer>> arrayList) {

        int maxSum = Integer.MIN_VALUE;

        List<Integer> sum = new ArrayList<>();

        for (List<Integer> temp : arrayList) {

            int tempSum = 0;
            for (int val : temp) {
                tempSum += val;
            }
            sum.add(tempSum);

            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }

        sum.sort(Collections.reverseOrder());

        int sumOfMaxThree = sum.get(0) + sum.get(1) + sum.get(2);
        System.out.println("array of sum " + sum);
        System.out.println("max sum is " + maxSum);
        System.out.println("sum of max three is " + sumOfMaxThree);
        return maxSum;
    }
}
