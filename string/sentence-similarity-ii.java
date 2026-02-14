class Solution {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> list : similarPairs){
            map.putIfAbsent(list.get(0), new HashSet<>());
            map.putIfAbsent(list.get(1), new HashSet<>());
            map.get(list.get(0)).add(list.get(1));
            map.get(list.get(1)).add(list.get(0));
        }

        int len1 = sentence1.length, len2 = sentence2.length;
        if(len1 != len2){
            return false;
        }

        for(int i=0; i<len1; i++){
            String s1 = sentence1[i];
            String s2 = sentence2[i];

            if(s1.equals(s2)){
                continue;
            }
            if (!dfs(s1,s2, map, new HashSet<>())){
                return false;
            }
        }
        return true;
    }


    public boolean dfs(String s1, String target, Map<String, Set<String>> map, Set<String> visited){//manga,onepiece
        if(s1.equals(target)){  
            return true;
        }
        if(!map.containsKey(s1) || visited.contains(s1)){
            return false;
        }
        visited.add(s1); 

        for(String neighbor : map.get(s1)){
            if(dfs(neighbor, target, map, visited)){
                return true;  
            }
        }
        return false;
    }
}

