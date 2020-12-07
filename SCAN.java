public class SCAN{
	public void compute(int intCurrentPosition, int arrRequests[], int intSize, String strDirection){
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
}