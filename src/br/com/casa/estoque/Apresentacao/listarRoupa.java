package br.com.casa.estoque.Apresentacao;

import br.com.casa.estoque.Controlador.Controlador;
import br.com.casa.estoque.Dao.IDao;
import br.com.casa.estoque.Entidades.Roupa;
import br.com.casa.estoque.fabrica.Factory;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class listarRoupa extends javax.swing.JInternalFrame {

    
    public listarRoupa() {
        initComponents();
        listarRoupa();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setTitle("Roupas");

        jList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tamanho", "Quantidade", "Descrição", "Preço", "Tipo"
            }
        ));
        jScrollPane1.setViewportView(jList);

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Atualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jButton2)
                .addGap(36, 36, 36)
                .addComponent(jButton1)
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton3))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ((DefaultTableModel) jList.getModel()).setNumRows(0); 
        jList.updateUI();
        listarRoupa();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
           Controlador con = new Controlador();
        
        try {
            
            String codigo = jCodigo.getText();
            
            con.removerRoupa(codigo);
            
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Preencha Corretamente");
        } catch(Throwable t){
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        JOptionPane.showMessageDialog(null, "Removido");

        ((DefaultTableModel) jList.getModel()).setNumRows(0); 
        jList.updateUI();
        listarRoupa();

        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void listarRoupa() {
        try {
           
            
            File file = new File("\\Projeto\\Roupa");
            File fileList[] = file.listFiles();
            
                       
            
            IDao<Roupa> daoRoupa = Factory.getDao(Roupa.class);
            
            for (File fileList1 : fileList) {
                Roupa roupaX = daoRoupa.search(fileList1.getName());
                DefaultTableModel listaRoupa = (DefaultTableModel) jList.getModel();

                listaRoupa.addRow(new String[]{roupaX.getCodeRoupa(), String.valueOf(roupaX.getTamanho()), String.valueOf(roupaX.getQuantidade()),
                    roupaX.getDescricao(), String.valueOf(roupaX.getPreco()), roupaX.getTipo()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Não tem roupa cadastrada");
            
            this.dispose();
        }
    }

    
}
