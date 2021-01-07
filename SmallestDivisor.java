class SmallestDivisor {
    
    //In this function we add all the nums in nums[] div by x
    public int computeSum(int[] nums, int x){
        
        int sum = 0;
        
        for(int n : nums){
            
            //We are ceiling number
            sum += n / x + (n % x == 0 ? 0 : 1);
        }
        
        return sum;
        
    }
    public int smallestDivisor(int[] nums, int threshold) {
        
        //It is given that the number of elements in nums will be less than threshold
        //The least value of divisor can be 1 and max value of divisor will be max element in nums as it will create all elements as 1 and sum of them will be less than threshold
        //So our search space will be from 1 to max(nums). Hence we can use binary search
        
        int left = 1;
        int right = nums[nums.length - 1];
        
        //Binary search
        while(left < right){

            int pivot = left + (right - left) / 2;
            
            int sum = computeSum(nums, pivot);
            
            //If a divisor makes the ans <= threshold then all the divisors to the right of ans will also give same result so we search left to find the smallest divisor
            if(sum <= threshold)
                right = pivot;
            
            //If a divisor makes the ans > threshold then all the divisors to left along with it will be invalid so go right
            else
                left = pivot + 1;
            
        }
        
        // at the end of loop, left == right, search space of 1
        return right;
        
    }
}
