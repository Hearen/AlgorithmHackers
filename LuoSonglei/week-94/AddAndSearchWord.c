/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-02 18:23
Description : 
Source      : https://leetcode.com/problems/add-and-search-word-data-structure-design/
*******************************************/
#include <bool.h>
#define SIZE 26
struct TrieNode
{
    bool isWord;
    struct TrieNode **children;
};

struct WordDictionary
{
    struct TrieNode *root;
};

struct TrieNode* trieNodeMaker()
{
    struct TrieNode *t = (struct TrieNode*)malloc(sizeof(struct TrieNode));
    t->isWord = false;
    int space = sizeof(struct TrieNode*)*SIZE;
    t->children = (struct TrieNode**)malloc(space);
    memset(t->children, 0, space);
    return t;
}
struct WordDictionary* wordDictionaryCreate()
{
    struct WordDictionary *dict = (struct WordDictionary*)malloc(sizeof(struct WordDictionary));
    dict->root = trieNodeMaker();
    return dict;
}

void addWord(struct WordDictionary* dict, char* word)
{
    struct TrieNode *cur = dict->root;
    for(int i = 0; word[i]; i++)
    {
        if(!(cur->children[word[i]-'a']))
            cur->children[word[i]-'a'] = trieNodeMaker();
        cur = cur->children[word[i]-'a'];
    }
    cur->isWord = true;
}


bool trieSearch(const char* word, struct TrieNode* root)
{
    struct TrieNode *cur = root;
    for(int i = 0; word[i]; i++)
    {
        if(!cur) return false;
        if(word[i]!='.')
            cur = cur->children[word[i]-'a'];
        else if(word[i]=='.')
        {
            for(int j = 0; j < SIZE; j++) //try every possible path;
                if(trieSearch(word+i+1, cur->children[j]))
                    return true;
            return false; //all possible paths have failed;
        }
    }
    return cur&&cur->isWord; //the last checking;
}

//Runtime Error - unkonwn! - pointer of an array -> children;
// The term comes from "retrieval" and the originator, Edward Fredkin, pronounced it "tree." However, "trey" is the more common pronounciation. "Try" is rare and considered incorrect.
//https://leetcode.com/discuss/39022/80ms-clear-c-code-with-detailed-explanations
//https://en.wikipedia.org/wiki/Trie
//AC - 44ms;
bool search(struct WordDictionary* dict, char* word)
{
    trieSearch(word, dict->root);
}


void wordDictionaryFree(struct WordDictionary *dict)
{
    free(dict->root->children);
    free(dict->root);
    free(dict);
}
