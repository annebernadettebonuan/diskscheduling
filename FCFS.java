import java.util.*;

public class FCFS {
    public void computeFCFS(int intCurrentPosition, int intArrayRequests[]) {
        int intDistance, intCurTrack, intSeekCount = 0;
        for (int i = 0; i < intArrayRequests.length; i++) {
            intCurTrack = intArrayRequests[i];

            intDistance = Math.abs(intCurTrack - intCurrentPosition);

            intSeekCount += intDistance;

            intCurrentPosition = intCurTrack;
        }
        System.out.println("Total Head Movement: " + intSeekCount);
    }
}
