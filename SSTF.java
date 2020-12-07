public class SSTF {
    public void compute(int intCurrentPosition, int arrRequests[]) {
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
}