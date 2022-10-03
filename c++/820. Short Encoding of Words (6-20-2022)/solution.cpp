class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
        int arr[words.size()];
        for(int i = 0;i<words.size();i++){
            arr[i] = words[i].append("#").size();
            cout<<words[i]<<arr[i];
        }
        for(int i=0;i<words.size();i++){
            for(int j=i;j<words.size();j++){
                //cout<<words[i],words[j];
                if(i!=j && words[i].find(words[j])!=-1 && arr[i]>0 && arr[j]>0){
                    arr[j] = 0;
                }
                 if(i!=j && words[j].find(words[i])!=-1 && arr[i]>0 && arr[j]>0){
                    arr[i] = 0;
                }
            }
        }
        
        int sum = 0;
        for(int i=0;i<words.size();i++){
            cout<<arr[i];
            sum += arr[i];
        }
        return sum;
    }
};