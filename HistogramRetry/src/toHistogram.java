import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class toHistogram {
    public static List<String> toList(String line){
        String[] str1 = line.split(" ");
        return Arrays.asList(str1);
    }

    public static void main(String[] args) {
        int lessThanZeroPtZeroOne = 0;
        int lessThanZeroPtZeroTwo = 0;
        int lessThanZeroPtZeroThree = 0;
        int lessThanZeroPtZeroFour = 0;
        int lessThanZeroPtZeroFive = 0;
        int lessThanZeroPtZeroSix = 0;
        int lessThanZeroPtZeroSeven = 0;
        int lessThanZeroPtZeroEight = 0;
        int lessThanZeroPtZeroNine = 0;
        int lessThanZeroPtOne = 0;
        int lessThanZeroPtOneOne = 0;
        int lessThanZeroPtOneTwo = 0;
        int lessThanZeroPtOneThree = 0;
        int lessThanZeroPtOneFour = 0;
        int lessThanZeroPtOneFive = 0;
        int lessThanZeroPtOneSix = 0;
        int lessThanZeroPtOneSeven = 0;
        int lessThanZeroPtOneEight = 0;
        int lessThanZeroPtOneNine = 0;
        int lessThanZeroPtTwo = 0;
        int moreThanZeroPtTwo = 0;
        List<String> currentList = null;
        String currentLine;
        String nextLine = null;


        //Finds the input file in the "output" folder, then writes a new file
        //that sorts the data into 21 bins. Then saves it in the "outputToHistogram" folder.
        try {
            File f1 = new File("output\\eHMI_early-03_output.txt");
            File f2 = new File("outputToHistogram\\eHMI_early-03_histogram.txt");
            Scanner sc = new Scanner(f1);
            currentLine = sc.nextLine();

            while (sc.hasNext()) {
                currentList = toList(currentLine);
                nextLine = sc.nextLine();
                System.out.println("\ncurr: " + currentList);

                //sorts each timestamp differences
                if(Double.parseDouble(currentList.get(0)) <= 0.01 ){
                    lessThanZeroPtZeroOne++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in value <= 0.01: " + lessThanZeroPtZeroOne);
                }else if(Double.parseDouble(currentList.get(0)) > 0.01 && Double.parseDouble(currentList.get(0)) <= 0.02){
                    lessThanZeroPtZeroTwo++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.01 < value <= 0.02 : " + lessThanZeroPtZeroTwo);
                }else if(Double.parseDouble(currentList.get(0)) > 0.02 && Double.parseDouble(currentList.get(0)) <= 0.03){
                    lessThanZeroPtZeroThree++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.02 < value <= 0.03 : " + lessThanZeroPtZeroThree);
                }else if(Double.parseDouble(currentList.get(0)) > 0.03 && Double.parseDouble(currentList.get(0)) <= 0.04){
                    lessThanZeroPtZeroFour++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.03 < value <= 0.04 : " + lessThanZeroPtZeroFour);
                }else if(Double.parseDouble(currentList.get(0)) > 0.04 && Double.parseDouble(currentList.get(0)) <= 0.05){
                    lessThanZeroPtZeroFive++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.04 < value <= 0.05 : " + lessThanZeroPtZeroFive);
                }else if(Double.parseDouble(currentList.get(0)) > 0.05 && Double.parseDouble(currentList.get(0)) <= 0.06){
                    lessThanZeroPtZeroSix++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.05 < value <= 0.06 : " + lessThanZeroPtZeroSix);
                }else if(Double.parseDouble(currentList.get(0)) > 0.06 && Double.parseDouble(currentList.get(0)) <= 0.07){
                    lessThanZeroPtZeroSeven++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.06 < value <= 0.07 : " + lessThanZeroPtZeroSeven);
                }else if(Double.parseDouble(currentList.get(0)) > 0.07 && Double.parseDouble(currentList.get(0)) <= 0.08){
                    lessThanZeroPtZeroEight++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.07 < value <= 0.08 : " + lessThanZeroPtZeroEight);
                }else if(Double.parseDouble(currentList.get(0)) > 0.08 && Double.parseDouble(currentList.get(0)) <= 0.09){
                    lessThanZeroPtZeroNine++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.08 < value <= 0.09 : " + lessThanZeroPtZeroNine);
                }else if(Double.parseDouble(currentList.get(0)) > 0.09 && Double.parseDouble(currentList.get(0)) <= 0.1){
                    lessThanZeroPtOne++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.09 < value <= 0.10 : " + lessThanZeroPtOne);
                }else if(Double.parseDouble(currentList.get(0)) > 0.1 && Double.parseDouble(currentList.get(0)) <= 0.11){
                    lessThanZeroPtOneOne++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.10 < value <= 0.11 : " + lessThanZeroPtOneOne);
                }else if(Double.parseDouble(currentList.get(0)) > 0.11 && Double.parseDouble(currentList.get(0)) <= 0.12){
                    lessThanZeroPtOneTwo++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.11 < value <= 0.12 : " + lessThanZeroPtOneTwo);
                }else if(Double.parseDouble(currentList.get(0)) > 0.12 && Double.parseDouble(currentList.get(0)) <= 0.13){
                    lessThanZeroPtOneThree++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.12 < value <= 0.13 : " + lessThanZeroPtOneThree);
                }else if(Double.parseDouble(currentList.get(0)) > 0.13 && Double.parseDouble(currentList.get(0)) <= 0.14){
                    lessThanZeroPtOneFour++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.13 < value <= 0.14 : " + lessThanZeroPtOneFour);
                }else if(Double.parseDouble(currentList.get(0)) > 0.14 && Double.parseDouble(currentList.get(0)) <= 0.15){
                    lessThanZeroPtOneFive++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.14 < value <= 0.15 : " + lessThanZeroPtOneFive);
                }else if(Double.parseDouble(currentList.get(0)) > 0.15 && Double.parseDouble(currentList.get(0)) <= 0.16){
                    lessThanZeroPtOneSix++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.15 < value <= 0.16 : " + lessThanZeroPtOneSix);
                }else if(Double.parseDouble(currentList.get(0)) > 0.16 && Double.parseDouble(currentList.get(0)) <= 0.17){
                    lessThanZeroPtOneSeven++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.16 < value <= 0.17 : " + lessThanZeroPtOneSeven);
                }else if(Double.parseDouble(currentList.get(0)) > 0.17 && Double.parseDouble(currentList.get(0)) <= 0.18){
                    lessThanZeroPtOneEight++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.17 < value <= 0.18 : " + lessThanZeroPtOneEight);
                }else if(Double.parseDouble(currentList.get(0)) > 0.18 && Double.parseDouble(currentList.get(0)) <= 0.19){
                    lessThanZeroPtOneNine++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.18 < value <= 0.19 : " + lessThanZeroPtOneNine);
                }else if(Double.parseDouble(currentList.get(0)) > 0.19 && Double.parseDouble(currentList.get(0)) <= 0.20){
                    lessThanZeroPtTwo++;
                    System.out.println("Current diff: " + currentList.get(0) + " put in 0.19 < value <= 0.20 : " + lessThanZeroPtTwo);
                }else if(Double.parseDouble(currentList.get(0)) > 0.20){
                    moreThanZeroPtTwo++;
                    System.out.println("Current diff: " + currentList.get(0) + "  value > 0.20 : " + moreThanZeroPtTwo);
                }else{
                    System.out.println("Error");
                }

                currentLine = nextLine;
                System.out.println("\n" + "_____________________________________________");
            }


            // I had to repeat it one last time because the while loop leaves out the last line
            currentLine = nextLine;
            currentList = toList(currentLine);
            if(Double.parseDouble(currentList.get(0)) <= 0.01 ){
                lessThanZeroPtZeroOne++;
                System.out.println("Current diff: " + currentList.get(0) + " put in value <= 0.01: " + lessThanZeroPtZeroOne);
            }else if(Double.parseDouble(currentList.get(0)) > 0.01 && Double.parseDouble(currentList.get(0)) <= 0.02){
                lessThanZeroPtZeroTwo++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.01 < value <= 0.02 : " + lessThanZeroPtZeroTwo);
            }else if(Double.parseDouble(currentList.get(0)) > 0.02 && Double.parseDouble(currentList.get(0)) <= 0.03){
                lessThanZeroPtZeroThree++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.02 < value <= 0.03 : " + lessThanZeroPtZeroThree);
            }else if(Double.parseDouble(currentList.get(0)) > 0.03 && Double.parseDouble(currentList.get(0)) <= 0.04){
                lessThanZeroPtZeroFour++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.03 < value <= 0.04 : " + lessThanZeroPtZeroFour);
            }else if(Double.parseDouble(currentList.get(0)) > 0.04 && Double.parseDouble(currentList.get(0)) <= 0.05){
                lessThanZeroPtZeroFive++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.04 < value <= 0.05 : " + lessThanZeroPtZeroFive);
            }else if(Double.parseDouble(currentList.get(0)) > 0.05 && Double.parseDouble(currentList.get(0)) <= 0.06){
                lessThanZeroPtZeroSix++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.05 < value <= 0.06 : " + lessThanZeroPtZeroSix);
            }else if(Double.parseDouble(currentList.get(0)) > 0.06 && Double.parseDouble(currentList.get(0)) <= 0.07){
                lessThanZeroPtZeroSeven++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.06 < value <= 0.07 : " + lessThanZeroPtZeroSeven);
            }else if(Double.parseDouble(currentList.get(0)) > 0.07 && Double.parseDouble(currentList.get(0)) <= 0.08){
                lessThanZeroPtZeroEight++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.07 < value <= 0.08 : " + lessThanZeroPtZeroEight);
            }else if(Double.parseDouble(currentList.get(0)) > 0.08 && Double.parseDouble(currentList.get(0)) <= 0.09){
                lessThanZeroPtZeroNine++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.08 < value <= 0.09 : " + lessThanZeroPtZeroNine);
            }else if(Double.parseDouble(currentList.get(0)) > 0.09 && Double.parseDouble(currentList.get(0)) <= 0.1){
                lessThanZeroPtOne++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.09 < value <= 0.10 : " + lessThanZeroPtOne);
            }else if(Double.parseDouble(currentList.get(0)) > 0.1 && Double.parseDouble(currentList.get(0)) <= 0.11){
                lessThanZeroPtOneOne++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.10 < value <= 0.11 : " + lessThanZeroPtOneOne);
            }else if(Double.parseDouble(currentList.get(0)) > 0.11 && Double.parseDouble(currentList.get(0)) <= 0.12){
                lessThanZeroPtOneTwo++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.11 < value <= 0.12 : " + lessThanZeroPtOneTwo);
            }else if(Double.parseDouble(currentList.get(0)) > 0.12 && Double.parseDouble(currentList.get(0)) <= 0.13){
                lessThanZeroPtOneThree++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.12 < value <= 0.13 : " + lessThanZeroPtOneThree);
            }else if(Double.parseDouble(currentList.get(0)) > 0.13 && Double.parseDouble(currentList.get(0)) <= 0.14){
                lessThanZeroPtOneFour++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.13 < value <= 0.14 : " + lessThanZeroPtOneFour);
            }else if(Double.parseDouble(currentList.get(0)) > 0.14 && Double.parseDouble(currentList.get(0)) <= 0.15){
                lessThanZeroPtOneFive++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.14 < value <= 0.15 : " + lessThanZeroPtOneFive);
            }else if(Double.parseDouble(currentList.get(0)) > 0.15 && Double.parseDouble(currentList.get(0)) <= 0.16){
                lessThanZeroPtOneSix++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.15 < value <= 0.16 : " + lessThanZeroPtOneSix);
            }else if(Double.parseDouble(currentList.get(0)) > 0.16 && Double.parseDouble(currentList.get(0)) <= 0.17){
                lessThanZeroPtOneSeven++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.16 < value <= 0.17 : " + lessThanZeroPtOneSeven);
            }else if(Double.parseDouble(currentList.get(0)) > 0.17 && Double.parseDouble(currentList.get(0)) <= 0.18){
                lessThanZeroPtOneEight++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.17 < value <= 0.18 : " + lessThanZeroPtOneEight);
            }else if(Double.parseDouble(currentList.get(0)) > 0.18 && Double.parseDouble(currentList.get(0)) <= 0.19){
                lessThanZeroPtOneNine++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.18 < value <= 0.19 : " + lessThanZeroPtOneNine);
            }else if(Double.parseDouble(currentList.get(0)) > 0.19 && Double.parseDouble(currentList.get(0)) <= 0.20){
                lessThanZeroPtTwo++;
                System.out.println("Current diff: " + currentList.get(0) + " put in 0.19 < value <= 0.20 : " + lessThanZeroPtTwo);
            }else if(Double.parseDouble(currentList.get(0)) > 0.20){
                moreThanZeroPtTwo++;
                System.out.println("Current diff: " + currentList.get(0) + "  value > 0.20 : " + moreThanZeroPtTwo);
            }else{
                System.out.println("Error");
            }
            System.out.println("\n" + "_____________________________________________");


            //Writes and shows the final sortings
            System.out.println("< 0.01: " + lessThanZeroPtZeroOne + "\n");
            System.out.println("0.01-0.02: " + lessThanZeroPtZeroTwo + "\n");
            System.out.println("0.02-0.03: " + lessThanZeroPtZeroThree + "\n");
            System.out.println("0.03-0.04: " + lessThanZeroPtZeroFour + "\n");
            System.out.println("0.04-0.05: " + lessThanZeroPtZeroFive + "\n");
            System.out.println("0.05-0.06: " + lessThanZeroPtZeroSix + "\n");
            System.out.println("0.06-0.07: " + lessThanZeroPtZeroSeven + "\n");
            System.out.println("0.07-0.08: " + lessThanZeroPtZeroEight + "\n");
            System.out.println("0.08-0.09: " + lessThanZeroPtZeroNine + "\n");
            System.out.println("0.09-0.10: " + lessThanZeroPtOne + "\n");
            System.out.println("0.10-0.11: " + lessThanZeroPtOneOne + "\n");
            System.out.println("0.11-0.12: " + lessThanZeroPtOneTwo + "\n");
            System.out.println("0.12-0.13: " + lessThanZeroPtOneThree + "\n");
            System.out.println("0.13-0.14: " + lessThanZeroPtOneFour + "\n");
            System.out.println("0.14-0.15: " + lessThanZeroPtOneFive + "\n");
            System.out.println("0.15-0.16: " + lessThanZeroPtOneSix + "\n");
            System.out.println("0.16-0.17: " + lessThanZeroPtOneSeven + "\n");
            System.out.println("0.17-0.18: " + lessThanZeroPtOneEight + "\n");
            System.out.println("0.18-0.19: " + lessThanZeroPtOneNine + "\n");
            System.out.println("0.19-0.20: " + lessThanZeroPtTwo + "\n");
            System.out.println("> 0.20: " + moreThanZeroPtTwo + "\n");

            FileWriter myWriter = new FileWriter(f2);
            myWriter.write("< 0.01 : " + lessThanZeroPtZeroOne + "\n");
            myWriter.write("0.01 - 0.02: " + lessThanZeroPtZeroTwo + "\n");
            myWriter.write("0.02 - 0.03: " + lessThanZeroPtZeroThree + "\n");
            myWriter.write("0.03 - 0.04: " + lessThanZeroPtZeroFour + "\n");
            myWriter.write("0.04 - 0.05: " + lessThanZeroPtZeroFive + "\n");
            myWriter.write("0.05 - 0.06: " + lessThanZeroPtZeroSix + "\n");
            myWriter.write("0.06 - 0.07: " + lessThanZeroPtZeroSeven + "\n");
            myWriter.write("0.07 - 0.08: " + lessThanZeroPtZeroEight + "\n");
            myWriter.write("0.08 - 0.09: " + lessThanZeroPtZeroNine + "\n");
            myWriter.write("0.09 - 0.10: " + lessThanZeroPtOne + "\n");
            myWriter.write("0.10 - 0.11: " + lessThanZeroPtOneOne + "\n");
            myWriter.write("0.11 - 0.12: " + lessThanZeroPtOneTwo + "\n");
            myWriter.write("0.12 - 0.13: " + lessThanZeroPtOneThree + "\n");
            myWriter.write("0.13 - 0.14: " + lessThanZeroPtOneFour + "\n");
            myWriter.write("0.14 - 0.15: " + lessThanZeroPtOneFive + "\n");
            myWriter.write("0.15 - 0.16: " + lessThanZeroPtOneSix + "\n");
            myWriter.write("0.16 - 0.17: " + lessThanZeroPtOneSeven + "\n");
            myWriter.write("0.17 - 0.18: " + lessThanZeroPtOneEight + "\n");
            myWriter.write("0.18 - 0.19: " + lessThanZeroPtOneNine + "\n");
            myWriter.write("0.19 - 0.20: " + lessThanZeroPtTwo + "\n");
            myWriter.write("> 0.20: " + moreThanZeroPtTwo  + "\n");
            myWriter.flush();
            myWriter.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
