/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-02 11:12
Description : 
Source      : https://leetcode.com/problems/valid-number/
*******************************************/
/*
 * .1 -> true;
 * 07 -> true;
 * 09 -> true;
 * 3. -> true;
 * 0000 -> true;
 * 10e300 -> true;
 * 10e-300 -> true;
 * 10e+300 -> true;
 * 10000000000.0000 -> true;
 *
 * e -> false;
 * 0e -> false;
 * 0e+ -> false;
 * 6ee9 -> false;
 * ..2 -> false;
 * ++2 -> false;
 * - -> false;
 * + -> false;
 *    -> false;
 * . -> false;
 * e3 -> false;
 * 3e 3 -> false;
 * 10E20 -> false;
 * 0xf and 0xF -> false;
 */
#include <bool.h>
bool isSign(char c)
{
    return c=='+' || c=='-';
}

//AC - 8ms;
bool isNumber(char* s)
{
    int index = 0;
    int len = strlen(s);
    int i = 0;
    while(s[i] == ' ') i++; //remove the prefixing white spaces;
    if(isSign(s[i])) i++; //if there is a sign in the head, remove it first - only remove the first ignoring the latter ones if there are some;
    while(i < len)
            s[index++] = s[i++];
    while(s[index-1] == ' ') index--; //remove the suffixing white spaces;
    s[index] = '\0';//no prefixing and suffixing white spaces and preceding sign;
    if(index==0) return false; //nothing here;
    bool eOccurred = false;
    bool signOccurred = false;
    bool digitOccurred = false;
    bool dotOccurred = false;
    for(int i = 0; i < index; i++) //traversing and checking each character;
    {
        if(isdigit(s[i]))
            digitOccurred = true;
        else if(s[i]=='e') //e only appears once; e cannot be the first and the last also;
        {
            if(eOccurred || !digitOccurred || s[i+1] == '\0') return false;
            eOccurred = true;
        }
        else if(isSign(s[i])) //since we removed the first sign(if there is), the latter sign can only occur after e; can only appear once if ignoring the first preceding one; can not be the first since we have remove one if there is; the previous character must be e; and it cannot be the last;
        {
            if(!eOccurred || signOccurred || (i==0 || s[i-1]!='e' || s[i+1]=='\0')) return false;
            signOccurred = true;
        }
        else if(s[i] == '.') //dot cannot be following e; can only appear once; there must be some preceding digits if dot is the last;
        {
            if(eOccurred || dotOccurred || (!digitOccurred && s[i+1]=='\0')) return false;
            dotOccurred = true;
        }
        else //white space or other characters;
            return false;
    }
    return true;
}
