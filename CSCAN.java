import java.util.*;

public class CSCAN {
    public void compute(int intCurrent, int arrRequests[], int intSize) {
        int intDistance, intCurTrack, intSeekCount = 0;
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

        for (int i = 0; i < arrayRight.size(); i++) {
            intCurTrack = arrayRight.get(i);
            // appending current track to seek sequence
            arraySequence.add(intCurTrack);

            // calculate absolute distance
            intDistance = Math.abs(intCurTrack - intCurrent);

            // increase the total count
            intSeekCount += intDistance;

            // accessed track is now new head
            intCurrent = intCurTrack;
        }

        intCurrent = 0;
        for (int i = 0; i < arrayLeft.size(); i++) {
            intCurTrack = arrayLeft.get(i);

            // appending current track to seek sequence
            arraySequence.add(intCurTrack);

            // calculate absolute distance
            intDistance = Math.abs(intCurTrack - intCurrent);

            // increase the total count
            intSeekCount += intDistance;

            // accessed track is now the new head
            intCurrent = intCurTrack;
        }

        System.out.println("Total Head Movement: " + intSeekCount);

    }
}
