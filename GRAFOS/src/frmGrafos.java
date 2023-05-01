
import javax.swing.*;
import java.util.ArrayList;
public class frmGrafos extends javax.swing.JFrame {
 Grafo G;
 Grafo H;
 
    /** Creates new form Formulario */
    public frmGrafos() {
        initComponents();
        G=new Grafo();
        H=new Grafo();        
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnCargarGrafo = new javax.swing.JToggleButton();
        ImprimirGrafo = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jta = new javax.swing.JTextArea();
        jButton9 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("GRAFOS DIRIGIDOS");

        btnCargarGrafo.setText("Leer Grafo");
        btnCargarGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarGrafoActionPerformed(evt);
            }
        });

        ImprimirGrafo.setText("Imprimir Grafo");
        ImprimirGrafo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImprimirGrafoActionPerformed(evt);
            }
        });

        jta.setColumns(20);
        jta.setRows(5);
        jScrollPane1.setViewportView(jta);

        jButton9.setText("DFS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton5.setText("BFS");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setText("PRUEBAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Metodos");

        jMenuItem1.setText("GradoDeEntradaDeVerticeX");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("GRADO DE SALIDA DE X");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("CANTIDAD DE ARCOS");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem4.setText("MOSTRAR CAMINOS");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("MOSTRAR COSTOS");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setText("SON IGUALES");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem7.setText("TIENE CICLOS");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setText("CANTIDAD_CAMINOS V2");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem9.setText("MOSTRAR CAMINOS V2");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(btnCargarGrafo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ImprimirGrafo)))
                                .addGap(82, 82, 82)
                                .addComponent(jButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel1)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ImprimirGrafo)
                            .addComponent(btnCargarGrafo))
                        .addGap(93, 93, 93)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCargarGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarGrafoActionPerformed
        // TODO add your handling code here:        
        G.crearVertice("A");             
        G.crearVertice("B");         
        G.crearVertice("C");     
        G.crearVertice("D");
        G.crearVertice("E");
      //  G.crearVertice("F");
        
        /*H.crearVertice("A");             
        H.crearVertice("B");         
        H.crearVertice("C");  */   
        //H.crearVertice("D");
        
        
       /* G.insertarArco("A", "B", 2);
        G.insertarArco("A", "D", 8);        
        G.insertarArco("B", "C", 3);
        G.insertarArco("B", "D", 4);        
        G.insertarArco("C", "A", 5);
        G.insertarArco("D", "C", 7);
        G.insertarArco("E", "D", 10);*/
        
        /* G.insertarArco("A", "C", 7);        
        G.insertarArco("A", "B", 5);
        G.insertarArco("C", "B", 4);        
        G.insertarArco("B", "C", 5); */ 
        //-----------------------------GRAFO--------------------------
       /* G.insertarArco("A", "E", 2);        
        G.insertarArco("A", "D", 15);
        G.insertarArco("A", "B", 4);        
        G.insertarArco("A", "C", 10);
        G.insertarArco("C", "B", 5);
        G.insertarArco("B", "D", 5);
        G.insertarArco("E", "D", 10);*/
     //---------------------PARA EL SON IGUALES prueba1-------------------------
        
      /*G.insertarArco("A", "B", 15);
        G.insertarArco("B", "D", 5);        
        G.insertarArco("D", "C", 10);
         G.insertarArco("C", "A", 20);*/
       /* H.insertarArco("B", "A", 15);
        H.insertarArco("A", "C", 20);        
        H.insertarArco("D", "C", 10);
        H.insertarArco("B", "D", 5);*/
     //---------------------PARA EL SON IGUALES prueba2-------------------------    
       /* G.insertarArco("A", "B", 10);
        G.insertarArco("B", "C", 15);  
        
        H.insertarArco("A", "B", 10);
        H.insertarArco("B", "C", 15);*/
    //---------------------PARA EL CANTIDAD DE CAMINOS AGAIN CUADERNO-----------
       /* G.insertarArco("A", "B",6 );
        G.insertarArco("B", "D", 5);        
        G.insertarArco("D", "E", 30);
        G.insertarArco("A", "D", 20);
        G.insertarArco("A", "C", 15);
        G.insertarArco("C", "D", 25);
        G.insertarArco("A", "F", 40);*/
        G.insertarArco("A", "B", 15);
        G.insertarArco("A", "C", 10);
        G.insertarArco("C", "D", 20);
        G.insertarArco("B", "D", 30);
        G.insertarArco("E", "B",40);
    }//GEN-LAST:event_btnCargarGrafoActionPerformed

    private void ImprimirGrafoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImprimirGrafoActionPerformed
        // TODO add your handling code here:   
        //G.ordenarVertices();
        G.imprimir(jta);
    }//GEN-LAST:event_ImprimirGrafoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (DFS):");        
        G.ordenarVerticesAlf();                    
        G.DFS(A,jta);
       
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String A=JOptionPane.showInputDialog("Vertice inicial (BFS):");        
        G.ordenarVerticesAlf();        
        G.BFS(A,jta);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
       String x=JOptionPane.showInputDialog("Vertice= ");
        JOptionPane.showMessageDialog(rootPane,"Grado de entrada: "+
                G.gradoDeEntradaDeVertice(x));
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        String x=JOptionPane.showInputDialog("Vertice= ");
        JOptionPane.showMessageDialog(rootPane,"Grado de salida: "+
                G.gradoDeSalidaDeVertice(x));
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(rootPane,"Cantidad de arcos: "+
                G.cantidadDeAristas());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        // TODO add your handling code here:
        String x=JOptionPane.showInputDialog("Introduzca vertice origen");
        String y=JOptionPane.showInputDialog("Introduzca vertice destino");
        G.MostrarCaminos(x, y, jta);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
         String x=JOptionPane.showInputDialog("Introduzca vertice origen");
        String y=JOptionPane.showInputDialog("Introduzca vertice destino");

   
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
    
        JOptionPane.showMessageDialog(rootPane,G.sonIguales(G, H));
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
      String x=JOptionPane.showInputDialog("Vertice de partida= ");
      JOptionPane.showMessageDialog(rootPane, G.tieneCiclos(x));
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        String x=JOptionPane.showInputDialog("X=");
        String y=JOptionPane.showInputDialog("Y=");
        JOptionPane.showMessageDialog(rootPane,G.cantidadDeCaminosAgain(x, y));
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
         String x=JOptionPane.showInputDialog("X=");
        String y=JOptionPane.showInputDialog("Y=");
     G.mostrarCaminos(x, y, jta);
  
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String x=JOptionPane.showInputDialog("X=");
        String y=JOptionPane.showInputDialog("Y=");
        G.MostrarCaminosConCosto(x, y, jta);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmGrafos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton ImprimirGrafo;
    private javax.swing.JToggleButton btnCargarGrafo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jta;
    // End of variables declaration//GEN-END:variables

}
