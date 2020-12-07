public class FCFS {
    public void compute(int intCurrentPosition, int arrRequests[]) {
        int intDistance, intCurTrack, seek_time = 0;

        int i = 0;
        while(i < arrRequests.length){
            intCurTrack = arrRequests[i];

            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            
            seek_time += intDistance;

            intCurrentPosition = intCurTrack;
            i++;
        }
        System.out.println("\nTotal Seek Time: " + seek_time);
    }
}
