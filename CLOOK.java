import java.util.*;
public class CLOOK{
	public void compute(int intCurrentPosition, int arrRequests[], int intTrackSize){
        int intDistance, intCurTrack, seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        ArrayList<Integer> arraySequence = new ArrayList<Integer>();
         
        for (int i = 0; i < arrRequests.length; i++) { 
            if (arrRequests[i] < intCurrentPosition){ 
                arrayLeft.add(arrRequests[i]); 
            }
            else if (arrRequests[i] > intCurrentPosition) {
                arrayRight.add(arrRequests[i]); 
            }
        } 

        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);

        System.out.println("Seek sequence is:\n" + intCurrentPosition);

        for (int i = 0; i < arrayRight.size(); i++) {
            intCurTrack = arrayRight.get(i); 
            System.out.println(intCurTrack);
            arraySequence.add(intCurTrack); 
    
            intDistance = Math.abs(intCurTrack - intCurrentPosition); 
    
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 
        }
    
        seek_time += Math.abs(intCurrentPosition - arrayLeft.get(0));
        intCurrentPosition = arrayLeft.get(0);

        for (int i = 0; i < arrayLeft.size(); i++) { 
            intCurTrack = arrayLeft.get(i); 
            System.out.println(intCurTrack);
            arraySequence.add(intCurTrack); 
    
            intDistance = Math.abs(intCurTrack - intCurrentPosition); 
    
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 
        } 
    
        System.out.println("\nTotal Seek Time : " + seek_time);
    }
}