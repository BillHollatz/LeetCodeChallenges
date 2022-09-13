class Solution {
    public int romanToInt(String s) {
        int num = 0;
        int add = 0;
        int tmp = 0;
        for(int i=0;i<s.length();i++){
            
            if(s.charAt(i)=='I'){
                tmp = 1;
            }
            else if(s.charAt(i)=='V'){
                tmp = 5;
            }
            else if(s.charAt(i)=='X'){
                tmp = 10;
            }
            else if(s.charAt(i)=='L'){
                tmp = 50;
            }
            else if(s.charAt(i)=='C'){
                tmp = 100;
            }
            else if(s.charAt(i)=='D'){
                tmp = 500;
            }
            else if(s.charAt(i)=='M'){
                tmp = 1000;
            }
            if(tmp>add && add !=0){
                num = num + tmp - add;
                tmp = 0;
                add = 0;  
            }
            else{
                num = num + add;
                add = tmp;
                tmp = 0;
            }
        }
        num = num + add;
        return num;
    }
}