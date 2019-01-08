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
public class AtualizarConsultorio extends javax.swing.JFrame {

    /**
     * Creates new form AtualizarConsultorio
     */
    public AtualizarConsultorio() {
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

        PanelConsultorio = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblnome = new javax.swing.JLabel();
        txtrazao = new javax.swing.JTextField();
        txtcnpj = new javax.swing.JFormattedTextField();
        lblcnpj = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtnomefantasia = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtcidade = new javax.swing.JTextField();
        txtrua = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnumero = new javax.swing.JTextField();
        txtbairro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUf = new javax.swing.JComboBox();
        lblendereco = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcep = new javax.swing.JFormattedTextField();
        jPanel9 = new javax.swing.JPanel();
        txtemail = new javax.swing.JTextField();
        lblemail = new javax.swing.JLabel();
        txttelefone = new javax.swing.JFormattedTextField();
        lbltelefone = new javax.swing.JLabel();
        txtcelular = new javax.swing.JFormattedTextField();
        lbltelefone1 = new javax.swing.JLabel();
        BotaoSalvarConsultorio = new javax.swing.JButton();
        BotaoCancelarrConsultorio = new javax.swing.JButton();
        labeltarefa = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 134));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1160, 600));

        PanelConsultorio.setPreferredSize(new java.awt.Dimension(1160, 610));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consultorio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lblnome.setText("Razão Socia:l");

        try {
            txtcnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtcnpj.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtcnpjFocusLost(evt);
            }
        });
        txtcnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcnpjActionPerformed(evt);
            }
        });

        lblcnpj.setText("CNPJ:");

        jLabel7.setText("Nome Fantasia:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnome)
                            .addComponent(lblcnpj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtrazao)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnomefantasia)))
                .addGap(50, 50, 50))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcnpj)
                    .addComponent(txtcnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnome)
                    .addComponent(txtrazao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtnomefantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel3.setText("Rua:");

        jLabel4.setText("Número:");

        jLabel5.setText("Bairro:");

        jLabel6.setText("UF:");

        txtUf.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        lblendereco.setText("Cidade:");

        jLabel2.setText("Cep:");

        try {
            txtcep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(lblendereco))
                .addGap(17, 17, 17)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtnumero, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtbairro, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(txtcidade)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtrua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(txtcep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtUf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });

        lblemail.setText("E-mail:");

        try {
            txttelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbltelefone.setText("Telefone:");

        try {
            txtcelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbltelefone1.setText("Celular:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(lbltelefone)
                .addGap(18, 18, 18)
                .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltelefone1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblemail)
                .addGap(22, 22, 22)
                .addComponent(txtemail)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblemail))
                .addGap(13, 13, 13)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltelefone1))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txttelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbltelefone)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BotaoSalvarConsultorio.setBackground(new java.awt.Color(255, 255, 255));
        BotaoSalvarConsultorio.setForeground(new java.awt.Color(0, 0, 204));
        BotaoSalvarConsultorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fundamento/resource/tick.png"))); // NOI18N
        BotaoSalvarConsultorio.setText("Atualizar");

        BotaoCancelarrConsultorio.setBackground(new java.awt.Color(255, 255, 255));
        BotaoCancelarrConsultorio.setForeground(new java.awt.Color(0, 0, 204));
        BotaoCancelarrConsultorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/fundamento/resource/cross.png"))); // NOI18N
        BotaoCancelarrConsultorio.setText("Cancelar");
        BotaoCancelarrConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarrConsultorioActionPerformed(evt);
            }
        });

        labeltarefa.setFont(new java.awt.Font("Felix Titling", 0, 24)); // NOI18N
        labeltarefa.setText("Atualizar Consultorio");

        jPanel10.setBackground(new java.awt.Color(0, 57, 69));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelConsultorioLayout = new javax.swing.GroupLayout(PanelConsultorio);
        PanelConsultorio.setLayout(PanelConsultorioLayout);
        PanelConsultorioLayout.setHorizontalGroup(
            PanelConsultorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelConsultorioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoSalvarConsultorio)
                .addGap(18, 18, 18)
                .addComponent(BotaoCancelarrConsultorio)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelConsultorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelConsultorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltarefa))
                .addContainerGap())
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelConsultorioLayout.setVerticalGroup(
            PanelConsultorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelConsultorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labeltarefa)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(PanelConsultorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoCancelarrConsultorio)
                    .addComponent(BotaoSalvarConsultorio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 768, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(PanelConsultorio, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(PanelConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcnpjFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtcnpjFocusLost

    }//GEN-LAST:event_txtcnpjFocusLost

    private void txtcnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcnpjActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void BotaoCancelarrConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarrConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoCancelarrConsultorioActionPerformed

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
            java.util.logging.Logger.getLogger(AtualizarConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AtualizarConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AtualizarConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AtualizarConsultorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarConsultorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoCancelarrConsultorio;
    private javax.swing.JButton BotaoSalvarConsultorio;
    private javax.swing.JPanel PanelConsultorio;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel labeltarefa;
    private javax.swing.JLabel lblcnpj;
    private javax.swing.JLabel lblemail;
    private javax.swing.JLabel lblendereco;
    private javax.swing.JLabel lblnome;
    private javax.swing.JLabel lbltelefone;
    private javax.swing.JLabel lbltelefone1;
    private javax.swing.JComboBox txtUf;
    private javax.swing.JTextField txtbairro;
    private javax.swing.JFormattedTextField txtcelular;
    private javax.swing.JFormattedTextField txtcep;
    private javax.swing.JTextField txtcidade;
    private javax.swing.JFormattedTextField txtcnpj;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnomefantasia;
    private javax.swing.JTextField txtnumero;
    private javax.swing.JTextField txtrazao;
    private javax.swing.JTextField txtrua;
    private javax.swing.JFormattedTextField txttelefone;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the BotaoCancelarrConsultorio
     */
    public javax.swing.JButton getBotaoCancelarrConsultorio() {
        return BotaoCancelarrConsultorio;
    }

    /**
     * @param BotaoCancelarrConsultorio the BotaoCancelarrConsultorio to set
     */
    public void setBotaoCancelarrConsultorio(javax.swing.JButton BotaoCancelarrConsultorio) {
        this.BotaoCancelarrConsultorio = BotaoCancelarrConsultorio;
    }

    /**
     * @return the BotaoSalvarConsultorio
     */
    public javax.swing.JButton getBotaoSalvarConsultorio() {
        return BotaoSalvarConsultorio;
    }

    /**
     * @param BotaoSalvarConsultorio the BotaoSalvarConsultorio to set
     */
    public void setBotaoSalvarConsultorio(javax.swing.JButton BotaoSalvarConsultorio) {
        this.BotaoSalvarConsultorio = BotaoSalvarConsultorio;
    }

    /**
     * @return the PanelConsultorio
     */
    public javax.swing.JPanel getPanelConsultorio() {
        return PanelConsultorio;
    }

    /**
     * @param PanelConsultorio the PanelConsultorio to set
     */
    public void setPanelConsultorio(javax.swing.JPanel PanelConsultorio) {
        this.PanelConsultorio = PanelConsultorio;
    }

    /**
     * @return the jLabel2
     */
    public javax.swing.JLabel getjLabel2() {
        return jLabel2;
    }

    /**
     * @param jLabel2 the jLabel2 to set
     */
    public void setjLabel2(javax.swing.JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    /**
     * @return the jLabel3
     */
    public javax.swing.JLabel getjLabel3() {
        return jLabel3;
    }

    /**
     * @param jLabel3 the jLabel3 to set
     */
    public void setjLabel3(javax.swing.JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    /**
     * @return the jLabel4
     */
    public javax.swing.JLabel getjLabel4() {
        return jLabel4;
    }

    /**
     * @param jLabel4 the jLabel4 to set
     */
    public void setjLabel4(javax.swing.JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    /**
     * @return the jLabel5
     */
    public javax.swing.JLabel getjLabel5() {
        return jLabel5;
    }

    /**
     * @param jLabel5 the jLabel5 to set
     */
    public void setjLabel5(javax.swing.JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    /**
     * @return the jLabel6
     */
    public javax.swing.JLabel getjLabel6() {
        return jLabel6;
    }

    /**
     * @param jLabel6 the jLabel6 to set
     */
    public void setjLabel6(javax.swing.JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    /**
     * @return the jLabel7
     */
    public javax.swing.JLabel getjLabel7() {
        return jLabel7;
    }

    /**
     * @param jLabel7 the jLabel7 to set
     */
    public void setjLabel7(javax.swing.JLabel jLabel7) {
        this.jLabel7 = jLabel7;
    }

    /**
     * @return the jPanel10
     */
    public javax.swing.JPanel getjPanel10() {
        return jPanel10;
    }

    /**
     * @param jPanel10 the jPanel10 to set
     */
    public void setjPanel10(javax.swing.JPanel jPanel10) {
        this.jPanel10 = jPanel10;
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
     * @return the jPanel8
     */
    public javax.swing.JPanel getjPanel8() {
        return jPanel8;
    }

    /**
     * @param jPanel8 the jPanel8 to set
     */
    public void setjPanel8(javax.swing.JPanel jPanel8) {
        this.jPanel8 = jPanel8;
    }

    /**
     * @return the jPanel9
     */
    public javax.swing.JPanel getjPanel9() {
        return jPanel9;
    }

    /**
     * @param jPanel9 the jPanel9 to set
     */
    public void setjPanel9(javax.swing.JPanel jPanel9) {
        this.jPanel9 = jPanel9;
    }

    /**
     * @return the labeltarefa
     */
    public javax.swing.JLabel getLabeltarefa() {
        return labeltarefa;
    }

    /**
     * @param labeltarefa the labeltarefa to set
     */
    public void setLabeltarefa(javax.swing.JLabel labeltarefa) {
        this.labeltarefa = labeltarefa;
    }

    /**
     * @return the lblcnpj
     */
    public javax.swing.JLabel getLblcnpj() {
        return lblcnpj;
    }

    /**
     * @param lblcnpj the lblcnpj to set
     */
    public void setLblcnpj(javax.swing.JLabel lblcnpj) {
        this.lblcnpj = lblcnpj;
    }

    /**
     * @return the lblemail
     */
    public javax.swing.JLabel getLblemail() {
        return lblemail;
    }

    /**
     * @param lblemail the lblemail to set
     */
    public void setLblemail(javax.swing.JLabel lblemail) {
        this.lblemail = lblemail;
    }

    /**
     * @return the lblendereco
     */
    public javax.swing.JLabel getLblendereco() {
        return lblendereco;
    }

    /**
     * @param lblendereco the lblendereco to set
     */
    public void setLblendereco(javax.swing.JLabel lblendereco) {
        this.lblendereco = lblendereco;
    }

    /**
     * @return the lblnome
     */
    public javax.swing.JLabel getLblnome() {
        return lblnome;
    }

    /**
     * @param lblnome the lblnome to set
     */
    public void setLblnome(javax.swing.JLabel lblnome) {
        this.lblnome = lblnome;
    }

    /**
     * @return the lbltelefone
     */
    public javax.swing.JLabel getLbltelefone() {
        return lbltelefone;
    }

    /**
     * @param lbltelefone the lbltelefone to set
     */
    public void setLbltelefone(javax.swing.JLabel lbltelefone) {
        this.lbltelefone = lbltelefone;
    }

    /**
     * @return the lbltelefone1
     */
    public javax.swing.JLabel getLbltelefone1() {
        return lbltelefone1;
    }

    /**
     * @param lbltelefone1 the lbltelefone1 to set
     */
    public void setLbltelefone1(javax.swing.JLabel lbltelefone1) {
        this.lbltelefone1 = lbltelefone1;
    }

    /**
     * @return the txtUf
     */
    public javax.swing.JComboBox getTxtUf() {
        return txtUf;
    }

    /**
     * @param txtUf the txtUf to set
     */
    public void setTxtUf(javax.swing.JComboBox txtUf) {
        this.txtUf = txtUf;
    }

    /**
     * @return the txtbairro
     */
    public javax.swing.JTextField getTxtbairro() {
        return txtbairro;
    }

    /**
     * @param txtbairro the txtbairro to set
     */
    public void setTxtbairro(javax.swing.JTextField txtbairro) {
        this.txtbairro = txtbairro;
    }

    /**
     * @return the txtcelular
     */
    public javax.swing.JFormattedTextField getTxtcelular() {
        return txtcelular;
    }

    /**
     * @param txtcelular the txtcelular to set
     */
    public void setTxtcelular(javax.swing.JFormattedTextField txtcelular) {
        this.txtcelular = txtcelular;
    }

    /**
     * @return the txtcep
     */
    public javax.swing.JFormattedTextField getTxtcep() {
        return txtcep;
    }

    /**
     * @param txtcep the txtcep to set
     */
    public void setTxtcep(javax.swing.JFormattedTextField txtcep) {
        this.txtcep = txtcep;
    }

    /**
     * @return the txtcidade
     */
    public javax.swing.JTextField getTxtcidade() {
        return txtcidade;
    }

    /**
     * @param txtcidade the txtcidade to set
     */
    public void setTxtcidade(javax.swing.JTextField txtcidade) {
        this.txtcidade = txtcidade;
    }

    /**
     * @return the txtcnpj
     */
    public javax.swing.JFormattedTextField getTxtcnpj() {
        return txtcnpj;
    }

    /**
     * @param txtcnpj the txtcnpj to set
     */
    public void setTxtcnpj(javax.swing.JFormattedTextField txtcnpj) {
        this.txtcnpj = txtcnpj;
    }

    /**
     * @return the txtemail
     */
    public javax.swing.JTextField getTxtemail() {
        return txtemail;
    }

    /**
     * @param txtemail the txtemail to set
     */
    public void setTxtemail(javax.swing.JTextField txtemail) {
        this.txtemail = txtemail;
    }

    /**
     * @return the txtnomefantasia
     */
    public javax.swing.JTextField getTxtnomefantasia() {
        return txtnomefantasia;
    }

    /**
     * @param txtnomefantasia the txtnomefantasia to set
     */
    public void setTxtnomefantasia(javax.swing.JTextField txtnomefantasia) {
        this.txtnomefantasia = txtnomefantasia;
    }

    /**
     * @return the txtnumero
     */
    public javax.swing.JTextField getTxtnumero() {
        return txtnumero;
    }

    /**
     * @param txtnumero the txtnumero to set
     */
    public void setTxtnumero(javax.swing.JTextField txtnumero) {
        this.txtnumero = txtnumero;
    }

    /**
     * @return the txtrazao
     */
    public javax.swing.JTextField getTxtrazao() {
        return txtrazao;
    }

    /**
     * @param txtrazao the txtrazao to set
     */
    public void setTxtrazao(javax.swing.JTextField txtrazao) {
        this.txtrazao = txtrazao;
    }

    /**
     * @return the txtrua
     */
    public javax.swing.JTextField getTxtrua() {
        return txtrua;
    }

    /**
     * @param txtrua the txtrua to set
     */
    public void setTxtrua(javax.swing.JTextField txtrua) {
        this.txtrua = txtrua;
    }

    /**
     * @return the txttelefone
     */
    public javax.swing.JFormattedTextField getTxttelefone() {
        return txttelefone;
    }

    /**
     * @param txttelefone the txttelefone to set
     */
    public void setTxttelefone(javax.swing.JFormattedTextField txttelefone) {
        this.txttelefone = txttelefone;
    }




}