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
public class Node {
    char data;
    Node right;
    SubNode down;

    public Node(char data){
        this.data = data;
        this.right = null;
        this.down = null;
    }
    
}
