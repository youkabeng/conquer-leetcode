// @desc-start
// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
// You may assume that you have an infinite number of each kind of coin.
//  
// Example 1:
// 
// Input: coins = [1,2,5], amount = 11
// Output: 3
// Explanation: 11 = 5 + 5 + 1
// 
// Example 2:
// 
// Input: coins = [2], amount = 3
// Output: -1
// 
// Example 3:
// 
// Input: coins = [1], amount = 0
// Output: 0
// 
// Example 4:
// 
// Input: coins = [1], amount = 1
// Output: 1
// 
// Example 5:
// 
// Input: coins = [1], amount = 2
// Output: 2
// 
//  
// Constraints:
// 
// 1 <= coins.length <= 12
// 1 <= coins[i] <= 231 - 1
// 0 <= amount <= 104
// 
// 
// @desc-end


// @code-start
class Solution {
    public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for(int i = 1; i < dp.length; i++) {
			dp[i] = amount + 1;
		}
		for(int i = 1; i <= amount; i++) {
			for(int j = 0; j < coins.length; j++) {
				int n = i - coins[j];
				if(n < 0) {
					continue;
				}
				dp[i] = Math.min(dp[i], dp[n] + 1);
			}
		}
		if(dp[amount] == amount + 1) {
			return -1;
		}
		return dp[amount];
    }
}
// @code-end
