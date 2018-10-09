package p2018_09_18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

// You are given coins of different denominations and a total amount of money amount.
// Write a function to compute the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.
public class CoinChange {

	public int coinChange(int[] coins, int amount) {

		int[][] dp = new int[coins.length+1][amount+1];
		// TODO


		return 0;
	}

	@Test
	public void test() {

		assertEquals(coinChange(new int[] {1, 2, 5},11), 3);
		assertEquals(coinChange(new int[] {2},3), -1);
	}

}
