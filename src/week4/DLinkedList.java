package week4;

public class DLinkedList {
   DNode head;
   DNode tail;
   public DLinkedList(){
      this.head = null;
      this.tail = null;
   }
   public boolean isEmpty(){
      return head == null && tail == null;
   }

   public void addFirst(int data) {
      DNode newNode = new DNode(data);
      if (head == null) {
         head = newNode;
         tail = newNode;
      } else {
         newNode.next = head;
         head.prev = newNode;
         head = newNode;
      }
   }
   public void addTail(int data) {
      DNode newNode = new DNode(data);
      if (tail == null) {
         head = newNode;
         tail = newNode;
      } else {
         newNode.prev = tail;
         tail.next = newNode;
         tail = newNode;
      }
   }
   public int size() {
      int count = 0;
      DNode current = head;
      while (current != null) {
         count++;
         current = current.next;
      }
      return count;
   }
   public void insertAt(int data, int position) {
      DNode newNode = new DNode(data);
      if (position <= 0) {
         addFirst(data);
      } else if (position >= size()) {
         addTail(data);
      } else {
         DNode current = head;
         int index = 0;
         while (current != null && index < position) {
            current = current.next;
            index++;
         }
         newNode.prev = current.prev;
         newNode.next = current;
         current.prev.next = newNode;
         current.prev = newNode;
      }
   }
   public void delete(int data) {
      DNode current = head;

      // Duyệt danh sách để tìm phần tử cần xóa
      while (current != null) {
         if (current.data == data) {
            if (current.prev != null) {
               current.prev.next = current.next;
            } else {
               head = current.next;
            }
            if (current.next != null) {
               current.next.prev = current.prev;
            } else {
               tail = current.prev;
            }
            return; // Phần tử đã được xóa, thoát khỏi hàm
         }
         current = current.next;
      }
   }
   public void printList() {
      DNode current = head;
      while (current != null) {
         System.out.print(current.data + " ");
         current = current.next;
      }
      System.out.println();
   }


   public static void main(String[] args) {
      DLinkedList list = new DLinkedList();

      // Thêm các phần tử vào đầu và cuối danh sách
      list.addFirst(3);
      list.addTail(5);
      list.addTail(7);

      // In danh sách
      System.out.print("Danh sách ban đầu: ");
      list.printList();

      // Chèn một phần tử vào vị trí bất kỳ
      list.insertAt(4, 1);

      // In danh sách sau khi chèn
      System.out.print("Danh sách sau khi chèn: ");
      list.printList();
   }
}
