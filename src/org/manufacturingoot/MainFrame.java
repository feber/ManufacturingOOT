package org.manufacturingoot;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.manufacturingoot.model.SalesForecast;
import org.manufacturingoot.view.DistributionOrderPanel;
import org.manufacturingoot.view.ManufacturingOrderPanel;
import org.manufacturingoot.view.PartPanel;
import org.manufacturingoot.view.ProductPanel;
import org.manufacturingoot.view.SalesForecastPanel;
import org.manufacturingoot.view.WorkSchedulePanel;

public class MainFrame extends javax.swing.JFrame {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ManufacturingOOTPU");
    private ManufacturingOrderPanel manufacturingOrderPanel = new ManufacturingOrderPanel(emf);
    private DistributionOrderPanel distributionOrderPanel = new DistributionOrderPanel(emf);
    private PartPanel partPanel = new PartPanel(emf);
    private ProductPanel productPanel = new ProductPanel(emf);
    private SalesForecastPanel forecastPanel = new SalesForecastPanel(emf);
    private WorkSchedulePanel workSchedulePanel = new WorkSchedulePanel(emf);

    public MainFrame() {
        initComponents();
        cardPanel.add(manufacturingOrderPanel);
        cardPanel.add(distributionOrderPanel);
        cardPanel.add(partPanel);
        cardPanel.add(productPanel);
        cardPanel.add(forecastPanel);
        cardPanel.add(workSchedulePanel);

        setSize(800, 600);
    }

    private void setPanelVisibility(JPanel key) {
        JPanel[] panels = {
            manufacturingOrderPanel,
            distributionOrderPanel,
            partPanel,
            productPanel,
            forecastPanel,
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
        buttonDistributionOrder = new javax.swing.JButton();
        buttonManufacturingOrder1 = new javax.swing.JButton();
        buttonProduct = new javax.swing.JButton();
        buttonPart = new javax.swing.JButton();
        buttonWorkSchedule = new javax.swing.JButton();
        buttonSalesForecast = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cardPanel.setLayout(new java.awt.CardLayout());

        buttonDistributionOrder.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonDistributionOrder.setText("Distribution Order");
        buttonDistributionOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDistributionOrderActionPerformed(evt);
            }
        });

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

        buttonPart.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonPart.setText("Part");
        buttonPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPartActionPerformed(evt);
            }
        });

        buttonWorkSchedule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        buttonWorkSchedule.setText("Work Schedule");
        buttonWorkSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonWorkScheduleActionPerformed(evt);
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
                    .addComponent(buttonManufacturingOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPart, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonWorkSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonSalesForecast, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonDistributionOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonManufacturingOrder1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPart, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonSalesForecast, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonWorkSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

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

    private void buttonDistributionOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDistributionOrderActionPerformed
        setPanelVisibility(distributionOrderPanel);
    }//GEN-LAST:event_buttonDistributionOrderActionPerformed

    private void buttonManufacturingOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonManufacturingOrder1ActionPerformed
        setPanelVisibility(manufacturingOrderPanel);
    }//GEN-LAST:event_buttonManufacturingOrder1ActionPerformed

    private void buttonProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonProductActionPerformed
        setPanelVisibility(productPanel);
    }//GEN-LAST:event_buttonProductActionPerformed

    private void buttonPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPartActionPerformed
        setPanelVisibility(partPanel);
    }//GEN-LAST:event_buttonPartActionPerformed

    private void buttonWorkScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonWorkScheduleActionPerformed
        setPanelVisibility(workSchedulePanel);
    }//GEN-LAST:event_buttonWorkScheduleActionPerformed

    private void menuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemExitActionPerformed

    private void buttonSalesForecastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalesForecastActionPerformed
        setPanelVisibility(forecastPanel);
    }//GEN-LAST:event_buttonSalesForecastActionPerformed

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
    private javax.swing.JButton buttonDistributionOrder;
    private javax.swing.JButton buttonManufacturingOrder1;
    private javax.swing.JButton buttonPart;
    private javax.swing.JButton buttonProduct;
    private javax.swing.JButton buttonSalesForecast;
    private javax.swing.JButton buttonWorkSchedule;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JPanel menuPanel;
    // End of variables declaration//GEN-END:variables
}
