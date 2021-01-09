class MinimumStepsToMakeAnagram {
    public int minSteps(String s, String t) {
        
        //Keeps count of frequency of each letter in both strings
        int[] count = new int[26];
        
        //Traversing through both strings
        for(int i = 0; i < s.length(); i++){
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            //If we find a letter in s then increment its count
            count[c1 - 'a']++;
            
            //If we find a letter in t then decrement its count
            count[c2 - 'a']--;
        }
        
        //Counts number of changes to make t an anagram of s
        int result = 0;
        
        //The once which are same their count will be 0, the count which is > 0 are the ones which are different letter
        for(int i : count){
            
            if(i > 0){
                //The count of each letter will be the number of changes that t has to do inorder to be same as s
                result += i;
            }
        }
        
        return result;
    }
}
