/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-01-21 09:02
Description : 
Source      : https://leetcode.com/problems/contains-duplicate-ii/
*******************************************/
#include <stdbool.h>
#include <stdlib.h>
//AC - 1040ms;
bool containsNearbyDuplicate0(int* nums, int size, int k)
{
    for(int i = 0; i < size; i++)
        for(int j = i+1; j < i+k+1 && j < size; j++)
            if(nums[i] == nums[j])
                return true;
    return false;
}

typedef struct hash_node
{
    int value;
    int index;
    struct hash_node *next;
} hash_node_t;


//AC - 8ms;
bool containsNearbyDuplicate(int* nums, int numsSize, int k) {
    hash_node_t **table;
    table = calloc(numsSize, sizeof(hash_node_t));
    memset(table, 0, sizeof(hash_node_t) * numsSize );
    int i = 0;
    int key = 0;
    hash_node_t *node = NULL;
    hash_node_t *p = NULL;
    bool result = false;
    for (i = 0; (i < numsSize && result == false); i++)
    {
        key = abs(*nums) % numsSize;
        node = malloc(sizeof(hash_node_t));
        node->value = *nums;
        node->index = i;
        node->next = table[key];
        table[key] = node;
        p = table[key]->next;
        while(p)
        {
            if ((p->value == *nums) && ((i - p->index) <= k))
            {
                result = true;
                break;
            }
            p = p->next;
        }
        nums++;
    }
    for (i = 0; i < numsSize; i++)
    {
        while(table[i])
        {
            p = table[i]->next;
            free(table[i]);
            table[i] = p;
        }
    }
    free(table);
    return result;
}
