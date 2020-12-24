class MulPeakElements {
    public int findPeakElement(int[] nums) {
        
        int mid, left = 0, right = nums.length - 1;
        
        while(left < right){
            
            mid = left + (right - left) / 2;
            
            //If the mid is less than next element then the peak is def on right
            if(nums[mid] < nums[mid + 1])
                left = mid + 1;
            
            //If mid is > next element then either it is peak or go left and check for further peak elements
            else 
                right = mid;
        }
        
        //At end we get 1 element search space, which will be the peak (left == right; hence loop breaks)
        return left;
        
    }
}
