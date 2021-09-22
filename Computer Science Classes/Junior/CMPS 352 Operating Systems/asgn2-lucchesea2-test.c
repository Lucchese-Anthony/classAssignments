/* Program:     doubly linked List in C
   File name:   doubly-linked-list.c
   Compile:     gcc -o myList doubly-linked-list.c
   Run:         ./myList
   Description: The program accepts three integers from keyboard,
                inserts them as three nodes in a doubly linked list,
                finally, prints the three nodes. 
*/
#include <stdio.h>
#include <stdlib.h>

// define the struct of nodes
struct NODE {
   int x;
   struct NODE *prev;
   struct NODE *next;
};
// give "struct NODE" a short name (Node)
typedef struct NODE  Node;

// define a struct and give it a short name
typedef struct LIST {
   int count;
   Node *first;
   Node *last;
} List; 

// declare function prototypes
Node *createNode();
void printNode(Node *nodePtr);
List *createList();
void insertNode(List *listPtr, Node *newPtr);
void printList(List *listPtr);

int main() {
   List *listPtr;

   listPtr = createList();

   // create three nodes and add them to list
   for (int i = 0; i < 3; i++) {
      Node *nodePtr = createNode();
      insertNode(listPtr, nodePtr);
   }

   printList(listPtr);
}

Node *createNode() {
   int input;
   printf("Enter an integer: ");
   scanf("%d", &input);
   Node *nodePtr = (Node *) malloc(sizeof(Node));
   nodePtr->x = input;

   return nodePtr;
}

List *createList() {
   List *listPtr = (List*) malloc(sizeof(List));
   listPtr->count = 0;
   listPtr->first = NULL;
   listPtr->last = NULL;

   return listPtr;
}

void insertNode(List *listPtr, Node *newPtr) {
   if (listPtr->count == 0) {
      // empty list
      newPtr->prev = NULL;
      newPtr->next = NULL;

      listPtr->first = newPtr;
      listPtr->last = newPtr;
   }
   else {
      // at least one node
      newPtr->prev = NULL;
      newPtr->next = listPtr->first;

      listPtr->first = newPtr;
   }
   listPtr->count++;
}

void printList(List *listPtr) {
   if (listPtr->count == 0) {
      printf("Empty list!\n");
   }
   else {
      printf("List: %d\n", listPtr->count);
      Node *ptr = listPtr->first;
      for (int i = 0; i < listPtr->count; i++) {
         printNode(ptr);
         ptr = ptr->next;
      }
   }
}

void printNode(Node *nodePtr) {
   printf("X: %d\n", nodePtr->x);
}
