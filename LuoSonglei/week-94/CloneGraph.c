/*******************************************
Author      : LHearen
E-mail      : LHearen@126.com
Time        : 2016-03-04 15:02
Description : Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
Source      : https://leetcode.com/problems/clone-graph/
*******************************************/
#include <stdlib.h>
#include <bool.h>
#define NEIGHBORS_MAX_SIZE 100
struct UndirectedGraphNode
{
    int label;
    struct UndirectedGraphNode *neighbors[NEIGHBORS_MAX_SIZE];
    int neighborsCount;
};

struct Mapper
{
    struct UndirectedGraphNode *key;
    struct UndirectedGraphNode *value;
    struct Mapper *next;
};

bool push(struct Mapper* head, struct UndirectedGraphNode* key, struct UndirectedGraphNode* value)
{
    struct Mapper* p = head;
    while(p->next)
    {
        if(p->key == key)
            return false;
        p = p->next;
    }
    p->next = (struct Mapper*)malloc(sizeof(struct Mapper));
    p = p->next;
    p->key = key;
    p->value = value;
    return true;
} 

struct UndirectedGraphNode* pop(struct Mapper* head, struct UndirectedGraphNode* key)
{
    while(head)
    {
        if(head->key == key) return head->value;
        head = head->next;
    }
    return NULL;
}

struct UndirectedGraphNode* copy(struct UndirectedGraphNode* node)
{
    struct UndirectedGraphNode *t = (struct UndirectedGraphNode*)malloc(sizeof(struct UndirectedGraphNode));
    t->label = node->label;
    int count = node->neighborsCount;
    t->neighborsCount = count;
    for(int i = 0; i < count; i++)
        t->neighbors[i] = node->neighbors[i];
    return t;
}

struct UndirectedGraphNode* cloneGraph(struct UndirectedGraphNode* graph)
{
    if(!graph) return NULL;
    struct UndirectedGraphNode *root = copy(graph);
    struct Mapper *head = (struct Mapper*)malloc(sizeof(struct Mapper));
    head->next = NULL;
    head->key = 0;
    push(head, graph, root);
    struct UndirectedGraphNode **stack = (struct UndirectedGraphNode**)malloc(sizeof(struct UndirectedGraphNode*)); //recording the address of the original graph;
    int size = 0;
    stack[size++] = graph;
    while(size)
    {
        struct UndirectedGraphNode *cur = stack[--size];
        printf("size: %d\tcurrent label: %d\t neighborsCount: %d\n", size, cur->label, cur->neighborsCount);
        for(int i = 0; i < cur->neighborsCount; i++)
        {
            struct Mapper *p = head;
            printf("inside map\n");
            while(p)
            {
                printf("key address: %ld\tvalue: %ld\n", p->key, p->value);
                p = p->next;
            }
            printf("address of neighbor: %ld, pop: %d\n", cur->neighbors[i], pop(head, cur->neighbors[i]));
            if(!pop(head, cur->neighbors[i])) //not visited;
            {
                stack = (struct UndirectedGraphNode**)realloc(stack, sizeof(struct UndirectedGraphNode*)*(size+2));
                stack[size++] = cur->neighbors[i];
                struct UndirectedGraphNode *cCur = pop(head, cur);
                struct UndirectedGraphNode *cNeighbor = copy(cur->neighbors[i]);
                cCur->neighbors[i] = cNeighbor;
                push(head, cur->neighbors[i], cNeighbor);
            }
        }
    }
    return root;
}
