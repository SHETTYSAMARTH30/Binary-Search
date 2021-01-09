class SplitDepth {
    public int[] maxDepthAfterSplit(String seq) {
        
        int len = seq.length();
        
        //It stores the index of A
        List<Integer> first = new ArrayList<>();
        
        //Number of open A's
        int firstOpen = 0;
        
        //It stores the index of B
        List<Integer> second = new ArrayList<>();
        
        //Number of open B's
        int secondOpen = 0;
        
        //Keeps track of max depth
        int maxDepth = 0;
        
        //We need to divide this balanced parenthesis string in such a way that the maxDepth is minimum
        for(int i = 0; i < len; i++){
            
            if(seq.charAt(i) == '('){
                
                if(firstOpen <= secondOpen){
                    
                    firstOpen++;
                    first.add(i);
                }
                else{
                    
                    secondOpen++;
                    second.add(i);
                }
                
            }
            else{
                
                if(secondOpen >= firstOpen){
                    
                    secondOpen--;
                    second.add(i);
                }
                else{
                    
                    firstOpen--;
                    first.add(i);
                } 
            }
            
            maxDepth = Math.max(maxDepth, Math.max(firstOpen, secondOpen));
        }
        
        //Parenthesis assigned to A will be marked as 0, assigned to B will be marked as 1
        int[] result = new int[len];
        
        //Mark the index which is assigned to A as 0
        for(Integer i : first){
            
            result[i] = 0;
        }
        
        //Mark the index which is assigned to B as 1
        for(Integer i : second){
            
            result[i] = 1;
        }
        
        return result;
        
    }
}
