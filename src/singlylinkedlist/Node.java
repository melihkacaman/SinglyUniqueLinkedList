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
public class Node<T extends Comparable<T>> {
    T data; 
    Node nextNode; 
    
    public Node(T data){
        this.data = data; 
    }
    
}
