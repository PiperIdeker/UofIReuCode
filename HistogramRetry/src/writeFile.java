import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class writeFile {
    // reformats lines to the list format
    public static List<String> toList(String line){
        String str1[] = line.split(" ");
        List<String> currentList = Arrays.asList(str1);
        return currentList;
    }

    //Finds the input file in the "eHMI" folder, then writes a new file
    //that is only the participant data in the "zeroID" folder

    public static void main(String[] args){
        try {
            String zeroLine;
            List<String> zeroList;
            File input = new File("eHMI\\eHMI_early-07.txt");
            FileWriter myWriter = new FileWriter("zeroID\\zeroID_eHMI_early-07.txt");
            Scanner sc = new Scanner(input);


            while (sc.hasNext()){
                zeroLine = sc.nextLine();
                zeroList = toList(zeroLine);
                System.out.println(zeroList);

                // if the id is a person, write the line to "zeroID_early-03.txt"
                if (zeroList.get(2).equals("0")){
                    myWriter.write(zeroLine + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
