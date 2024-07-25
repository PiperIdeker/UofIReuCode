import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> toList(String line) {
        String str1[] = line.split(" ");
        List<String> currentList = Arrays.asList(str1);
        return currentList;
    }

    public static void main(String [] args){
        ArrayList<ArrayList<Double>> lengthArray = new ArrayList<>();
        String currentLine;
        String nextLine;
        List<String> currentList;
        List<String> nextList;
        int row = 0;
        int fixationCounter = 0;
        double startIndexForFixation = 0.0;
        double endIndexForFixation;
        double sum = 0.0;
        double maxDiff = 0.0;
        double diffStartIndex = 0.0;
        double maxFixation = 0.0;
        double fixationStartIndex = 0.0;
        double maxJump = 0.0;
        double jumpStartIndex = 0.0;
        double jumpSize;
        double maxFixationLine = 0.0;
        double fixationLineStartIndex = 0.0;
        int finalCounter = 0;
        int runLength2Counter = 0;
        int runLength3Counter = 0;
        int runLength4Counter = 0;
        int runLength5Counter = 0;
        int runLength6OrMoreCounter = 0;


        //Finds the input file in the "zeroID" folder, then writes a new file
        //that has the timestamp differences and fixations when present.
        //It writes the output folder in the "output" folder

        //If there is no fixations:
        //[Timestamp Difference, Current Timestamp, Next Timestamp]

        //If there is a fixation:
        //[Timestamp Difference, Current Timestamp(for timestamp difference), Next Timestamp(for timestamp difference),
        // Length of Fixation, Start Index For Fixation, End Index For Fixation, Jump Size  Number of Lines Repeated]

        try {
            File f1 = new File("zeroID\\zeroID_eHMI_early-07.txt");
            File f2 = new File("output\\eHMI_early-07_test_output.txt");
            Scanner sc = new Scanner(f1);
            FileWriter myWriter = new FileWriter(f2);

            currentLine = sc.nextLine();
            lengthArray.add(new ArrayList<>());

            while (sc.hasNext()){
                currentList = toList(currentLine);
                nextLine = sc.nextLine();
                nextList = toList(nextLine);


                //If the first number in the current line matches the one in the next line:
                if (currentList.get(0).equals("2") && nextList.get(0).equals("2")) {

                    //Save the difference between next timestamp and current time stamp
                    lengthArray.get(row).add(Double.parseDouble(nextList.get(1)) - Double.parseDouble(currentList.get(1)));
                    //Saves the timestamp of the current line
                    lengthArray.get(row).add(Double.parseDouble(currentList.get(1)));
                    //Saves the timestamp of the next line
                    lengthArray.get(row).add(Double.parseDouble(nextList.get(1)));

                    //If the z positions match, check if there is a fixation
                    if (currentList.get(5).equals(nextList.get(5))) {
                        //If there was no fixation, start the fixation counter and save the time stamp where the fixation started
                        if (fixationCounter == 0) {
                            startIndexForFixation = Double.parseDouble(currentList.get(1));
                        }
                        fixationCounter++;
                    //If the positions don't match, check if there was a previous fixation
                    } else if (!(currentList.get(5).equals(nextList.get(5)))) {
                        //If there was a fixation, that means the fixation ended.
                        //Adds the length of fixation, start index for fixation, end index for fixation, jump size, number of lines repeated
                        if (fixationCounter != 0) {
                            endIndexForFixation = Double.parseDouble(currentList.get(1));
                            jumpSize = (Double.parseDouble(nextList.get(5)) - Double.parseDouble(currentList.get(5)));
                            lengthArray.get(row).add((endIndexForFixation - startIndexForFixation));
                            lengthArray.get(row).add(startIndexForFixation);
                            lengthArray.get(row).add(endIndexForFixation);
                            lengthArray.get(row).add(Math.abs(jumpSize));
                            lengthArray.get(row).add((double) (fixationCounter + 1));

                            //Resets the fixation counter and the start index for fixation back to 0
                            fixationCounter = 0;
                            startIndexForFixation = 0;
                        }
                    }
                    lengthArray.add(new ArrayList<>());
                    row++;
                }
                currentLine = nextLine;
            }

            //Finds the maximum of the timestamp differences, fixation differences and fixation line
            //Also sorts the fixation lines into
            for (int i = 0; i < row; i++) {
                if (lengthArray.get(i).get(0) > maxDiff) {
                    maxDiff = lengthArray.get(i).get(0);
                    diffStartIndex = lengthArray.get(i).get(1);
                }

                //If the line has 8 elements:
                //Find the maximum of the timestamp differences, fixation differences and fixation line
                //Also sorts the fixation lines into number of two lines, three lines, ect...
                //Then write lengthArray with 8 elements
                if (lengthArray.get(i).size() == 8) {
                    if (lengthArray.get(i).get(3) > maxFixation) {
                        maxFixation = lengthArray.get(i).get(3);
                        fixationStartIndex = lengthArray.get(i).get(1);
                    }
                    if (lengthArray.get(i).get(6) > maxJump) {
                        maxJump = lengthArray.get(i).get(6);
                        jumpStartIndex = lengthArray.get(i).get(4);
                    }
                    if (lengthArray.get(i).get(7) > maxFixationLine) {
                        maxFixationLine = lengthArray.get(i).get(7);
                        fixationLineStartIndex = lengthArray.get(i).get(1);
                    }
                    if (lengthArray.get(i).get(7) == 2.0) {
                        runLength2Counter++;
                    }
                    if (lengthArray.get(i).get(7) == 3.0) {
                        runLength3Counter++;
                    }
                    if (lengthArray.get(i).get(7) == 4.0){
                        runLength4Counter++;
                    }
                    if(lengthArray.get(i).get(7) == 5.0){
                        runLength5Counter++;
                    }
                    if (lengthArray.get(i).get(7) >= 6.0){
                        runLength6OrMoreCounter++;
                    }
                    System.out.println(lengthArray.get(i).get(0) + " " + lengthArray.get(i).get(1) + " " + lengthArray.get(i).get(2) + " " + lengthArray.get(i).get(3) + " "
                            + lengthArray.get(i).get(4) + " " + lengthArray.get(i).get(5) + " " + lengthArray.get(i).get(6) + " " + lengthArray.get(i).get(7).intValue() + "\n");
                    //Writes all values to text files
                    myWriter.write(lengthArray.get(i).get(0) + " " + lengthArray.get(i).get(1) + " " + lengthArray.get(i).get(2) + " " + lengthArray.get(i).get(3) + " "
                            + lengthArray.get(i).get(4) + " " + lengthArray.get(i).get(5) + " " + lengthArray.get(i).get(6) + " " + lengthArray.get(i).get(7).intValue() + "\n");
                //If lengthArray does not have 8 elements, then it has 3 elements and will also write it to the output text file.
                }else {
                    System.out.println(lengthArray.get(i).get(0) + " " + lengthArray.get(i).get(1) + " " + lengthArray.get(i).get(2) + " " +  "\n");
                    myWriter.write(lengthArray.get(i).get(0) + " " + lengthArray.get(i).get(1) + " " + lengthArray.get(i).get(2) + " " +  "\n");
                }

                sum = sum + lengthArray.get(i).get(0);
                finalCounter++;
            }

            //Shows the final calculations
            System.out.println("File: " + f2 + "\n");
            System.out.println("Number of differences: " + finalCounter);
            System.out.println("Avg: " + (sum / finalCounter));
            System.out.println("Maximum Difference: " + maxDiff + ", starting at timestamp: " + diffStartIndex);
            System.out.println("Maximum Timestamp Fixation: " + maxFixation + ", starting at timestamp: " + fixationStartIndex);
            System.out.println("Maximum jump: " + maxJump + ", starting at timestamp: " + jumpStartIndex);
            System.out.println("Max Run Length: " + (int) maxFixationLine + ", starting at timestamp: " + fixationLineStartIndex);
            System.out.println("# Runs of Length 2: " + runLength2Counter);
            System.out.println("# Runs of Length 3: " + runLength3Counter);
            System.out.println("# Runs of Length 4: " + runLength4Counter);
            System.out.println("# Runs of Length 5: " + runLength5Counter);
            System.out.println("# Runs of Length 6 or more: " + runLength6OrMoreCounter);

            myWriter.flush();
            myWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}