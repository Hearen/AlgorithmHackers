/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-01 22:42
Description : 
Source      : https://leetcode.com/problems/fraction-to-recurring-decimal/
*******************************************/
#include <limits.h>
#define LEN 10000
struct MyListNode
{
    long long key;
    int val;
    struct MyListNode *next;
};

void push(struct MyListNode* head, long long key, int val)
{
    struct MyListNode *p = head;
    while(p->next)
        p = p->next;
    struct MyListNode *t = (struct MyListNode*)malloc(sizeof(struct MyListNode));
    t->key = key;
    t->val = val;
    p->next = t;
}

int pop(struct MyListNode* head, long long key)
{
    struct MyListNode *p = head->next;
    while(p)
    {
        if(p->key == key)
            return p->val;
        p = p->next;
    }
    return 0;
}

//AC - 4ms;
char* fractionToDecimal(int n, int d)
{
    if(n == 0) return "0";
    char *s = (char*)malloc(sizeof(char)*LEN);
    int index = 0;
    if((n<0 && d>0) || (n>0 && d<0)) s[index++] = '-'; //get the sign part;
    long long numerator = (n==INT_MIN)? -1*(long long)n : abs(n); //get the positive format of numerator;
    long long denominator = (d==INT_MIN)? -1*(long long)d : abs(d); //get the positive format of denominator;
    long long integer = numerator/denominator; //collecting the integer part;
    if(integer == 0)
        s[index++] = '0';
    else
    {
        char *t = (char*)malloc(sizeof(char)*LEN); //used to store the integer part in reverse order;
        int index0 = 0;
        while(integer)
        {
            t[index0++] = integer%10+'0';
            integer /= 10;
        }
        for(int i = index0-1; i > -1; i--) //reverse it again, then s will store the integer part in normal sequence;
            s[index++] = t[i];
    }
    long long remainder = numerator%denominator; //get the remainder by mod operator;
    if(remainder == 0) 
    {
        s[index] = '\0';
        return s;
    }
    s[index++] = '.'; //there are decimals;
    struct MyListNode *head = (struct MyListNode*)malloc(sizeof(struct MyListNode)); //used to store the remainder digit index in string for recurring;
    while(remainder)
    {
        int pre = pop(head, remainder);
        if(pre) //check if this digit has already occurred, if so, add brackets;
        {
            for(int i = index; i > pre; i--)
                s[i] = s[i-1];
            index++;
            s[pre] = '(';
            s[index++] = ')';
            break;
        }
        push(head, remainder, index);
        remainder *= 10; //imitating division process here, retrieving the high decimal digit;
        s[index++] = remainder/denominator+'0';
        remainder %= denominator;
    }
    s[index] = '\0';
    return s;
}
