/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rizalord.inner;

import Data.ProductCart;
import com.rizalord.models.Transaction_Model;
import java.awt.Image;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class OrderFrame extends javax.swing.JFrame {

    ArrayList<ProductCart> cart ;
    String username ;
    Transaction_Model trans = new Transaction_Model();
    
    public OrderFrame(ArrayList<ProductCart> list , String uname , int totalPrice) {
        initComponents();
        setVisible(true);
        setTitle("Go Cure - Order");
        
        this.username = uname;
        setLocationRelativeTo(null);
        cart = list;
        
        
//        timer schedule
        _timerSecondSchedule();
        
//        do transaction
        trans.addNewTransaction(cart, username);
        
//        count row 
        int row = trans.checkRow();
        
//        check transaction
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                if(!trans.checkTransaction(username)){
                    
                    if(row != trans.checkRow()){
                        System.out.println("stop");
                        setVisible(false);
                        SuccessTransaction suc = new SuccessTransaction(totalPrice);
                    }else{
                        System.out.println("stop");
                        setVisible(false);
                        FailedTransaction fail = new FailedTransaction();
                    }
                    
                    timer.cancel();
                    timer.purge();
                }else{
                    System.out.println("ada mas");
                }
            }
        };
        
        timer.scheduleAtFixedRate(task, 1000, 1000);
       
    }
    
    
    
    
    

    protected void _timerSecondSchedule(){
        Timer timer = new Timer();
        
        TimerTask task;
        task = new TimerTask() {
            
            private int count = 0;
            
            @Override
            public void run() {
                
                count++;
                
                if(count == 1){
                    secondText.setText("Please wait a Second");
                }else if(count == 2){
                    secondText.setText("Please wait a Second.");
                }else if(count == 3){
                    secondText.setText("Please wait a Second..");
                }else{
                    secondText.setText("Please wait a Second...");
                    count = 0;
                }
                
                
            }
        };
        
        
        timer.scheduleAtFixedRate(task, 1000, 1000);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        secondText = new javax.swing.JLabel();
        loadingLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(231, 223, 221));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Your Transaction is On Proggress");

        secondText.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        secondText.setText("Please wait a Second");

        loadingLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Assets/img/load2.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(secondText))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(loadingLabel)))
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(secondText)
                .addGap(26, 26, 26)
                .addComponent(loadingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderFrame(new ArrayList() , "root" , 100000);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loadingLabel;
    private javax.swing.JLabel secondText;
    // End of variables declaration//GEN-END:variables
}