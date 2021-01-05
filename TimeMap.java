class TimeMap {

    //Map of Key -> List of pair of (Timestamp, value)
    Map<String, List<Pair<Integer, String>>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        
        //If the key is not present then create an arraylist
        map.putIfAbsent(key, new ArrayList<Pair<Integer, String>>());
       
        //If key is already present in the map then add the pair
        map.get(key).add(new Pair(timestamp, value));
        
    }
    
    public String get(String key, int timestamp) {
        
        //If the key is not present in the map then return ""
        if(!map.containsKey(key))
            return "";
        
        //Get the list of pairs from the map
        List<Pair<Integer, String>> list = map.get(key);
        
        //Then we search for the index of the timestamp that we are looking for using binary search, but for binary search we need to sort the list using timestamp first
        int i = Collections.binarySearch(list, new Pair<>(timestamp, "{"), (a, b) -> a.getKey() - b.getKey());
        
        if(i >= 0)
            return list.get(i).getValue();
        
        //If the timestamp is not present we get -1
        if(i == -1)
            return "";
        
        else
            //If the timestamp is not present then we get the value of the greatest value less than the timestamp. {-insertion point - 1} is used to check 
            return list.get(-i - 2).getValue();
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
