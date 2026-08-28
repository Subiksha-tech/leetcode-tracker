// Last updated: 28/08/2026, 09:27:49
1#include <stdlib.h>
2
3typedef struct Node {
4    int key;
5    int value;
6    struct Node *prev;
7    struct Node *next;
8} Node;
9
10typedef struct {
11    int capacity;
12    int size;
13    Node *head;
14    Node *tail;
15    Node **table;
16} LRUCache;
17
18#define HASH_SIZE 10007
19
20int hash(int key) {
21    return key % HASH_SIZE;
22}
23
24// Remove a node from the linked list
25void removeNode(Node *node) {
26    node->prev->next = node->next;
27    node->next->prev = node->prev;
28}
29
30// Add node just after head
31void addFront(LRUCache *obj, Node *node) {
32    node->next = obj->head->next;
33    node->prev = obj->head;
34
35    obj->head->next->prev = node;
36    obj->head->next = node;
37}
38
39// Find node using hash table
40Node* findNode(LRUCache *obj, int key) {
41    int index = hash(key);
42    Node *curr = obj->table[index];
43
44    while (curr != NULL) {
45        if (curr->key == key)
46            return curr;
47
48        curr = curr->next;
49    }
50
51    return NULL;
52}
53
54LRUCache* lRUCacheCreate(int capacity) {
55
56    LRUCache *obj = malloc(sizeof(LRUCache));
57
58    obj->capacity = capacity;
59    obj->size = 0;
60
61    obj->head = malloc(sizeof(Node));
62    obj->tail = malloc(sizeof(Node));
63
64    obj->head->next = obj->tail;
65    obj->head->prev = NULL;
66
67    obj->tail->prev = obj->head;
68    obj->tail->next = NULL;
69
70    obj->table = calloc(HASH_SIZE, sizeof(Node*));
71
72    return obj;
73}
74
75int lRUCacheGet(LRUCache* obj, int key) {
76
77    Node *node = findNode(obj, key);
78
79    if (node == NULL)
80        return -1;
81
82    // Move node to front because it is recently used
83    removeNode(node);
84    addFront(obj, node);
85
86    return node->value;
87}
88
89void lRUCachePut(LRUCache* obj, int key, int value) {
90
91    Node *node = findNode(obj, key);
92
93    // Key already exists
94    if (node != NULL) {
95
96        node->value = value;
97
98        // Move to front
99        removeNode(node);
100        addFront(obj, node);
101
102        return;
103    }
104
105    // Create new node
106    node = malloc(sizeof(Node));
107
108    node->key = key;
109    node->value = value;
110
111    // Add to hash table
112    int index = hash(key);
113    node->next = obj->table[index];
114    obj->table[index] = node;
115
116    // Add to front of linked list
117    addFront(obj, node);
118
119    obj->size++;
120
121    // Capacity exceeded
122    if (obj->size > obj->capacity) {
123
124        // Least recently used node
125        Node *lru = obj->tail->prev;
126
127        removeNode(lru);
128
129        // Remove from hash table
130        int h = hash(lru->key);
131
132        Node *curr = obj->table[h];
133        Node *prev = NULL;
134
135        while (curr != NULL) {
136
137            if (curr == lru) {
138
139                if (prev == NULL)
140                    obj->table[h] = curr->next;
141                else
142                    prev->next = curr->next;
143
144                break;
145            }
146
147            prev = curr;
148            curr = curr->next;
149        }
150
151        free(lru);
152        obj->size--;
153    }
154}
155
156void lRUCacheFree(LRUCache* obj) {
157
158    Node *curr = obj->head;
159
160    while (curr != NULL) {
161        Node *temp = curr;
162        curr = curr->next;
163        free(temp);
164    }
165
166    free(obj->table);
167    free(obj);
168}