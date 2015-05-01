package org.manufacturingoot;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.manufacturingoot.view.ManufacturingOrderPanel;
import org.manufacturingoot.view.PartPanel;
import org.manufacturingoot.view.WorkSchedulePanel;

public class MainFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");

    public MainFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemManufacturingOrder = new javax.swing.JMenuItem();
        menuItemPart = new javax.swing.JMenuItem();
        menuItemWorkSchedule = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        menuItemManufacturingOrder.setText("Manufacturing Order");
        menuItemManufacturingOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemManufacturingOrderActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemManufacturingOrder);

        menuItemPart.setText("Part");
        menuItemPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPartActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemPart);

        menuItemWorkSchedule.setText("Work Schedule");
        menuItemWorkSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemWorkScheduleActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemWorkSchedule);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemManufacturingOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemManufacturingOrderActionPerformed
        setContentPane(new ManufacturingOrderPanel(emf));
        revalidate();
    }//GEN-LAST:event_menuItemManufacturingOrderActionPerformed

    private void menuItemPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPartActionPerformed
        setContentPane(new PartPanel(emf));
        revalidate();
    }//GEN-LAST:event_menuItemPartActionPerformed

    private void menuItemWorkScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemWorkScheduleActionPerformed
        setContentPane(new WorkSchedulePanel(emf));
        revalidate();
    }//GEN-LAST:event_menuItemWorkScheduleActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemManufacturingOrder;
    private javax.swing.JMenuItem menuItemPart;
    private javax.swing.JMenuItem menuItemWorkSchedule;
    // End of variables declaration//GEN-END:variables
}
