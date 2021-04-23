
package GUI;

import com.formdev.flatlaf.FlatDarkLaf;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Michal
 */
public class MainGui extends javax.swing.JFrame {

StructuresContainer sct = new StructuresContainer(); //Klasa sluzaca do przechowywania wszystki informacji ktore zostana wprowadzone w trakcie dzialania programu
graphPanell paintSurface = new graphPanell(sct); //Panel na ktorym przeprowadzana jest wizualizacja i wszystkie pozostale operacje
ButtonGroup checkBoxesGroup = new ButtonGroup(); //Grupa przyciskow do tworzenia/dodawania nowych elementow geometrycznych - utworzona aby uniemozliwic na przyklad dodawanie linii w trakcie gdy wlaczone jest dodawnaie punktow
int clickCounter =0; //Licznik pomocniczy stworzony bo to by liczyc kliki w powierzchnie i na ich pdostawie wyznaczac poczatek i koniec lini/tworzyc linie
boolean startOk = false; //Przechowuje wynik sprawdzenia czy wybrany (jako poczatek liniI) punkt znajduje sie w zbiorze punktow narysowanych na powierzchni
boolean endOk = false; //Przechowuje wynik sprawdzenia czy wybrany (jako koniec linii) punkt znajduje sie w zbiorze punktow narysowanych na powierzchni
Point startEdgePoint; //Zmienna tymczasowa - przechowujaca chwilowy poczatek lini
Point endEdgePoint; //Zmienna tymczasowa - przechowujaca chwilowy koniec linii

