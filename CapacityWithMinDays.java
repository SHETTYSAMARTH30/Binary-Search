class CapacityWithMinDays {
    
    public int calculateDays(int[] weights, int capacity){
        
        int daysRequired = 1;
        int sum = 0;
        
        //It will calculate num of days reqd to send all the weights for a particular per day capacity
        for(int w: weights){
            
            sum += w;
            
            //The sum of wts for a day must not exceed capacity
            if(sum > capacity){
                
                daysRequired++;
                //Since the current weight is not considered we retain that for next day capacity
                sum = w;
            }
        }
        
        return daysRequired;
    }
    
    public int shipWithinDays(int[] weights, int D) {
        
        //Eg: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
        //The min wt the belt can carry at once is 10. The max wt will be sum of all weights, that belt can carry at once.ie 55
        //We need to find the minimum wt that belt can carry in D days
        
        int min = 0;
        int max = 0;
        
        //Cal the min and max weights that belt can carry
        for(int w : weights){
            
            max += w;
            min = Math.max(min, w);
        }
        
        //We can linearly check for all the weight but it will take O(n) * O(max - min). 
        //Binary search will be useful as we are searching in the ordered range of min to max. O(n)*O(log (max - min))
        while(min < max){
            
            int mid = min + (max - min) / 2;
            
            //Num of days reqd for particular capacity per day
            int numberOfDays = calculateDays(weights, mid);
            
            //If for a particular capacity it is taking more num of days. Then we increase capacity
            if(numberOfDays > D){
                
                min = mid + 1;
            }
            //The days might be equal to D or less. But we still need to find least capacity
            else{
                
                max = mid;
            } 
        }
        
        return min;
    }
}
