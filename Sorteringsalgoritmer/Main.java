//https://github.uio.no/IN2010/oblig3_h20_src/blob/master/Oblig3.java

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.err.println("\u001B[31mError: Filename not included.\u001B[0m \n\nUsage: java Oblig3 <filename>");
            System.exit(1);
        }

        String filename = args[0];
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        int[] A = in.lines().mapToInt(i -> Integer.parseInt(i)).toArray();
        in.close();

        MainRunner.runAlgsPart1(A, filename);
        MainRunner.runAlgsPart2(A, filename);
    }
}
