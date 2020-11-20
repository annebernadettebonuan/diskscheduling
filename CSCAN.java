import java.util.*;

public class CSCAN {
    private int intCurrentPosition, intNumoOfRequests, intTrackSize;
    private int intArrayRequests[];

    public void computeCSCAN(int intCurrentPosition, int intArrayRequests[], int intNumoOfRequests, int intTrackSize) {
        int intDistance, intCurTrack, intSeekCount = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        ArrayList<Integer> arraySequence = new ArrayList<Integer>();

        arrayLeft.add(0);
        arrayRight.add(intTrackSize - 1);
        for (int i = 0; i < intArrayRequests.length; i++) {
            if (intArrayRequests[i] < intCurrentPosition) {
                arrayLeft.add(intArrayRequests[i]);
            } else if (intArrayRequests[i] > intCurrentPosition) {
                arrayRight.add(intArrayRequests[i]);
            }
        }

        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);

        for (int i = 0; i < arrayRight.size(); i++) {
            intCurTrack = arrayRight.get(i);
            // appending current track to seek sequence
            arraySequence.add(intCurTrack);

            // calculate absolute distance
            intDistance = Math.abs(intCurTrack - intCurrentPosition);

            // increase the total count
            intSeekCount += intDistance;

            // accessed track is now new head
            intCurrentPosition = intCurTrack;
        }

        intCurrentPosition = 0;
        for (int i = 0; i < arrayLeft.size(); i++) {
            intCurTrack = arrayLeft.get(i);

            // appending current track to seek sequence
            arraySequence.add(intCurTrack);

            // calculate absolute distance
            intDistance = Math.abs(intCurTrack - intCurrentPosition);

            // increase the total count
            intSeekCount += intDistance;

            // accessed track is now the new head
            intCurrentPosition = intCurTrack;
        }

        System.out.println("Total Head Movement: " + intSeekCount);

    }
}
