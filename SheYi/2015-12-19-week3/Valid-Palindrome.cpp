#include<stdio.h>
#include <string.h>
#include<math.h>
//void main(){
//	bool isPalindrome(char* s);
//	char* str="52345";
//	bool result=isPalindrome(str);
//	printf("result=%d",result);
//}

bool isPalindrome(char* s) {
    bool isnumeric(char c);
	bool isalphal(char c);
	int left=0,right=strlen(s)-1;
    while(left<right){
	   if(!isalphal(s[left])&&!isnumeric(s[left])){
	        left++;continue;
	   }
	   if(!isalphal(s[right])&&!isnumeric(s[right])){
	        right--;continue;
	   }
	   if(isnumeric(s[left])&&s[left]==s[right]){
	        left++;right--;continue;
	   }
	   if(isnumeric(s[left])&&s[left]!=s[right])
			 return false;
	   if(isalphal(s[left])&&(abs(s[left]-s[right])==0||abs(s[left]-s[right])==32)){
	      left++;right--;continue;
	   }
	   if(isalphal(s[left])&&(abs(s[left]-s[right])!=0&&abs(s[left]-s[right])!=32))
		   return false;
	}
	return true;
}

bool isalphal(char c){
     if((c>64&&c<91)||(c>96&&c<123))
		 return true;
	 else
	     return false;
}
bool isnumeric(char c){
	  if(c>47&&c<58)
	   return true;
   else
	   return false;
}