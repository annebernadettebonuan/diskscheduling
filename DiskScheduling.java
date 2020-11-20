import java.util.Scanner;

public class DiskScheduling {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int intCurrentPosition, intTrackSize, intNumOfRequests, intSeekRate, intInputAgain = 0;
        String stringAlgChoice, stringInputAgain;
        do {
            System.out.print("Input current position: ");
            intCurrentPosition = input.nextInt();
            System.out.print("Input Track Size: ");
            intTrackSize = input.nextInt();
            if (intTrackSize > intCurrentPosition) {
                System.out.print("Input Seek Rate: ");
                intSeekRate = input.nextInt();
                System.out.print("Input number of requests (Max of 10): ");
                intNumOfRequests = input.nextInt();
                if (intNumOfRequests <= 10 && intNumOfRequests >= 1) {
                    int intArrayRequests[] = new int[intNumOfRequests], intCheck;
                    for (int i = 0; i < intArrayRequests.length; i++) {
                        do {
                            System.out.print("Loc " + (i + 1) + ": ");
                            intArrayRequests[i] = input.nextInt();
                            if (intArrayRequests[i] >= intTrackSize || intArrayRequests[i] < 0) {
                                intCheck = 1;
                                System.out.println("Invalid Input Please try again");
                            } else {
                                intCheck = 0;
                            }
                        } while (intCheck == 1);
                    }

                    System.out.println("Choose Disk Scheduling Algorithm: ");
                    System.out.println("[A] First Come First Serve (FCFS)");
                    System.out.println("[B] Shortest Seek Time First (SSTF)");
                    System.out.println("[C] Scan");
                    System.out.println("[D] Look");
                    System.out.println("[E] Circular Scan (CSCAN)");
                    System.out.println("[F] Circular Look (CLOOK)");
                    System.out.println("[G] Exit");
                    System.out.print("Enter Choice: ");
                    stringAlgChoice = input.next();
                    input.close();
                    switch (stringAlgChoice) {
                        case "A":
                            FirstComeFirstServe(intCurrentPosition, intArrayRequests, intNumOfRequests);
                            System.out.print("Input again [y/n]?: ");
                            stringInputAgain = input.next();
                            if (stringInputAgain.equals("y")) {
                                intInputAgain = 1;
                            } else {
                                intInputAgain = 0;
                            }
                            break;
                        case "B":

                            break;
                        case "C":

                            break;
                        case "D":

                            break;
                        case "E":

                            break;
                        case "F":

                            break;
                        case "G":

                            break;

                        default:
                            break;
                    }

                } else {
                    System.out.print("Number of Requests is invalid");
                }
            } else {
                System.out.print("Track Size is less than Current Position");
            }

        } while (intInputAgain == 1);
    }

    private static void FirstComeFirstServe(int intCurrentPosition, int intArrayRequests[], int intNumOfRequests) {
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
