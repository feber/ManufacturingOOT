package org.manufacturingoot.view;

import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.manufacturingoot.model.DistributionOrder;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.SalesDepartment;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.service.DistributionOrderService;
import org.manufacturingoot.util.Constants;
import org.manufacturingoot.util.SessionUtil;

public class DistributionOrderForm extends javax.swing.JFrame {

    private ManufacturingOrder currentOrder;
    private DistributionOrder currentItem;
    private EntityManagerFactory emf;

    private ManufacturingOrderService mos;

    public DistributionOrderForm(EntityManagerFactory emf, DistributionOrder mo) {
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
        buttonSave = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        textId = new javax.swing.JTextField();
        textDate = new javax.swing.JFormattedTextField();
        comboManufacturing = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        textPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAddress = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Work Schedule");

        jLabel2.setText("Manufacturing Order");

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Id");

        textId.setEnabled(false);

        textDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        comboManufacturing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboManufacturingActionPerformed(evt);
            }
        });

        jLabel7.setText("Send Date");

        jLabel3.setText("Full Name");

        jLabel4.setText("Email");

        jLabel5.setText("Phone Number");

        jLabel8.setText("Address");

        textAddress.setColumns(20);
        textAddress.setRows(5);
        jScrollPane1.setViewportView(textAddress);

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
                        .addComponent(jLabel7)
                        .addGap(66, 66, 66)
                        .addComponent(textDate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textPhone)
                            .addComponent(textEmail)
                            .addComponent(textId)
                            .addComponent(comboManufacturing, 0, 300, Short.MAX_VALUE)
                            .addComponent(textName)
                            .addComponent(jScrollPane1))))
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
                    .addComponent(jLabel3)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        DistributionOrderService mos = new DistributionOrderService(emf);

        if (currentItem != null) {
            loadForm();
            try {
                mos.edit(currentItem);
                textDate.requestFocus();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal melakukan update");
            }
        } else {
            currentItem = new DistributionOrder();
            loadForm();
            mos.create(currentItem);
        }

        WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        dispatchEvent(event);
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void comboManufacturingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboManufacturingActionPerformed
        currentOrder = mos.findManufacturingOrderByColumn(
                "email", comboManufacturing.getSelectedItem().toString());
        textEmail.setText(currentOrder.getEmail());
    }//GEN-LAST:event_comboManufacturingActionPerformed

    private void loadForm() {
        try {
            String date = textDate.getText().trim();
            currentItem.setSendDate(
                    new SimpleDateFormat(Constants.DATE_FORMAT).parse(date));
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Date tidak dapat diolah");
        }
        currentItem.setAddress(textAddress.getText());
        currentItem.setEmail(textEmail.getText());
        currentItem.setFullName(textName.getText());
        currentItem.setPhoneNumber(textPhone.getText());
        currentItem.setOrder(currentOrder);
        currentItem.setCreatedBy((SalesDepartment) SessionUtil.getSession());
    }

    private void prepareForm() {
        if (currentItem == null) {
            textDate.setText(
                    new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date()));
        } else {
            textId.setText(currentItem.getId().toString());
            String date = new SimpleDateFormat(Constants.DATE_FORMAT).format(currentItem.getSendDate());
            textDate.setText(date);
            textAddress.setText(currentItem.getAddress());
            textEmail.setText(currentItem.getEmail());
            textName.setText(currentItem.getFullName());
            textPhone.setText(currentItem.getPhoneNumber());
            comboManufacturing.setSelectedItem(currentItem.getOrder());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox comboManufacturing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textAddress;
    private javax.swing.JFormattedTextField textDate;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textId;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPhone;
    // End of variables declaration//GEN-END:variables
}
