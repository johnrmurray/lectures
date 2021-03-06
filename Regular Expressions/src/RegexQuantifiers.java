
/**
 * Demonstrates differences between quantifiers.
 *
 * @see RegexHelper
 */
public class RegexQuantifiers {

	public static void main(String[] args) {

		String text = "aardvark";
		String regex;

		/*
		 * Basic greedy quantifiers.
		 */

		// aardvark
		// 01___2__
		regex = "a";	
		System.out.println("\n1. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 00***4**
		regex = "a*";
		System.out.println("\n2. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 00___1__
		regex = "a+";
		System.out.println("\n3. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 00______
		regex = "a{2}";
		System.out.println("\n4. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		/*
		 * Demonstrate reluctant.
		 */

		// aardvark
		// 0000000_
		regex = "a.+r";		// greedy
		System.out.println("\n5. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 000_____
		regex = "a.+?r";		// reluctant
		System.out.println("\n6. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		/*
		 * Demonstrate possessive.
		 */

		// aardvark
		// 00000000
		regex = "[^k]+k";
		System.out.println("\n7. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 00000000
		regex = "[^k]++k";
		System.out.println("\n8. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// 0000____
		regex = "[^k]+d";
		System.out.println("\n9. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// aardvark
		// ________
		regex = "[^k]++d";
		System.out.println("\n10. Regex: " + regex);
		RegexHelper.showMatches(text, regex);

		// Possessive is trying to match entire string, no backtracking
		// is done if entire string does not match.
	}
}
