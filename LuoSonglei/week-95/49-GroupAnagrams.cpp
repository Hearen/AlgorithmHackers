/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-07 13:51
Description : Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
["ate", "eat","tea"],
["nat","tan"],
["bat"]

]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.
Source      : https://leetcode.com/problems/anagrams/
*******************************************/
#include <vector.h>
class Solution
{
    public:
        //AC - 64ms;
        vector<vector<string>> groupAnagrams(vector<string>& strs)
        {
            unordered_map<string, vector<string>> map;
            for(auto s: strs)
            {
                string t(s);
                sort(t.begin(), t.end());
                map[t].push_back(s);
            }
            vector<vector<string>> result(map.size());
            int i = 0;
            for(auto iter=map.begin(); iter!=map.end(); ++iter, ++i)
            {
                result[i].swap(iter->second);
                sort(result[i].begin(), result[i].end());
            }
            return result;
        }
};
