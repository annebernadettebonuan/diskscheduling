import java.util.*;
public class LOOK{
	public void compute(int intCurrentPosition, int intArrayRequests[], int intTrackSize, String strDirection){
        int intDistance, intCurTrack,intSeekCount = 0;
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
    
        System.out.println("Seek Sequence is:\n" + intCurrentPosition);

        int run = 2;
        while (run-- > 0){
            switch (strDirection){
            case "left":
                for (int i = arrayLeft.size() - 1; i >= 0; i--) 
                {
                    intCurTrack = arrayLeft.get(i);
                    System.out.println(intCurTrack);
                    arraySequence.add(intCurTrack);
                    intDistance = Math.abs(intCurTrack - intCurrentPosition);
                    intSeekCount += intDistance;
                    intCurrentPosition = intCurTrack;
                }
                strDirection = "right";
                break;
            case "right":
                for (int i = 0; i < arrayRight.size(); i++) 
                {
                    intCurTrack = arrayRight.get(i);
                    System.out.println(intCurTrack);
                    arraySequence.add(intCurTrack);
                    intDistance = Math.abs(intCurTrack - intCurrentPosition);
                    intSeekCount += intDistance;
                    intCurrentPosition = intCurTrack;
                }
                strDirection = "left";
                break;
            }
        }
        System.out.println("\nTotal Seek Time : " + intSeekCount);
    }
}