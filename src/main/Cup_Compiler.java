package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Cup_Compiler {
    
    public static void main(String[] args) {
        Cup_Compiler compiler = new Cup_Compiler();
        compiler.compile_files();
        boolean mvAL = move_file("Lexer.java");
        boolean mvAS = move_file("AnalizadorSintactico.java");
        boolean mvSym = move_file("sym.java");
        probandoLenguaje(); 
    }
     
    public static void probandoLenguaje(){
        File archivo = new File("./src/test/test.txt");
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            System.out.println("Texto: \n"+ST);
            int cont = 1;
            Lexer lexico = new Lexer(new BufferedReader(new StringReader(ST)));
            AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
            
            sintactico.parse();
        } catch (Exception e) {
            System.out.println("Hubo un pedo en el parser ewe");
            System.out.println(e);
        }
    }
    
    public void compile_files() {
        String LexicFile = "";
        String SyntacticFile = "";
        
        System.out.println("\n*** Procesando archivo default ***\n");
        LexicFile = "./src/main/Lexer.flex";
        SyntacticFile = "./src/main/Parser.cup";
        
        String[] LexicArray = {LexicFile};
        String[] SyntacticArray = {"-parser", "AnalizadorSintactico", SyntacticFile};
        jflex.Main.main(LexicArray);
        try {
            java_cup.Main.main(SyntacticArray);
        } catch (Exception e) {
            System.out.println("Han sido generados correctamente");
        }
    }

    public static boolean move_file(String FileName) {
        boolean executed = false;
        File file = new File(FileName);
        if (file.exists()) {
            System.out.println("\n*** Moviendo " + file + " ***");
            Path currentRelativePath = Paths.get("");
            String NewDir = currentRelativePath.toAbsolutePath().toString()
                    + File.separator + "src" + File.separator
                    + "main" + File.separator + file.getName();
            File OldFile = new File(NewDir);
            OldFile.delete();
            if (file.renameTo(new File(NewDir))) {
                System.out.println("\n*** Generado " + FileName + "***\n");
                executed = true;
            } else {
                System.out.println("\n*** No movido " + FileName + " ***\n");
            }

        } else {
            System.out.println("\n*** Codigo no existente ***\n");
        }
        return executed;
    }
}