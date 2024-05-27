/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modelosPdv.views;

import ModeloPdv.models.Cliente;
import ModeloPdv.models.ItemVenda;
import ModeloPdv.models.Produtos;
import ModeloPdv.models.Vendas;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modeloPdv.DAO.ClienteDAO;
import modeloPdv.DAO.ProdutosDAO;
import modeloPdv.DAO.VendaDAO;
import modelosPdv.views.TelaConsultaCliente;
import modelosPdv.views.TelaInicial;

/**
 *
 * @author Daniel
 */
public class TelaVendas extends javax.swing.JFrame {

    Vendas objVenda = new Vendas();
    float valorTotal = 0;

    /**
     * Creates new form TelaVendas
     */
    public TelaVendas() {
        initComponents();
        carregarProdutos();

        cboProdutos.removeAllItems();

        ArrayList<Produtos> ListaProdutos = ProdutosDAO.listar();

        for (Produtos item : ListaProdutos) {
            cboProdutos.addItem(item);
        }
    }

    private void carregarProdutos() {
        ArrayList<Produtos> produtos = ProdutosDAO.listar();
        DefaultComboBoxModel<Produtos> model = new DefaultComboBoxModel<>();
        for (Produtos produto : produtos) {
            model.addElement(produto);
        }
        cboProdutos.setModel(model);
    }

