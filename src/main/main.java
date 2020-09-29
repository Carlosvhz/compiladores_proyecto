/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFileChooser;

public class main extends javax.swing.JFrame {

    public static File newfile;
    
    public main() {
        initComponents();
    }
    
    public void test(){
        try {
            File archivo = newfile;
            Parser parser = new Parser(new Lexer(new FileReader(archivo)));
            parser.parse();
            Node root = Parser.father;
            Graph(recorrido(root));
            output.setText("AST Generado de manera exitosa");
        } catch (Exception e) {
            output.setText("Hubo un error sintáctico\nNo se genero el AST, porfavor comprobar el archivo");
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
            System.out.println(e);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        output = new javax.swing.JTextArea();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        input.setEditable(false);
        input.setColumns(20);
        input.setRows(5);
        jScrollPane1.setViewportView(input);

        output.setEditable(false);
        output.setColumns(20);
        output.setRows(5);
        jScrollPane2.setViewportView(output);

        label1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label1.setText("Input:");

        label2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label2.setText("Output:");

        jButton1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton1.setText("Generar Árbol");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jButton2.setText("Limpiar Output");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jMenu1.setText("File");

        Open.setText("Open File");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(10, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1)))
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            newfile = file;
            try {
                // What to do with the file, e.g. display it in a TextArea
                input.read(new FileReader(file.getAbsolutePath()), null);
                output.setText("");
            } catch (IOException ex) {
                System.out.println("Conflicto al acceder al archivo " + file.getAbsolutePath());
            }
        } else {
            System.out.println("El acceso al archivo fue cancelado por el usuario.");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            output.setText("");
            test();
        } catch (Exception ex) {
            System.out.println("No se pudo acceder al archivo.");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        output.setText("");
    }//GEN-LAST:event_jButton2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Open;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JTextArea input;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JTextArea output;
    // End of variables declaration//GEN-END:variables
}
