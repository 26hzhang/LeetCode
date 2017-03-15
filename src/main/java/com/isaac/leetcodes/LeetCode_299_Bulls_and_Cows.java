package com.isaac.leetcodes;

/**
 * You are playing the following Bulls and Cows game with your friend: You write
 * down a number and ask your friend to guess what the number is. Each time your
 * friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position
 * (called "bulls") and how many digits match the secret number but locate in
 * the wrong position (called "cows"). Your friend will use successive guesses
 * and hints to eventually derive the secret number.
 *
 * For example:
 * Secret number: "1807"
 * Friend's guess: "7810"
 *
 * Hint:
 * • 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * •
 * Write a function to return a hint according to the secret number and friend's
 * guess, use A to indicate the bulls and B to indicate the cows. In the above
 * example, your function should return "1A3B".
 *
 * Please note that both secret number and friend's guess may contain duplicate
 * digits, for example:
 *
 * Secret number: "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a
 * cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain
 * digits, and their lengths are always equal.
 *
 * Tags: Hash Table.
 *
 * @author ZHANG HAO
 *
 */
public class LeetCode_299_Bulls_and_Cows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String getHint(String secret, String guess) {
		int bull = 0, cow = 0;
		int[] count1 = new int[10]; //store the digits of secrete
		int[] count2 = new int[10]; //store the digits of guess
		for (int i = 0; i < secret.length(); i++) {
			count1[secret.charAt(i) - '0']++;
			// if meets a bull, secrete counter should not change
			if (secret.charAt(i) == guess.charAt(i)) {
				bull++;
				count1[secret.charAt(i) - '0']--;
			} else {
				count2[guess.charAt(i) - '0']++;
			}
		}
		// check the two arrays item by item and sum up the cows
		for (int i = 0; i <= 9; i++)
			cow += count1[i] >= count2[i] ? count2[i] : count1[i];
		return bull + "A" + cow + "B";
	}

}
