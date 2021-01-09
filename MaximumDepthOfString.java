class MaximumDepthOfString {
    public int maxDepth(String s) {
        
        //Depth of curly brackets
        int maxDepth = 0;
        
        int count = 0;
        
        for(char ch : s.toCharArray()){
            
            //When we find the opening bracket we increase count
            if(ch == '('){
                
                count++;
            }
            //And for closing decreases the count
            else if(ch == ')'){
                
                count--;
            }
            else{
                continue;
            }
            
            //We calculate max depth at any point
            maxDepth = Math.max(maxDepth, count);
        }
        
        return maxDepth;
        
    }
}
