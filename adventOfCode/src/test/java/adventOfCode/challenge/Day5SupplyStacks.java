package adventOfCode.challenge;

import adventOfCode.utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day5SupplyStacks {

    static String filename = "testdata5.csv";

    public static void main(String[] args) throws IOException {

        List<String[]> data = FileReader.readCSVallCoulumn(filename);

        partOne(data);

    }

    private static void partOne(List<String[]> data) {

        int noOfCrates = 0;
        int indexProcedure = 0;

        for (int i = 0; i < data.size(); i++) {
            String[] temp = data.get(i);
            for (String s : temp) {
                String[] temp3 = s.trim().split("\\s");
                for (String currVal : temp3) {
                    try {
                        Integer.parseInt(currVal.trim());
                        noOfCrates = Integer.parseInt(temp3[temp3.length - 1]);
                        break;
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                        break;
                    }
                }
                if (noOfCrates != 0) {
                    indexProcedure = i + 2;
                    break;
                }
            }
            if (noOfCrates != 0) {
                break;
            }
        }

        char[][] noOfStacksOfCrates = new char[indexProcedure - 2][noOfCrates];

        List<List<Character>> allStacks = getStacks(data, noOfStacksOfCrates, noOfCrates);
        List<String> procedure = getProcedure(data, indexProcedure);

        for (String temp : procedure) {
            int noOfCratesToMove, from, to;
            try {
                String[] a = temp.split(" ");
                noOfCratesToMove = Integer.parseInt(a[1]);
                from = Integer.parseInt(a[3]);
                to = Integer.parseInt(a[5]);


                while (noOfCratesToMove > 0) {
                    Character chToMove = allStacks.get(from - 1).get(0);
                    System.out.println("moving " + chToMove + " to " + (to - 1));

                    allStacks.get(to - 1).add(0, chToMove);
                    allStacks.get(from - 1).remove(chToMove);
                    System.out.println(allStacks.get(to - 1));

                    noOfCratesToMove--;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StringBuilder ans = new StringBuilder();
        for (List<Character> stacks : allStacks) {
            ans.append(stacks.get(0));
        }

        System.out.println(allStacks);

        System.out.println("ans part one is " + ans);
    }

    private static List<List<Character>> getStacks(List<String[]> data, char[][] noOfStacks, int noOfStack) {
        for (int row = 0; row < noOfStack - 1; row++) {
            int col = 0;
            char[] charArray = data.get(row)[0].toCharArray();
            for (int column = 1; column < charArray.length; column += 4) {
                char current = charArray[column];
                if (!Character.isWhitespace(current)) {
                    try {
                        noOfStacks[row][col] = current;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    noOfStacks[row][col] = ' ';
                }
                col++;
            }
        }

        List<List<Character>> allStacks = new ArrayList<>(noOfStacks.length);

        for (int i = 0; i <= noOfStacks.length; i++) {

            List<Character> tempList = new ArrayList<>();
            for (char[] ofStack : noOfStacks) {
                char ch = ofStack[i];
                if (!Character.isWhitespace(ch)) tempList.add(ch);

            }
            allStacks.add(tempList);
        }

        System.out.println("stacks of crates stored \n" + allStacks);
        return allStacks;
    }

    private static List<String> getProcedure(List<String[]> data, int indexProcedure) {
        System.out.println("procedure starts from  index " + indexProcedure);
        List<String> procedure = new ArrayList<>();

        for (int i = indexProcedure; i < data.size(); i++) {
            String[] temp = data.get(i);
            procedure.add(temp[0]);
        }
        return procedure;
    }


    private static Object partTwo(List<String[]> data) {
        return null;
    }

}
