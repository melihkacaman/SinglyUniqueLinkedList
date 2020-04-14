/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 *
 * @author MelihKacaman
 */
public class SinglyLinkedList {

    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    private void addFirst(Node newData) {
        if(isEmpty()) {
            head = newData;
        } else {
            newData.nextNode = head;
            head = newData;
        }
    }

    private void addFirst(char data) {
        Node newNode = new Node(data);
        addFirst(newNode);
    }

    private void addLast(Node newNode) {
        if (isEmpty()) {
            addFirst(newNode);
        } else {
            Node temp = head;

            while (temp.nextNode != null) {
                temp = temp.nextNode;
            }

            temp.nextNode = newNode;
        }
    }

    private void addLast(char data) {
        addLast(new Node(data));
    }

    private boolean addAfter(Node newNode, char search) {
        if (isEmpty()) {
            addFirst(newNode);
            return true;
        } else {
            Node temp = head;

            while (temp != null && temp.data != search) {
                temp = temp.nextNode;
            }

            if (temp != null) {
                newNode.nextNode = temp.nextNode;
                temp.nextNode = newNode;
                return true;
            }

        }

        return false;
    }

    private boolean addAfter(char data, char search) {
        return addAfter(new Node(data), search);
    }

    private Node remove(char data) {
        Node removedNote = null;
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        } else {
            if (head.data == data) {
                removedNote = head;
                head = head.nextNode;
                return removedNote;
            } else {
                Node temp = head;

                while (temp.nextNode != null && temp.nextNode.data != data) {
                    temp = temp.nextNode;
                }

                if (temp.nextNode != null) {
                    removedNote = temp.nextNode;
                    temp.nextNode = temp.nextNode.nextNode;
                    return removedNote;
                }
            }
        }
        return removedNote;
    }

    void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    private boolean isEmpty() {
        return head == null;
    }

    void add(Node newNode) {
        Node active = checkForState(newNode.data);

        if (active != null){
            if (isEmpty()) {
                addFirst(active);
            } else {
                Node temp = head;

                while (temp.nextNode != null) {
                    temp = temp.nextNode;
                }

                temp.nextNode = active;
            }
        }
    }

    void add(char data) {
        add(new Node(data));
    }

    private Node checkForState(char data) {
        Node result = null;

        data = Character.toLowerCase(data);

        if (Character.isLetter(data)) {

            Node temp = head;
            while (temp != null && temp.data != data) {
                temp = temp.nextNode;
            }

            if (temp == null) {
                result = new Node(data);
            }
        }

        return result;
    }

}
