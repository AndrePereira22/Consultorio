/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fundamento.view;

/**
 *
 * @author Glenda Alves de Lima
 */
public class BuscarContaApagar extends javax.swing.JFrame {

    /**
     * Creates new form BuscarContaApagar
     */
    public BuscarContaApagar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labeltarefa1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtdiario = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtvalor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelacontapagar = new javax.swing.JTable();
        botaoadicionar = new javax.swing.JButton();
        botaofechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(100, 134));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1160, 500));

        labeltarefa1.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labeltarefa1.setText("contas a pagar");

        jPanel7.setBackground(new java.awt.Color(0, 57, 69));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        txtdiario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Diario", "Semanal", "Mensal" }));

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        jLabel1.setText("R$");

        txtvalor.setBackground(new java.awt.Color(153, 255, 153));
        txtvalor.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        txtvalor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        txtvalor.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtvalor, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtvalor, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabelacontapagar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabelacontapagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, "", null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Descrição", "Data Vencimento", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelacontapagar.setRowHeight(25);
        tabelacontapagar.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tabelacontapagar.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(tabelacontapagar);

        botaoadicionar.setBackground(new java.awt.Color(255, 255, 255));
        botaoadicionar.setForeground(new java.awt.Color(0, 0, 204));
        botaoadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fundamento/resource/plus.png"))); // NOI18N
        botaoadicionar.setText("Adicionar");
        botaoadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoadicionarActionPerformed(evt);
            }
        });

        botaofechar.setBackground(new java.awt.Color(255, 255, 255));
        botaofechar.setForeground(new java.awt.Color(0, 0, 204));
        botaofechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fundamento/resource/cross.png"))); // NOI18N
        botaofechar.setText("Fechar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 195, Short.MAX_VALUE)
                .addComponent(txtdiario, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoadicionar)
                .addGap(18, 18, 18)
                .addComponent(botaofechar)
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(labeltarefa1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 556, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
                    .addContainerGap())
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaofechar)
                        .addComponent(botaoadicionar)
                        .addComponent(txtdiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(332, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(labeltarefa1)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(129, 129, 129)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoadicionarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoadicionarActionPerformed

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
            java.util.logging.Logger.getLogger(BuscarContaApagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarContaApagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarContaApagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarContaApagar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarContaApagar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoadicionar;
    private javax.swing.JButton botaofechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labeltarefa1;
    private javax.swing.JTable tabelacontapagar;
    private javax.swing.JComboBox<String> txtdiario;
    private javax.swing.JTextField txtvalor;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the botaoadicionar
     */
    public javax.swing.JButton getBotaoadicionar() {
        return botaoadicionar;
    }

    /**
     * @param botaoadicionar the botaoadicionar to set
     */
    public void setBotaoadicionar(javax.swing.JButton botaoadicionar) {
        this.botaoadicionar = botaoadicionar;
    }

    /**
     * @return the botaofechar
     */
    public javax.swing.JButton getBotaofechar() {
        return botaofechar;
    }

    /**
     * @param botaofechar the botaofechar to set
     */
    public void setBotaofechar(javax.swing.JButton botaofechar) {
        this.botaofechar = botaofechar;
    }

    /**
     * @return the jLabel1
     */
    public javax.swing.JLabel getjLabel1() {
        return jLabel1;
    }

    /**
     * @param jLabel1 the jLabel1 to set
     */
    public void setjLabel1(javax.swing.JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    /**
     * @return the jPanel1
     */
    public javax.swing.JPanel getjPanel1() {
        return jPanel1;
    }

    /**
     * @param jPanel1 the jPanel1 to set
     */
    public void setjPanel1(javax.swing.JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    /**
     * @return the jPanel7
     */
    public javax.swing.JPanel getjPanel7() {
        return jPanel7;
    }

    /**
     * @param jPanel7 the jPanel7 to set
     */
    public void setjPanel7(javax.swing.JPanel jPanel7) {
        this.jPanel7 = jPanel7;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the labeltarefa1
     */
    public javax.swing.JLabel getLabeltarefa1() {
        return labeltarefa1;
    }

    /**
     * @param labeltarefa1 the labeltarefa1 to set
     */
    public void setLabeltarefa1(javax.swing.JLabel labeltarefa1) {
        this.labeltarefa1 = labeltarefa1;
    }

    /**
     * @return the tabelacontapagar
     */
    public javax.swing.JTable getTabelacontapagar() {
        return tabelacontapagar;
    }

    /**
     * @param tabelacontapagar the tabelacontapagar to set
     */
    public void setTabelacontapagar(javax.swing.JTable tabelacontapagar) {
        this.tabelacontapagar = tabelacontapagar;
    }

    /**
     * @return the txtdiario
     */
    public javax.swing.JComboBox<String> getTxtdiario() {
        return txtdiario;
    }

    /**
     * @param txtdiario the txtdiario to set
     */
    public void setTxtdiario(javax.swing.JComboBox<String> txtdiario) {
        this.txtdiario = txtdiario;
    }

    /**
     * @return the txtvalor
     */
    public javax.swing.JTextField getTxtvalor() {
        return txtvalor;
    }

    /**
     * @param txtvalor the txtvalor to set
     */
    public void setTxtvalor(javax.swing.JTextField txtvalor) {
        this.txtvalor = txtvalor;
    }




}
