#include<stdio.h>
#include<string.h>
int getNext(int *next,char *s){
    next[0] = -1;
    int i = 0, j =-1;
    while(s[i]){
        if( j == -1 || s[i] == s[j]){
            ++i;
            ++j;
            next[i] = j;
        }else{
            j = next[j];
        }
    }
}
int strStr(char* haystack, char* needle) {
    int next[10000];
    getNext(next,needle);
    int i=0,j=0;
    while(i!=strlen(haystack) && j!=strlen(needle)){
        if(j == -1 || haystack[i] == needle[j]){
            ++i;
            ++j;
        }else{
            j = next[j];
        }
    }
    //printf("%d %d\n",i,j);
    return needle[j] == 0 ? i - j : -1;
}
int main(){
    char *s = "123456";
    char *p = "456";
    printf("%d",strStr(s,p));
    return 0;
}
