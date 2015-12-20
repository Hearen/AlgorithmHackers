#include<stdio.h>
#include<string>
void main(){
  bool isMatch(char* s, char* p);
  char* s="a";
  char* p=".*..a*";
  bool result=isMatch(s,p);
  printf("result= %d",result);
}

bool isMatch(char* s, char* p) {
    int startS=0;
	int curP=0;
	char xpreChar;
	char preChar;
	int plength=strlen(p);
	bool isCharMatch(char a,char b);
	for(int i=0;i<strlen(s);i++){
	   if(curP>=plength) return false; 
	   if(isCharMatch(s[i],p[curP])){
		   if(p[curP]=='.') xpreChar=s[i];  
	      preChar=p[curP];
		  curP++;
	   }else if(p[curP]=='*'){
	      if(!isCharMatch(s[i],preChar)){
		     i--;
			 curP++;
		  }
		  else { if(preChar=='.') xpreChar=s[i]; 
			  continue;}
	   }else if(((curP+1)<plength)&&p[curP+1]=='*'){
	      curP+=2;
		  i--;
	   }    
	   else return false;
	}


	bool rmark=false;
	for(int i=curP;i<plength;i++){
		if(p[i]=='*') {rmark=true;continue;}
		else if(p[i]!='*'&&rmark){
		     if(p[i]==preChar) continue;
			 else if(preChar=='.'&&p[i]==xpreChar) continue;
			 else if(p[i+1]=='*'){
		       i++;continue;
			 }else return false;
		}
		else if(p[i]!='*'&&!rmark) {
			if(p[i+1]=='*') {i++;continue;}
			else return false;
		}
	}

	return true;


}

bool isCharMatch(char a,char b){
      if(a==b) return true;
	  else if(b=='.') return true;
	  else return false;

}