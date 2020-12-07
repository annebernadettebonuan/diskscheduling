import java.util.*;

public class CSCAN {
    public void compute(int intCurrentPosition, int arrRequests[], int intSize) {
        int intDistance, intCurTrack, seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        ArrayList<Integer> arraySequence = new ArrayList<Integer>();

        arrayLeft.add(0);
        arrayRight.add(intSize - 1);

        for (int i = 0; i < arrRequests.length; i++) {
            if (arrRequests[i] < intCurrentPosition) {
                arrayLeft.add(arrRequests[i]);
            } else if (arrRequests[i] > intCurrentPosition) {
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

        intCurrentPosition = 0;

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

        System.out.println("\nTotal Seek Time: " + seek_time);
    }
}
