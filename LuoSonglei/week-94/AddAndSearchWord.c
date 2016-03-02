/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-02 18:23
Description : 
Source      : https://leetcode.com/problems/add-and-search-word-data-structure-design/
*******************************************/
#include <bool.h>
struct WordDictionary
{
    char **words;
    int size;
};

struct WordDictionary* wordDictionaryCreate()
{
    struct WordDictionary *dict = (struct WordDictionary*)malloc(sizeof(struct WordDictionary));
    char **words = (char**)malloc(sizeof(char*));
    dict->words = words;
    dict->size = 0;
    return dict;
}

void addWord(struct WordDictionary* dict, char* word)
{
    dict->size += 1;
    dict->words = (char**)realloc(dict->words, sizeof(char*)*dict->size);
    dict->words[dict->size-1] = word;
}

bool equal(char* s1, char* s2)
{
    while(*s1 && *s2)
    {
        if(!(*s1==*s2 || *s1=='.' || *s2=='.'))
            return false;
        s1++;
        s2++;
    }
    if(*s1 || *s2) return false;
    return true;
}

//TLE;
bool search(struct WordDictionary* dict, char* word)
{
    int size = dict->size;
    int len = strlen(word);
    for(int i = 0; i < size; i++)
    {
        char *s1 = dict->words[i];
        char *s2 = word;
        if(strlen(s1) != len) continue;
        while(*s1 && *s2)
        {
            if(!(*s1==*s2 || *s1=='.' || *s2=='.'))
                break;
            s1++;
            s2++;
        }
        if(*s1 || *s2) continue;
        return true;
    }
    return false;
}


void wordDictionaryFree(struct WordDictionary *dict)
{
    free(dict->words);
    free(dict);
}
