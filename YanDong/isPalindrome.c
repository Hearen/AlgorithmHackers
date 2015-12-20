#include<ctype.h>
#include<stdio.h>
typedef int bool;
int true = 1;
int false = 0;
bool isPalindrome(char* s) {
    bool ret = true;
    int start = 0,end = 0;
    while(s[end]!=0){
        end +=1;
    }
    end-=1;
    printf("%d %d\n",start,end);
    while(start < end){
        printf("%d %d\n",start,end);
        while(s[start] !=0 && !(isalpha(s[start]) || isalnum(s[start]))){
            start++;
        }
        while(end >=0 && !(isalpha(s[end]) || isalnum(s[end]))){
            end--;
        }
        if(tolower(s[start++])!=tolower(s[end--])){
            ret = false;
            break;
        }
    }
    return ret;
}
int main(){
    char *s = ".,";

    printf("%d\n",isPalindrome(s));;
    return 0;

}
