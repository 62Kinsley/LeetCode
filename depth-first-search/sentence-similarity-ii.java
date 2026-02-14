// class Solution {
//     public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        
//         Map<String, Set<String>> map = new HashMap<>();
//         for(List<String> list : similarPairs){
//             map.putIfAbsent(list.get(0), new HashSet<>());
//             map.putIfAbsent(list.get(1), new HashSet<>());
//             map.get(list.get(0)).add(list.get(1));
//             map.get(list.get(1)).add(list.get(0));
//         }

//         int len1 = sentence1.length, len2 = sentence2.length;
//         if(len1 != len2){
//             return false;
//         }

//         for(int i=0; i<len1; i++){
//             String s1 = sentence1[i];
//             String s2 = sentence2[i];

//             if(s1.equals(s2)){
//                 continue;
//             }
//             if (!dfs(s1,s2, map, new HashSet<>())){
//                 return false;
//             }
//         }
//         return true;
//     }


//     public boolean dfs(String s1, String target, Map<String, Set<String>> map, Set<String> visited){//manga,onepiece
//         if(s1.equals(target)){  
//             return true;
//         }
//         if(!map.containsKey(s1) || visited.contains(s1)){
//             return false;
//         }
//         visited.add(s1); 

//         for(String neighbor : map.get(s1)){
//             if(dfs(neighbor, target, map, visited)){
//                 return true;  
//             }
//         }
//         return false;
//     }
// }

// class Solution {
    
//     class UnionFind {
//         int[] p;
//         int[] r;
//         int n;
        
//         UnionFind(int n) {
//             this.n = n;
//             this.r = new int[n];
//             this.p = new int[n];
//             for (int i = 0; i < n; i++)
//                 p[i] = i;
//         }
        
//         public int find(int x) {
//             if (p[x] != x)
//                 p[x] = find(p[x]);
//             return p[x];
//         }
        
//         public void union(int x, int y) {
//             int px = find(x);
//             int py = find(y);
//             if (px == py) return;
//             if (r[px] > r[py]) p[py] = px;
//             else if (r[px] < r[py]) p[px] = py;
//             else {
//                 p[py] = px;
//                 r[px]++;
//             }
//         }
//     }
    
//     public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {        
        
//         if (sentence1.length != sentence2.length) return false;
//         Map<String, Integer> idMap = new HashMap<>();
//         int id = 0;
        
//         for (List<String> pair: similarPairs) {
//             String a = pair.get(0);
//             String b = pair.get(1);
            
//             if (!idMap.containsKey(a)) {
//                 idMap.put(a, id++);
//             }
//             if (!idMap.containsKey(b)) {
//                 idMap.put(b, id++);
//             }
//         }
        
//         UnionFind dsu = new UnionFind(id);

//         for (List<String> pair: similarPairs) {
//             int u = idMap.get(pair.get(0));
//             int v = idMap.get(pair.get(1));
//             dsu.union(u, v);
//         }
        
//         for (int i = 0; i < sentence1.length; i++) {
//             String w1 = sentence1[i];
//             String w2 = sentence2[i];
            
//             if (w1.equals(w2)) continue;
//             else {
//                 if (!idMap.containsKey(w1) || !idMap.containsKey(w2))
//                     return false;
//                 if (dsu.find(idMap.get(w1)) != dsu.find(idMap.get(w2)))
//                     return false;
//             }
//         }
        
//         return true;
//     }
// }

class Solution{
    class UnionFind{
        int[] parent;//parent[i]的父节点
        int n;

        public UnionFind(int n){
            this.n = n;
            parent = new int[n]; 
            for(int i=0; i<n; i++){
                parent[i] = i;//初始化根节点，也就是自己的根节点是自己
            }
        }

        public int find(int x){
            if(parent[x] != x){
                int needFind = parent[x];
                return find(needFind);
            }
            
            return parent[x];
            
        }

        public void union(int x, int y){
                int rootX = find(x);
                int rootY = find(y);

                if(rootX == rootY){
                    return ;
                }

                parent[rootX] = rootY;
        }
    }
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) { 
        int len1 = sentence1.length, len2 = sentence2.length;
        if(len1 != len2){
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        int id = 0;

        for (List<String> pair: similarPairs) {
            String a = pair.get(0);
            String b = pair.get(1);
            if (!map.containsKey(a)) {
                map.put(a, id++);
            }
            if (!map.containsKey(b)) {
                map.put(b, id++);
            }
        }
        

        UnionFind uf = new UnionFind(id);
        for (List<String> list: similarPairs) {
            int x = map.get(list.get(0));
            int y = map.get(list.get(1));
            uf.union(x,y);
        }


        for(int i=0; i<len1; i++){
            String s1 = sentence1[i];
            String s2 = sentence2[i];

            if(s1.equals(s2)){
                continue;
            }

            if(!map.containsKey(s1) || !map.containsKey(s2)){
                return false;
            }
            int id1 = map.get(s1);
            int id2 = map.get(s2);
            if(uf.find(id1) != uf.find(id2)){
                return false;
            }
        }
        return true;
        
    }
    

}
