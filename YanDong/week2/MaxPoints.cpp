#include<iostream>
#include<vector>
#include<algorithm>
#include<map>

using namespace std;
class Solution {
public:
    struct Point {
        int x;
        int y;
        Point() : x(0), y(0) {}
        Point(int a, int b) : x(a), y(b) {}
    };
    int maxPoints(vector<Point>& points) {
        if(points.size() <= 1)
            return points.size();
        vector<float> angle;
        int max = 0;
        int maxAngle = 0;
        for(int j=0;j<points.size();j++){
            angle.clear();
            int same = 0;
            for(int i=0;i<points.size();i++){
                if(i == j)
                    continue;
                if(points[i].x == points[j].x && points[i].y == points[j].y){
                    same += 1;
                    continue;
                }
                if(points[i].x == points[j].x){
                    angle.push_back(1000000);
                }
                else{
                    float current = (points[i].y-points[j].y) *1.0 / (points[i].x - points[j].x);
                    angle.push_back(current);
                }
            }
            map<float,int> bucket;
            for(vector<float>::iterator it = angle.begin();it!=angle.end();++it){
                if(bucket.find(*it) == bucket.end()){
                    bucket[*it] = 1;
                }
                else{
                    bucket[*it] += 1;
                }
            }
            int tmpMax = 0;
            for(map<float,int>::iterator it = bucket.begin();it!=bucket.end();++it){
                if(it->second > tmpMax){
                    tmpMax = it -> second;
                    maxAngle = it->first;
                }
            }
            /*另外加上　相同的节点　以及　节点本身*/
            if(tmpMax + same + 1 > max){
                max = tmpMax + same + 1;
            }
        }
        return max;
    }

    void test(){
        vector<Point> v;

        //[[84,250],[0,0],[1,0],[0,-70],[0,-70],[1,-1],[21,10],[42,90],[-42,-230]]
        v.push_back(Point(84,250));
        v.push_back(Point(0,0));
        v.push_back(Point(1,0));
        v.push_back(Point(0,-70));
        v.push_back(Point(0,-70));
        v.push_back(Point(1,-1));
        v.push_back(Point(21,10));
        v.push_back(Point(42,90));
        v.push_back(Point(-42,-230));
        cout<<maxPoints(v)<<endl;
    }
};
int main(){
    Solution sol;
    sol.test();
    return 0;
}
