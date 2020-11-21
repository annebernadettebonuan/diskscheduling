import java.util.*;

public class DiskScheduling {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int intCurrent = 0, intSize = 0, intReqNum = 0, intSeekRate = 0; //seek rate not used
        boolean isComplete = false;
        String strInput;

        int check = 1;
        do{
            boolean isCorrect = false;

            while (!isCorrect) {
                try {
                    System.out.print("Input Current Position: ");
                    intCurrent = Integer.parseInt(input.nextLine());
                    isCorrect = true;
                } catch (Exception e) {
                    isCorrect = false;
                    System.out.println("Invalid input. Please input a number");
                }
            }
            
            isCorrect = false;
    
            while (!isCorrect) {
                try {
                    System.out.print("Input Track Size: ");
                    intSize = Integer.parseInt(input.nextLine());
    
                    if(intSize > intCurrent){
                        isCorrect = true;
                    }else{
                        System.out.println("The size should be more than the current position.");
                        isCorrect = false;
                    }
                } catch (Exception e) {
                    isCorrect = false;
                    System.out.println("Invalid input. Please input a number");
                }
            }
    
            isCorrect = false;
    
            while(!isCorrect){
                try{
                    System.out.print("Input number of requests (1-10): ");
                    intReqNum = Integer.parseInt(input.nextLine());
                    
                    if(intReqNum >= 1 && intReqNum <= 10){
                        isCorrect = true;
                    }else{
                        isCorrect = false;
                    }
                }catch(Exception e){
                    isCorrect = false;
                    System.out.println("Number of requests range from 1 to 10.");
                }
            }
    
            int arrRequests[] = new int[intReqNum];
    
            if (intReqNum <= 10 && intReqNum >= 1) {
                arrRequests = new int[intReqNum];
                for (int i = 0; i < arrRequests.length; i++) {
                    do {
                        System.out.print("Loc " + (i + 1) + ": ");
                        arrRequests[i] = input.nextInt();
                        if (arrRequests[i] >= intSize || arrRequests[i] < 0) {
                            isComplete = true;
                            System.out.println("Invalid Input Please try again");
                        } else {
                            isComplete = false;
    
                        }
                    } while (isComplete);
                }
            } else {
                System.out.print("Number of Requests is invalid");
            }

            printChoices(intCurrent, intSize, intReqNum, arrRequests);
            
            System.out.print("\n\nInput again [y/n]?: ");
            strInput = input.next();
            if(strInput.substring(0,1).toLowerCase().equals("y")){
                check = 1;
            }
            else{
                check = 0;
            }
        }while(check == 1);

        input.close();
    }

    static void printChoices(int intCurrent, int intSize, int intReqNum, int arrRequests[]) {
        String strDirection = "", strChoice;

        System.out.println("\nChoose Disk Scheduling Algorithm: ");
        System.out.println("[A] First Come, First Serve (FCFS)");
        System.out.println("[B] Shortest Seek Time First (SSTF)");
        System.out.println("[C] SCAN");
        System.out.println("[D] LOOK");
        System.out.println("[E] Circular Scan (CSCAN)");
        System.out.println("[F] Circular Look (CLOOK)");
        System.out.println("[G] Exit\n");
        System.out.print("Enter Choice: ");
        strChoice = input.next().toUpperCase();

        switch (strChoice) {
            case "A":
                System.out.println("First Come, First Serve (FCFS)");
                FCFS fcfs = new FCFS();
                fcfs.compute(intCurrent, arrRequests);
                break;
            case "B":
                System.out.println("Shortest Seek Time First (SSTF)");
                SSTF sstf = new SSTF();
                sstf.compute(intCurrent, arrRequests);
                break;
            case "C":
                strDirection = getDirection();

                System.out.println("SCAN");
                SCAN scan = new SCAN();
                scan.compute(intCurrent, arrRequests, intSize, strDirection);
                break;
            case "D":
                System.out.println("LOOK");
                
                break;
            case "E":
                System.out.println("Circular SCAN");
                CSCAN cscan = new CSCAN();

                cscan.compute(intCurrent, arrRequests, intSize);
                break;
            case "F":
                strDirection = getDirection();

                System.out.println("Circular LOOK");
                
                break;
            case "G":
                System.exit(0);
                break;
            default:
                System.out.println("Thank you for using our program.\n");
        }
    }

    private static String getDirection(){
        String strDirection = "";

        boolean isCorrect = false;
        while(!isCorrect){
            try{
                System.out.print("Enter direction (left or right): ");
                strDirection = input.nextLine();
                if(strDirection.toLowerCase().equals("left") || strDirection.toLowerCase().equals("right")){
                    isCorrect = true;
                }else{
                    isCorrect = false;
                }
            }catch(Exception e){
            isCorrect = false;
            }
        }
        return strDirection;
    }
}