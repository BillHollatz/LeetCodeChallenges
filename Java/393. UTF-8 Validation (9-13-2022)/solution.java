class Solution {
    public boolean validUtf8(int[] data) {
        int[] bin = intToBin(data[0]);
        if (bin[0] == 0){
            if(data.length == 1){return true;}
            int[] cpy = new int[data.length - 1];
            System.arraycopy(data,1,cpy,0,data.length-1);
            return true && validUtf8(cpy);
        }
        int len = 1;
        while (bin[len]==1){
            
            len++;
            
            //System.out.println(data[len]);
            if(len>data.length){return false;}
            int[] dat = intToBin(data[len-1]);
            if(dat[0] != 1 || dat[1] != 0){
                return false;
            }
        }
        if(len == 1 || len>4 ){return false;}
        if(len == data.length){
            return true;
        }
        int[] cpy = new int[data.length - len];
        System.arraycopy(data,len,cpy,0,data.length-len);
        return true && validUtf8(cpy);
    }
    public int[] intToBin(int num){
        System.out.println(num);
        int n = num;
        int[] bin = new int[8];
        for(int i=7;i>=0;i--){
            int x = pow(2,i);
            if(n>=x){
                n-=x;
                bin[7-i] = 1;
            }
            else{bin[7-i]=0;}
            System.out.print(bin[7-i]);
        }
        System.out.println();
        return bin;
    }
    public int pow(int l, int u){
        if(u==0){
            return 1;
        }
        
        //System.out.println(u);
        return l * pow(l,u-1);
    }
}