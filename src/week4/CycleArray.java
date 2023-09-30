package week4;

public class CycleArray {
    //Link: https://leetcode.com/problems/linked-list-cycle/description/
    public boolean hasCycle(Node head) {
        if(head == null || head.next ==null){
            return false;
        }
        Node oneStepNode = head;
        Node twoStepNode = head;
        while(oneStepNode != null && twoStepNode != null && twoStepNode.next != null)  {
            oneStepNode = oneStepNode.next;
            twoStepNode = twoStepNode.next.next;
            if(oneStepNode == twoStepNode){
                return true;
            }


        }
        return false;
    }
}
