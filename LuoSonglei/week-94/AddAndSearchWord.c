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
    struct TrieNode *children[SIZE];
};

struct WordDictionary
{
    struct TrieNode *root;
};

struct TrieNode* trieNodeMaker()
{
    printf("making a trie node now\n");
    struct TrieNode *t = (struct TrieNode*)malloc(sizeof(struct TrieNode));
    t->isWord = false;
    for(int i = 0; i < SIZE; i++)
        t->children[i] = NULL;
    printf("return the newly created trie node\n");
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
        printf("inserting: %c\n", word[i]);
        if(!(cur->children[word[i]-'a']))
            cur->children[word[i]-'a'] = trieNodeMaker();
        cur = cur->children[word[i]-'a'];
    }
    printf("inserting done!\n");
    cur->isWord = true;
}


bool trieSearch(const char* word, struct TrieNode* root)
{
    printf("searching for %s in dict\n", word);
    struct TrieNode *cur = root;
    for(int i = 0; word[i]; i++)
    {
        if(cur && word[i]!='.')
            cur = cur->children[word[i]-'a'];
        else if(cur && word[i]=='.')
        {
            struct TrieNode *t = cur;
            for(int j = 0; j < SIZE; j++)
            {
                cur = t->children[i];
                if(trieSearch(word+i+1, cur))
                    return true;
            }
        }
        else break;
    }
    return cur&&cur->isWord;
}

//Runtime Error - unkonwn!
//https://leetcode.com/discuss/39022/80ms-clear-c-code-with-detailed-explanations
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