    public MainGui() {
        initComponents();
        this.checkBoxesGroup.add(addingPointBox);
        this.checkBoxesGroup.add(addingEdgeBox);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        operationsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        polygonsLabel = new javax.swing.JLabel();
        avaliableLabel = new javax.swing.JLabel();
        addingPointBox = new javax.swing.JCheckBox();
        addingEdgeBox = new javax.swing.JCheckBox();
        addNewPolygon = new javax.swing.JButton();
        crossingPointsButton = new javax.swing.JButton();
        convexHullButton = new javax.swing.JButton();
        randomPointsButton = new javax.swing.JButton();
        triangleAreaButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        rPanel = new javax.swing.JPanel();
        graphPanel = paintSurface;
        wizualizacjaL = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setDividerSize(0);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Wielokata", "Liczba punktow", "Liczba linii"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        polygonsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        polygonsLabel.setText("Wprowadzone wielokaty");

        avaliableLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        avaliableLabel.setText("Dostępne operacje");

        addingPointBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addingPointBox.setText("Włącz dodawanie punktow");

        addingEdgeBox.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addingEdgeBox.setText("Włącz dodawanie lini");

        addNewPolygon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        addNewPolygon.setText("<html><center>Dodaj nowy<br />wielokąt</center></html>");
        addNewPolygon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewPolygonActionPerformed(evt);
            }
        });

        crossingPointsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        crossingPointsButton.setText("<html><center>Wyznacz współrzędne<br />punktów przecięcia</center></html>");

        convexHullButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        convexHullButton.setText("<html><center>Wyznacz <br />otoczkę wypukłą</center></html>");

        randomPointsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        randomPointsButton.setText("<html><center>Wygeneruj losowe<br />punkty</center></html>");

        triangleAreaButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        triangleAreaButton.setText("<html><center>Oblicz pole<br />trójkąta</center></html>");
        triangleAreaButton.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout operationsPanelLayout = new javax.swing.GroupLayout(operationsPanel);
        operationsPanel.setLayout(operationsPanelLayout);
        operationsPanelLayout.setHorizontalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, operationsPanelLayout.createSequentialGroup()
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, operationsPanelLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(operationsPanelLayout.createSequentialGroup()
                                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(addingPointBox)
                                    .addComponent(addingEdgeBox, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(randomPointsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(operationsPanelLayout.createSequentialGroup()
                                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(crossingPointsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(convexHullButton, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(triangleAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(operationsPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(avaliableLabel)))
                .addGap(165, 165, 165))
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addNewPolygon, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(polygonsLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        operationsPanelLayout.setVerticalGroup(
            operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(operationsPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(polygonsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addNewPolygon, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(76, 76, 76)
                .addComponent(avaliableLabel)
                .addGap(18, 18, 18)
                .addComponent(addingPointBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addingEdgeBox)
                .addGap(56, 56, 56)
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(triangleAreaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(crossingPointsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(operationsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(convexHullButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(randomPointsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(operationsPanel);

        rPanel.setForeground(new java.awt.Color(255, 255, 255));

        graphPanel.setBackground(new java.awt.Color(204, 204, 204));
        graphPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        graphPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graphPanelMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                graphPanelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        wizualizacjaL.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        wizualizacjaL.setText("Wizualizacja");

        javax.swing.GroupLayout rPanelLayout = new javax.swing.GroupLayout(rPanel);
        rPanel.setLayout(rPanelLayout);
        rPanelLayout.setHorizontalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wizualizacjaL, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        rPanelLayout.setVerticalGroup(
            rPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(wizualizacjaL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        jSplitPane1.setRightComponent(rPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void graphPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphPanelMouseClicked
 
    }//GEN-LAST:event_graphPanelMouseClicked

    private void graphPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graphPanelMousePressed
        
       //Dodawanie punktow po kliknieciu w przestrzen odpowiedzialna za wizualizacje
       if (addingPointBox.isSelected()){
        Point p = MouseInfo.getPointerInfo().getLocation(); //Pobranie wspolrzednych punktu z obszaru panelu
        SwingUtilities.convertPointFromScreen(p, graphPanel); //Zrzutowanie na panel jesli ramka bylaby przesuwana,poniewaz zadne layouty nie sa wykorzystywane
        sct.Points.add(p);
        graphPanel.repaint();
       }
       
       //Dodawanie lini po klienciu w punkt istniejacy w przestrzeni odpowiedzialnej za wizualizacje 
       //Dodatkowo aby 'ulatwic' klikanie +/- 10px tolerancji w kazda ze stron
       if (addingEdgeBox.isSelected()){
           clickCounter++;
           if (clickCounter == 1){
               startEdgePoint = evt.getPoint();
               startOk = sct.isPointInSurface(startEdgePoint);
           }
           
           if (clickCounter == 2){
               if (startOk){
                  endEdgePoint = evt.getPoint();
                  endOk = sct.isPointInSurface(endEdgePoint);
                  if (endOk){
               Edge edgeTmp = new Edge(startEdgePoint, endEdgePoint);
               sct.Edges.add(edgeTmp);
               graphPanel.repaint();
               clickCounter = 0;
               startEdgePoint = null;
               endEdgePoint = null;
               endOk = false;
               startOk = false;
              //        System.out.println("Dodano");
               }
               else{
                   startOk = false;
                   startEdgePoint = null;
               }
              
           }
           
       }
           if (clickCounter >= 3){
               clickCounter = 0;
               startEdgePoint = null;
               endEdgePoint = null;
               endOk = false;
               startOk = false;
           }
       }
    }//GEN-LAST:event_graphPanelMousePressed

    private void addNewPolygonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewPolygonActionPerformed
    
    }//GEN-LAST:event_addNewPolygonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
                try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception ex){
            System.out.println("Error");
        }
                
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGui().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewPolygon;
    private javax.swing.JCheckBox addingEdgeBox;
    private javax.swing.JCheckBox addingPointBox;
    private javax.swing.JLabel avaliableLabel;
    private javax.swing.JButton convexHullButton;
    private javax.swing.JButton crossingPointsButton;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTable jTable1;
    private javax.swing.JPanel operationsPanel;
    private javax.swing.JLabel polygonsLabel;
    javax.swing.JPanel rPanel;
    private javax.swing.JButton randomPointsButton;
    private javax.swing.JButton triangleAreaButton;
    private javax.swing.JLabel wizualizacjaL;
    // End of variables declaration//GEN-END:variables
}
