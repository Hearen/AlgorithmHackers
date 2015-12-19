#include<iostream>
#include<vector>
#include<set>
#include <hash_map>
#include "Solution.cpp"
using namespace std;
  struct Point {
      int x;
      int y;
      Point() : x(0), y(0) {}
      Point(int a, int b) : x(a), y(b) {}
  };
  class Solution {
public:
    int maxPoints(vector<Point>& points) {
		Point curPoint;
		if(points.size()<=1) return 0;
		int max=0;
		float k=0.0; //Ð±ÂÊ
		multiset<float> ms;
		multiset<float> ::iterator it;
		for(int i=0;i<points.size();i++){
		   curPoint=points[i];
		   for(int j=i+1;j<points.size();j++){
			   if(points[j].x==curPoint.x) k=1.0;
			   else if(points[j].y==curPoint.y) k=0.0; 
			   else { k=(float)(points[j].y-curPoint.y)/(float)(points[j].x-curPoint.x);}
			   ms.insert(k);  
		   }
		     it = ms.begin();
			 int tempCount=0;
            while(it!=ms.end())//±éÀú
				if(ms.count(*it)>tempCount)  tempCount=ms.count(*it);
		    if(max<tempCount) max=tempCount;
		}
		return max;
	}
};
void main(){
	Solution s;
	vector<Point> p;
	p.insert(p.begin(),new Point(0,0));
	p.insert(p.begin(),new Point(0,0));

	s.maxPoints(p);
}


