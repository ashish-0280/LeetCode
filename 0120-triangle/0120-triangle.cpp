#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int dp[201][201];

    int minimumTotal(vector<vector<int>>& triangle) {
        for(int i = 0; i < 201; i++)
            for(int j = 0; j < 201; j++)
                dp[i][j] = 1001;
        return solve(triangle, 0, 0);
    }

    int solve(vector<vector<int>>& triangle, int i, int j) {
        if(i == triangle.size() - 1)
            return triangle[i][j];
        if(dp[i][j] != 1001)
            return dp[i][j];
        int down = solve(triangle, i + 1, j);
        int diagonal = solve(triangle, i + 1, j + 1);
        return dp[i][j] = triangle[i][j] + min(down, diagonal);
    }
};
