class Solution {
public:
    int findLCS(string &s1,string &s2,int i,int j,vector<vector<int>>&dp){
        if(i>=s1.size()){
            int sum=0;
            for(int k=j;k<s2.size();k++){
                sum+=s2[k];
            }
            return sum;
        }
        if(j>=s2.size()){
            int sum=0;
            for(int k=i;k<s1.size();k++){
                sum+=s1[k];
            }
            return sum;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1[i]==s2[j]){
            return dp[i][j]=findLCS(s1,s2,i+1,j+1,dp);
        }else{
            return dp[i][j]=min(findLCS(s1,s2,i,j+1,dp)+s2[j],findLCS(s1,s2,i+1,j,dp)+s1[i]);
        }
    }
    int minimumDeleteSum(string s1, string s2) {
        vector<vector<int>>dp(s1.size(),vector<int>(s2.size(),-1));
        int ans=findLCS(s1,s2,0,0,dp);
        return ans;
    }
};