HeadTracking Revolving Door Code

## Table of Contents
1. Introduction
2. Features
3. Author
4. What I learned/What I'd do differently

1. Introduction: This is a prototype of a simulation for the University of Iowa, where they wanted a new simulation to research how children with 
developmental coordination disorder try to balance themselves while moving through a revolving door. The simulation ran in the Unity game engine 
on an Oculus Rift, but unfortunatly the game objects such as the door itself is under a liscence that I am not able to share. I am however able to 
share the code that I wrote, and an example output file from a simulation test run.

1.1 How to read the output file:
    first column: TimeStamp	
    second: PreviousTimeStamp	
    third: DoorRotation- revolving door's angle (0/360 degrees is north, 90 is east, 180 south, 270 west)	
    fourth: PreviousDoorRotation
    fifth: topAngle- difference in the door's rotation angle since the last update
    sixth, seventh and eighth column: XPosition, YPosition, and ZPosition
    nineth: Inside/Outside:	
        -0: outside the radius of the door 
        -1: inside the radius of the door
    tenth: AngleOfParticipant- participant's angle relative to the center of the door in degrees.	
    eleventh: DeltaTheta- angular difference between the revolving door's current rotation and the participant's angle.	
    twelfth: Radius- distance of the participant from the origin (center of the door) in the x-z plane.	
    thirteenth: ClosestAngleToDoor: participant's proximity to the edges of the revolving door's sections.
    fourteenth: TTC(Time to Collision)- the time until the door would theoretically reach the participant's angle if it 
        continued rotating at its current speed.

2. Features:
    - "FacePlayer.cs": This is Unity code that updates the timestamps and calls Headtracking.cs
    - "HeadTracking.cs": This is the main code that calculates the data the researchers needed listed above.

3. Author: Written by Piper Ideker

4. What I learned/What I'd do differently: This is the first project that I did, and I did not have the good coding practice
of documentation and explaining the different variables and formulas used. I would also organize each formula into their own
function to make it easier to read and explain.