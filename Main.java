import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        BINNODE English = new BINNODE();
        BINNODE French = new BINNODE();
        boolean translate = false;
        int mode = -1; // -1 sin idioma definido, 0 English,  1 Frenchy
        //leet el archivo 
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el archivo con los datos");
            String directory = scanner.nextLine();
            BufferedReader reader = new BufferedReader(new FileReader(directory));
            String line;
            while ((line = reader.readLine()) != null){//agregar al diccionario correspondiente
                String[] parts = line.split(",");
                English.add(parts[0].toLowerCase(), parts[1].toLowerCase());
                French.add(parts[2].toLowerCase(), parts[1].toLowerCase());
            }
            translate = true;
        }catch (Exception e) {
            System.out.println("Error inesperado, cerrando sesion");
            System.exit(1);
        }
        if(translate){
        Scanner op = new Scanner(System.in);
        while (true) {
            System.out.println("1. traducir archivo");
            System.out.println("2. editar traduccion de palabra");
            System.out.println("3. borrar palabra de dicconario"); 
            System.out.println("4. salir");
            System.out.println("5. Mostrar contenido de diccionarios");
            System.out.println("6. Traducir una palabra");
            try {
                switch(op.nextInt()){
                    case 1 ->{
                        Scanner scanner = new Scanner(System.in);
                        try{
                            String file = scanner.nextLine();
                            BufferedReader reader = new BufferedReader(new FileReader(file));
                            String line;
                            ArrayList<String> notfoundTokens = new ArrayList<String>();//ArrayList con las palabras no encontradas en los diccionarios
                            while ((line = reader.readLine()) != null){
                                String[] tokens = line.split(" ");
                                ArrayList<String> tokensList = new ArrayList<String>();//ArrayList con los resultados de traduccion
                                for(String word: tokens){
                                    if(English.containsNode(word.toLowerCase())){
                                        mode = 0;
                                        break;
                                    }
                                    if(French.containsNode(word.toLowerCase())){
                                        mode = 1;
                                        break;
                                    }
                                }
                                switch(mode){
                                    case 0 -> {
                                        for(String word: tokens){
                                            if(English.containsNode(word.toLowerCase())){
                                                Noder value = English.getNode(word.toLowerCase());
                                                tokensList.add((String)value.data.getValue());
                                            }else{
                                                notfoundTokens.add(word);
                                                tokensList.add("*" + word + "*");
                                            }
                                        }
                                        String transaltion = "";
                                        for(String word : tokensList){
                                            transaltion = transaltion + " " + word;
                                        }
                                        System.out.println(transaltion);
                                    }
                                    case 1 -> {
                                        for(String word: tokens){
                                            if(French.containsNode(word.toLowerCase())){
                                                Noder value = French.getNode(word.toLowerCase());
                                                tokensList.add((String)value.data.getValue());
                                            }else{
                                                notfoundTokens.add(word);
                                                tokensList.add("*" + word + "*");
                                            }
                                        }
                                        String transaltion = "";
                                        for(String word : tokensList){
                                            transaltion = transaltion + " " + word;
                                        }
                                        System.out.println(transaltion);

                                    }
                                    case -1 ->{
                                        System.out.println("no se reconoce el idioma");
                                        break;
                                    }
                                }
                            }
                        }
                        catch(FileNotFoundException e){
                            System.out.println("file not found");
                            scanner.next();
                        }
                        catch (Exception e){
                            System.out.println("unexpected error");
                            scanner.next();
                        }

                    }
                    case 4->{
                        System.exit(0);
                    }
                    case 5->{
                        System.out.println("Diccionario en Ingles");
                        English.traverseInOrder(English.root);
                        System.out.println("\n Diccionario en Frances");
                        French.traverseInOrder(French.root);
                        System.out.println();
                    }
                    case 6 ->{
                        System.out.println("ingrese palabra");
                        Scanner scanner = new Scanner(System.in);
                        String word = scanner.nextLine();
                        if(English.containsNode(word.toLowerCase())){
                            Noder wordy = English.getNode(word.toLowerCase());
                            System.out.println(wordy.data.getValue());
                        }

                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Entrada no valida");
                op.next();
            }
            
            
        }
    }
       
        
        
    } 
    
}

 