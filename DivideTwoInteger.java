class DivideTwoInteger {
    
    private final int HALF_MIN_INT = -1073741824;
        
    public int divide(int dividend, int divisor) {
        
        //We can't use *, / hence we will use <<, >>
        //We will make both numbers negative
        
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        
        int negatives = 2;
        
        if(dividend > 0){
            
            negatives--;
            dividend = -dividend;
        }
        
        if(divisor > 0){
            
            negatives--;
            divisor = -divisor;
        }
        
        //We can linearly subtract divisor each time from dividend and get the answer, but it takes time. Instead we can subtract divisor in powers of two
        
        //Highest multiples of divisor that we subtract from dividend
        int highestDouble = divisor;
        
        //We save the power in this, this can act as quotient
        int highestPowerOfTwo = -1;
        
        while(highestDouble >= HALF_MIN_INT && highestDouble + highestDouble >= dividend){
            
            highestDouble += highestDouble;
            highestPowerOfTwo += highestPowerOfTwo;
        }
        
        //Once we get max mul of divisor less than dividend, we subtract it by highestPower and add powerOfTwo to quotient. We do same to result of subtracted number
        int quotient = 0;
        
        while(dividend <= divisor){
            
            if(highestDouble >= dividend){
                
                dividend -= highestDouble;
                
                //We add the power of that multiple of divisor to quotient 
                quotient += highestPowerOfTwo;
            }
            
            //Divide by 2
            highestDouble >>= 1;
            
            highestPowerOfTwo >>= 1;
            
        }
        
        //If either dividend or divisor is negative the quotient will be negative else positive
        if(negatives != 1){
            
            return -quotient;
        }
        
        return quotient;
        
    }
}
