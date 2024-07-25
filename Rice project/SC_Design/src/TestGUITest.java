import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TestGUITest extends JFrame{
    private JPanel MainPanel;
    private JPanel ConvertButtonPanel;
    private JButton ConvertButton;
    private JPanel InputPanel;
    private JTextField InputTextField;
    private JLabel InputLabel;
    private JPanel OutputPanel;
    private JTextField OutputTextField;
    private JLabel OutputLabel;
    private JTextField FileLocation;
    private JPanel CheckBoxPanel;
    private JCheckBox audioCheckBox;
    private JCheckBox vehicleCheckBox;
    private JPanel RadioPanel;
    private JRadioButton SCFileRadioButton;
    private JRadioButton TTCFileRadioButton;

    private File outputFile;

    //Checks if the sc file type is selected
    private boolean scIsChecked = false;
    //Checks if the ttc file type is selected
    private boolean ttcIsChecked = false;
    //Checks if any file type is selected
    private boolean fileTypeChecked = false;
    //Checks if the audio object type is selected
    private boolean audioIsChecked = false;
    //Checks if the vehicle object type is selected
    private boolean vehicleIsChecked = false;
    //Checks if any object type is selected
    private boolean objectChecked = false;

    public TestGUITest(){
        //Adds the main panel, sets the size of the window
        //and closes the program when the x button is clicked
        add(MainPanel);
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Adds a listener to the convert button and
        //starts the convert method with the file names
        ConvertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Radio boxes make sure that only one file type is selected

                //If the SC file type is selected, say that the SC type
                //and a general file type is selected
                if(SCFileRadioButton.isSelected()){
                    scIsChecked = true;
                    fileTypeChecked = true;
                }
                //If the TTC file type is selected, say that the TTC type
                //and a general file type is selected
                else if(TTCFileRadioButton.isSelected()){
                    ttcIsChecked = true;
                    fileTypeChecked = true;
                }
                //If no file type is selected, show a message box and try again
                else if (!fileTypeChecked){
                    JOptionPane.showMessageDialog(null, "Must choose one file type");
                }



                //If both file objects are selected
                if(audioCheckBox.isSelected() && vehicleCheckBox.isSelected()){
                    audioIsChecked = true;
                    vehicleIsChecked = true;
                    objectChecked = true;
                }
                //If the vehicle file object are selected,
                else if(vehicleCheckBox.isSelected()){
                    vehicleIsChecked = true;
                    objectChecked = true;
                }
                //If the audio file object are selected
                else if(audioCheckBox.isSelected()){
                    audioIsChecked = true;
                    objectChecked = true;
                }
                //If no object type is selected, show a message box and try again
                else if (!objectChecked){
                    JOptionPane.showMessageDialog(null, "Must choose at least one object type");
                }



                //If both the file type and object type is checked
                if (fileTypeChecked && objectChecked){
                    String inputName = InputTextField.getText();
                    String outputName = OutputTextField.getText();

                    //Creates a directory to the user's desktop
                    File directory = new File(System.getProperty("user.home"), "/Desktop");
                    //Finds the input file on the user's desktop
                    File checkInputFile = new File(directory, inputName);


                    //Checks if the file is a TTC file type
                    if (ttcIsChecked){
                        //If the input file doesn't exist, show a message box and try again
                        if(!checkInputFile.exists()){
                            JOptionPane.showMessageDialog(null, "File " + checkInputFile + " does not exist on desktop");
                        //If the input file does exist, run the TTC class
                        }else{
                            outputFile = TTC.TTCConverter(directory, checkInputFile, outputName, audioIsChecked, vehicleIsChecked);
                            //Writes where the output file went
                            FileLocation.setText("File created at: " + outputFile.getAbsolutePath());
                        }
                    }
                    //Checks if the file is a SC file type
                    if (scIsChecked){
                        //If the input file doesn't exist, show a message box and try again
                        if(!checkInputFile.exists()){
                            JOptionPane.showMessageDialog(null, "File " + checkInputFile + " does not exist on desktop");
                        //If the input file does exist, run the SC class
                        }else{
                            outputFile = SC.SCConverter(directory, checkInputFile, outputName, audioIsChecked, vehicleIsChecked);
                            //Writes where the output file went
                            FileLocation.setText("File created at: " + outputFile.getAbsolutePath());
                        }
                    }

                    //Resets booleans
                    scIsChecked = false;
                    ttcIsChecked = false;
                    fileTypeChecked = false;
                    audioIsChecked = false;
                    vehicleIsChecked = false;
                    objectChecked = false;
                }
            }
        });
    }
}
