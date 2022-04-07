import static org.junit.Assert.assertEquals;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.BufferedReader;

import org.junit.Test;

public class TreeTest {
    @Test
    public void searchTest(){
        GenericBST English = new GenericBST();
        try {
            
            //String directory = scanner.nextLine();
            String directory = "D:\\Universidad\\SEMESTRE 3\\Algoritmos y Datos\\HOJA7\\diccionario.txt";
            BufferedReader reader = new BufferedReader(new FileReader(directory));
            String line;
            while ((line = reader.readLine()) != null){//agregar al diccionario correspondiente
                line = line.replace(",", " ");
                String[] parts = line.split("\\s");
                English.insert(parts[0].strip().toLowerCase(), parts[1].toLowerCase());
                
            }
            
        }catch (Exception e) {
            System.out.println("Error inesperado, cerrando sesion");
            System.exit(1);
        }

        boolean result = English.contains("woman"); //se conoce que posee esta llave
        assertEquals(result, true);
        boolean result2 = English.contains("yes"); //se conoce que posee esta llave
        assertEquals(result2, true);
        boolean result3 = English.contains("egg");
        assertEquals(result3, false);
    }
    
    
}
/*

          _____                    _____            _____                    _____                   _____                    _____          
         /\    \                  /\    \          /\    \                  /\    \                 /\    \                  /\    \         
        /::\    \                /::\    \        /::\    \                /::\____\               /::\____\                /::\    \        
       /::::\    \              /::::\    \       \:::\    \              /:::/    /              /:::/    /               /::::\    \       
      /::::::\    \            /::::::\    \       \:::\    \            /:::/    /              /:::/    /               /::::::\    \      
     /:::/\:::\    \          /:::/\:::\    \       \:::\    \          /:::/    /              /:::/    /               /:::/\:::\    \     
    /:::/__\:::\    \        /:::/__\:::\    \       \:::\    \        /:::/____/              /:::/    /               /:::/__\:::\    \    
   /::::\   \:::\    \      /::::\   \:::\    \      /::::\    \      /::::\    \             /:::/    /               /::::\   \:::\    \   
  /::::::\   \:::\    \    /::::::\   \:::\    \    /::::::\    \    /::::::\    \   _____   /:::/    /      _____    /::::::\   \:::\    \  
 /:::/\:::\   \:::\    \  /:::/\:::\   \:::\____\  /:::/\:::\    \  /:::/\:::\    \ /\    \ /:::/____/      /\    \  /:::/\:::\   \:::\____\ 
/:::/  \:::\   \:::\____\/:::/  \:::\   \:::|    |/:::/  \:::\____\/:::/  \:::\    /::\____\:::|    /      /::\____\/:::/  \:::\   \:::|    |
\::/    \:::\  /:::/    /\::/   |::::\  /:::|____/:::/    \::/    /\::/    \:::\  /:::/    /:::|____\     /:::/    /\::/   |::::\  /:::|____|
 \/____/ \:::\/:::/    /  \/____|:::::\/:::/    /:::/    / \/____/  \/____/ \:::\/:::/    / \:::\    \   /:::/    /  \/____|:::::\/:::/    / 
          \::::::/    /         |:::::::::/    /:::/    /                    \::::::/    /   \:::\    \ /:::/    /         |:::::::::/    /  
           \::::/    /          |::|\::::/    /:::/    /                      \::::/    /     \:::\    /:::/    /          |::|\::::/    /   
           /:::/    /           |::| \::/____/\::/    /                       /:::/    /       \:::\__/:::/    /           |::| \::/____/    
          /:::/    /            |::|  ~|       \/____/                       /:::/    /         \::::::::/    /            |::|  ~|          
         /:::/    /             |::|   |                                    /:::/    /           \::::::/    /             |::|   |          
        /:::/    /              \::|   |                                   /:::/    /             \::::/    /              \::|   |          
        \::/    /                \:|   |                                   \::/    /               \::/____/                \:|   |          
         \/____/                  \|___|                                    \/____/                 ~~                       \|___|          
                                                                                                                                             

*/