#include<iostream>
#include<set>
using namespace std;
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
		if(s.length()==0) return 0;
	 int head=0;  //count start point 
	 int maxLength=1; //the current max lenght of substring
	 int count=1;  //cout for a certain substring
	 set<char> charSet;  //set store identical elements

	 charSet.insert(s[0])  ;
		for(int i=1;i<s.length();){
			if(charSet.count(s[i])==0){  //if not contains
			  charSet.insert(s[i]);    //add to set
			  count++;                
			  if(count>maxLength) maxLength=count; //update maxLength
			  i++;
			}else{                //if contains
				if(count>maxLength) maxLength=count;  
				charSet.erase(s[head]);  //erase the head element
				head++;       //move start point
				count=count-1;  
				if(count<1) {charSet.insert(s[i]);count=1;i++;} //for two same elements are neighbour
			}
		}
		return maxLength;
    }

};
int main(){
	Solution s;
	string str="abcbbcdeafcf";
	int result=s.lengthOfLongestSubstring(s);
    cout<<"result:"<<result<<endl;
}

