class TotalMissingElement {
    
    //It gives the total num of missing elements between nums[0] and nums[idx]
    public int totalMissing(int idx, int[] nums){
        
        return nums[idx] - nums[0] - idx;
    }
    
    public int missingElement(int[] nums, int k) {
        
        int n = nums.length;
        
        //If k is greater than total num of missing elements bet 1st and last element, then k is definitely after last element.
        //So we add k to last element and subtract total missing elements until last element
        if(k > totalMissing(n - 1, nums))
            return nums[n - 1] + k - totalMissing(n - 1, nums);
        
        int left = 0;
        int right = n - 1;
        
        //We can linearly check for each element from start whether k comes in between
        //But we do binary search for logN
        // missing(left - 1) < k <= missing(left)
        while(left < right){
            
            int mid = left + (right - left) / 2;
            
            //If total num of missing element until mid is less than k then we can check right
            if(totalMissing(mid, nums) < k)
                left = mid + 1;
            //If total num of missing is = or > k then we have to go left, so that we can find the smallest index where number of missing elements >= k
            else
                right = mid;
            
        }
        
        //We will add k to 1 element before the index that satisfies condition; and then sub total missing elements until last element
        return nums[left - 1] + k - totalMissing(left - 1, nums);
        
    }
}