    public void adicionarProdutoNaVenda() {
        Produtos itemSelecionado = (Produtos) cboProdutos.getSelectedItem();
        if (itemSelecionado != null) {
            int qtd = (Integer) spnQtd.getValue();
            if (qtd > 0) {
                DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
                float valorUnitario = (float) itemSelecionado.getPrecoVenda();
                float valorLinha = valorUnitario * qtd;
                modelo.addRow(new Object[]{
                    itemSelecionado.getId(),
                    itemSelecionado.getNomeProduto(),
                    qtd,
                    valorUnitario,
                    valorLinha
                });
                valorTotal += valorLinha;
                lblValorTotal.setText(String.format("%.2f", valorTotal));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Quantidade deve ser maior que zero.");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Nenhum produto selecionado.");
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
        lblCPF = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        btnBuscarCPF = new javax.swing.JButton();
        lblNomeCliente = new javax.swing.JLabel();
        cboProdutos = new javax.swing.JComboBox<Produtos>();
        spnQtd = new javax.swing.JSpinner();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenda = new javax.swing.JTable();
        btnExcluir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblValorTotal = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tela de Vendas");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblCPF.setText("CPF :");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnBuscarCPF.setText("Buscar");
        btnBuscarCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarCPFActionPerformed(evt);
            }
        });

        cboProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboProdutosActionPerformed(evt);
            }
        });

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAdicionarMouseClicked(evt);
            }
        });
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        tblVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Produto", "Nome", "Qtd", "Vlr Unitario"
            }
        ));
        jScrollPane1.setViewportView(tblVenda);

        btnExcluir.setText("Excluir");
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirMouseClicked(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Valor Total:");

        lblValorTotal.setBackground(new java.awt.Color(255, 255, 255));
        lblValorTotal.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConfirmarMouseClicked(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Sair");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 34, Short.MAX_VALUE)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblCPF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnBuscarCPF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblNomeCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAdicionar))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(276, 276, 276)
                                .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCancelar, btnConfirmar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCPF)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnBuscarCPF))))
                    .addComponent(btnAdicionar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(lblValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed
    //DUVIDA NESSA PARTE!!!!!!!
    private void btnBuscarCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarCPFActionPerformed
        String cpf = txtCPF.getText().replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            JOptionPane.showMessageDialog(rootPane, "Digite um CPF válido!");
            return;
        }

        Cliente objRetorno = ClienteDAO.buscarPorCpf(cpf);

        if (objRetorno != null) {
            lblNomeCliente.setText(objRetorno.getNomeCliente());
            objVenda.setIdCliente(objRetorno.getIdCliente());
            JOptionPane.showMessageDialog(rootPane, "CPF Encontrado: " + txtCPF.getText());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado!");
        }

    }//GEN-LAST:event_btnBuscarCPFActionPerformed

    private void cboProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboProdutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboProdutosActionPerformed

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == btnCancelar) {
            int result = JOptionPane.showOptionDialog(rootPane, "Deseja realmente cancelar?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, "Não");
            if (result == JOptionPane.YES_OPTION) {
                TelaInicial telaInicial = new TelaInicial();
                telaInicial.setVisible(true);
                this.dispose();
            } else {

            }
        }
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void btnExcluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == btnExcluir) {
            int result = JOptionPane.showOptionDialog(rootPane, "Deseja realmente excluir?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Sim", "Não"}, "Não");
            if (result == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(rootPane, "Excluido!");
            } else {

            }
        }
    }//GEN-LAST:event_btnExcluirMouseClicked

    private void btnConfirmarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConfirmarMouseClicked
        // TODO add your handling code here:
        if (evt.getSource() == btnConfirmar) {
            JOptionPane.showMessageDialog(rootPane, "Confirmado!");
        }
    }//GEN-LAST:event_btnConfirmarMouseClicked

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed

        Produtos produtoSelecionado = (Produtos) cboProdutos.getSelectedItem();
        if (produtoSelecionado != null) {
            DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
            modelo.addRow(new String[]{
                String.valueOf(produtoSelecionado.getId()),
                produtoSelecionado.getNomeProduto(),
                String.valueOf(Integer.parseInt(spnQtd.getValue().toString())),
                String.valueOf(produtoSelecionado.getPrecoVenda())
            });

            double valorUnitario = produtoSelecionado.getPrecoVenda();
            int qtd = Integer.parseInt(spnQtd.getValue().toString());

            double valorLinha = valorUnitario * qtd;

            valorTotal += valorLinha;

            lblValorTotal.setText(String.valueOf(valorTotal));
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAdicionarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAdicionarMouseClicked

    }//GEN-LAST:event_btnAdicionarMouseClicked

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        try {
            String cpf = txtCPF.getText().replaceAll("[^0-9]", "");

            if (cpf.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "CPF não pode estar em branco!");
                return;
            }

            if (cpf.length() != 11) {
                JOptionPane.showMessageDialog(rootPane, "Digite um CPF válido!");
                return;
            }

            Cliente objRetorno = ClienteDAO.buscarPorCpf(cpf);

            if (objRetorno == null) {
                JOptionPane.showMessageDialog(rootPane, "Cliente não encontrado!");
                return;
            }

            DefaultTableModel modelo = (DefaultTableModel) tblVenda.getModel();
            ArrayList<ItemVenda> listaItens = new ArrayList<>();

            for (int i = 0; i < modelo.getRowCount(); i++) {
                int idProduto = Integer.parseInt(modelo.getValueAt(i, 0).toString());
                int qtdProduto = Integer.parseInt(modelo.getValueAt(i, 2).toString());
                double vlrUnitario = Double.parseDouble(modelo.getValueAt(i, 3).toString());

                ItemVenda novoItem = new ItemVenda(idProduto, qtdProduto, vlrUnitario);
                listaItens.add(novoItem);
            }

            Vendas objVenda = new Vendas();
            objVenda.setValorVenda((float) Double.parseDouble(lblValorTotal.getText()));
            objVenda.setDataVenda(new Date());
            objVenda.setIdCliente(objRetorno.getIdCliente());
            objVenda.setListaItens(listaItens);

            boolean retorno = VendaDAO.salvar(objVenda);

            if (retorno) {
                JOptionPane.showMessageDialog(rootPane, "Venda realizada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Falha na venda!");
            }
        } catch (Exception ex) {
            Logger.getLogger(TelaVendas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        int linhaSelecionada = tblVenda.getSelectedRow();
    if (linhaSelecionada >= 0) {
    DefaultTableModel model = (DefaultTableModel) tblVenda.getModel();


    int idVenda = Integer.parseInt(model.getValueAt(linhaSelecionada, 0).toString());

    model.removeRow(linhaSelecionada);

    float valorLinha = Float.parseFloat(model.getValueAt(linhaSelecionada, 4).toString());
    valorTotal -= valorLinha;
    lblValorTotal.setText(String.format("%.2f", valorTotal)); 

    boolean isDeleted = VendaDAO.excluir(idVenda);
    if (isDeleted) {
        JOptionPane.showMessageDialog(rootPane, "Item de venda excluído com sucesso!");
    } else {
        JOptionPane.showMessageDialog(rootPane, "Falha ao excluir item de venda.");
    }
} else {
    JOptionPane.showMessageDialog(rootPane, "Selecione uma linha para excluir.");
}
        
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnBuscarCPF;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JComboBox<Produtos> cboProdutos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCPF;
    private javax.swing.JLabel lblNomeCliente;
    private javax.swing.JLabel lblValorTotal;
    private javax.swing.JSpinner spnQtd;
    private javax.swing.JTable tblVenda;
    private javax.swing.JFormattedTextField txtCPF;
    // End of variables declaration//GEN-END:variables

    private static class Venda {

        public Venda() {
        }

        private void setIdCliente(int idCliente) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}
