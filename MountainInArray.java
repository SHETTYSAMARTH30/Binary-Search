class MountainInArray {
    public int peakIndexInMountainArray(int[] arr) {
    
        //In linear search we just check A[i] < A[i+1] if it breaks then we return i, we do same using binary search. If A[i] < A[i+1] we keep going right else the index can be mountain so we move left
        
        int mid, left = 0, right = arr.length - 1;
        
        //left == right, we have reached the mountain
        while(left < right){
            
            mid = left + (right - left) / 2;
            
            //Kee going left to find mountain as this index can't be a mountain
            if(arr[mid] < arr[mid + 1])
                left = mid + 1;
            
            //It can be a mountain or we are on number which is on right side of mountain
            else
                right = mid;
        }
        
        return left;
        
    }
}
