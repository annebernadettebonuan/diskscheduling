public class SSTF {
    public void compute(int intCurrentPosition, int arrRequests[]) {
        node diff[] = new node[arrRequests.length];

        for (int i = 0; i < diff.length; i++){
            diff[i] = new node();
        }

        int seek_time = 0;
        int[] seek_sequence = new int[arrRequests.length + 1];

        for (int i = 0; i < arrRequests.length; i++) {
            seek_sequence[i] = intCurrentPosition;
            calculateDifference(arrRequests, intCurrentPosition, diff);

            int index = findMin(diff);

            diff[index].accessed = true;
            seek_time += diff[index].distance;

            intCurrentPosition = arrRequests[index];
        }

        seek_sequence[seek_sequence.length - 1] = intCurrentPosition;
        
        System.out.println("Seek Sequence is:");

        for (int i = 0; i < seek_sequence.length; i++){
            System.out.println(seek_sequence[i]);
        }
        System.out.println("\nTotal Seek Time: " + seek_time);
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
    int distance = 0;
    boolean accessed = false;
}