/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-12 19:40
Description : Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Update (2015-02-12):
For C programmers: Try to solve it in-place in O(1) space.
Source      : https://leetcode.com/problems/reverse-words-in-a-string/
*******************************************/
void reverseWords(char* s)
{
    int len = strlen(s);
    int count = 0;
    while(s[count] == ' ') count++; //remove the preceding white spaces;
    for(int i = count; i < len+1; i++)
        s[i-count] = s[i];
    len -= count;
    while(s[len-1] == ' ') len--; //remove the tailing white spaces;
    s[len] = '\0';
    int index = 0;
    count = 0;
    for(int i = 0; i < len; i++) //removing all the redundant white spaces among words;
    {
        if(s[i] != ' ')
        {
            s[index++] = s[i];
            count = 0;
        }
        else
        {
            if(!count) //only the first white space will be collected;
                s[index++] = s[i];
            count++;
        }
    }
    s[index] = '\0';
    len = index;
    for(int i = 0; i < len/2; i++)
    {
        char c=s[i]; s[i]=s[len-i-1]; s[len-i-1]=c;
    }
    int begin=0, end=0;
    for(int i = 0; i < len; i++)
    {
        if(s[i] == ' ' || i == len-1)
        {
            end = i;
            if(i != len-1) end--; //point to the last letter of the word;
            int size = end-begin+1;
            for(int j = 0; j < size/2; j++)
            {
                char c=s[begin+j]; s[begin+j]=s[end-j]; s[end-j]=c;
            }
            begin = end+2; //point to the leading letter of the next word;
        }
    }
}

