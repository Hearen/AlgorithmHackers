/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-13 16:30
Description : Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
Source      : https://leetcode.com/problems/longest-palindromic-substring/
*******************************************/
void check(char* s, int len, int l, int r, int* start, int* maxLen)
{
    while(l>-1 && r<len && s[l]==s[r]) l--, r++;
    int len0 = r-l-1;
    if(len0 > *maxLen)
    {
        *maxLen = len0;
        *start = l+1;
    }
}

//AC - 20ms;
char* longestPalindrome0(char* s)
{
    int len = strlen(s);
    if(len < 2) return s;
    int start = 0;
    int maxLen = 0;
    for(int i = 0; i < len-1; i++)
    {
        check(s, len, i, i, &start, &maxLen);
        check(s, len, i, i+1, &start, &maxLen);
    }
    char* t = (char*)malloc(sizeof(char)*(maxLen+1));
    memcpy(t, s+start, sizeof(char)*maxLen);
    t[maxLen] = '\0';
    return t;
}

//AC - 12ms;
char* longestPalindrome1(char* s)
{
    int len = strlen(s);
    if(len < 2) return s;
    int start = 0;
    int maxLen = 0;
    for(int i = 0; i < len-1 && len-i > maxLen/2; i++)
    {
        check(s, len, i, i, &start, &maxLen);
        check(s, len, i, i+1, &start, &maxLen);
    }
    char* t = (char*)malloc(sizeof(char)*(maxLen+1));
    memcpy(t, s+start, sizeof(char)*maxLen);
    t[maxLen] = '\0';
    return t;
}


//AC - 0ms;
char* longestPalindrome(char* s)
{
    int len = strlen(s);
    if(len < 2) return s;
    int start=0, maxLen=0;
    int l=0, r=0;
    for(int i = 0; i<len && len-i>maxLen/2;)
    {
        l = r = i;
        while(r<len-1 && s[r+1]==s[r]) r++; //remove all the duplicates but l remains the same, only the non-duplicate should be checked with l -> now there will no even or odd length palindrome problem;
        i = r+1; //move to the next non-duplicate for a new start;
        while(l>0 && r<len-1 && s[r+1]==s[l-1]) l--, r++;
        int len0 = r-l+1;
        if(len0 > maxLen)
        {
            maxLen = len0;
            start = l;
        }
    }
    char* t = (char*)malloc(sizeof(char)*(maxLen+1));
    memcpy(t, s+start, sizeof(char)*maxLen);
    t[maxLen] = '\0';
    return t;
}
