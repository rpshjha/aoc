package adventOfCode.challenge;

import adventOfCode.utils.FileReader;

import java.io.IOException;
import java.util.List;

public class Day4CampCleanup {

    static String filename = "testdata4.csv";

    public static void main(String[] args) throws IOException {

        List<String[]> data = FileReader.readCSVallCoulumn(filename);

        int ans1 = partOne(data);

        System.out.println("ans part 1 is " + ans1);

        int ans2 = partTwo(data);

        System.out.println("ans part 2 is " + ans2);
    }


    private static int partOne(List<String[]> data) {

        int ans = 0;

        for (String[] currentData : data) {

            int s1 = Integer.parseInt(currentData[0].split("-")[0]);
            int e1 = Integer.parseInt(currentData[0].split("-")[1]);

            int s2 = Integer.parseInt(currentData[1].split("-")[0]);
            int e2 = Integer.parseInt(currentData[1].split("-")[1]);

//            .2345678.   2-8
//            ..34567..   3-7

//            .....6...  6-6
//            ...456...  4-6

            if (s1 <= s2 && e2 <= e1 ||
                    s2 <= s1 && e1 <= e2) {
                ans += 1;
            }

        }
        return ans;
    }

    private static int partTwo(List<String[]> data) {

        int ans = 0;

        for (String[] currentData : data) {

            int s1 = Integer.parseInt(currentData[0].split("-")[0]);
            int e1 = Integer.parseInt(currentData[0].split("-")[1]);

            int s2 = Integer.parseInt(currentData[1].split("-")[0]);
            int e2 = Integer.parseInt(currentData[1].split("-")[1]);


            if (s1 >= s2 && s1 <= e2) {
                ans += 1;
            } else if (e1 >= s2 && e1 <= e2) {
                ans += 1;
            } else if (s2 >= s1 && s2 <= e1) {
                ans += 1;
            } else if (e2 >= s1 && e2 <= e1) {
                ans += 1;
            }
        }
        return ans;
    }


}
