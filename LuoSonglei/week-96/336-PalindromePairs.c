/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-10 08:02
Description : Given a list of unique words. Find all pairs of indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:
Given words = ["bat", "tab", "cat"]
Return [[0, 1], [1, 0]]
The palindromes are ["battab", "tabbat"]
Example 2:
Given words = ["abcd", "dcba", "lls", "s", "sssll"]
Return [[0, 1], [1, 0], [3, 2], [2, 4]]
The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
Source      : https://leetcode.com/problems/palindrome-pairs/
*******************************************/
//TLE;
int** palindromePairs(char** words, int wSize, int** colSizes, int* returnSize)
{
    int **pairs = (int**)malloc(sizeof(int*));
    *colSizes = (int*)malloc(sizeof(int));
    int maxLen = 0;
    int *lens = (int*)malloc(sizeof(int)*wSize);
    for(int i = 0; i < wSize; i++)
    {
        lens[i] = strlen(words[i]);
        if(lens[i] > maxLen)
            maxLen = lens[i];
    }
    char *t = (char*)malloc(sizeof(char)*(2*maxLen+1));
    for(int i = 0; i < wSize; i++)
    {
        for(int j = 0; j < wSize; j++)
        {
            if(i == j) continue;
            *t = '\0';
            strcat(t, words[i]);
            strcat(t, words[j]);
            int k = 0;
            int len = lens[i]+lens[j];
            while(k<len/2 && t[k]==t[len-k-1])
                k++;
            if(k == len/2)
            {
                *returnSize += 1;
                *colSizes = (int*)realloc(*colSizes, sizeof(int)*(*returnSize));
                (*colSizes)[*returnSize-1] = 2;
                pairs = (int**)realloc(pairs, sizeof(int*)*(*returnSize));
                pairs[*returnSize-1]  = (int*)malloc(sizeof(int)*2);
                pairs[*returnSize-1][0] = i;
                pairs[*returnSize-1][1] = j;
            }
        }
    }
    return pairs;
}
