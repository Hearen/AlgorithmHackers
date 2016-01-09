/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-07 07:56
Description : 
Source      : https://leetcode.com/problems/word-ladder/
*******************************************/
#include <iostream>
#include <string>
#include <unordered_set>
//AC - 60ms;
class Solution
{
    public:
        int ladderLength(string bWord, string eWord, unordered_set<string>& wordList)
        {
            if(bWord == eWord)
                return 1;
            unordered_set<string> bList, eList;
            bList.insert(bWord);
            eList.insert(eWord);
            wordList.erase(bWord);
            wordList.erase(eWord);
            return ladderLength(bList, eList, wordList, 1);
        }
    private:
        //If there is no '&' before set, the time cost will be tripled;
        int ladderLength(unordered_set<string>& bList, unordered_set<string>& eList, unordered_set<string>& wordList, int len)
        {
            if(bList.empty())
                return 0;
            if(bList.size() > eList.size())
                return ladderLength(eList, bList, wordList, len);
            unordered_set<string> tmpList;
            for(auto it=bList.begin(); it!=bList.end(); it++)
            {
                string cur = *it;
                for(int i=0; i<cur.size(); i++)
                {
                    char c0 = cur[i];
                    for(char c='a'; c<='z'; c++)
                    {
                        cur[i]=c;
                        if(eList.count(cur)) return len+1;
                        if(wordList.count(cur))
                        {
                            tmpList.insert(cur);
                            wordList.erase(cur);
                        }
                    }
                    cur[i] = c0;
                }
            }
            return ladderLength(tmpList, eList, wordList, len+1);
        }
};

//AC - 60ms;
class Solution
{
    public:
        int ladderLength(string bWord, string eWord, unordered_set<string>& wordList)
        {
            if(bWord==eWord)
                return 1;
            unordered_set<string> bList, eList, tmpList;
            bList.insert(bWord);
            eList.insert(eWord);
            wordList.erase(bWord);
            wordList.erase(eWord);
            int len = 1;
            int wLen = bWord.size();
            while(!bList.empty()&&!eList.empty())
            {
                if(bList.size() > eList.size())
                    bList.swap(eList);
                for(auto it=bList.begin(); it!=bList.end(); it++)
                {
                    string cur=*it;
                    for(int i=0; i<wLen; i++)
                    {
                        char c0=cur[i];
                        for(char c='a'; c<='z'; c++)
                        {
                            cur[i]=c;
                            if(eList.count(cur)) return len+1;
                            if(wordList.count(cur))
                            {
                                tmpList.insert(cur);
                                wordList.erase(cur);
                            }
                        }
                        cur[i]=c0;
                    }
                }
                bList.swap(tmpList);
                len++;
            }
            return 0;
        }
};
