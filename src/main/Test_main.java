package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test_main {
    
    public static void main(String[] args) {
        
        // Este codigo compila cambios de CUP y JFlex
        /* Test_main compiler = new Test_main();
        compiler.compile_files();
        boolean mvAL = move_file("Lexer.java");
        boolean mvAS = move_file("Parser.java");
        boolean mvSym = move_file("sym.java"); */
        
        
        // Esta función lo que hace es probar el CUP y Jflex a un archivo de texto 
        probandoLenguaje(); 
        // AnalizadorSintactico p = new AnalizadorSintactico();
        
    }
     
    public static void probandoLenguaje(){
        File archivo = new File("./src/test/test.txt");
        try {
            Parser parser = new Parser(new Lexer(new FileReader(archivo)));
            parser.parse();
    	if (true) {
      		Node root = Parser.father;
      		Graficar(recorrido(root));
      		System.out.println("AST Generado");
    	} else {
    		System.out.println("No se genero el AST");
    	}
        } catch (Exception e) {
               System.out.println("Error en el main");
               System.out.println(e);
        }
        
        /* try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            System.out.println("Texto: \n"+ST);
            int cont = 1;
            Lexer lexico = new Lexer(new BufferedReader(new StringReader(ST)));
            Parser sintactico = new Parser(lexico);
            
            sintactico.parse();
        } catch (Exception e) {
            System.out.println("Hubo un pedo en el parser ewe");
            System.out.println(e);
        }*/
        
    }
    
    private static String recorrido(Node root) {
  		String cuerpo = "";
    	for (Node child : root.children) {
    		// System.out.println("hola");
      		if (!(child.getTag().equals("vacio"))) {
        		cuerpo += "\"" + root.getId()+ ". " + root.getTag()+ " = " + root.getValue()+
        			"\"->\""+ child.getId()+". " + child.getTag()+ " = " + child.getValue()+ "\""  + "\n";
        		cuerpo += recorrido(child);
      		}
    	}
    	return cuerpo;
    }
    
    private static void Graficar(String cadena) {
        FileWriter fw = null;
    	PrintWriter pw = null;
    	String archivo = "AST.dot";
    	try {
            fw = new FileWriter(archivo);
            pw = new PrintWriter(fw);
            pw.println("digraph G {");
            pw.println(cadena);
            pw.println("\n}");
            fw.close();
    	} catch (Exception e) {
            System.out.println(e);
    	}
    	try {
            String cmd = "dot -Tpng AST.dot -o fotoAST.png"; 
            Runtime.getRuntime().exec(cmd);
    	} catch (IOException ioe) {
            System.out.println(ioe);
    	}
    }
    
    
    public void compile_files() {
        String LexicFile = "";
        String SyntacticFile = "";
        
        System.out.println("\n*** Procesando archivo default ***\n");
        LexicFile = "./src/main/Lexer.flex";
        SyntacticFile = "./src/main/Parser.cup";
        
        String[] LexicArray = {LexicFile};
        String[] SyntacticArray = {"-parser", "Parser", SyntacticFile};
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