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
        int index = word[i]-'a';
        if(!(root->children[index])) //when there is no such child, create one;
            root->children[index] = nodeMaker();
        root = root->children[index];
    }
    root->isWord = true; //label this child as the leaf of the word;
}

struct TrieNode *findLeaf(struct TrieNode *root, char *word)
{
    for(int i = 0; word[i]; i++) //following the word to traverse the tree;
    {
        root = root->children[word[i]-'a']; 
        if(!root) return false; //there is no corresponding child node;
    }
    return root; //at the end of the traversal, return the last node;
}

//AC - 36ms;
bool search(struct TrieNode *root, char *word)
{
    root = findLeaf(root, word);
    return root&&root->isWord; //check whether the node exists and it's the leaf of a word;
}

bool startsWith(struct TrieNode *root, char *prefix)
{
    root = findLeaf(root, word);
    return root; //check whether the node is valid;
}

void trieFree(struct TrieNode *root)
{
    free(root->children);
    free(root);
}
