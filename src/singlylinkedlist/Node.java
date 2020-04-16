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
