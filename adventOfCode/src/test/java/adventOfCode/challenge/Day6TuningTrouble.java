package adventOfCode.challenge;

import adventOfCode.utils.FileReader;

import static adventOfCode.utils.StringUtils.*;

import java.io.IOException;
import java.util.List;

public class Day6TuningTrouble {

    static String filename = "day6.txt";

    public static void main(String[] args) throws IOException {

        List<String> data = FileReader.readTextFile(filename);

        assert data != null;
        partOne(data.get(0));

    }

    static void partOne(String input) {

        String tempString = "";
        int diffCharSeqIndex = 14;
        boolean duplicateFlag = false;

        for (int i = 0; i < input.length(); i++) {

            String substring = input.substring(i, i + diffCharSeqIndex);

            if (!duplicateFlag) tempString += substring;
            else tempString = substring;

            if (checkIfDuplicates(tempString).isEmpty()) {
                int indexOfFirstStartOfPacketMarker = i + diffCharSeqIndex;
                System.out.println("first start of packet marker is complete after\n" +
                        indexOfFirstStartOfPacketMarker + " steps");
                break;
            } else {
                duplicateFlag = true;
            }
        }

    }


}
