package com.zen.strings;

public class ReverseInPlace
{
	public static void main(String[] args)
	{
		reverseString("Password");

		reverseString("#### Webhook #####");

		reverseWordsInSentece("My name is Vadim");
		reverseWordsInSentece("My name is Vadim    ");
		reverseWordsInSentece("  My name is Vadim  ");
		reverseWordsInSentece("I");
		reverseWordsInSentece("");
		reverseWordsInSentece(" ");
		reverseWordsInSentece("    ");

	}

	private static void reverseString(String str)
	{
		char[] arr = str.toCharArray();

		System.out.println("A[" + String.valueOf(arr) + "]");

		for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--)
		{
			arr[i] += arr[j];
			arr[j] = (char) (arr[i] - arr[j]);
			arr[i] -= arr[j];
		}

		System.out.println("B[" + String.valueOf(arr) + "]");
		System.out.println("--");
	}

	private static void reverseWordsInSentece(String str)
	{
		char[] arr = str.toCharArray();

		System.out.println("A  [" + String.valueOf(arr) + "]");

		// First reverse all chars in the sentence treating spaces as other letters
		for (int i = 0, j = arr.length - 1; i < arr.length / 2; i++, j--)
		{
			arr[i] += arr[j];
			arr[j] = (char) (arr[i] - arr[j]);
			arr[i] -= arr[j];
		}
		
		System.out.println("   [" + String.valueOf(arr) + "]");

		// Iterate through words and reverse chars in each words
		for (int begin = 0, end = 0; end < arr.length; end++)
		{	
			// Words separated by spaces
			if (arr[end] == ' ')
			{
				for (int i = begin, j = end - 1; i < begin + (end - begin) / 2; i++, j--)
				{
					arr[i] += arr[j];
					arr[j] = (char) (arr[i] - arr[j]);
					arr[i] -= arr[j];
				}
				begin = end + 1;
				end = begin;
			}
			
			// Last word does not have following space, so treat it differently
			if (end == arr.length - 1) 
			{
				for (int i = begin, j = end; i <= begin + (end - begin) / 2; i++, j--)
				{
					arr[i] += arr[j];
					arr[j] = (char) (arr[i] - arr[j]);
					arr[i] -= arr[j];
				}
				break;
			}
		}

		System.out.println("B  [" + String.valueOf(arr) + "]");
		System.out.println("--");
	}
}
