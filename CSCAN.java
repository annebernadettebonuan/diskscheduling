import java.util.*;

public class CSCAN {
    public void compute(int intCurrent, int arrRequests[], int intSize) {
        int intDistance, intCurTrack, seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        ArrayList<Integer> arraySequence = new ArrayList<Integer>();

        arrayLeft.add(0);
        arrayRight.add(intSize - 1);
        for (int i = 0; i < arrRequests.length; i++) {
            if (arrRequests[i] < intCurrent) {
                arrayLeft.add(arrRequests[i]);
            } else if (arrRequests[i] > intCurrent) {
                arrayRight.add(arrRequests[i]);
            }
        }

        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);

        System.out.println("Seekk Sequence is:");
        
        for (int i = 0; i < arrayRight.size(); i++) {
            intCurTrack = arrayRight.get(i);
            arraySequence.add(intCurTrack);

            intDistance = Math.abs(intCurTrack - intCurrent);

            seek_time += intDistance;

            System.out.println("Track: " + intCurTrack);

            intCurrent = intCurTrack;
        }

        intCurrent = 0;
        for (int i = 0; i < arrayLeft.size(); i++) {
            intCurTrack = arrayLeft.get(i);

            arraySequence.add(intCurTrack);

            intDistance = Math.abs(intCurTrack - intCurrent);
            
            seek_time += intDistance;

            System.out.println("Track: " + intCurTrack);
            intCurrent = intCurTrack;
        }

        System.out.println("Total Seek Time: " + seek_time);

    }
}
