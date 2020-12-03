public class FCFS {
    public void compute(int intCurrentPosition, int arrRequests[]) {
        int intDistance, intCurTrack, seek_time = 0;

        System.out.println("Seek Sequence is:");
        for (int i = 0; i < arrRequests.length; i++) {
            intCurTrack = arrRequests[i];

            intDistance = Math.abs(intCurTrack - intCurrentPosition);

            seek_time += intDistance;

            System.out.println(intCurTrack);
            intCurrentPosition = intCurTrack;
        }
        System.out.println("\nTotal Seek Time: " + seek_time);
    }
}
