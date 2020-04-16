/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singlylinkedlist;

/**
 * @file CheckStateResult
 * @description Dışarıdan parametre olarak gelen karakterin kontrol işlemleri için hazırlanan metodun result sınıfı.
 * @assignment 1
 * @date 15.04.2020
 * @author Melih Kaçaman, mkacamann@gmail.com
 */

public class LinkedList {

    Node head;
    String tracker; // for previous character (yeni eklenen karakterler peş peşe eklenir.)
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

    Node remove(char data) {
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
            System.out.print(temp.data);
            if(temp.down != null){
                SubNode subTemp = temp.down;
                System.out.print(" -> ");
                while(subTemp != null){
                    System.out.print(subTemp.data+","+subTemp.count+" -> ");
                    subTemp = subTemp.down;
                }
                System.out.print("null");
            }
            System.out.println("");
            temp = temp.right;
        }

        System.out.println("null");
    }

    private boolean isEmpty() {
        return head == null;
    }

    private boolean isEmptyForSubNode(Node node){
        /// Node'un kendi listesine işaret eden ilk düğümü kontrol eder.
        return node.down == null;
    }

    private char previousCharacter(){
        // Bir önceki karaktere ulaşılır.
        return (char) this.tracker.charAt(this.tracker.length() -1);
    }

    private void proccessOfSubnode(CheckStateResult active){
        // Ana listede var olan bir node'un listesine düğüm eklemek için yazıldı.
        char previousCharacter = previousCharacter();
        if(Character.isLetter(previousCharacter)){
            Node targetNode = find(Character.toLowerCase(previousCharacter));
            addSubNode(new SubNode(active.result.data),targetNode);
        }
    }

    void add(Node newNode) {
        // Linked Liste tüm kontrolleri yaparak eleman ekler.
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

                proccessOfSubnode(active);
            }
        }
        else if (active.result != null){
            proccessOfSubnode(active);
        }
        this.tracker += newNode.data;
    }

    void add(char data) {
        add(new Node(data));
    }

    private CheckStateResult checkForState(char data) {
        // Gelen karakterin eğer harf ise ana listeyi kontrol eden ve bulup bulmama durumuna göre sonuç üretir.
        // CheckStateResult tipinde bir nesne döndürülür, bu nesne içindeki isFound ve result değişkenlerine göre durum
        // add metodunda yönetilir.
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
        // Ana listedeki bir node'un listesine eleman ekler.
        // Ana listedeki nodu ve ekleyeceği subNode dışarıdan alır.
        if(isEmptyForSubNode(target)) {
            target.down = newNode;
        } else {
            SubNode temp = target.down;

            if(temp.data == newNode.data){
                temp.count++;
                return;
            }

            while (temp.down != null && temp.down.data!= newNode.data) {
                temp = temp.down;
            }

            if(temp.down == null){
                temp.down = newNode;
            }
            else {
                temp.down.count++;
            }
        }

    }

    void ardisikKarakterler(char k){
        // Target node'un listesinde gezer.
        Node target = find(k);
        if(target != null){
            System.out.print(target.data + " -> ");
            if(target.down != null){
                SubNode subTemp = target.down;
                System.out.print(" -> ");
                while(subTemp != null){
                    System.out.print(subTemp.data+","+subTemp.count+" -> ");
                    subTemp = subTemp.down;
                }
                System.out.print("null");
            }
        }
        else {
            System.out.println("Not found!");
        }
        System.out.println();
    }

    void enCokArdisik(){
        // Önceki eleman ile karşılaştırma algoritması kullanıldı.
        // Önce her bir nodun içinde en çok kullanılmış karakter ile ikili oluşturulur ardından aynı işlem yapılarak ikisi
        // karşılaştırılır.
        Node temp = head;
        Node theBiggest = null;

        while(temp != null){
            if(temp.down != null){
                SubNode subTemp = temp.down;
                Node theBiggestCouple = temp;
                theBiggestCouple.down = subTemp;

                while(subTemp != null){
                    if(subTemp.count > theBiggestCouple.down.count){
                        theBiggestCouple.down = subTemp;
                    }

                    subTemp = subTemp.down;
                }
                if(theBiggest == null || theBiggest.down.count < theBiggestCouple.down.count)
                    theBiggest = theBiggestCouple;
            }
            temp = temp.right;
        }

        System.out.println(theBiggest.data + " " + theBiggest.down.data+","+theBiggest.down.count);
    }

    void enCokArdisik(char k){
        // Üstteki metodun aynısıdır lakin ayrıca ana listede de gezmiyor hedef bir Node'da geziyor.
        Node target = find(k);

        if(target != null && target.down != null){
            SubNode subTemp = target.down;
            Node theBiggestCouple = target;
            theBiggestCouple.down = subTemp;

            while(subTemp != null){
                if(subTemp.count > theBiggestCouple.down.count){
                    theBiggestCouple.down = subTemp;
                }

                subTemp = subTemp.down;
            }
            System.out.println(theBiggestCouple.data + " " + theBiggestCouple.down.data+","+theBiggestCouple.down.count);
            return;
        }

        System.out.println("The character you've chosen have no couples!");
    }

    void enAzArdisik(){
        // enCokArdisik metodunun aynısıdır
        Node temp = head;
        Node theBiggest = null;

        while(temp != null){
            if(temp.down != null){
                SubNode subTemp = temp.down;
                Node theBiggestCouple = temp;
                theBiggestCouple.down = subTemp;

                while(subTemp != null){
                    if(subTemp.count > theBiggestCouple.down.count){    // karşılaştırma yönü değişmiştirilmiştir.
                        theBiggestCouple.down = subTemp;
                    }

                    subTemp = subTemp.down;
                }
                if(theBiggest == null || theBiggest.down.count > theBiggestCouple.down.count)
                    theBiggest = theBiggestCouple;
            }
            temp = temp.right;
        }

        System.out.println(theBiggest.data + " " + theBiggest.down.data+","+theBiggest.down.count);
    }

    void enAzArdisik(char k){
        Node target = find(k);

        if(target != null &&target.down != null){
            SubNode subTemp = target.down;
            Node theBiggestCouple = target;
            theBiggestCouple.down = subTemp;

            while(subTemp != null){
                if(subTemp.count < theBiggestCouple.down.count){
                    theBiggestCouple.down = subTemp;
                }

                subTemp = subTemp.down;
            }
            System.out.println(theBiggestCouple.data + " " + theBiggestCouple.down.data+","+theBiggestCouple.down.count);
            return;
        }

        System.out.println("The character you've chosen have no couples or no char!");
    }
}
