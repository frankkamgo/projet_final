/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi_graphique;

import javax.swing.JOptionPane;
import taxi_DAO.Vehicule_taxi_DAO;
import taxi.metier.Vehicule_taxi;

/**
 *
 * @author KAmgo
 */
public class CreaTaxi extends javax.swing.JPanel {

    /**
     * Creates new form CreaCli
     */
    Vehicule_taxi_DAO taxiDAO=null;
    public CreaTaxi() {
        initComponents();
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

        lblimmatriculation = new javax.swing.JLabel();
        llblnumtaxi = new javax.swing.JLabel();
        lblprixkm = new javax.swing.JLabel();
        lbldescription = new javax.swing.JLabel();
        lblcarburant = new javax.swing.JLabel();
        txtnumtaxi = new javax.swing.JTextField();
        txtprixkm = new javax.swing.JTextField();
        txtimmatriculation = new javax.swing.JTextField();
        txtdescription = new javax.swing.JTextField();
        txtcarburant = new javax.swing.JTextField();
        btcreate = new javax.swing.JButton();

        lblimmatriculation.setText("immatriculation");

        llblnumtaxi.setText("numéro du taxi");

        lblprixkm.setText("prix par km");

        lbldescription.setText("description");

        lblcarburant.setText("carburant");

        txtnumtaxi.setEditable(false);
        txtnumtaxi.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumtaxi.setNextFocusableComponent(txtimmatriculation);
        txtnumtaxi.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumtaxi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumtaxiActionPerformed(evt);
            }
        });

        txtprixkm.setMinimumSize(new java.awt.Dimension(50, 20));
        txtprixkm.setNextFocusableComponent(txtdescription);
        txtprixkm.setPreferredSize(new java.awt.Dimension(150, 30));
        txtprixkm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprixkmActionPerformed(evt);
            }
        });

        txtimmatriculation.setMinimumSize(new java.awt.Dimension(50, 20));
        txtimmatriculation.setNextFocusableComponent(txtprixkm);
        txtimmatriculation.setPreferredSize(new java.awt.Dimension(150, 30));
        txtimmatriculation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtimmatriculationActionPerformed(evt);
            }
        });

        txtdescription.setMinimumSize(new java.awt.Dimension(50, 20));
        txtdescription.setNextFocusableComponent(txtcarburant);
        txtdescription.setPreferredSize(new java.awt.Dimension(150, 30));
        txtdescription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescriptionActionPerformed(evt);
            }
        });

        txtcarburant.setMinimumSize(new java.awt.Dimension(50, 20));
        txtcarburant.setPreferredSize(new java.awt.Dimension(150, 30));

        btcreate.setText("création");
        btcreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btcreateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblprixkm)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnumtaxi)
                            .addComponent(lblimmatriculation)
                            .addComponent(lbldescription)
                            .addComponent(lblcarburant))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcarburant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtprixkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtimmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btcreate)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnumtaxi)
                    .addComponent(txtnumtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblimmatriculation)
                    .addComponent(txtimmatriculation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblprixkm)
                    .addComponent(txtprixkm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldescription)
                    .addComponent(txtdescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcarburant)
                    .addComponent(txtcarburant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btcreate)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumtaxiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumtaxiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumtaxiActionPerformed

    private void btcreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btcreateActionPerformed
     try{  
       String immatriculation=txtimmatriculation.getText();
       int prixkm=Integer.parseInt(txtprixkm.getText());
       String description= txtdescription.getText();
       String carburant=txtcarburant.getText();
      
       Vehicule_taxi taxi = new Vehicule_taxi(0,immatriculation,carburant,prixkm,description);
       taxi=taxiDAO.create(taxi);
       txtnumtaxi.setText(""+taxi.getIdtaxi());
       JOptionPane.showMessageDialog(this,"taxi créé","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
               
    }//GEN-LAST:event_btcreateActionPerformed

    private void txtimmatriculationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtimmatriculationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtimmatriculationActionPerformed

    private void txtprixkmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprixkmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprixkmActionPerformed

    private void txtdescriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescriptionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcreate;
    private javax.swing.JLabel lblcarburant;
    private javax.swing.JLabel lbldescription;
    private javax.swing.JLabel lblimmatriculation;
    private javax.swing.JLabel lblprixkm;
    private javax.swing.JLabel llblnumtaxi;
    private javax.swing.JTextField txtcarburant;
    private javax.swing.JTextField txtdescription;
    private javax.swing.JTextField txtimmatriculation;
    private javax.swing.JTextField txtnumtaxi;
    private javax.swing.JTextField txtprixkm;
    // End of variables declaration//GEN-END:variables
}
