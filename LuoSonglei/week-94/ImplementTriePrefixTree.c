/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-03 10:12
Description : 
Source      : https://leetcode.com/problems/implement-trie-prefix-tree/
*******************************************/
#include <stdlib.h>
#include <bool.h>
#define LEN 26
struct TrieNode
{
    bool isWord;
    struct TrieNode **children;
};

struct TrieNode* nodeMaker()
{
    struct TrieNode *t = (struct TrieNode*)malloc(sizeof(struct TrieNode));
    t->isWord = false;
    int space = sizeof(struct TrieNode*)*LEN;
    t->children = (struct TrieNode**)malloc(space);
    memset(t->children, 0, space);
    return t;
}
struct TrieNode* trieCreate()
{
    return nodeMaker();
}

void insert(struct TrieNode *root, char *word)
{
    for(int i = 0; word[i]; i++)
    {
        if(!(root->children[word[i]-'a']))
            root->children[word[i]-'a'] = nodeMaker();
        root = root->children[word[i]-'a'];
    }
    root->isWord = true;
}

//AC - 40ms;
bool search(struct TrieNode *root, char *word)
{
    for(int i = 0; word[i]; i++)
    {
        root = root->children[word[i]-'a'];
        if(!root) return false;
    }
    return root&&root->isWord;
}

bool startsWith(struct TrieNode *root, char *prefix)
{
    for(int i = 0; prefix[i]; i++)
    {
        root = root->children[prefix[i]-'a'];
        if(!root) return false;
    }
    return root;
}

void trieFree(struct TrieNode *root)
{
    free(root->children);
    free(root);
}
