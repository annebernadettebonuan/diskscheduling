/*
* Bonuan, Anne Bernadette L.
* Sing, James Anthony P.
* Ybera, Jose Miguel
*/

import java.util.*;

public class DiskScheduling {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int intCurrentPosition = 0, intSize = 0, intReqNum = 0, intSeekRate = 0; //seek rate not used
        boolean isComplete = false;
        String strInput;

        int check = 1;
        do{
            boolean isCorrect = false;

            while (!isCorrect) {
                try {
                    System.out.print("Input Current Position: ");
                    intCurrentPosition = Integer.parseInt(input.nextLine());
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
    
                    if(intSize > intCurrentPosition){
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
    
            int arrRequests[] = {};
    
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

            printChoices(intCurrentPosition, intSize, intReqNum, arrRequests);
            
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

    static void printChoices(int intCurrentPosition, int intSize, int intReqNum, int arrRequests[]) {
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
                System.out.println("\nFirst Come, First Serve (FCFS)");
                computeFCFS(intCurrentPosition, arrRequests);
                break;
            case "B":
                System.out.println("\nShortest Seek Time First (SSTF)");
                computeSSTF(intCurrentPosition, arrRequests);
                break;
            case "C":
                strDirection = getDirection();
                System.out.println("\nSCAN");
                computeSCAN(intCurrentPosition, arrRequests, intSize, strDirection);
                break;
            case "D":
                strDirection = getDirection();
                System.out.println("\nLOOK");
                computeLOOK(intCurrentPosition, arrRequests, strDirection);
                break;
            case "E":
                System.out.println("\nCircular SCAN");
                computeCSCAN(intCurrentPosition, arrRequests, intSize);
                break;
            case "F":
                System.out.println("\nCircular LOOK");
                computeCLOOK(intCurrentPosition, arrRequests);
                
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

    private static void computeFCFS(int intCurrentPosition, int arrRequests[]) {
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

    private static void computeSSTF(int intCurrentPosition, int arrRequests[]) {
        int seek_time = 0, intDistance;

        int[] n = new int[arrRequests.length + 1]; 
        
		for(int i = 0 ; i < arrRequests.length ; i++)
		{
			int min = 100000;
            int index = 0, j = 0;

            while(j < arrRequests.length){
                int compare = arrRequests[j] - intCurrentPosition;
                
                if(compare < 0){
                    compare *= -1;
                }

                if(compare < min)
				{
					if(n[j]==0)
					{
						min = Math.abs(arrRequests[j] - intCurrentPosition);
						index = j;
					}
				}
                j++;
            }
            n[index] = 1;

            intDistance = arrRequests[index] - intCurrentPosition;
            
            if(intDistance < 0){
                intDistance *= -1;
            }
            
            seek_time += intDistance;
           
			intCurrentPosition = arrRequests[index];
		}
		
        System.out.println("\nTotal Seek Time :" + seek_time);
    }

    private static void computeSCAN(int intCurrentPosition, int arrRequests[], int intSize, String strDirection){
		int intFirstLocation = 0, intLastLocation = intSize - 1, seek_time = 0, intDistance;

		int[] n = new int[arrRequests.length + 1];

		for (int i = 0 ; i < arrRequests.length ; i++){
			int min = 10000, index = -1, j = 0;

			while(j < arrRequests.length){
				int compare = arrRequests[j] - intCurrentPosition;

				if(compare < 0){
					compare *= -1;
				}

				switch(strDirection){
					case "right":
						if(arrRequests[j] > intCurrentPosition && min > compare && n[j] == 0){
							min = arrRequests[j] - intCurrentPosition;
							
							if(min < 0){
								min *= -1;
							}
							index = j;
						}
					break;

					case "left":
						if(arrRequests[j] <= intCurrentPosition && min > compare && n[j] == 0){
							index = j;
							min = arrRequests[j] - intCurrentPosition;
							
							if(min < 0){
								min *= -1;
							}
						}
					break;
				}
				j++;
			}

			if(index == -1){
				switch(strDirection){
					case "right":
						strDirection = "left";

						intDistance = intLastLocation - intCurrentPosition;

						if(intDistance < 0){
							intDistance *= -1;
						}
						seek_time += intDistance;
						intCurrentPosition = intLastLocation;
						break;
						
					case "left":
						strDirection = "right";

						intDistance = intFirstLocation - intCurrentPosition;

						if(intDistance < 0){
							intDistance *= -1;
						}
						
						seek_time += intDistance;
						intCurrentPosition = intFirstLocation;
						break;
				}
				i--;
				continue;
			}
			n[index] = 1;

			intDistance = arrRequests[index] - intCurrentPosition;

			if(intDistance < 0){
				intDistance *= -1;
			}

            seek_time += intDistance;
            
			intCurrentPosition = arrRequests[index];
		}
		System.out.println("\nTotal Seek Time : " + seek_time);
    }
    
    private static void computeLOOK(int intCurrentPosition, int arrRequests[], String strDirection){
        int intDistance, intCurTrack,seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        
        
         for (int i = 0; i < arrRequests.length; i++) { 
            if (arrRequests[i] < intCurrentPosition){ 
                arrayLeft.add(arrRequests[i]); 
            }
            else if (arrRequests[i] > intCurrentPosition) {
                arrayRight.add(arrRequests[i]); 
            }
        }   
    
        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);
    
        int run = 2;
        while (run-- > 0){
            switch (strDirection){
            case "left":
                int left = arrayLeft.size() - 1;

                while(left >= 0){
                    intCurTrack = arrayLeft.get(left);
                   
                    
                    intDistance = intCurTrack - intCurrentPosition;
                    
                    if(intDistance < 0){
                        intDistance *= -1;
                    }

                    seek_time += intDistance;
                    intCurrentPosition = intCurTrack;

                    left--;
                }
                strDirection = "right";
                break;

            case "right":
                int right = 0;

                while(right < arrayRight.size()){
                    intCurTrack = arrayRight.get(right);
                   

                    intDistance = intCurTrack - intCurrentPosition;

                    if(intDistance < 0){
                        intDistance *= -1;
                    }

                    seek_time += intDistance;
                    intCurrentPosition = intCurTrack;

                    right++;
                }
                strDirection = "left";
                break;
            }
        }
        System.out.println("\nTotal Seek Time : " + seek_time);
    }

    private static void computeCSCAN(int intCurrentPosition, int arrRequests[], int intSize) {
        int intDistance, intCurTrack, seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
      

        arrayLeft.add(0);
        arrayRight.add(intSize - 1);

        for (int i = 0; i < arrRequests.length; i++) {
            if (arrRequests[i] < intCurrentPosition) {
                arrayLeft.add(arrRequests[i]);
            } else if (arrRequests[i] > intCurrentPosition) {
                arrayRight.add(arrRequests[i]);
            }
        }

        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);
        
        int right = 0;

        while(right < arrayRight.size()){
            intCurTrack = arrayRight.get(right);

            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            seek_time += intDistance;

            intCurrentPosition = intCurTrack;

            right++;
        }

        intCurrentPosition = 0;

        int left = 0;
        while(left < arrayLeft.size()){
            intCurTrack = arrayLeft.get(left);

         

            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            
            seek_time += intDistance;

            intCurrentPosition = intCurTrack;
            left++;
        }

        System.out.println("\nTotal Seek Time: " + seek_time);
    }

    private static void computeCLOOK(int intCurrentPosition, int arrRequests[]){
        int intDistance, intCurTrack, seek_time = 0;
        ArrayList<Integer> arrayLeft = new ArrayList<Integer>();
        ArrayList<Integer> arrayRight = new ArrayList<Integer>();
        
         
        for (int i = 0; i < arrRequests.length; i++) { 
            if (arrRequests[i] < intCurrentPosition){ 
                arrayLeft.add(arrRequests[i]); 
            }
            else if (arrRequests[i] > intCurrentPosition) {
                arrayRight.add(arrRequests[i]); 
            }
        } 

        Collections.sort(arrayLeft);
        Collections.sort(arrayRight);

        int right = 0;
        
        while(right < arrayRight.size()){
            intCurTrack = arrayRight.get(right); 
            
            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 

            right++;
        }
    
        intDistance = intCurrentPosition - arrayLeft.get(0);

        if(intDistance < 0){
            intDistance *= -1;
        }
        
        seek_time += intDistance;
        
        intCurrentPosition = arrayLeft.get(0);

        int left = 0;

        while(left < arrayLeft.size()){
            intCurTrack = arrayLeft.get(left); 
    
            intDistance = intCurTrack - intCurrentPosition;

            if(intDistance < 0){
                intDistance *= -1;
            }
            seek_time += intDistance; 
    
            intCurrentPosition = intCurTrack; 
            left++;
        }
    
        System.out.println("\nTotal Seek Time : " + seek_time);
    }
}