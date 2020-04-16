package singlylinkedlist;

import java.io.*;

/**
 * @file CheckStateResult
 * @description Dışarıdan parametre olarak gelen karakterin kontrol işlemleri için hazırlanan metodun result sınıfı.
 * @assignment 1
 * @date 15.04.2020
 * @author Melih Kaçaman, mkacamann@gmail.com
 */

public class Test {
    public static void main(String[] args) throws IOException {
        
        LinkedList chars = new LinkedList();

        File f=new File("input.txt");     
        FileReader fr=new FileReader(f);   
        BufferedReader br=new BufferedReader(fr);  
        String s=null; 

        char previousCharaceter = ' '; 

        while((s=br.readLine())!=null)      
        {
            for (char character : s.toCharArray()) {
                chars.add(character);
            }       
        }
        fr.close();
        
        chars.print();
        System.out.println();

        System.out.println("Ardışık karakterler:");
        chars.ardisikKarakterler('v');

        System.out.println("En çok ardışık:");
        chars.enCokArdisik();

        System.out.println("En çok ardışık belirli bir karakterden sonra:");
        chars.enCokArdisik('v');

        System.out.println("En az ardışık");
        chars.enAzArdisik();

        System.out.println("En az ardışık belirli bir karakterden sonra:");
        chars.enAzArdisik('l');
    }
}
