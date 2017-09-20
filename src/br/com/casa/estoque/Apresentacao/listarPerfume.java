
package br.com.casa.estoque.Apresentacao;

import br.com.casa.estoque.Controlador.Controlador;
import br.com.casa.estoque.Dao.IDao;
import br.com.casa.estoque.Entidades.Perfume;
import br.com.casa.estoque.fabrica.Factory;
import java.io.File;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class listarPerfume extends javax.swing.JInternalFrame {

    
    public listarPerfume() {
        initComponents();
        listarPerfume();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jAdicionar = new javax.swing.JTextField();
        jContador = new javax.swing.JSpinner();
        jButtonAdicionar = new javax.swing.JButton();

        setTitle("Perfumes");

        jList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Tipo", "Quantidade", "Preço", "Descrição"
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

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jContador.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jButtonAdicionar.setText("Adicionar");
        jButtonAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jContador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAdicionar))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ((DefaultTableModel) jList.getModel()).setNumRows(0); 
        jList.updateUI();
        listarPerfume();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Controlador con = new Controlador();
        
        try {
            
            String codigo = jCodigo.getText();
            
            con.removerPerfume(codigo);
            
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Preencha Corretamente");
        } catch(Throwable t){
            JOptionPane.showMessageDialog(null, "Erro");
        }
        
        JOptionPane.showMessageDialog(null, "Removido");
        
        ((DefaultTableModel) jList.getModel()).setNumRows(0); 
        jList.updateUI();
        listarPerfume();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarActionPerformed
        Controlador con = new Controlador();
        
        try {
            
            String codigo=jAdicionar.getText();
            int quantidade=Integer.parseInt(jContador.getValue().toString());
     
            if(codigo.equals("nato")&&quantidade==1){
                
                JOptionPane.showMessageDialog(null, "Java sempre será maior que python");
                
            }
            
            con.adicionarPerfumeExistene(codigo, quantidade);
            
        } catch (NullPointerException e) {
        
            JOptionPane.showMessageDialog(null, "Preencha corretamente");
                    
        }
        
        ((DefaultTableModel) jList.getModel()).setNumRows(0); 
        jList.updateUI();
        listarPerfume();
        
    }//GEN-LAST:event_jButtonAdicionarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAdicionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAdicionar;
    private javax.swing.JTextField jCodigo;
    private javax.swing.JSpinner jContador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

   
    private void listarPerfume() {
        try {
           
            
            File file = new File("\\Projeto\\Perfume");
            File fileList[] = file.listFiles();
            
                       
            
            IDao<Perfume> daoPerfume = Factory.getDao(Perfume.class);
            
            for (File fileList1 : fileList) {
                Perfume perfumeX = daoPerfume.search(fileList1.getName());
                DefaultTableModel listaPerfume = (DefaultTableModel) jList.getModel();
                listaPerfume.addRow(new String[]{perfumeX.getCodePerfume(), perfumeX.getNome(),perfumeX.getTipo(),
                    String.valueOf(perfumeX.getQuantidade()), String.valueOf(perfumeX.getPreco()), perfumeX.getDescricao()});
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, "Não tem perfume cadastrado");
            
            this.dispose();
        }
    
}
}