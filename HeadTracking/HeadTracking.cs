using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using System.IO;
using System;
using System.Linq;
using System.Text.RegularExpressions;

public class HeadTracking : MonoBehaviour
{
    public string ParticipantNumber;
    public GameObject rotatingDoor;
    private Vector3 holderPosition;
    private Vector3 holderRotation;
    private double xPosSquared;
    private double zPosSquared;
    private double participantLocation;
    string txtDocumentDir;
    float previousTimeStamp = 0;
    float previousDoorRotation = 0;

    void Start()
    {
        rotatingDoor = GameObject.Find("/World/Environment/Interactive/RevolvingDoor/RevolvingDoor");
        Directory.CreateDirectory(Application.dataPath + "/HeadTracking/");
        txtDocumentDir = Application.dataPath + "/HeadTracking/" + ParticipantNumber + ".txt";
        CreateTextFile();
    }


    public void CreateTextFile()
    {
        File.AppendAllText(txtDocumentDir, "");
        File.AppendAllText(txtDocumentDir, "TimeStamp" + "," + "PreviousTimeStamp" + "," + "DoorRotation" + "," + "PreviousDoorRotation" + "," + "topAngle" + ","
            + "XPosition" + "," + "YPosition" + "," + "ZPosition" + "," + "Inside/Outside" + "," + "AngleOfParticipant" + "," + "DeltaTheta"
            + "," + "Radius" + "," + "ClosestAngleToDoor" + "," + "TTC" + "\n");
    }

    private void Update()
    {
        float angleOfParticipant = Mathf.Atan2(transform.position.x, transform.position.z) * Mathf.Rad2Deg;
        angleOfParticipant = angleOfParticipant + 270;
        
        if (angleOfParticipant >= 360) {
            angleOfParticipant = angleOfParticipant - 360;
        }

        float deltaTheta = rotatingDoor.transform.eulerAngles.y - angleOfParticipant;

        if (deltaTheta < 0) {
            deltaTheta = deltaTheta + 360; 
        }

        float closestAngleToDoor = 0;

        if (240 <= deltaTheta && deltaTheta <= 360) {
            closestAngleToDoor = deltaTheta - 240;
        } else if (120 <= deltaTheta && deltaTheta < 240) {
            closestAngleToDoor = deltaTheta - 120;
        } else if (0 <= deltaTheta && deltaTheta < 120) {
            closestAngleToDoor = deltaTheta;
        }

        double topAngle = 0;
        if (previousDoorRotation < rotatingDoor.transform.eulerAngles.y)
        {
            topAngle = 360 - (rotatingDoor.transform.eulerAngles.y - previousDoorRotation);
        }
        else
        {
            topAngle = previousDoorRotation - rotatingDoor.transform.eulerAngles.y;
        }
        double alphaDot = topAngle / (Time.time - previousTimeStamp);
        double ttc = rotatingDoor.transform.eulerAngles.y / alphaDot;

        xPosSquared = Mathf.Pow(transform.position.x, 2);
        zPosSquared = Mathf.Pow(transform.position.z, 2);

        double radius = Math.Sqrt(xPosSquared + zPosSquared);

        if (radius <= 1)
        {
            //inside
            participantLocation = 1;
        }
        else if (radius > 1)
        {
            //outside
            participantLocation = 0;
        }
        File.AppendAllText(txtDocumentDir, Time.time + "," + previousTimeStamp + "," + rotatingDoor.transform.eulerAngles.y + "," + previousDoorRotation + "," + topAngle + ","
            + transform.position.x + "," + transform.position.y + "," + transform.position.z + "," + participantLocation + "," + angleOfParticipant + "," + deltaTheta
            + "," + radius + "," + closestAngleToDoor + ","  + ttc + "\n");
        previousTimeStamp = Time.time;
        previousDoorRotation = rotatingDoor.transform.eulerAngles.y;
    }
}
