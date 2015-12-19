#include <stdio.h>
#include <string.h>
//void main(){
//	int myAtoi(char* str);
//	char* str="9223372036854775809";
//	int result=myAtoi(str);
//	printf("reslut=%d",result);
//}
/**
  把字符串转为int型 String to Integer (atoi)
*/
int myAtoi(char* str) {
	bool isSign(char c);
	bool isNum(char c);
    bool containSign=false;
	bool isFirst=true;
	int start=-1;
	long long result=0;
	long long maxInt=2147483647;
	if(strlen(str)==0) return 0;

    for(int i=0;i<strlen(str);i++){
		if(str[i]==' '&&start<0) continue; //字符中的空格
		
		if(isFirst){     //第一个非空格字符
			isFirst=false;
			start=i;
	     if(isSign(str[i])){ //是否是“+”，“-”号
		    containSign=true;  //有符号  
		    continue;
		   }
		}

	   if(isNum(str[i]))           //依次处理每一个字符
		   result=result*10+(str[i]-48);  
	   else                       //遇到非数字停止
		break;

	   if(result>(maxInt+1)) break;  //大于int表示的范围
	    
	}
	 if(containSign&&str[start]==45){  //判断符号
	    result=-result;
	 }

	  if(result>maxInt)            //比较结果是否在int的表示的范围内
		  return maxInt;
	  else if(result<-(maxInt+1))
		  return -(maxInt+1);
	  else 
		  return result;

}

bool isNum(char c){
   if(c>47&&c<58)
	   return true;
   else
	   return false;
}

bool isSign(char c){
	if(c==43||c==45)
	   return true;
     else
	   return false;
  
}
