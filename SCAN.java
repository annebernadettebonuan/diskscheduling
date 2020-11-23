public class SCAN{
	public void compute(int intCurrent, int arrRequests[], int intSize, String direction){
		int intFirstLocation = 0, intLastLocation = intSize - 1, seek_time = 0;

		int[] visited = new int[arrRequests.length + 1];

        System.out.println("Seekk Sequence is:");

		for (int i = 0 ; i < arrRequests.length ; i++){
			int position = -1;
			int min = 10000;
			for(int j = 0 ; j < arrRequests.length ; j++){
				if(direction.equals("right")){
					if(arrRequests[j] > intCurrent && min > Math.abs(arrRequests[j] - intCurrent) && visited[j] == 0){
						min = Math.abs(arrRequests[j] - intCurrent);
						position = j;
					}
				}
				else if(direction.equals("left")){
					if(arrRequests[j] <= intCurrent && min > Math.abs(arrRequests[j] - intCurrent) && visited[j] == 0){
						position = j;
						min = Math.abs(arrRequests[j] - intCurrent);
					}
				}
			}
			if(position == -1){
				if(direction.equals("right")){
					direction = "left";
					seek_time += Math.abs(intLastLocation - intCurrent);
                    intCurrent = intLastLocation;
                    System.out.println(intLastLocation);
				}
				else{
					direction = "right";
					seek_time += Math.abs(intFirstLocation - intCurrent);
                    intCurrent = intFirstLocation;
                    System.out.println(intFirstLocation);
                }
				i--;
				continue;
			}
			visited[position] = 1;
            seek_time += Math.abs(arrRequests[position] - intCurrent);
            
			System.out.println("Track: " + arrRequests[position]);
			intCurrent = arrRequests[position];
		}
		System.out.println("\nTotal Seek Time : " + seek_time);
	}
}