/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        
        int lo = 1;
        int hi = n;
        
        while(lo < hi){
            
            int mid = lo + (hi - lo)/ 2;
            
            //If we find a bad then we want to discard all the bad after it, we want to keep mid cuz it can be the first one but we also want to check on its left hence hi = mid. So our search space will be frm lo to mid cuz that will have answer
            if(isBadVersion(mid)){
                
                hi = mid;
                
            }
            //If we find mid = good then we dont need anything on left of mid as well as mid so we reduce our search space to be from mid + 1 to hi since that contains answer
            else{
                
                lo = mid + 1;
            }
        }
        
        return lo;
    }
}
