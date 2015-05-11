package org.manufacturingoot;

import java.awt.event.WindowEvent;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.manufacturingoot.view.ManufacturingOrderPanel;
import org.manufacturingoot.view.ProductPanel;
import org.manufacturingoot.view.WorkSchedulePanel;

public class ProductionFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private ManufacturingOrderPanel manufacturingOrderPanel;
    private ProductPanel productPanel;
    private WorkSchedulePanel workSchedulePanel;

    public ProductionFrame(EntityManagerFactory emf) {
        initComponents();
        this.emf = emf;

        manufacturingOrderPanel = new ManufacturingOrderPanel(emf);
        productPanel = new ProductPanel(emf);
        workSchedulePanel = new WorkSchedulePanel(emf);

        cardPanel.add(manufacturingOrderPanel);
        cardPanel.add(productPanel);
        cardPanel.add(workSchedulePanel);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void setPanelVisibility(JPanel key) {
        JPanel[] panels = {
            manufacturingOrderPanel,
            productPanel,
            workSchedulePanel
        };

        for (int i = 0; i < panels.length; i++) {
            panels[i].setVisible(false);
            if (key.equals(panels[i])) {
                panels[i].setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        buttonManufacturingOrder1 = new javax.swing.JButton();
        buttonProduct = new javax.swing.JButton();
        buttonWorkSchedule = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemLogOut = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Production Department");

        cardPanel.setLayout(new java.awt.CardLayout());

        buttonManufacturingOrder1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonManufacturingOrder1.setText("Manufacturing Order");
        buttonManufacturingOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonManufacturingOrder1ActionPerformed(evt);
            }
        });

        buttonProduct.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonProduct.setText("Product");
        buttonProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonProductActionPerformed(evt);
            }
        });

        buttonWorkSchedule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonWorkSchedule.setText("Work Schedule");
        buttonWorkSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWorkScheduleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonManufacturingOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonWorkSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonManufacturingOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWorkSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        menuItemLogOut.setText("Log out");
        menuItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogOutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogOut);

        menuItemExit.setText("Exit");
        menuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemExit);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonManufacturingOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManufacturingOrder1ActionPerformed
        setPanelVisibility(manufacturingOrderPanel);
    }//GEN-LAST:event_buttonManufacturingOrder1ActionPerformed

    private void buttonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductActionPerformed
        setPanelVisibility(productPanel);
    }//GEN-LAST:event_buttonProductActionPerformed

    private void buttonWorkScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWorkScheduleActionPerformed
        setPanelVisibility(workSchedulePanel);
    }//GEN-LAST:event_buttonWorkScheduleActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void menuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogOutActionPerformed
        new LoginFrame().setVisible(true);
        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        dispatchEvent(event);
    }//GEN-LAST:event_menuItemLogOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonManufacturingOrder1;
    private javax.swing.JButton buttonProduct;
    private javax.swing.JButton buttonWorkSchedule;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLogOut;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
