class MajorityElement {
    public boolean isMajorityElement(int[] nums, int target) {
        
        //Find the size
        int len = nums.length;
        
        //The majority element is > N/2, so it should be at center of array.
        if(nums[len / 2] != target)
            return false;
        
        int lo = 0;
        int hi = len - 1;
        
        //To count the frequency of majority element
        int count = 0;
        
        while(lo < hi){
            
            int mid = lo + (hi - lo) / 2;
            
            if(target == nums[mid]){

                //Count the middle element
                count++;
                
                //We count all the same element to left of mid
                int idx = mid - 1;
                
                while(idx >= 0 && nums[idx--] == target)
                    count++;
                
                //Then we count all the same element to right of mid
                idx = mid + 1;
                
                while(idx < len && nums[idx++] == target)
                    count++;
                
                //After finding the count of target we break
                break;
                
            }
            //If target is at left go left
            else if(target < nums[mid]){
                hi = mid - 1;
            }
            //If target is at right go right
            else{
                lo = mid + 1;
            }
        }
        
        return count > len / 2;
        
    }
}
