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
public class SinglyLinkedList<T extends Comparable<T>> {

    Node<T> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    private void addFirst(Node newData) {
        if (isEmpty()) {
            head = newData;
        } else {
            newData.nextNode = head;
            head = newData;
        }

    }

    private void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        addFirst(newNode);
    }

    private void addLast(Node<T> newNode) {
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

    private void addLast(T data) {
        addLast(new Node<>(data));
    }

    private boolean addAfter(Node<T> newNode, T search) {
        if (isEmpty()) {
            addFirst(newNode);
            return true;
        } else {
            Node<T> temp = head;

            while (temp != null && !temp.data.equals(search)) {
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

    private boolean addAfter(T data, T search) {
        return addAfter(new Node<>(data), search);
    }

    private Node<T> remove(T data) {
        Node<T> removedNote = null;
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        } else {
            if (head.data.equals(data)) {
                removedNote = head;
                head = head.nextNode;
                return removedNote;
            } else {
                Node temp = head;

                while (temp.nextNode != null && !temp.nextNode.data.equals(data)) {
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
        Node<T> temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.nextNode;
        }

        System.out.println("null");
    }

    private boolean isEmpty() {
        return head == null;
    }

    void add(Node<T> newNode) {
        char character = Character.toLowerCase(((Character)newNode.data));
        
        if (isEmpty()) {
            addFirst(newNode);
        } else {
            if (checkForState(newNode.data)) {
                Node temp = head;

                while (temp.nextNode != null) {
                    temp = temp.nextNode;
                }

                temp.nextNode = newNode;
            } else {

            }
        }
    }

    void add(T data) {
        add(new Node<>(data));
    }

    private boolean checkForState(T data) {

        if (Character.isLetter((Character) data)) {

            Node temp = head;
            while (temp != null && temp.data != data) {
                temp = temp.nextNode;
            }

            if (temp == null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}
