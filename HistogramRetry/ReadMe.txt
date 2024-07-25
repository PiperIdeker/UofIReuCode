Histogram Data Debugging

## Table of Contents
1. Introduction
2. Features
3. Installation/Usage
4. Author
5. What I learned/What I'd do differently

1. Introduction: This is a program for the University of Iowa where they were having problems with their data capturing system
freezing. My job was to collect the amount of freezes and put that in a histogram for them to further analyze. They found that the
there were more freezes than they originally thought and were so fast to the naked eye for them to see.

1.1 How to read the input files:
        first column: "0": participant data (NOTE: I took out this taken out due to participant confidentiality).
                      "1": starting point in the simulation room
                      "2": stimulation running
                      "9": new car incoming
        second: timestamp
        third, fourth, and fifth column: participant's x,y, and z head positions
        sixth, seventh, and eighth column: participant's x,y, and z body locations

2. Features:
    - "writeFile.java": This prepares the input data by getting rid of participant data.
    - "Main.java": This code generates the amount of freezes, how many timestamps it took to unfreeze
    - "toHistogram": This code takes the sorted data from Main.java and sorts it into bins easier to read

3. Installation/Usage: This program ran through IntelliJ. The professors I worked with wanted a general idea of what was happening,
so not every participant was analysed and could be loose in terms of running/usage. The order to run is writeFile, then Main,
then toHistogram.

4. Author: Written by Piper Ideker

5. What I learned/What I'd do differently: I did this project before I took any algorithms class, and I now understand that
this is very inefficient with a big-O of O(n [Lines] * L [length of lines]) for writeFile, Main.java and toHistogram.java
I also think I could have been better organized in terms of running in one place instead of having to run
and rename files.