package singlylinkedlist;
/**
 * @file CheckStateResult
 * @description Dışarıdan parametre olarak gelen karakterin kontrol işlemleri için hazırlanan metodun result sınıfı.
 * @assignment 1
 * @date 15.04.2020
 * @author Melih Kaçaman, mkacamann@gmail.com
 */
public class SubNode {
    char data;
    int count;
    SubNode down;

    public SubNode(char data){
        this.data = data;
        this.count = 1;
        this.down = null;
    }
}
