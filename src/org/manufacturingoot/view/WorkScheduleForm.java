package org.manufacturingoot.view;

import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.manufacturingoot.model.ManufacturingOrder;
import org.manufacturingoot.model.WorkSchedule;
import org.manufacturingoot.service.ManufacturingOrderService;
import org.manufacturingoot.service.WorkScheduleService;
import org.manufacturingoot.util.Constants;

public class WorkScheduleForm extends javax.swing.JFrame {

    private ManufacturingOrder currentOrder;
    private WorkSchedule currentItem;
    private EntityManagerFactory emf;
    private boolean updateData;

    private ManufacturingOrderService mos;

    public WorkScheduleForm(EntityManagerFactory emf, WorkSchedule mo) {
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
        textStartDate = new javax.swing.JFormattedTextField();
        comboManufacturing = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textDueDate = new javax.swing.JFormattedTextField();
        textFinishDate = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Work Schedule");

        jLabel2.setText("Manufacturing Order");

        jLabel4.setText("Finish Date");

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        jLabel6.setText("Id");

        textId.setEnabled(false);

        textStartDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        comboManufacturing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboManufacturingActionPerformed(evt);
            }
        });

        jLabel7.setText("Start Date");

        jLabel8.setText("Due Date");

        textDueDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

        textFinishDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));

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
                            .addComponent(jLabel1))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textId)
                            .addComponent(comboManufacturing, 0, 300, Short.MAX_VALUE)
                            .addComponent(textFinishDate)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDueDate)
                            .addComponent(textStartDate))))
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
                    .addComponent(textStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textDueDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textFinishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonSave)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        WorkScheduleService mos = new WorkScheduleService(emf);

        if (currentItem != null) {
            loadForm();
            try {
                mos.edit(currentItem);
                textStartDate.requestFocus();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Gagal melakukan update");
            }
        } else {
            currentItem = new WorkSchedule();
            loadForm();
            mos.create(currentItem);
        }

        if (updateData) {
            WindowEvent event = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            dispatchEvent(event);
        } else {
            currentItem = null;
            prepareForm();
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void comboManufacturingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboManufacturingActionPerformed
        currentOrder = mos.findManufacturingOrderByColumn(
                "email", comboManufacturing.getSelectedItem().toString());
        System.out.println(currentOrder);
    }//GEN-LAST:event_comboManufacturingActionPerformed

    private void loadForm() {
        String date = "";
        try {
            date = textStartDate.getText().trim();
            currentItem.setStartDate(
                    new SimpleDateFormat(Constants.DATE_FORMAT).parse(date));
            date = textDueDate.getText().trim();
            currentItem.setDueDate(
                    new SimpleDateFormat(Constants.DATE_FORMAT).parse(date));
            date = textFinishDate.getText().trim();
            currentItem.setFinishDate(
                    new SimpleDateFormat(Constants.DATE_FORMAT).parse(date));
        } catch (ParseException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Date tidak dapat diolah");
        }
        currentItem.setOrder(currentOrder);
    }

    private void prepareForm() {
        if (currentItem == null) {
            textStartDate.setText(
                    new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date()));
            textDueDate.setText(
                    new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date()));
            textFinishDate.setText(
                    new SimpleDateFormat(Constants.DATE_FORMAT).format(new Date()));
        } else {
            updateData = true;
            String date = "";

            textId.setText(currentItem.getId().toString());
            date = new SimpleDateFormat(Constants.DATE_FORMAT).format(currentItem.getStartDate());
            textStartDate.setText(date);
            date = new SimpleDateFormat(Constants.DATE_FORMAT).format(currentItem.getDueDate());
            textDueDate.setText(date);
            date = new SimpleDateFormat(Constants.DATE_FORMAT).format(currentItem.getFinishDate());
            textFinishDate.setText(date);
            comboManufacturing.setSelectedItem(currentItem.getOrder());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonSave;
    private javax.swing.JComboBox comboManufacturing;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField textDueDate;
    private javax.swing.JFormattedTextField textFinishDate;
    private javax.swing.JTextField textId;
    private javax.swing.JFormattedTextField textStartDate;
    // End of variables declaration//GEN-END:variables
}
