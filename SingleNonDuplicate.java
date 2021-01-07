class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
    
        int left = 0;
        int right = nums.length - 1;
        
        //The single element will always be on even index and its neighbor on the right will not be same. All the elements to left of that element will be in pair on even-odd index. All the elements to right of that element will be in pair of odd-even
        
        //We will do binary search to find that single element (even index and not same neighbors)
        while(left < right){
            
            int mid = left + (right - left) / 2;
            
            //We need to only check even indexes
            if(mid % 2 == 1)
                mid--;
        
            //If the even index has same right neighbor, then ans is to right
            if(nums[mid] == nums[mid + 1])
                left = mid + 2;
            
            //If even index has not similar neighbor, then it can be ans or ans is to left
            else 
                right = mid;
        }
        
        return nums[left];
    }
}
