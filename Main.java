import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        BINNODE English = new BINNODE();
        BINNODE French = new BINNODE();
        //leet el archivo 
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el archivo con los datos");
            String directory = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(directory));
            String line;
            while ((line = reader.readLine()) != null){//agregar al diccionario correspondiente
                String[] parts = line.split(",");
                English.add(parts[0], parts[1]);
                French.add(parts[2], parts[1]);
            }
        }catch (Exception e) {
            System.out.println("Error inesperado, cerrando sesion");
            System.exit(1);
        }
        System.out.println("English" + "\n" );
        English.traverseInOrder(English.root);
        System.out.println("\nFrench" + "\n" );
        French.traverseInOrder(French.root);

        
        
    } 
 }
 