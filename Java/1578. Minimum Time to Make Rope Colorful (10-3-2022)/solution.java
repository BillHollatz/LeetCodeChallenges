class Solution {
    public int minCost(String colors, int[] neededTime) {
        List<Integer> group = new ArrayList<Integer>();
        int match = 0;
        int sum = 0;
        for(int i=0;i<colors.length()-1;i++){
            if( i!= colors.length()-1 && colors.charAt(i) == colors.charAt(i+1) && match == 0){
                //System.out.println("1:"+i);
                match = 1;
                group.clear();
                group.add(i);
            }
            else if(colors.charAt(i) == colors.charAt(i+1) && match == 1){
                //System.out.println("2:"+i);
                group.add(i);
            }
            if( ((colors.charAt(i) != colors.charAt(i+1)) ||(i==colors.length()-2)) && match == 1){
                if(!group.contains(i)){
                    group.add(i);
                }
                if(colors.charAt(i) == colors.charAt(i+1)){
                    group.add(i+1);
                }
                //System.out.println("3:"+i);
                int max = 0;
                int Localsum = 0;
                for(int j=0;j<group.size();j++){
                    int x = group.get(j);
                    if(neededTime[x] > max){
                        max = neededTime[x];
                    }
                    Localsum += neededTime[x];
                    //System.out.println("n"+neededTime[x]);
                }
                sum += Localsum - max;
                match = 0;
            }
            else{System.out.println("i"+i);}
            //System.out.println( ((i!= 0 && colors.charAt(i) != colors.charAt(i-1)) ||(i==colors.length()-1)) && match == 1);
        }
        
        return sum;
    }
}