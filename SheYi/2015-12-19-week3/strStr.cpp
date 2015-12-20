#include<stdio.h>
#include<string.h>
//void main(){
//	int strStr(char* haystack, char* needle);
//	char* haystack="";
//	char* needle="";
//	int result=strStr(haystack,needle);
//	printf("the start index=%d",result);
//}

 int strStr(char* haystack, char* needle) {
    int start=0;
	int curindex=0;
	int hlength=strlen(haystack);
	int nlength=strlen(needle);
	 if(strlen(needle)==0) return 0;
	 for(int i=0;i<hlength;i++){
		 curindex=i;
		 int j=0;
		 while(haystack[curindex]==needle[j]){
			 curindex++;j++;
		    if(j==nlength) return i;
		 }
         if(i+nlength>hlength)
			 break;
	 }
	
	 return -1;
}