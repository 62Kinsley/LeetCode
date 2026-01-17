class Solution {
    public String countAndSay(int n){ //4
        if(n == 1){
            return "1";
        }
        
        return rle(countAndSay(n-1)); 
    }

    public static String rle(String s){
        if(s.equals("1")){
            return "11";
        }
        if(s.equals("11")){
            return "21";
        }
           
        //21
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<s.length()){
            int count = 1;
            // char cur = s.charAt(i);//'1'
            while(i<s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                count++;//2
                i++;
            }
            sb.append(count).append(s.charAt(i));//12 11
            i++;
        }
        return sb.toString();

    }
}