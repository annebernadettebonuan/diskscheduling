import java.util.*;
public class LOOK{
	public void compute(int intCurrentPosition, int intArrayRequests[], int intTrackSize, String strDirection){
        int intDistance, intCurTrack,intSeekCount = 0, intDirection = 0;
         ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
         ArrayList<Integer> arrayRight = new ArrayList<Integer>();
         ArrayList<Integer> arraySequence = new ArrayList<Integer>();
         for (int i = 0; i < intArrayRequests.length; i++) { 
        if (intArrayRequests[i] < intCurrentPosition){ 
            arrayLeft.add(intArrayRequests[i]); 
        }
       else if (intArrayRequests[i] > intCurrentPosition) {
            arrayRight.add(intArrayRequests[i]); 
        }
    }
     Collections.sort(arrayLeft);
    Collections.sort(arrayRight);
    switch (strDirection){
        case "left":
        intDirection = 1;
        break;
        case "right":
        intDirection = 2;
        break;
        default:
        break;
    }
     int run = 2;
          while (run-- >0){
         switch (intDirection){
             case 1:
              for (int i = arrayLeft.size() - 1; i >= 0; i--) 
            {
                intCurTrack = arrayLeft.get(i);
 
                arraySequence.add(intCurTrack);

                intDistance = Math.abs(intCurTrack - intCurrentPosition);

                intSeekCount += intDistance;

                intCurrentPosition = intCurTrack;
            }
            intDirection = 2;
             break;
             case 2:
             for (int i = 0; i < arrayRight.size(); i++) 
            {
                intCurTrack = arrayRight.get(i);
  
                arraySequence.add(intCurTrack);
 
                intDistance = Math.abs(intCurTrack - intCurrentPosition);
 
               intSeekCount += intDistance;
 
                intCurrentPosition = intCurTrack;
            }
           intDirection = 1;
             
             break;
             default:
             break;
             
            }
        }
        System.out.println("\nTotal Seek Time : " + intSeekCount);
	   
	   }}