using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class FacePlayer : MonoBehaviour
{
    public Transform facing;
   
    void Update()
    {
        transform.LookAt(new Vector3(facing.position.x, facing.position.y, facing.position.z));
    }
}
