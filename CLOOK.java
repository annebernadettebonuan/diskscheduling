import java.util.*;
public class CLOOK{
	public void compute(int intCurrentPosition, int arrRequests[]){
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

        int right = 0;
        
        while(right < arrayRight.size()){
            intCurTrack = arrayRight.get(right); 
            arraySequence.add(intCurTrack); 
    
            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 

            right++;
        }
    
        intDistance = intCurrentPosition - arrayLeft.get(0);

        if(intDistance < 0){
            intDistance *= -1;
        }
        
        seek_time += intDistance;
        
        intCurrentPosition = arrayLeft.get(0);

        int left = 0;

        while(left < arrayLeft.size()){
            intCurTrack = arrayLeft.get(left); 
            arraySequence.add(intCurTrack); 
    
            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 
            left++;
        }
    
        System.out.println("\nTotal Seek Time : " + seek_time);
    }
}