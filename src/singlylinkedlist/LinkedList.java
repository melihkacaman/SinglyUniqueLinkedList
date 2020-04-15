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
public class LinkedList {

    Node head;
    String tracker; // for previous character
    public LinkedList() {
        this.head = null;
        this.tracker = "";
    }

    private void addFirst(Node newData) {
        if(isEmpty()) {
            head = newData;
        } else {
            newData.right = head;
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

            while (temp.right != null) {
                temp = temp.right;
            }

            temp.right = newNode;
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
                temp = temp.right;
            }

            if (temp != null) {
                newNode.right = temp.right;
                temp.right = newNode;
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
                head = head.right;
                return removedNote;
            } else {
                Node temp = head;

                while (temp.right != null && temp.right.data != data) {
                    temp = temp.right;
                }

                if (temp.right != null) {
                    removedNote = temp.right;
                    temp.right = temp.right.right;
                    return removedNote;
                }
            }
        }
        return removedNote;
    }

    private Node find(char data) {
        Node foundNode = null;
        if (isEmpty()) {
            System.out.println("List is empty!");
            return null;
        } else {
            if (head.data == data) {
                foundNode = head;
                return foundNode;
            } else {
                Node temp = head;

                while (temp.right != null && temp.right.data != data) {
                    temp = temp.right;
                }

                if (temp.right != null) {
                    foundNode = temp.right;
                    return foundNode;
                }
            }
        }
        return foundNode;
    }

    void print() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.right;
        }

        System.out.println("null");
        System.out.println(this.tracker);
    }

    private boolean isEmpty() {
        return head == null;
    }

    private boolean isEmptyForSubNode(Node node){
        return node.down == null;
    }

    void add(Node newNode) {
        CheckStateResult active = checkForState(newNode.data);
        if (!active.isFound && active.result != null){
            if (isEmpty()) {
                addFirst(active.result);
            } else {
                Node temp = head;

                while (temp.right != null) {
                    temp = temp.right;
                }

                temp.right = active.result;
                char previousCharacter = (char) this.tracker.charAt(this.tracker.length() -1);
                if(previousCharacter != ' '){
                    Node targetNode = find(Character.toLowerCase(previousCharacter));
                    addSubNode(new SubNode(active.result.data),targetNode);
                }
            }
        }
        else if (active.result != null){
            char previousCharacter = (char) this.tracker.charAt(this.tracker.length() -1);
            if(previousCharacter != ' '){
                Node targetNode = find(previousCharacter);
                addSubNode(new SubNode(active.result.data),targetNode);
            }
        }
        this.tracker += newNode.data;
        System.out.println(this.tracker);

    }

    void add(char data) {
        add(new Node(data));
    }

    private CheckStateResult checkForState(char data) {
        CheckStateResult result = new CheckStateResult(false);

        data = Character.toLowerCase(data);

        if (Character.isLetter(data)) {

            Node temp = head;
            while (temp != null && temp.data != data) {
                temp = temp.right;
            }

            if (temp == null) {
                result.result = new Node(data);
            }
            else {
                result.isFound = true;
                result.result = temp;
            }
        }

        return result;
    }

    private void addSubNode(SubNode newNode, Node target) {
        if(isEmptyForSubNode(target)) {
            target.down = newNode;
        } else {
            SubNode temp = target.down;

            while (temp != null && temp.data!= newNode.data) {
                temp = temp.down;
            }
            // TO DO: LOSE THE ADDRESS
            if(temp == null){
                temp = newNode;
            }
            else {
                temp.count++;
            }
        }
    }
}
