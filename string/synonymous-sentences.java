class Solution {
    List<String> result = new ArrayList<>();
    class UnionFind{
        int[] parent;
        int n;
        public UnionFind(int n){
            this.n = n;
            parent = new int[n];
            for(int i=0; i<n; i++){
                parent[i] = i;
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
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        int id = 0;
        Map<String, Integer> map = new HashMap<>();//happy:0, joy:1 sad:2 sorrow:3 cheerful:4

        //给每一个string取一个独一无二的id
        for(List<String> list : synonyms){
            String s0 = list.get(0);
            String s1 = list.get(1);

            if(!map.containsKey(s0)){
                map.put(s0, id++);
            }
             if(!map.containsKey(s1)){
                map.put(s1, id++);
            }
        }
        UnionFind uf = new UnionFind(id);

        //把同义词的id union在一起
        for(List<String> list : synonyms){
            String s0 = list.get(0);
            String s1 = list.get(1);

            int id0 = map.get(s0);
            int id1 = map.get(s1);

            uf.union(id0, id1);
        }

        //group synonymous
        //这时候这些同义词的id都会指向同一个 root， 用一个map 把他们group起来
        Map<Integer, List<String>> syn = new HashMap<>();//1-<happy, joy, cheerful>, 
        //不要遍历 synonyms，而是遍历 map 里的所有单词。每个单词只会出现一次，就不会重复了：
        for(String word : map.keySet()){
         
            int idx = map.get(word);
            int root = uf.find(idx);

            if(!syn.containsKey(root)){
                syn.put(root, new ArrayList<>());
            }
            syn.get(root).add(word);

        }

        //把每组同义词里的同义词排序
        for(int root : syn.keySet()){
            List<String> list = syn.get(root);
            Collections.sort(list);
        }

        String[] words = text.split(" ");
        List<List<String>> options = new ArrayList<>();//[ [["I"], ["am"], ["cheerful", "happy", "joy"], ["today"]]]
        for (String word : words) {
            if(map.containsKey(word)){
                int idx = map.get(word);
                int root = uf.find(idx);
                options.add(syn.get(root));
            }else{
                List<String> single = new ArrayList<>();
                single.add(word);
                options.add(single);
            }
        }

        backtrack(0,  options, new ArrayList<>());
        return result;
    }

    public void backtrack(int index, List<List<String>> options, List<String> path){
        if (index == options.size()){
            result.add(String.join(" ", path));
            return ;
        }
        
        for(String word : options.get(index)){//["cheerful", "happy", "joy"],
            path.add(word);//["I"], ["am"], ["cheerful"] ["today"] but was sad yesterday"
            backtrack(index+1, options, path);//
            path.remove(path.size() - 1);
        }
    }
}