package singlylinkedlist;

/**
 * @file CheckStateResult
 * @description Dışarıdan parametre olarak gelen karakterin kontrol işlemleri için hazırlanan metodun result sınıfı.
 * @assignment 1
 * @date 15.04.2020
 * @author Melih Kaçaman, mkacamann@gmail.com
 */

public class CheckStateResult {
    boolean isFound;
    Node result;
    public CheckStateResult(boolean isFound) {
        this.isFound = isFound;
        this.result = null;
    }
}
