/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi_graphique;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import taxi_DAO.Vehicule_taxi_DAO;
import taxi.metier.Vehicule_taxi;

/**
 *
 * @author Kamgo
 */
public class RechDescription extends javax.swing.JPanel {

    /**
     * Creates new form RechDescription
     */
    
   Vehicule_taxi_DAO taxiDAO=null;
   DefaultTableModel dft1 = new DefaultTableModel();
  
    public RechDescription() {
        initComponents();
        dft1.addColumn("numtaxi");
        dft1.addColumn("immatriculation");
        dft1.addColumn("prixkm");
        dft1.addColumn("carburant");
        dft1.addColumn("description");
        jTable1.setModel(dft1);

        
    }
   
   

    public void setTaxiDAO(Vehicule_taxi_DAO taxiDAO){
        this.taxiDAO=taxiDAO;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldescription = new javax.swing.JLabel();
        txtdescription = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        lbldescription.setText("description");

        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbldescription)
                        .addGap(92, 92, 92)
                        .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldescription)
                    .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
       try{ 
        String desRech=txtdescription.getText();
        List<Vehicule_taxi> alc= taxiDAO.rechdescption(desRech);
        int nr = dft1.getRowCount();
        for(int i=nr-1;i>=0;i--)dft1.removeRow(i);
        for(Vehicule_taxi taxi:alc){
            Vector v = new Vector();
            v.add(taxi.getIdtaxi());
            v.add(taxi.getImmatriculation());
            v.add(taxi.getPrixkm());
            v.add(taxi.getCarburant());
            v.add(taxi.getDescription());
            dft1.addRow(v);
           
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_txtdescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbldescription;
    private javax.swing.JTextField txtdescription;
    // End of variables declaration//GEN-END:variables
}
