/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-14 12:41
Description : Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
Source      : https://leetcode.com/problems/lru-cache/
*******************************************/
#include <stdlib.h>
struct MyListNode
{
    int key;
    int val;
    struct MyListNode *next, *previous;
};
struct Cache
{
    struct MyListNode **map;
    struct MyListNode *head, *tail;
    int maxSize;
    int currentSize;
} cache;

void deleteNode(struct MyListNode* p)
{
    p->previous->next = p->next;
    p->next->previous = p->previous;
}

void insertAfterHead(struct MyListNode *t)
{
    t->next = cache.head->next;
    t->previous = cache.head;
    cache.head->next->previous = t;
    cache.head->next = t;
}

void lruCacheInit(int capacity)
{
    cache.head = (struct MyListNode*)malloc(sizeof(struct MyListNode));
    cache.tail = (struct MyListNode*)malloc(sizeof(struct MyListNode));
    cache.head->previous = NULL;
    cache.head->next = cache.tail;
    cache.tail->previous = cache.head;
    cache.tail->next = NULL;
    cache.maxSize = capacity;
    cache.currentSize = 0;
    cache.map = (struct MyListNode**)malloc(sizeof(struct MyListNode*)*10000);
    memset(cache.map, 0, sizeof(struct MyListNode*)*10000);
}

void lruCacheFree()
{
}

int lruCacheGet(int key)
{
    struct MyListNode *p = cache.map[key];
    if(!p) return -1;
    deleteNode(p);
    insertAfterHead(p);
    return p->val;
}

void lruCacheSet(int key, int value)
{
    struct MyListNode *p = cache.map[key];
    if(p)
    {
        p->val = value;
        deleteNode(p);
        insertAfterHead(p);
    }
    else
    {
        struct MyListNode* t = (struct MyListNode*)malloc(sizeof(struct MyListNode));
        t->key = key;
        t->val = value;
        cache.map[key] = t;
        if(cache.currentSize < cache.maxSize)
        {
            cache.currentSize++;
        }
        else
        {
            cache.map[cache.tail->previous->key] = NULL;
            cache.tail->previous->previous->next = cache.tail;
            cache.tail->previous = cache.tail->previous->previous;
        }
        insertAfterHead(t);
    }
}
