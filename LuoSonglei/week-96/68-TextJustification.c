/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-14 16:24
Description : Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:
[
"This    is    an",
"example  of text",
"justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
Source      : https://leetcode.com/problems/text-justification/
*******************************************/
char** fullJustify(char** words, int wSize, int maxWidth, int* returnSize)
{
    char** arr = (char**)malloc(sizeof(char*));
    for(int start = 0; start < wSize; )
    {
        int len = strlen(words[start]);
        int index = start+1;
        while(index < wSize) //after the collecting, the index will point to the first word of the next line or the position after the last word;
        {
            if(strlen(words[index])+len+1 > maxWidth) break;
            len += strlen(words[index])+1;
            index++;
        }
        char* t = (char*)malloc(sizeof(char)*(maxWidth+2));
        *t = '\0';
        int spaceCount = index-start-1;
        if(index==wSize || spaceCount==0) //the last line or only one word just take up the whole line -> should be left justified;
        {
            int j = 0;
            for(int i = start; i < index; i++) //left justified;
            {
                for(int k = 0; k < strlen(words[i]); k++)
                    t[j++] = words[i][k];
                t[j++] = ' ';
            }
            t[j-1] = '\0'; //remove the last redundant white space;
            for(int i = j-1; i < maxWidth; i++) //fill up the left spaces with white spaces;
                t[i] = ' ';
            t[maxWidth] = '\0';
        }
        else //normally full justification;
        {
            int averageSpace = (maxWidth-len)/spaceCount; //average white spaces should be filled in each slot between words;
            int remainder = (maxWidth-len)%spaceCount; //the left;
            for(int i = start; i < index; i++)
            {
                strcat(t, words[i]);
                if(i < index-1) //the last word cannot be followed by white spaces;
                    for(int j = 0; j <= averageSpace+((i-start)<remainder? 1 : 0); j++)
                        strcat(t, " ");
            }
        }
        start = index;
        *returnSize += 1;
        arr = (char**)realloc(arr, sizeof(char*)*(*returnSize));
        arr[*returnSize-1] = t;
    }
    return arr;
}
