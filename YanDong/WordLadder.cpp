#include<map>
#include<set>
#include<vector>
#include<string>
#include<unordered_set>
#include<unordered_map>
#include<iostream>
#include<queue>
//#define _DEBUG
using namespace std;
/***
    unorder_set是C++11特性，需在编译器中开启
***/
class Solution {
public:

    /*思想：O(n^2)时间计算状态转换图，然后dfs这个状态转换图得到最佳的变换步数
    multimap RunTime Error （不知道什么原因，本地测试没问题）
    unordered_map<string,unordered_set<string>> TLE
    */
    int compare(const string &a,const string &b){
        int diff = 0;
        for(int i = 0;i<a.size();++i){
            if(a[i]!=b[i]){
                ++diff;
                if(diff > 1){
                    return -1;
                }
            }
        }
        if(diff == 0){
            return 0;
        }
        return 1;
    }
    /*dfs 超时*/
    void dfs(unordered_map<string,unordered_set<string>> &dict,string currentWord,string &endWord,map<string,int > &visited,int length,int *ans){
        if(currentWord == endWord){
            //cout<<length<<endl;
            if(length < *ans){
                *ans = length;
            }
        }
        unordered_map<string,unordered_set<string>>::iterator it = dict.find(currentWord);
        if(it == dict.end())
            return;
        unordered_set<std::string>::iterator it1= (it->second).begin();

        for(;it1 != (it->second).end();++it1){
            if(visited.find(*it1)!=visited.end()){
                continue;
            }
            visited.insert(pair<string,int>(*it1,1));
            dfs(dict,*it1,endWord,visited,length+1,ans);
            visited.erase(visited.find(*it1));

        }
    }
    /*bfs效率明显比dfs好，原因是bfs天然的性质决定了第一次搜索到的路径必定是最优解
    但是仍然 TLE 猜测可能是构图的效率太低 是O(n^2)当n太大是耗时,继续对bfs进行优化，优化构图这一部分
    */
    int bfs(unordered_map<string,unordered_set<string>> &dict,string &beginWord,string &endWord){
        /*记录访问到的距离*/
        unordered_map<string,int> dist;
        dist.insert(pair<string,int>(beginWord,0));


        /*bfs所使用的数组*/
        queue<string> q;
        q.push(beginWord);

        while(!q.empty()){
            string cur = q.front();
            q.pop();
            int cur_dist = (dist.find(cur))->second;
            unordered_map<string,unordered_set<string>>::iterator it = dict.find(cur);
            //cout<<it->first<<endl;
            if(it == dict.end())
                continue;
            unordered_set<string>::iterator it1 = (it->second).begin();
            //cout<<*it1<<endl;
            for(;it1!=(it->second).end();++it1){
                unordered_map<string,int>::iterator it2;
                if(dist.find(*it1)==dist.end()){
                    if(*it1 == endWord)
                        return cur_dist + 1;
                    //visited.insert(*it1);
                    dist.insert(pair<string,int>(*it1,cur_dist+1));
                    q.push(*it1);
                }
            }

        }
    }
    /***
    AC代码
    相较于bfs,bfs1没有提前构转换图，而是在每次搜索的时候动态的尝试，每次最多尝试 26*str_size次。
    */
    int bfs1(string beginWord, string endWord, unordered_set<string>& wordList){
        queue<string> q;
        q.push(beginWord);

        unordered_map<string,int> dist;
        dist.insert(pair<string,int>(beginWord,0));

        while(!q.empty()){
            string cur = q.front();
            q.pop();
            int cur_dist = (dist.find(cur))->second;
            //cout<<cur_dist<<endl;
            for(int i = 0;i<cur.size();++i){
                for(int j = 'a';j<='z';++j){
                    if(cur[i] == j) continue;
                    string tmp = cur;
                    tmp[i] = j;
                    if(cur == endWord)
                        return cur_dist + 1;
                    if(wordList.find(tmp) != wordList.end() && dist.find(tmp)==dist.end()){

                        dist.insert(pair<string,int>(tmp,cur_dist+1));
                        q.push(tmp);
                    }
                }
            }

        }
    }
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        wordList.insert(beginWord);
        wordList.insert(endWord);
        unordered_set<string>::iterator it1,it2;
        unordered_map<string,unordered_set<string>> dict;
        for(it1 = wordList.begin();it1!=wordList.end();it1++){
            for(it2 = wordList.begin();it2 !=wordList.end();it2++){
                if(compare(*it1,*it2) == 1){
                    unordered_map<string,unordered_set<string>>::iterator it;
                    if((it = dict.find(*it1))!=dict.end()){
                        (it->second).insert(*it2);
                    }else{
                        unordered_set<string> tmp;
                        tmp.insert(*it2);
                        pair<string,unordered_set<string>> ele(*it1,tmp);
                        dict.insert(ele);
                    }
                }
            }
        }
        #ifdef _DEBUG
            unordered_map<string,unordered_set<string>>::iterator it;
            for(it=dict.begin();it!=dict.end();++it){
                cout<<it->first<<endl;
                for(unordered_set<string>::iterator it1 = (it->second).begin();it1!=(it->second).end();++it1){
                    cout<<*it1<<" ";
                }
                cout<<endl;

            }
        #endif
        map<string,int> visited;
        int ret = 0x0FFFFFFF;
        //dfs(dict,beginWord,endWord,visited,0,&ret);
        //ret = bfs(dict,beginWord,endWord);
        ret = bfs1(beginWord,endWord,wordList);
        return ret;

    }
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList){
        queue<string> q;
        q.push(beginWord);

        unordered_map<string,int> dist;
        dist.insert(pair<string,int>(beginWord,0));

        while(!q.empty()){
            string cur = q.front();
            q.pop();
            int cur_dist = (dist.find(cur))->second;
            //cout<<cur_dist<<endl;
            for(int i = 0;i<cur.size();++i){
                for(int j = 'a';j<='z';++j){
                    if(cur[i] == j) continue;
                    string tmp = cur;
                    tmp[i] = j;
                    if(cur == endWord)
                        return cur_dist + 1;
                    if(wordList.find(tmp) != wordList.end() && dist.find(tmp)==dist.end()){

                        dist.insert(pair<string,int>(tmp,cur_dist+1));
                        q.push(tmp);
                    }
                }
            }

        }
    }
};
int main(){
    Solution sol;
    unordered_set<string> wordList;
    wordList.insert("hot");
    wordList.insert("dot");
    wordList.insert("dog");
    wordList.insert("lot");
    wordList.insert("log");
    string beginWord("hit");
    string endWord("cog");
    cout<<sol.ladderLength(beginWord,endWord,wordList)<<endl;

    return 0;
}
