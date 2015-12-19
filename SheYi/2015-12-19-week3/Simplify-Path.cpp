#include<iostream>
#include<string>
#include<stack>
using namespace std;
class Solution {
public:
    string simplifyPath(string path) {
		path+="/";
		string curDir="";
		string result="";
		stack<string> dirStack;
		stack<string> resStack;
		for(int i=1;i<path.size();i++){
			if(path[i]=='/'){
				if(strcmp(curDir.c_str(),"")==0) continue;  //过滤连续多个“\”
				if(strcmp(curDir.c_str(),".")==0) {
					curDir="";
					continue;
				}
				else if(strcmp(curDir.c_str(),"..")==0){
					if(dirStack.empty()){  
						curDir="";
						continue;
					}
					else dirStack.pop();
				  }
				else 
			    dirStack.push(curDir);
				curDir="";
			}else   
			curDir+=path[i];
		}
		if(dirStack.empty())  return "/";
		while(!dirStack.empty()){
			resStack.push(dirStack.top());
			dirStack.pop();
		}
		while(!resStack.empty()){
		    result+="/"+resStack.top();
			resStack.pop();
		}
		return result;
    }
};
//void main(){
//	Solution s;
//	string result=s.simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///");
//	cout<<"result="<<result<<endl;
//	
//}

