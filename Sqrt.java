class Sqrt {
    public int mySqrt(int x) {
        
        //If a number is less than x then return num
        if(x < 2)
            return x;
        
        long num;
        
        //If x > 2 then the sqrt(x) is always <= x/2 hence we keep right side of search space as x/2.Even if we keep the left as 0 the code works fine.
        int mid, left = 2, right = x / 2;
        
        while(left <= right){
            
            //Find the pivot element
            mid = left + (right - left) / 2;
            
            num = (long)mid * mid;
            
            //If ans is greater then search on left side of mid
            if(num > x)
                right = mid - 1;
            
            //If ans is less then search on right side of mid
            else if(num < x)
                left = mid + 1;
                       
            //If we find sqrt then return number
            else
                return mid;
        }
        
        //If we can't find the proper square root then return right
        return right;
        
    }
}
