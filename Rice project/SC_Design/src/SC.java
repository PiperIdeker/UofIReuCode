import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SC {

    //Method turns a string to a list
    public static List<String> toList(String line) {
        String[] str1 = line.split(",");
        return Arrays.asList(str1);
    }

    public static File SCConverter (File directory, File inputFile, String outputName, boolean aCheck, boolean vCheck){
        //2d array that holds the entire data
        ArrayList<ArrayList<String>> lengthArray = new ArrayList<>();
        //Keeps track of the rows of the 2d array
        int row = 0;
        //Keeps track of the trial number of each line
        int trialNumber = 0;

        //Keeps track of the current line of the input file
        String currentLine;
        //String nextLine;

        List<String> currentList;
        //List<String> nextList = null;

        //
        double StartX;

        //Creates output file
        File outputFile = null;


        try {
            //Assigns the output file to write on the user's desktop
            outputFile = new File(directory, outputName);
            //Writer to the output file
            FileWriter myWriter = new FileWriter(outputFile);
            //Scans each line on the input file
            Scanner sc = new Scanner(inputFile);

            //Skips the first line with the column headers and adds
            //the first array list in the 2d list
            currentLine = sc.nextLine();
            lengthArray.add(new ArrayList<>());

            //If there is both the vehicle and audio object types
            if(aCheck && vCheck){
                //Writes the column headers
                myWriter.write("trialNum, " + "trialName, " + "corrAns, " + "playSound, " + "objNum, " + "objType, " + "gain, " + "customMot, " + "customFile, " + "customDur, " + "objScale, " +
                        "objRot, " + "startPos, " + "endPos, " + "velocity, " + "timeVisible, " + "rotationSpeedX, " + "rotationSpeedY, " + "rotationSpeedZ, " + "offsetX, " + "offsetY, " + "offsetZ, " +
                        "objNum, " + "objType, " + "gain, " + "customMot, " + "customFile, " + "customDur, " + "objScale, " +"objRot, " + "startPos, " + "endPos, " + "velocity, " + "timeVisible, "
                        + "rotationSpeedX, " + "rotationSpeedY, " + "rotationSpeedZ, " + "offsetX, " + "offsetY, " + "offsetZ, " +"\n");
                //While the input file has a next line
                while (sc.hasNextLine()){
                    //Assigns the current line, then changes it to a list
                    currentLine = sc.nextLine();
                    currentList = toList(currentLine);
                    //Ups the trialNumber value by one, then adds it to lengthArray
                    trialNumber++;
                    lengthArray.get(row).add(String.valueOf(trialNumber));

                    //Assigns trialName a value then adds it to lengthArray
                    String modalityCondition = currentList.get(0);
                    String TTCv = currentList.get(1);
                    String TTCa = currentList.get(2);
                    String vV = currentList.get(3);
                    String vA = currentList.get(4);
                    String gain = currentList.get(5);

                    //Sometimes quotation marks are used, so "\"  "\" is used
                    //Assigns objType a value based if vehicle size is small or large
                    String objType;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objType = "01-Golf Variant";
                            break;
                        case "large":
                        case "\"large\"":
                            objType = "PickUp_3A Variant";
                            break;
                        default:
                            System.out.println("Not small or large for objType");
                            objType = currentList.get(6);
                            break;
                    }

                    String trialName = modalityCondition + "x" + TTCv + "x" + TTCa + "x" + vV + "x" + vA + "x" + gain + "x" + objType;
                    lengthArray.get(row).add(trialName);


                    //Assigns corrAns a value, then adds it to lengthArray
                    int corrAns = 0;
                    lengthArray.get(row).add(String.valueOf(corrAns));
                    //Assigns playSound a value, then adds it to lengthArray
                    String playSound = "FALSE";
                    lengthArray.get(row).add(playSound);
                    //Assigns objNum a value, then adds it to lengthArray
                    int objNum = 1;
                    lengthArray.get(row).add(String.valueOf(objNum));

                    //Sometimes quotation marks are used, so "\"  "\" is used

                    //Adds objType to lengthArray
                    lengthArray.get(row).add(objType);
                    //Adds gain to lengthArray
                    lengthArray.get(row).add(gain);
                    //Assigns customMotion a value, then adds it to lengthArray
                    String customMotion = "FALSE";
                    lengthArray.get(row).add(customMotion);
                    //Assigns customFile a value, then adds it to lengthArray
                    String customFile = "\" \"";
                    lengthArray.get(row).add(customFile);
                    //Assigns customDur a value, then adds it to lengthArray
                    int customDur = 0;
                    lengthArray.get(row).add(String.valueOf(customDur));

                    //Sometimes quotation marks are used, so "\"  "\" is used

                    //Assigns objScale a value based if vehicle size is small
                    //or large, then adds it to lengthArray
                    String objScale = null;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objScale = "\"1,1,1\"";
                            lengthArray.get(row).add(objScale);
                            break;
                        case "large":
                        case "\"large\"":
                            objScale = "\"0.826,0.878,1\"";
                            lengthArray.get(row).add(objScale);
                            break;
                        default:
                            System.out.println("Not small or large for objScale");
                            lengthArray.get(row).add(currentList.get(6));
                            break;
                    }

                    //Sometimes quotation marks are used, so "\"  "\" is used

                    //Assigns objRotation a value based if vehicle size is small
                    //or large, then adds it to lengthArray
                    String objRotation;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objRotation = "\"-90,0,90\"";
                            lengthArray.get(row).add(objRotation);
                            break;
                        case "large":
                        case "\"large\"":
                            objRotation = "\"0,90,0\"";
                            lengthArray.get(row).add(objRotation);
                            break;
                        default:
                            System.out.println("Not small or large for objRotation");
                            lengthArray.get(row).add(currentList.get(6));
                            break;
                    }

                    //Assigns TTCv, SpeedVKmpHr, StartX and startPos a value, then adds startPos to lengthArray
                    String SpeedVKmpHr = currentList.get(3);
                    StartX = 0.277778 * Double.parseDouble(TTCv) * Double.parseDouble(SpeedVKmpHr);
                    String startPos = "\"" + (-StartX) + ",0,2.8288\"";
                    lengthArray.get(row).add(startPos);
                    //Assigns endPos a value, then adds it to lengthArray
                    String endPos = "\"0,0,2.8288\"";
                    lengthArray.get(row).add(endPos);
                    //Assigns velocity a value, then adds it to lengthArray
                    double velocity = Double.parseDouble(currentList.get(3)) * 0.277778;
                    lengthArray.get(row).add(String.valueOf(velocity));
                    //Assigns timeVisible a value, then adds it to lengthArray
                    double timeVisible = StartX / velocity;
                    lengthArray.get(row).add(String.valueOf((timeVisible)));
                    //Assigns rotationSpeedX a value, then adds it to lengthArray
                    int rotationSpeedX = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedX));
                    //Assigns rotationSpeedY a value, then adds it to lengthArray
                    int rotationSpeedY = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedY));
                    //Assigns rotationSpeedZ a value, then adds it to lengthArray
                    int rotationSpeedZ = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedZ));
                    //Assigns offSetX a value, then adds it to lengthArray
                    int offSetX = -1;
                    lengthArray.get(row).add(String.valueOf(offSetX));
                    //Assigns offSetY a value, then adds it to lengthArray
                    int offSetY = 0;
                    lengthArray.get(row).add(String.valueOf(offSetY));
                    //Assigns offSetZ a value, then adds it to lengthArray
                    int offSetZ = 0;
                    lengthArray.get(row).add(String.valueOf(offSetZ));


                    //Assigns objNum a value, then adds it to lengthArray
                    objNum = 2;
                    lengthArray.get(row).add(String.valueOf(objNum));
                    //Assigns objType a value, then adds it to lengthArray
                    objType = "Audio";
                    lengthArray.get(row).add(objType);
                    //Adds gain to lengthArray
                    lengthArray.get(row).add(gain);
                    //Adds customMotion to lengthArray
                    lengthArray.get(row).add(customMotion);
                    //Adds customFile to lengthArray
                    lengthArray.get(row).add(customFile);
                    //Adds customDur to lengthArray
                    lengthArray.get(row).add(String.valueOf(customDur));
                    //Adds objScale to lengthArray
                    lengthArray.get(row).add(objScale);
                    //Assigns objRotation a value, then adds it to lengthArray
                    objRotation = "\"-90,0,90\"";
                    lengthArray.get(row).add(objRotation);

                    //Assigns TTCv, SpeedVKmpHr, StartX and startPos a value, then adds startPos to lengthArray
                    TTCv = currentList.get(2);
                    SpeedVKmpHr = currentList.get(4);
                    StartX = 0.277778 * Double.parseDouble(TTCv) * Double.parseDouble(SpeedVKmpHr);
                    startPos = "\"" + StartX + ",0,2.8288\"";
                    lengthArray.get(row).add(startPos);

                    //Assigns endPos a value, then adds it to lengthArray
                    endPos = "\"0,0,2.8288\"";
                    lengthArray.get(row).add(endPos);
                    //Assigns velocity a value, then adds it to lengthArray
                    velocity = Double.parseDouble(currentList.get(3)) * 0.277778;
                    lengthArray.get(row).add(String.valueOf(velocity));
                    //Assigns timeVisible a value, then adds it to lengthArray
                    timeVisible = StartX / Double.parseDouble(lengthArray.get(row).get(14));
                    lengthArray.get(row).add(String.valueOf(timeVisible));
                    //Adds rotationSpeedX to lengthArray
                    lengthArray.get(row).add(String.valueOf(rotationSpeedX));
                    //Adds rotationSpeedY to lengthArray
                    lengthArray.get(row).add(String.valueOf(rotationSpeedY));
                    //Adds rotationSpeedZ to lengthArray
                    lengthArray.get(row).add(String.valueOf(rotationSpeedZ));
                    //Adds offSetX to lengthArray
                    lengthArray.get(row).add(String.valueOf(offSetX));
                    //Adds offSetY to lengthArray
                    lengthArray.get(row).add(String.valueOf(offSetY));
                    //Adds offSetZ to lengthArray
                    lengthArray.get(row).add(String.valueOf(offSetZ));

                    //Ups the row value by one and adds the another array list in the 2d list
                    row++;
                    lengthArray.add(new ArrayList<>());
                }

                //After the scanner reads the entire file, the loop writes each part of arraylist to the output file
                for (int a = 0; a < row; a++) {
                    myWriter.write(lengthArray.get(a).get(0) + "," + lengthArray.get(a).get(1) + "," + lengthArray.get(a).get(2)
                            + "," + lengthArray.get(a).get(3) + "," + lengthArray.get(a).get(4) + "," + lengthArray.get(a).get(5) + "," + lengthArray.get(a).get(6) + ","
                            + lengthArray.get(a).get(7) + ",\"" + lengthArray.get(a).get(8) + " \"" + "," + lengthArray.get(a).get(9) + "," + '"' + '"' + lengthArray.get(a).get(10)
                            +   '"' +'"' + "," + '"' + '"' + lengthArray.get(a).get(11) + '"' + '"' + "," + '"' + '"' + lengthArray.get(a).get(12) + '"' + '"' +  "," +
                            '"' + '"' + lengthArray.get(a).get(13) + '"' + '"' +  "," + lengthArray.get(a).get(14) + "," + lengthArray.get(a).get(15) + "," + lengthArray.get(a).get(16) + "," + lengthArray.get(a).get(17)
                            + "," + lengthArray.get(a).get(18) + "," + lengthArray.get(a).get(19) + "," + lengthArray.get(a).get(20) + "," + lengthArray.get(a).get(21)
                            + "," + lengthArray.get(a).get(22) + "," + lengthArray.get(a).get(23) + "," + lengthArray.get(a).get(24) + "," + lengthArray.get(a).get(25)
                            + ",\"" + lengthArray.get(a).get(26) + " \"," + lengthArray.get(a).get(27) + "," + '"' + '"' + lengthArray.get(a).get(28)
                            + '"' + '"' + "," + '"' + '"' + lengthArray.get(a).get(29) + '"' + '"' + "," + '"' + '"' + lengthArray.get(a).get(30) + '"' + '"' + ","
                            + '"' + '"' + lengthArray.get(a).get(31) + '"' + '"' + "," + lengthArray.get(a).get(32) + "," + lengthArray.get(a).get(33) + "," + lengthArray.get(a).get(34) + "," + lengthArray.get(a).get(35)
                            + "," + lengthArray.get(a).get(36) + "," + lengthArray.get(a).get(37)+ "," + lengthArray.get(a).get(38) + "," + lengthArray.get(a).get(39) + "\n");
                }




            //If there is the audio object type
            } else if (aCheck) {
                //Writes the column headers
                myWriter.write("trialNum, " + "trialName, " + "corrAns, " + "playSound, " + "objNum, " + "objType, " + "gain, " + "customMot, " + "customFile, " + "customDur, " + "objScale, " +
                        "objRot, " + "startPos, " + "endPos, " + "velocity, " + "timeVisible, " + "rotationSpeedX, " + "rotationSpeedY, " + "rotationSpeedZ, " + "offsetX, " + "offsetY, " + "offsetZ, " + "\n");
                //While the input file has a next line
                while (sc.hasNextLine()){
                    //Assigns the current line, then changes it to a list
                    currentLine = sc.nextLine();
                    currentList = toList(currentLine);
                    //Ups the trialNumber value by one, then adds it to lengthArray
                    trialNumber++;
                    lengthArray.get(row).add(String.valueOf(trialNumber));
                    //Assigns modalityCondition, TTCa, vA, gain, objType and trialName a value, then adds trialName to lengthArray
                    String modalityCondition = currentList.get(0);
                    String TTCv = currentList.get(2);
                    String vV = currentList.get(4);
                    String gain = currentList.get(5);
                    String objType = "Audio";
                    String trialName = modalityCondition + "x" + TTCv + "x" + vV + "x" + gain + "x" + objType;
                    lengthArray.get(row).add(trialName);
                    //Assigns corrAns a value, then adds it to lengthArray
                    int corrAns = 0;
                    lengthArray.get(row).add(String.valueOf(corrAns));
                    //Assigns playSound a value, then adds it to lengthArray
                    String playSound = "FALSE";
                    lengthArray.get(row).add(playSound);
                    //Assigns objNum a value, then adds it to lengthArray
                    int objNum = 2;
                    lengthArray.get(row).add(String.valueOf(objNum));
                    //Adds objType to lengthArray
                    lengthArray.get(row).add(objType);
                    //Adds gain to lengthArray
                    lengthArray.get(row).add(gain);
                    //Assigns customMotion a value, then adds it to lengthArray
                    String customMotion = "FALSE";
                    lengthArray.get(row).add(customMotion);
                    //Assigns customFile a value, then adds it to lengthArray
                    String customFile = "\" \"";
                    lengthArray.get(row).add(customFile);
                    //Assigns customDur a value, then adds it to lengthArray
                    int customDur = 0;
                    lengthArray.get(row).add(String.valueOf(customDur));
                    //Assigns objScale a value, then adds it to lengthArray
                    String objScale = "\"1,1,1\"";
                    lengthArray.get(row).add(objScale);
                    //Assigns objRotation a value, then adds it to lengthArray
                    String objRotation = "\"-90,0,90\"";
                    lengthArray.get(row).add(objRotation);

                    //Assigns TTCv, SpeedVKmpHr, StartX and startPos a value, then adds startPos to lengthArray
                    String SpeedVKmpHr = currentList.get(4);
                    StartX = 0.277778 * Double.parseDouble(TTCv) * Double.parseDouble(SpeedVKmpHr);
                    String startPos = "\"" + (-StartX) + ",0,2.8288\"";
                    lengthArray.get(row).add(startPos);


                    //Assigns endPos a value, then adds it to lengthArray
                    String endPos = "\"0,0,2.8288\"";
                    lengthArray.get(row).add(endPos);
                    //Assigns velocity a value, then adds it to lengthArray
                    double velocity = Double.parseDouble(currentList.get(4)) * 0.277778;
                    lengthArray.get(row).add(String.valueOf(velocity));
                    //Assigns timeVisible a value, then adds it to lengthArray
                    double timeVisible = StartX / velocity;
                    lengthArray.get(row).add(String.valueOf((timeVisible)));
                    //Assigns rotationSpeedX a value, then adds it to lengthArray
                    int rotationSpeedX = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedX));
                    //Assigns rotationSpeedY a value, then adds it to lengthArray
                    int rotationSpeedY = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedY));
                    //Assigns rotationSpeedZ a value, then adds it to lengthArray
                    int rotationSpeedZ = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedZ));
                    //Assigns offSetX a value, then adds it to lengthArray
                    int offSetX = -1;
                    lengthArray.get(row).add(String.valueOf(offSetX));
                    //Assigns offSetY a value, then adds it to lengthArray
                    int offSetY = 0;
                    lengthArray.get(row).add(String.valueOf(offSetY));
                    //Assigns offSetZ a value, then adds it to lengthArray
                    int offSetZ = 0;
                    lengthArray.get(row).add(String.valueOf(offSetZ));

                    //Ups the row value by one and adds the another array list in the 2d list
                    row++;
                    lengthArray.add(new ArrayList<>());
                }
                //After the scanner reads the entire file, the loop writes each part of arraylist to the output file
                for (int a = 0; a < row; a++) {
                    myWriter.write(lengthArray.get(a).get(0) + "," + lengthArray.get(a).get(1) + "," + lengthArray.get(a).get(2)
                            + "," + lengthArray.get(a).get(3) + "," + lengthArray.get(a).get(4) + "," + lengthArray.get(a).get(5) + "," + lengthArray.get(a).get(6) + ","
                            + lengthArray.get(a).get(7) + ", " + lengthArray.get(a).get(8) + ", " + lengthArray.get(a).get(9) + "," + '"' + '"' + lengthArray.get(a).get(10)
                            +   '"' +'"' + "," + '"' + '"' + lengthArray.get(a).get(11) + '"' + '"' + "," + '"' + '"' + lengthArray.get(a).get(12) + '"' + '"' +  "," +
                            '"' + '"' + lengthArray.get(a).get(13) + '"' + '"' + "," + lengthArray.get(a).get(14) + "," + lengthArray.get(a).get(15) + "," + lengthArray.get(a).get(16) + "," + lengthArray.get(a).get(17)
                            + "," + lengthArray.get(a).get(18) + "," + lengthArray.get(a).get(19) + "," + lengthArray.get(a).get(20) + "," + lengthArray.get(a).get(21) + "\n");
                }

            //If there is the vehicle object type
            }else if (vCheck) {
                //Writes the column headers
                myWriter.write("trialNum, " + "trialName, " + "corrAns, " + "playSound, " + "objNum, " + "objType, " + "gain, " + "customMot, " + "customFile, " + "customDur, " + "objScale, " +
                        "objRot, " + "startPos, " + "endPos, " + "velocity, " + "timeVisible, " + "rotationSpeedX, " + "rotationSpeedY, " + "rotationSpeedZ, " + "offsetX, " + "offsetY, " + "offsetZ, " + "\n");
                //While the input file has a next line
                while (sc.hasNextLine()) {
                    //Assigns the current line, then changes it to a list
                    currentLine = sc.nextLine();
                    currentList = toList(currentLine);
                    //Ups the trialNumber value by one, then adds it to lengthArray
                    trialNumber++;
                    lengthArray.get(row).add(String.valueOf(trialNumber));

                    //Assigns modalityCondition, TTCv, vV, gain, objType and trialName a value, then adds trialName to lengthArray
                    String modalityCondition = currentList.get(0);
                    String TTCv = currentList.get(1);
                    String vV = currentList.get(3);
                    String gain = "0";

                    //Sometimes quotation marks are used, so "\"  "\" is used
                    //Assigns objType a value based if vehicle size is small or large
                    String objType;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objType = "01-Golf Variant";
                            break;
                        case "large":
                        case "\"large\"":
                            objType = "PickUp_3A Variant";
                            break;
                        default:
                            System.out.println("Not small or large for objType");
                            objType = currentList.get(6);
                            break;
                    }
                    String trialName = modalityCondition + "x" + TTCv + "x" + vV + "x" + gain + "x" + objType;
                    lengthArray.get(row).add(trialName);
                    //Assigns corrAns a value, then adds it to lengthArray
                    int corrAns = 0;
                    lengthArray.get(row).add(String.valueOf(corrAns));
                    //Assigns playSound a value, then adds it to lengthArray
                    String playSound = "FALSE";
                    lengthArray.get(row).add(playSound);
                    //Assigns objNum a value, then adds it to lengthArray
                    int objNum = 1;
                    lengthArray.get(row).add(String.valueOf(objNum));

                    lengthArray.get(row).add(objType);
                    //Adds gain to lengthArray
                    lengthArray.get(row).add(gain);
                    //Assigns customMotion a value, then adds it to lengthArray
                    String customMotion = "FALSE";
                    lengthArray.get(row).add(customMotion);
                    //Assigns customFile a value, then adds it to lengthArray
                    String customFile = "\" \"";
                    lengthArray.get(row).add(customFile);
                    //Assigns customDur a value, then adds it to lengthArray
                    int customDur = 0;
                    lengthArray.get(row).add(String.valueOf(customDur));

                    //Sometimes quotation marks are used, so "\"  "\" is used
                    //Assigns objScale a value based if vehicle size is small
                    //or large, then adds it to lengthArray
                    String objScale;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objScale = "\"1,1,1\"";
                            lengthArray.get(row).add(objScale);
                            break;
                        case "large":
                        case "\"large\"":
                            objScale = "\"0.826,0.878,1\"";
                            lengthArray.get(row).add(objScale);
                            break;
                        default:
                            System.out.println("Not small or large for objScale");
                            lengthArray.get(row).add(currentList.get(6));
                            break;
                    }
                    System.out.println(lengthArray.get(row).get(10));

                    //Sometimes quotation marks are used, so "\"  "\" is used

                    //Assigns objRotation a value based if vehicle size is small
                    //or large, then adds it to lengthArray
                    String objRotation;
                    switch (currentList.get(6)) {
                        case "small":
                        case "\"small\"":
                            objRotation = "\"-90,0,90\"";
                            lengthArray.get(row).add(objRotation);
                            break;
                        case "large":
                        case "\"large\"":
                            objRotation = "\"0,90,0\"";
                            lengthArray.get(row).add(objRotation);
                            break;
                        default:
                            System.out.println("Not small or large for objRotation");
                            lengthArray.get(row).add(currentList.get(6));
                            break;
                    }
                    System.out.println(lengthArray.get(row).get(11));

                    //Assigns TTCv, SpeedVKmpHr, StartX and startPos a value, then adds startPos to lengthArray
                    String SpeedVKmpHr = currentList.get(3);
                    StartX = 0.277778 * Double.parseDouble(TTCv) * Double.parseDouble(SpeedVKmpHr);
                    String startPos = "\"" + StartX + ",0,2.8288\"";
                    lengthArray.get(row).add(startPos);

                    //Assigns trialName a value, then adds it to lengthArray
                    String endPos = "\"0,0,2.8288\"";
                    lengthArray.get(row).add(endPos);
                    //Assigns velocity a value, then adds it to lengthArray
                    double velocity = Double.parseDouble(currentList.get(3)) * 0.277778;
                    lengthArray.get(row).add(String.valueOf(velocity));
                    //Assigns timeVisible a value, then adds it to lengthArray
                    double timeVisible = StartX / Double.parseDouble(lengthArray.get(row).get(14));
                    lengthArray.get(row).add(String.valueOf((timeVisible)));
                    //Assigns rotationSpeedX a value, then adds it to lengthArray
                    int rotationSpeedX = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedX));
                    //Assigns rotationSpeedY a value, then adds it to lengthArray
                    int rotationSpeedY = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedY));
                    //Assigns rotationSpeedZ a value, then adds it to lengthArray
                    int rotationSpeedZ = 0;
                    lengthArray.get(row).add(String.valueOf(rotationSpeedZ));
                    //Assigns offSetX a value, then adds it to lengthArray
                    int offSetX = -1;
                    lengthArray.get(row).add(String.valueOf(offSetX));
                    //Assigns offSetY a value, then adds it to lengthArray
                    int offSetY = 0;
                    lengthArray.get(row).add(String.valueOf(offSetY));
                    //Assigns offSetZ a value, then adds it to lengthArray
                    int offSetZ = 0;
                    lengthArray.get(row).add(String.valueOf(offSetZ));
                    //Ups the row value by one and adds the another array list in the 2d list
                    row++;
                    lengthArray.add(new ArrayList<>());
                }
                //After the scanner reads the entire file, the loop writes each part of arraylist to the output file
                for (int a = 0; a < row; a++) {
                    myWriter.write(lengthArray.get(a).get(0) + "," + lengthArray.get(a).get(1) + "," + lengthArray.get(a).get(2) + "," + lengthArray.get(a).get(3) + "," + lengthArray.get(a).get(4) + "," +
                            lengthArray.get(a).get(5) + "," + lengthArray.get(a).get(6) + "," + lengthArray.get(a).get(7) + ",\"" + lengthArray.get(a).get(8) + " \"," + lengthArray.get(a).get(9) + "," + '"' + '"' + lengthArray.get(a).get(10)
                            +   '"' +'"' + "," + '"' + '"' + lengthArray.get(a).get(11) + '"' + '"' + "," + '"' + '"' + lengthArray.get(a).get(12) + '"' + '"' +  "," +
                            '"' + '"' + lengthArray.get(a).get(13) + '"' + '"' + "," + lengthArray.get(a).get(14) + "," + lengthArray.get(a).get(15) + "," + lengthArray.get(a).get(16) + "," + lengthArray.get(a).get(17)
                            + "," + lengthArray.get(a).get(18) + "," + lengthArray.get(a).get(19) + "," + lengthArray.get(a).get(20) + "," + lengthArray.get(a).get(21) + "\n");
                }
            }
            //Closes and refreshes the writer
            myWriter.flush();
            myWriter.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        //After calculations are done, the SC class returns the output file
        return outputFile;
    }
}
