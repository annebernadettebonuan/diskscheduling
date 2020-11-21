public class SSTF {
    public void compute(int intCurrentPosition, int intArrayRequests[]) {
        if (intArrayRequests.length == 0)
            return;

        // create array of objects of class node
        node diff[] = new node[intArrayRequests.length];

        // initialize array
        for (int i = 0; i < diff.length; i++)

            diff[i] = new node();

        // count total number of seek operation
        int seek_count = 0;

        // stores sequence in which disk access is done
        int[] seek_sequence = new int[intArrayRequests.length + 1];

        for (int i = 0; i < intArrayRequests.length; i++) {

            seek_sequence[i] = intCurrentPosition;
            calculateDifference(intArrayRequests, intCurrentPosition, diff);

            int index = findMin(diff);

            diff[index].accessed = true;

            // increase the total count
            seek_count += diff[index].distance;

            // accessed track is now new head
            intCurrentPosition = intArrayRequests[index];
        }

        // for last accessed track
        seek_sequence[seek_sequence.length - 1] = intCurrentPosition;

        System.out.println("Total number of seek operations = " + seek_count);

        System.out.println("Seek Sequence is");

        // print the sequence
        for (int i = 0; i < seek_sequence.length; i++)
            System.out.println(seek_sequence[i]);
    }

    public static int findMin(node diff[]) {
        int index = -1, minimum = Integer.MAX_VALUE;

        for (int i = 0; i < diff.length; i++) {
            if (!diff[i].accessed && minimum > diff[i].distance) {

                minimum = diff[i].distance;
                index = i;
            }
        }
        return index;
    }

    public static void calculateDifference(int queue[], int head, node diff[]) {
        for (int i = 0; i < diff.length; i++) {
            diff[i].distance = Math.abs(queue[i] - head);
        }
    }
}

class node {

    // represent difference between
    // head position and track number
    int distance = 0;

    // true if track has been accessed
    boolean accessed = false;
}