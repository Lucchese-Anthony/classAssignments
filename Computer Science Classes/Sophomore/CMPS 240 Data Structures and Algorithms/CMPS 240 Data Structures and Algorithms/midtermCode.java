3-9 insert on an unsorted link list O(1)
>given val
Node temp = new Node(val)
if head == null{
   head = temp;
} else {
   temp.next = head;
   head = temp;
}


14-24 find unsorted link list o(n)

int val

temp = head;
if temp == null{
   return null;
} else {
   while(temp.val != val){
      if temp == null{
         return null;
      temp = temp.next;
      
   }
   return temp;
}

28-35 push on stack (same as insert unsorted link list) o(1)

>given val
Node temp = new Node(val);
if head == null{
   head = temp;
} else {
   temp.next = head;
   head = temp;
}

41-47 pop on stack o(1)

>given val

if(head == null){
   return null
} else {
   temp = head;
   head = head.next
   return temp;
}

51-58 enqueue on a queue O(1)

>given head
>given tail
>given val
enqueue(){
   Node temp = new Node(val);
   tail.next = temp;
   tail = tail.next;
}

62-69 dequeue on a queue O(1)

>given head
>given tail
>given val
dequeue(){
   temp = head;
   head = head.next;
   return temp;
}

findNumberInNodeTHingy(Node node, int INT){
if(node.val ==INT){
   return node
} else {
   if(node.next != null){
      findNumberInNOdeThingy(node.next, INT);
   } else return null //or nullPointerException
}
}

find(int INT){
   findNUmberINNodeTHingy(Head, INT) 
}