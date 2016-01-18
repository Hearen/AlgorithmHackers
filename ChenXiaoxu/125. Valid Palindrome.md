# 125. Valid Palindrome

## Problem

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

tag:
- two pointers
- string

## Solution

**java**
```java
	public boolean isPalindrome(String s) {
		if (s == null || s.isEmpty())
			return true;
		int l = 0, r = s.length() - 1;
		while (l < r) {
			if (!Character.isLetterOrDigit(s.charAt(l))) {
				l++;
				continue;
			}
			if (!Character.isLetterOrDigit(s.charAt(r))) {
				r--;
				continue;
			}
			if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
				l++;
				r--;
			} else {
				return false;
			}
		}
		return true;
	}
```