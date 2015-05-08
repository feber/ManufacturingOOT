package org.manufacturingoot;

import java.awt.event.WindowEvent;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.manufacturingoot.view.DistributionOrderPanel;
import org.manufacturingoot.view.SalesForecastPanel;

public class SalesFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private SalesForecastPanel forecastPanel;
    private DistributionOrderPanel distributionOrderPanel;

    public SalesFrame(EntityManagerFactory emf) {
        initComponents();
        this.emf = emf;

        distributionOrderPanel = new DistributionOrderPanel(emf);
        forecastPanel = new SalesForecastPanel(emf);

        cardPanel.add(distributionOrderPanel);
        cardPanel.add(forecastPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }

    private void setPanelVisibility(JPanel key) {
        JPanel[] panels = {
            distributionOrderPanel,
            forecastPanel
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
        buttonDistributionOrder = new javax.swing.JButton();
        buttonSalesForecast = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemLogOut = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menutItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sales Department");

        cardPanel.setLayout(new java.awt.CardLayout());

        buttonDistributionOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonDistributionOrder.setText("Distribution Order");
        buttonDistributionOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDistributionOrderActionPerformed(evt);
            }
        });

        buttonSalesForecast.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonSalesForecast.setText("Sales Forecast");
        buttonSalesForecast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalesForecastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDistributionOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalesForecast, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonDistributionOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSalesForecast, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
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

        jMenu2.setText("Help");

        menutItemAbout.setText("About");
        jMenu2.add(menutItemAbout);

        menuBar.add(jMenu2);

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

    private void buttonDistributionOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDistributionOrderActionPerformed
        setPanelVisibility(distributionOrderPanel);
    }//GEN-LAST:event_buttonDistributionOrderActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void buttonSalesForecastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalesForecastActionPerformed
        setPanelVisibility(forecastPanel);
    }//GEN-LAST:event_buttonSalesForecastActionPerformed

    private void menuItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogOutActionPerformed
        new LoginFrame().setVisible(true);
        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        dispatchEvent(event);
    }//GEN-LAST:event_menuItemLogOutActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDistributionOrder;
    private javax.swing.JButton buttonSalesForecast;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLogOut;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JMenuItem menutItemAbout;
    // End of variables declaration//GEN-END:variables
}
