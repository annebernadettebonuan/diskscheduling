public class FCFS {
    public void compute(int intCurrent, int arrRequests[]) {
        int intDistance, intCurTrack, seek_time = 0;
        for (int i = 0; i < arrRequests.length; i++) {
            intCurTrack = arrRequests[i];

            intDistance = Math.abs(intCurTrack - intCurrent);

            seek_time += intDistance;

            intCurrent = intCurTrack;
        }
        System.out.println("Total Seek Time: " + seek_time);
    }
}
