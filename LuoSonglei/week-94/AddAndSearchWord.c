/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-02 18:23
Description : 
Source      : https://leetcode.com/problems/add-and-search-word-data-structure-design/
*******************************************/
#include <bool.h>
#define SIZE 26

struct WordDictionary
{
    bool isWord; //determine whether a word exists in the path;
    struct WordDictionary **children;
};

struct WordDictionary* nodeMaker()
{
    struct WordDictionary *t = (struct WordDictionary*)malloc(sizeof(struct WordDictionary));
    t->isWord = false;
    int space = sizeof(struct WordDictionary*)*SIZE;
    t->children = (struct WordDictionary**)malloc(space);
    memset(t->children, 0, space);
    return t;
}
struct WordDictionary* wordDictionaryCreate()
{
    return nodeMaker();
}

void addWord(struct WordDictionary* dict, char* word)
{
    struct WordDictionary *cur = dict;
    for(int i = 0; word[i]; i++)
    {
        if(!(cur->children[word[i]-'a']))
            cur->children[word[i]-'a'] = nodeMaker();
        cur = cur->children[word[i]-'a'];
    }
    cur->isWord = true; //set the flag for the existence of the word in the current path;
}

//Runtime Error - unkonwn! - pointer of an array -> children;
// The term comes from "retrieval" and the originator, Edward Fredkin, pronounced it "tree." However, "trey" is the more common pronounciation. "Try" is rare and considered incorrect.
//https://leetcode.com/discuss/39022/80ms-clear-c-code-with-detailed-explanations
//https://en.wikipedia.org/wiki/Trie
//AC - 40ms;
bool search(struct WordDictionary* root, char* word)
{
    struct WordDictionary *cur = root;
    for(int i = 0; word[i]; i++)
    {
        if(!cur) return false; //the path is interrupted;
        if(word[i]!='.') //track the path down;
            cur = cur->children[word[i]-'a'];
        else if(word[i]=='.') //while there is dot, the possible paths can be all;
        {
            for(int j = 0; j < SIZE; j++) //try every possible path;
                if(search(cur->children[j], word+i+1))
                    return true;
            return false; //all possible paths have failed;
        }
    }
    return cur&&cur->isWord; //the last checking;
}


void wordDictionaryFree(struct WordDictionary *dict)
{
    free(dict->children);
    free(dict);
}
