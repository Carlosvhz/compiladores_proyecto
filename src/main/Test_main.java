package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test_main {
    
    public static void main(String[] args) {
         
        // Este codigo compila cambios de CUP y JFlex
        Test_main compiler = new Test_main();
        compiler.compile_files();
        boolean mvAL = move_file("Lexer.java");
        boolean mvAS = move_file("Parser.java");
        boolean mvSym = move_file("sym.java");
        
        // Esta función lo que hace es probar el CUP y Jflex a un archivo de texto 
        // test(); 
         
   }
     
    public static void test(){
        try {
            File archivo = new File("./src/test/test4.txt");
            Parser parser = new Parser(new Lexer(new FileReader(archivo)));
            parser.parse();
            if (true) {
                    Node root = Parser.father;
                    Graph(recorrido(root));
                    System.out.println("AST Generado de manera exitosa");
            } else {
                    System.out.println("No se genero el AST, porfavor comprobar el archivo");
            }
        } catch (Exception e) {
               System.out.println(e);
        }
    }
    
    private static String recorrido(Node root) {
  		String cuerpo = "";
    	for (Node child : root.children) {
      		if (!(child.getTag().equals("vacio"))) {
        		
                if (root.getValue()!=null) 
                    cuerpo += "\""+root.getId()+". "+ root.getTag()+" = " + root.getValue();
                else 
                    cuerpo += "\""+root.getId()+". "+ root.getTag()+"\"->\"";

                if (child.getValue()!=null)
                    cuerpo += child.getId()+". "+child.getTag()+" = "+child.getValue()+"\""+"\n";

                else 
                    cuerpo += child.getId()+". "+child.getTag()+"\""+"\n";
                
                
                cuerpo += recorrido(child);
      		}
    	}
    	return cuerpo;
    }
    
    private static void Graph(String cadena) {
        FileWriter fw = null;
    	PrintWriter pw = null;
    	String archivo = "./src/AST/AST.dot";
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