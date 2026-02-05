class Solution {

        String[] digit = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] teen = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] ten = new String[]{"", "","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        
    public String numberToWords(int num) {
        
        if(num == 0){
            return "Zero";
        }
        //Segmenting the Number:
        //Mapping Numbers to Words:
        //<1000
        //>1000
        //concatenation


        String result = numberToWordsHelper(num%1000);//0-999
        
        num = num/1000;
        if(num > 0 && num%1000 > 0){
            result = numberToWordsHelper(num%1000) + "Thousand " + result;
        }
        num = num/1000;
        if(num > 0 && num%1000 > 0){
            result = numberToWordsHelper(num%1000) + "Million " + result;
        }
        num = num/1000;
        if(num > 0 && num%1000 > 0){
            result = numberToWordsHelper(num%1000) + "Billion " + result;
        }
        return result.trim();

    }

    public String numberToWordsHelper(int num){
        StringBuilder sb = new StringBuilder();

        if(num > 99){
            String s = digit[num/100];
            sb.append(s).append(" Hundred ");
        }
        num = num % 100;

        if(num >= 10 && num<=19){
            String s = teen[num%10];
            sb.append(s + " ");
        }else{
            if(num > 19){
                String s = ten[num/10];
                sb.append(s + " ");
            }
            num = num % 10;
            if(num > 0){
                String s = digit[num];
                sb.append(s + " ");
            }
        }
        return sb.toString();
    }
}