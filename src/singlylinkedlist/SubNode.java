package singlylinkedlist;

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
