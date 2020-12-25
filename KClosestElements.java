class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        //Store all the array elements in list
        List<Integer> list = new ArrayList<>();
        
        //Total size
        int len = arr.length;
        
        //Arrays to list
        for(int i : arr)
            list.add(i);
        
        //If x is less or equal to first element, then the first k elements is closer to x
        if(x <= list.get(0)){
            
            return list.subList(0, k);
        }
        //If x is greater or equal to last elements, then last k elements will be closer to x
        else if(x >= list.get(len - 1)){
            
            return list.subList(len - k, len);
        }
        
        //If the x is in middle then we keep range as k - 1 elements to left and k + 1 elements to right of x. We do binary search in this search space as our ans will lie in this
        else{
            
            //We find the index of x.
            int index = Collections.binarySearch(list, x);
            
            //If it isnt present then we take a little bit larger than x (when this list does not have it)
            if(index < 0)
                index = -index - 1;
            
            //We keep low to k-1 places before x, if it goes below 0 then keep 0
            int low = Math.max(0, index - k - 1);
            
            //We keep high to k-1 places after x, if it goes greater than len then keep len-1
            int high = Math.min(len - 1, index + k - 1);
            
            //If we get k elements between low and high that means we got our answer(k closest elements to x)
            while(high - low > k - 1){
                
                //If diff of x - low <= x - high; then the element at high is def not ans hence we discard
                if(x - list.get(low) <= list.get(high) - x)
                    high--;
                
                //If diff of x - high < x - low; then element at low will be discarded
                else if(x - list.get(low) > list.get(high) - x)
                    low++;
            }
            
            //We return k elements from low to high
            return list.subList(low, high + 1);
        }
        
        
    }
}
