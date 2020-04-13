package singlylinkedlist;

import java.io.*;


public class Test {
    public static void main(String[] args) throws IOException {
        
        SinglyLinkedList<Character> chars = new SinglyLinkedList<>(); 

        File f=new File("input.txt");     
        FileReader fr=new FileReader(f);   
        BufferedReader br=new BufferedReader(fr);  
        String s=null; 

        char previousCharaceter = ' '; 

        while((s=br.readLine())!=null)      
        {
            for (char character : s.toCharArray()) {
                chars.add(character); 

                previousCharaceter = character; 
            }       
        }
        fr.close();
        
        chars.print();
        
        
    }
}
