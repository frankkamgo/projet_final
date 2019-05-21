/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taxi_graphique;

import javax.swing.JOptionPane;
import taxi_DAO.Location_taxi_DAO;
import taxi.metier.Location_taxi;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;
import taxi.metier.Client_taxi;
import taxi.metier.Location_taxi;
/**
/**
 *
 * @author Kamgo
 */
public class Rechidlocation extends javax.swing.JPanel {

    /**
     * Creates new form recherche location
     */
     Location_taxi_DAO locationDAO=null;
    Location_taxi location=null;
    public Rechidlocation() {
        initComponents();
    }

    public void setLocationDAO( Location_taxi_DAO locationDAO){
        this.locationDAO=locationDAO;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbldatelocation = new javax.swing.JLabel();
        llblnumlocation = new javax.swing.JLabel();
        lblkmtotal = new javax.swing.JLabel();
        lblacompte = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        txtnumlocation = new javax.swing.JTextField();
        txtkmtotal = new javax.swing.JTextField();
        txtdate = new javax.swing.JTextField();
        txtacompte = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        btmaj = new javax.swing.JButton();
        btrech = new javax.swing.JButton();
        btdel = new javax.swing.JButton();
        lblidclient = new javax.swing.JLabel();
        txtidclient = new javax.swing.JTextField();
        lblidtaxi = new javax.swing.JLabel();
        txtidtaxi = new javax.swing.JTextField();
        lblidadrdebut = new javax.swing.JLabel();
        txtidadrdebut = new javax.swing.JTextField();
        ldlidadrfin = new javax.swing.JLabel();
        txtidadrfin = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 0));

        lbldatelocation.setText("date_location");

        llblnumlocation.setText("numéro du location");

        lblkmtotal.setText("kmtotal");

        lblacompte.setText("acompte");

        lbltotal.setText("total");

        txtnumlocation.setMinimumSize(new java.awt.Dimension(50, 20));
        txtnumlocation.setNextFocusableComponent(txtdate);
        txtnumlocation.setPreferredSize(new java.awt.Dimension(150, 30));
        txtnumlocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumlocationActionPerformed(evt);
            }
        });

        txtkmtotal.setMinimumSize(new java.awt.Dimension(50, 20));
        txtkmtotal.setNextFocusableComponent(txtacompte);
        txtkmtotal.setPreferredSize(new java.awt.Dimension(150, 30));

        txtdate.setMinimumSize(new java.awt.Dimension(50, 20));
        txtdate.setNextFocusableComponent(txtkmtotal);
        txtdate.setPreferredSize(new java.awt.Dimension(150, 30));

        txtacompte.setMinimumSize(new java.awt.Dimension(50, 20));
        txtacompte.setNextFocusableComponent(txttotal);
        txtacompte.setPreferredSize(new java.awt.Dimension(150, 30));

        txttotal.setMinimumSize(new java.awt.Dimension(50, 20));
        txttotal.setPreferredSize(new java.awt.Dimension(150, 30));

        btmaj.setText("maj");
        btmaj.setPreferredSize(new java.awt.Dimension(150, 30));
        btmaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btmajActionPerformed(evt);
            }
        });

        btrech.setText("Rechercher");
        btrech.setPreferredSize(new java.awt.Dimension(150, 30));
        btrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btrechActionPerformed(evt);
            }
        });

        btdel.setText("Effacer");
        btdel.setPreferredSize(new java.awt.Dimension(150, 30));
        btdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btdelActionPerformed(evt);
            }
        });

        lblidclient.setText("id du client");

        lblidtaxi.setText("id du taxi");

        lblidadrdebut.setText("id adr debut ");

        ldlidadrfin.setText("id adr fin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(llblnumlocation)
                            .addComponent(lblacompte)
                            .addComponent(lbltotal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ldlidadrfin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblidadrdebut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblidtaxi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblidclient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbldatelocation, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txttotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtacompte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtkmtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtnumlocation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtidclient)
                            .addComponent(txtidtaxi)
                            .addComponent(txtidadrdebut)
                            .addComponent(txtidadrfin))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(lblkmtotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btmaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(llblnumlocation)
                    .addComponent(txtnumlocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbldatelocation)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblkmtotal)
                    .addComponent(txtkmtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblacompte)
                    .addComponent(txtacompte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotal)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidclient)
                    .addComponent(txtidclient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidtaxi)
                    .addComponent(txtidtaxi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidadrdebut)
                    .addComponent(txtidadrdebut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldlidadrfin)
                    .addComponent(txtidadrfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btmaj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btdel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btrech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumlocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumlocationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumlocationActionPerformed

    private void btmajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btmajActionPerformed
     try{  
       int numlocation=Integer.parseInt(txtnumlocation.getText());
       String dateloc = txtdate.getText();
        int day = Integer.parseInt(dateloc.substring(8, 10));
        int month = Integer.parseInt(dateloc.substring(5, 7));
        int year = Integer.parseInt(dateloc.substring(0, 4));
        System.out.println("Nous sommes le "+day+" "+month+" "+year);
        LocalDate date = LocalDate.of(year, month, day);
        System.out.println(""+date);
      int lblkmtotal=Integer.parseInt(txtkmtotal.getText());
           int lblacompte=Integer.parseInt(txtacompte.getText());
       int lbltotal=Integer.parseInt(txttotal.getText());
         int lblidclient=Integer.parseInt(txtidclient.getText());
     int lblidtaxi=Integer.parseInt(txtidtaxi.getText());
         int lblidadrdebut=Integer.parseInt(txtidadrdebut.getText());
        int ldlidadrfin=Integer.parseInt(txtidadrfin.getText());
       Location_taxi location = new  Location_taxi(numlocation,date,lblkmtotal,lblacompte,lbltotal,lblidclient,lblidtaxi,lblidadrdebut,ldlidadrfin);
       locationDAO.update(location);
       JOptionPane.showMessageDialog(this,"location mis à jour","succès",JOptionPane.INFORMATION_MESSAGE);
       
     }
     catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
               
    }//GEN-LAST:event_btmajActionPerformed

    private void btrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btrechActionPerformed
        try{
             int numlocation=Integer.parseInt(txtnumlocation.getText());
             location = locationDAO.read(numlocation);
             txtdate.setText(""+location.getDateloc());
             txtkmtotal.setText(""+location.getKmtotal());
             txtacompte.setText(""+location.getAcompte());
             txttotal.setText(""+location.getTotal());
             txtidclient.setText(""+location.getIdclient());
             txtidtaxi.setText(""+location.getIdtaxi());
             txtidadrdebut.setText(""+location.getIdadrdebuit());
             txtidadrfin.setText(""+location.getIdadrfin());
             JOptionPane.showMessageDialog(this,"location trouvé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btrechActionPerformed

    private void btdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btdelActionPerformed
        try{
             int numlocation=Integer.parseInt(txtnumlocation.getText());
             locationDAO.delete(location);
             txtnumlocation.setText("");
             txtdate.setText("");
             txtkmtotal.setText("");
             txtacompte.setText("");
             txttotal.setText("");
            txtidclient.setText("");
             txtidtaxi.setText("");
             txtidadrdebut.setText("");
             txtidadrfin.setText("");
             JOptionPane.showMessageDialog(this,"location effacé","succès",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERREUR",JOptionPane.ERROR_MESSAGE);
     }
    }//GEN-LAST:event_btdelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdel;
    private javax.swing.JButton btmaj;
    private javax.swing.JButton btrech;
    private javax.swing.JLabel lblacompte;
    private javax.swing.JLabel lbldatelocation;
    private javax.swing.JLabel lblidadrdebut;
    private javax.swing.JLabel lblidclient;
    private javax.swing.JLabel lblidtaxi;
    private javax.swing.JLabel lblkmtotal;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel ldlidadrfin;
    private javax.swing.JLabel llblnumlocation;
    private javax.swing.JTextField txtacompte;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtidadrdebut;
    private javax.swing.JTextField txtidadrfin;
    private javax.swing.JTextField txtidclient;
    private javax.swing.JTextField txtidtaxi;
    private javax.swing.JTextField txtkmtotal;
    private javax.swing.JTextField txtnumlocation;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables
}
