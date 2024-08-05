"Rice" Project

## Table of Contents
1. Introduction
2. Features
3. Installation/Usage
4. Author
5. What I learned/What I'd do differently

1. Introduction: This is a program for the University of Iowa where they gave me an extra project that simply changes csv data file formats to make it easier for the researchers to get the data format they need for their 
pedestrian/car simulations(SC and TTC format). The code I wrote can be found in UofIReuCode/Rice project/SC_Design/src/SC.java, TTC.java and Main.java. Examples of both input and output files in both formats can be seen 
in UofIReuCode/Rice project/inputFiles and outputFiles.

1.1 How to read the input file names: XX_filename_AV_.csv
    -TTC: is in TTC format, SC: is in SC format
    -A: audio, V: video, AV: audio and video 

2. Features:
    - "writeFile.java": 

3. Installation/Usage: This program can be run through DesignToFull.exe. As long as the input file can be seen on the desktop, it can change the data format. 

3.1 Example: Using the file "SC_design_A" as an input (making sure it is on the desktop), enter the input file name in the textbox. Since it is a SC file, select the SC radio button then only select "Audio" (corresponding 
to the "A). Enter what you would like to name the output file, and it should match the output file "SC_A_test.csv". 

4. Author: Written by Piper Ideker

5. What I learned/What I'd do differently: I like that I actually created the application and didn't just run everything in the ide's like the other two projects. Looking back I think it was a good programming excerise to
look for the input file on the desktop, but in a real world setting I'm not entirely sure if it would be useful. If I'd do this again, I think it'd be less constrictive of the user to open File Explorer for them to navigate
to the input file instead.
