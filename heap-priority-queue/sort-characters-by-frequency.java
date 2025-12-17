class Solution {
    public String frequencySort(String s) {
        //1.caculate the fre of every characrt : hash arry

        //2. buket to store the frq that have which char
        //List<Character>[] = new ArrayList<>[];
  
        //StringBuilder to store the ans

        int[] arr = new int[128];
        for(char c: s.toCharArray()){
            arr[c]++;
        }

        List<Character>[] bucket = new ArrayList[s.length()+1];

        for(int i=0; i<128; i++){
            if(arr[i] > 0){
                int fre = arr[i];
                if(bucket[fre] == null){
                    bucket[fre] = new ArrayList<>();
                }
                bucket[fre].add( (char) i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=bucket.length - 1; i>=0; i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
        
    }
}


