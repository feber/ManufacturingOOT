package org.manufacturingoot.view;

import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.Product;
import org.manufacturingoot.model.ProductionDepartment;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.service.ProductService;
import org.manufacturingoot.util.SessionUtil;

public class ProductForm extends javax.swing.JFrame {

    private ManufacturingOrder currentOrder;
    private Product currentItem;
    private EntityManagerFactory emf;
    private boolean updateData;

    private ManufacturingOrderService mos;

    public ProductForm(EntityManagerFactory emf, Product mo) {
        initComponents();
        this.emf = emf;
        currentItem = mo;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mos = new ManufacturingOrderService(emf);
        loadComboManufacturing();
        prepareForm();

        setLocationRelativeTo(null);
    }

    private void loadComboManufacturing() {
        for (ManufacturingOrder mo : mos.findManufacturingOrderEntities()) {
            comboManufacturing.addItem(mo);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        buttonSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        comboManufacturing = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        textPrice = new javax.swing.JTextField();
        textWeight = new javax.swing.JTextField();
        textCost = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        buttonPart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Work Schedule");

        jLabel2.setText("Manufacturing Order");

        jLabel4.setText("Weight");

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Id");

        textId.setEnabled(false);

        comboManufacturing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboManufacturingActionPerformed(evt);
            }
        });

        jLabel7.setText("Name");

        jLabel8.setText("Price");

        textPrice.setText("0");

        textWeight.setText("0");

        textCost.setText("0");
        textCost.setEnabled(false);

        jLabel3.setText("Cost");

        buttonPart.setText("Set Parts");
        buttonPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSave))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textId)
                            .addComponent(comboManufacturing, 0, 300, Short.MAX_VALUE)
                            .addComponent(textName)
                            .addComponent(textPrice)
                            .addComponent(textWeight)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(textCost)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonPart)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboManufacturing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textWeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(buttonPart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(buttonSave)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        ProductService mos = new ProductService(emf);

        if (currentItem != null) {
            try {
                mos.edit(currentItem);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal melakukan update");
            }
        } else {
            currentItem = new Product();
            loadForm();
            mos.create(currentItem);
        }

        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        dispatchEvent(event);
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void comboManufacturingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboManufacturingActionPerformed
        currentOrder = mos.findManufacturingOrderByColumn(
                "email", comboManufacturing.getSelectedItem().toString());
        System.out.println(currentOrder);
    }//GEN-LAST:event_comboManufacturingActionPerformed

    private void buttonPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPartActionPerformed
        if (currentItem.getId() == null) {
            ProductService ps = new ProductService(emf);
            loadForm();
            ps.create(currentItem);
        }
        new ChoosePartPanel(emf, currentItem).setVisible(true);
    }//GEN-LAST:event_buttonPartActionPerformed

    private void loadForm() {
        currentItem.setName(textName.getText());
        currentItem.setPrice(Double.parseDouble(textPrice.getText()));
        currentItem.setProductionCost(Double.parseDouble(textCost.getText()));
        currentItem.setWeight(Double.parseDouble(textWeight.getText()));
        currentItem.setOrder(currentOrder);
        currentItem.setCreatedBy((ProductionDepartment) SessionUtil.getSession());
    }

    private void prepareForm() {
        if (currentItem == null) {
            currentItem = new Product();
        } else {
            textId.setText(currentItem.getId().toString());
            textName.setText(currentItem.getName());
            textPrice.setText(currentItem.getPrice().toString());
            textCost.setText(currentItem.getProductionCost().toString());
            textWeight.setText(currentItem.getWeight().toString());
            comboManufacturing.setSelectedItem(currentItem.getOrder());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonPart;
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox comboManufacturing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField textCost;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPrice;
    private javax.swing.JTextField textWeight;
    // End of variables declaration//GEN-END:variables
}
