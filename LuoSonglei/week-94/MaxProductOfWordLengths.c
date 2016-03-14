/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 13:26
Description : Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:
Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
Return 16
The two words can be "abcw", "xtfn".

Example 2:
Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
Return 4
The two words can be "ab", "cd".

Example 3:
Given ["a", "aa", "aaa", "aaaa"]
Return 0
No such pair of words.
Source      : https://leetcode.com/problems/maximum-product-of-word-lengths/
*******************************************/
//AC - 40ms;
int maxProduct(char** words, int wSize)
{
    int space = sizeof(int)*wSize; //since we are going to use this value several times, store it;
    int *lens = (int*)malloc(space);
    for(int i = 0; i < wSize; i++) //pre-store the lengths for all words;
        lens[i] = strlen(words[i]);
    int *flags = (int*)malloc(space);
    memset(flags, 0, space);
    for(int i = 0; i < wSize; i++) //retrieve the bit-flag from word;
        for(int j = 0; words[i][j]; j++)
            flags[i] |= 1<<(words[i][j]-'a');
    int max = 0;
    for(int i = 0; i < wSize; i++) //traversing each pair of two different words;
        for(int j = i+1; j < wSize; j++)
            if(!(flags[i] & flags[j]))
            {
                int t = lens[i]*lens[j];
                if(t > max)
                    max = t;
            }
    return max;
}
