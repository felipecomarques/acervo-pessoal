package UI;

import BD.discosDAO;
import BD.livrosDAO;
import ItensAcervo.discos;
import ItensAcervo.livros;
import Relatorio.Relatorio;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ListaAcervo1 extends javax.swing.JFrame {

    public ListaAcervo1() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagens/agenda (2).png")).getImage());

        //Configurações da Tabela//
        DefaultTableModel modelo = (DefaultTableModel) JT_Livros.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
        JT_Livros.setRowSorter(sorter);

        DefaultTableModel modelo2 = (DefaultTableModel) JT_Discos.getModel();
        TableRowSorter<DefaultTableModel> sorter2 = new TableRowSorter<>(modelo2);
        JT_Discos.setRowSorter(sorter2);

        JT_Livros.getColumn("Código").setMinWidth(0);
        JT_Livros.getColumn("Código").setMaxWidth(0);

        JT_Discos.getColumn("Código").setMinWidth(0);
        JT_Discos.getColumn("Código").setMaxWidth(0);

        TextPrompt TP1 = new TextPrompt("Digite aqui para pesquisar", JTF_PesquisarLivros);
        TextPrompt TP2 = new TextPrompt("Digite aqui para pesquisar", JTF_PesquisarDiscos);
        JRB_NomeLivros.setSelected(true);
        LerJTable();
    }

    private void LerJTable() {
        DefaultTableModel modelo2 = (DefaultTableModel) JT_Discos.getModel();
        DefaultTableModel modelo = (DefaultTableModel) JT_Livros.getModel();
        modelo.setNumRows(0);
        modelo2.setNumRows(0);
        discosDAO dvdD = new discosDAO();
        livrosDAO livD = new livrosDAO();
        for (livros l : livD.encontrar(null)) {
            modelo.addRow(new Object[]{
                l.getId(),
                l.getNome(),
                l.getAutor(),
                l.getEdicao()
            });
        }

        for (discos d : dvdD.encontrar(true, true, null)) {
            String tipo;
            if (d.isDisco()) {
                tipo = "Disco";
            } else {
                tipo = "CD";
            }
            modelo2.addRow(new Object[]{
                d.getId(),
                d.getNome(),
                d.getAutor(),
                tipo
            });
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

        JTP_TabelaLivroDiscos = new javax.swing.JTabbedPane();
        JP_Livros = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        JT_Livros = new javax.swing.JTable();
        JTF_PesquisarLivros = new javax.swing.JTextField();
        JB_AtualizarLivros = new javax.swing.JButton();
        JRB_NomeLivros = new javax.swing.JRadioButton();
        JRB_AutorLivros = new javax.swing.JRadioButton();
        JP_Discos = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        JT_Discos = new javax.swing.JTable();
        JTF_PesquisarDiscos = new javax.swing.JTextField();
        JB_AtualizarDiscos = new javax.swing.JButton();
        JRB_NomeDiscos = new javax.swing.JRadioButton();
        JRB_AutorDisco = new javax.swing.JRadioButton();
        JP_Botões = new javax.swing.JPanel();
        JB_Cadastrar = new javax.swing.JButton();
        JB_Voltar = new javax.swing.JButton();
        JB_Excluir = new javax.swing.JButton();
        JB_Editar = new javax.swing.JButton();
        JB_Relatório = new javax.swing.JButton();
        JP_Título = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Acervo Pessoal");
        setResizable(false);

        JT_Livros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Autor", "Edição"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(JT_Livros);

        JTF_PesquisarLivros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTF_PesquisarLivrosKeyTyped(evt);
            }
        });

        JB_AtualizarLivros.setText("Atualizar");
        JB_AtualizarLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AtualizarLivrosActionPerformed(evt);
            }
        });

        JRB_NomeLivros.setSelected(true);
        JRB_NomeLivros.setText("Nome");
        JRB_NomeLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_NomeLivrosActionPerformed(evt);
            }
        });

        JRB_AutorLivros.setText("Autor");
        JRB_AutorLivros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_AutorLivrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_LivrosLayout = new javax.swing.GroupLayout(JP_Livros);
        JP_Livros.setLayout(JP_LivrosLayout);
        JP_LivrosLayout.setHorizontalGroup(
            JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_LivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_LivrosLayout.createSequentialGroup()
                        .addComponent(JTF_PesquisarLivros, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_AtualizarLivros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JP_LivrosLayout.createSequentialGroup()
                        .addGroup(JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_LivrosLayout.createSequentialGroup()
                                .addComponent(JRB_NomeLivros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JRB_AutorLivros))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_LivrosLayout.setVerticalGroup(
            JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_LivrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_PesquisarLivros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_AtualizarLivros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_LivrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRB_NomeLivros)
                    .addComponent(JRB_AutorLivros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JTP_TabelaLivroDiscos.addTab("Livros", JP_Livros);

        JT_Discos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Autor", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(JT_Discos);

        JTF_PesquisarDiscos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                JTF_PesquisarDiscosKeyTyped(evt);
            }
        });

        JB_AtualizarDiscos.setText("Atualizar");
        JB_AtualizarDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_AtualizarDiscosActionPerformed(evt);
            }
        });

        JRB_NomeDiscos.setSelected(true);
        JRB_NomeDiscos.setText("Nome");
        JRB_NomeDiscos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_NomeDiscosActionPerformed(evt);
            }
        });

        JRB_AutorDisco.setText("Autor");
        JRB_AutorDisco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JRB_AutorDiscoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_DiscosLayout = new javax.swing.GroupLayout(JP_Discos);
        JP_Discos.setLayout(JP_DiscosLayout);
        JP_DiscosLayout.setHorizontalGroup(
            JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP_DiscosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JP_DiscosLayout.createSequentialGroup()
                        .addComponent(JTF_PesquisarDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JB_AtualizarDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JP_DiscosLayout.createSequentialGroup()
                        .addGroup(JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JP_DiscosLayout.createSequentialGroup()
                                .addComponent(JRB_NomeDiscos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(JRB_AutorDisco))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JP_DiscosLayout.setVerticalGroup(
            JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_DiscosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTF_PesquisarDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_AtualizarDiscos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JP_DiscosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JRB_NomeDiscos)
                    .addComponent(JRB_AutorDisco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JTP_TabelaLivroDiscos.addTab("Discos", JP_Discos);

        JB_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add-plus-button (1).png"))); // NOI18N
        JB_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_CadastrarActionPerformed(evt);
            }
        });

        JB_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/left-chevron.png"))); // NOI18N
        JB_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_VoltarActionPerformed(evt);
            }
        });

        JB_Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/rubbish-bin-delete-button.png"))); // NOI18N
        JB_Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_ExcluirActionPerformed(evt);
            }
        });

        JB_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/edit.png"))); // NOI18N
        JB_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_EditarActionPerformed(evt);
            }
        });

        JB_Relatório.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/pdf-file.png"))); // NOI18N
        JB_Relatório.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_RelatórioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JP_BotõesLayout = new javax.swing.GroupLayout(JP_Botões);
        JP_Botões.setLayout(JP_BotõesLayout);
        JP_BotõesLayout.setHorizontalGroup(
            JP_BotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_BotõesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JB_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JB_Relatório, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JB_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        JP_BotõesLayout.setVerticalGroup(
            JP_BotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_BotõesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JP_BotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JB_Editar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(JP_BotõesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JB_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JB_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JB_Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JB_Relatório, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        JP_Título.setBackground(new java.awt.Color(0, 0, 0));
        JP_Título.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JP_TítuloAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Acervo Pessoal");

        javax.swing.GroupLayout JP_TítuloLayout = new javax.swing.GroupLayout(JP_Título);
        JP_Título.setLayout(JP_TítuloLayout);
        JP_TítuloLayout.setHorizontalGroup(
            JP_TítuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_TítuloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(119, 119, 119))
        );
        JP_TítuloLayout.setVerticalGroup(
            JP_TítuloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JP_TítuloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32))
        );

        jMenu1.setText("Sobre");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP_Título, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(JTP_TabelaLivroDiscos)
                    .addComponent(JP_Botões, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(JP_Título, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTP_TabelaLivroDiscos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JP_Botões, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JP_TítuloAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JP_TítuloAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_JP_TítuloAncestorAdded

    // -------------- RETORNAR PARA O MENU -------------- //
    private void JB_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_VoltarActionPerformed
        this.setVisible(false);
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_JB_VoltarActionPerformed
    // -------------- PESQUISAR LIVROS -------------- //
    private void JTF_PesquisarLivrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_PesquisarLivrosKeyTyped
        PesquisarLivro(JRB_NomeLivros.isSelected());
    }//GEN-LAST:event_JTF_PesquisarLivrosKeyTyped
    // -------------- PESQUISAR DISCOS -------------- //
    private void JTF_PesquisarDiscosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTF_PesquisarDiscosKeyTyped
        PesquisarDiscos(JRB_NomeDiscos.isSelected());
    }//GEN-LAST:event_JTF_PesquisarDiscosKeyTyped
    // -------------- EDITAR DISCOS E LIVROS -------------- //
    private void JB_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_EditarActionPerformed
        if (JT_Livros.getSelectedRow() != -1 && JTP_TabelaLivroDiscos.getSelectedIndex() == 0) {
            if (JT_Livros.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                livros l = new livros();
                TelaEditar TEL;
                int id = (int) JT_Livros.getValueAt(JT_Livros.getSelectedRow(), 0);
                String nome = (String) JT_Livros.getValueAt(JT_Livros.getSelectedRow(), 1);
                String autor = (String) JT_Livros.getValueAt(JT_Livros.getSelectedRow(), 2);
                int edicao = (int) JT_Livros.getValueAt(JT_Livros.getSelectedRow(), 3);
                TEL = new TelaEditar(id, nome, autor, edicao);
                TEL.setVisible(true);
                AtualizarTabelaConstante(TEL);
            }
        } else if (JT_Discos.getSelectedRow() != -1 && JTP_TabelaLivroDiscos.getSelectedIndex() == 1) {
            if (JT_Discos.getSelectedRowCount() > 1) {
                JOptionPane.showMessageDialog(null, "Não pode editar mais de um item!");
            } else {
                discos d = new discos();
                TelaEditar TEL;
                int id = (int) JT_Discos.getValueAt(JT_Discos.getSelectedRow(), 0);
                String nome = (String) JT_Discos.getValueAt(JT_Discos.getSelectedRow(), 1);
                String autor = (String) JT_Discos.getValueAt(JT_Discos.getSelectedRow(), 2);
                String tipoST = (String) JT_Discos.getValueAt(JT_Discos.getSelectedRow(), 3);
                boolean tipoBO;
                tipoBO = "Disco".equals(tipoST);
                TEL = new TelaEditar(id, nome, autor, tipoBO);
                TEL.setVisible(true);
                AtualizarTabelaConstante(TEL);
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar algum item nas tabelas!");
        }
    }//GEN-LAST:event_JB_EditarActionPerformed

    private void JB_ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_ExcluirActionPerformed
        int[] a;
        if (JT_Livros.getSelectedRow() != -1 && JTP_TabelaLivroDiscos.getSelectedIndex() == 0) {
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir " + JT_Livros.getSelectedRowCount() + " livro(s)? Essa ação não pode ser revertida! ", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < JT_Livros.getSelectedRowCount(); i++) {
                    livros l = new livros();
                    a = JT_Livros.getSelectedRows();
                    l.setId((int) JT_Livros.getValueAt(a[i], 0));
                    l.deletar(l.getId());
                }
            }
        } else if (JT_Discos.getSelectedRow() != -1 && JTP_TabelaLivroDiscos.getSelectedIndex() == 1) {
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir " + JT_Discos.getSelectedRowCount() + " disco(s)? Essa ação não pode ser revertida! ", "Confirmação",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < JT_Discos.getSelectedRowCount(); i++) {
                    discos d = new discos();
                    a = JT_Discos.getSelectedRows();
                    d.setId((int) JT_Discos.getValueAt(a[i], 0));
                    d.deletar(d.getId());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "É necessário selecionar algum item nas tabelas!");
        }
        LerJTable();
    }//GEN-LAST:event_JB_ExcluirActionPerformed

    private void JB_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_CadastrarActionPerformed
        TelaCadastrar TC;
        if (JTP_TabelaLivroDiscos.getSelectedIndex() == 0) {
            TC = new TelaCadastrar(true);
        } else {
            TC = new TelaCadastrar(false);
        }
        TC.setVisible(true);
        AtualizarTabelaConstante(TC);
    }//GEN-LAST:event_JB_CadastrarActionPerformed

    private void JB_RelatórioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_RelatórioActionPerformed
        if (JTP_TabelaLivroDiscos.getSelectedIndex() == 0) {
            GerarRelatórioLivro();
        } else {
            GerarRelatórioDisco();
        }
    }//GEN-LAST:event_JB_RelatórioActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected

    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new TelaSobre().setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void JB_AtualizarLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AtualizarLivrosActionPerformed
        LerJTable();
    }//GEN-LAST:event_JB_AtualizarLivrosActionPerformed

    private void JB_AtualizarDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_AtualizarDiscosActionPerformed
        LerJTable();
    }//GEN-LAST:event_JB_AtualizarDiscosActionPerformed

    //Livros JRB 
    private void JRB_NomeLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_NomeLivrosActionPerformed
        LerJTable();
        JRB_AutorLivros.setSelected(false);
        JTF_PesquisarLivros.setText("");
    }//GEN-LAST:event_JRB_NomeLivrosActionPerformed

    private void JRB_AutorLivrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_AutorLivrosActionPerformed
        LerJTable();
        JRB_NomeLivros.setSelected(false);
        JTF_PesquisarLivros.setText("");
    }//GEN-LAST:event_JRB_AutorLivrosActionPerformed

    private void JRB_NomeDiscosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_NomeDiscosActionPerformed
        LerJTable();
        JRB_AutorDisco.setSelected(false);
        JTF_PesquisarDiscos.setText("");
    }//GEN-LAST:event_JRB_NomeDiscosActionPerformed

    private void JRB_AutorDiscoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JRB_AutorDiscoActionPerformed
        LerJTable();
        JRB_NomeDiscos.setSelected(false);
        JTF_PesquisarDiscos.setText("");
    }//GEN-LAST:event_JRB_AutorDiscoActionPerformed

    // -------------- ATUALIZA A TABELA ENQUANTO OUTRO JFRAME ESTÁ ABERTO -------------- //
    private void AtualizarTabelaConstante(JFrame x) {
        Thread t = new Thread(() -> {
            while (x.isVisible()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    LerJTable();
                } catch (InterruptedException ex) {
                    Logger.getLogger(ListaAcervo1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
    }

    //Gera o relatório baseado na tabela//
    public void GerarRelatórioLivro() {
        Relatorio re = new Relatorio();
        List<livros> listaLivros = new ArrayList<>();
        for (int i = 0; i < JT_Livros.getRowCount(); i++) {
            livros l = new livros();
            l.setId((Integer) JT_Livros.getValueAt(i, 0));
            l.setNome((String) JT_Livros.getValueAt(i, 1));
            l.setAutor((String) JT_Livros.getValueAt(i, 2));
            l.setEdicao((Integer) JT_Livros.getValueAt(i, 3));
            listaLivros.add(i, l);
        }
        re.gerarLivros(listaLivros);
    }

    //Gera o relatório baseado na tabela//
    public void GerarRelatórioDisco() {
        Relatorio re = new Relatorio();
        List<discos> listaDiscos = new ArrayList<>();
        for (int i = 0; i < JT_Discos.getRowCount(); i++) {
            discos d = new discos();
            d.setId((Integer) JT_Discos.getValueAt(i, 0));
            d.setNome((String) JT_Discos.getValueAt(i, 1));
            d.setAutor((String) JT_Discos.getValueAt(i, 2));
            if ("Disco".equals((String) JT_Discos.getValueAt(i, 3))) {
                d.setDisco(true);
            } else {
                d.setDisco(false);
            }
            listaDiscos.add(i, d);
        }
        re.gerarDiscos(listaDiscos);
    }

    //Pesquisarlivro//
    public void PesquisarLivro(boolean nomeOUautor) {
        DefaultTableModel modelo = (DefaultTableModel) JT_Livros.getModel();
        modelo.setNumRows(0);
        livrosDAO livD = new livrosDAO();
        if (nomeOUautor) {
            for (livros l : livD.encontrar(JTF_PesquisarLivros.getText())) {
                modelo.addRow(new Object[]{
                    l.getId(),
                    l.getNome(),
                    l.getAutor(),
                    l.getEdicao()
                });
            }
        } else {
            for (livros l : livD.encontrarAutor(JTF_PesquisarLivros.getText())) {
                modelo.addRow(new Object[]{
                    l.getId(),
                    l.getNome(),
                    l.getAutor(),
                    l.getEdicao()
                });
            }
        }
    }

    //PesquisarDisco//
    public void PesquisarDiscos(boolean nomeOUautor) {
        DefaultTableModel modelo = (DefaultTableModel) JT_Discos.getModel();
        modelo.setNumRows(0);
        discosDAO disD = new discosDAO();
        if (nomeOUautor) {
            for (discos d : disD.encontrar(true, true, JTF_PesquisarDiscos.getText())) {
                String tipo;
                if (d.isDisco()) {
                    tipo = "Disco";
                } else {
                    tipo = "CD";
                }
                modelo.addRow(new Object[]{
                    d.getId(),
                    d.getNome(),
                    d.getAutor(),
                    tipo
                });
            }
        } else {
            for (discos d : disD.encontrarAutor(true, true, JTF_PesquisarDiscos.getText())) {
                String tipo;
                if (d.isDisco()) {
                    tipo = "Disco";
                } else {
                    tipo = "CD";
                }
                modelo.addRow(new Object[]{
                    d.getId(),
                    d.getNome(),
                    d.getAutor(),
                    tipo
                });
            }
        }
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaAcervo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaAcervo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaAcervo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaAcervo1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaAcervo1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_AtualizarDiscos;
    private javax.swing.JButton JB_AtualizarLivros;
    private javax.swing.JButton JB_Cadastrar;
    private javax.swing.JButton JB_Editar;
    private javax.swing.JButton JB_Excluir;
    private javax.swing.JButton JB_Relatório;
    private javax.swing.JButton JB_Voltar;
    private javax.swing.JPanel JP_Botões;
    private javax.swing.JPanel JP_Discos;
    private javax.swing.JPanel JP_Livros;
    private javax.swing.JPanel JP_Título;
    private javax.swing.JRadioButton JRB_AutorDisco;
    private javax.swing.JRadioButton JRB_AutorLivros;
    private javax.swing.JRadioButton JRB_NomeDiscos;
    private javax.swing.JRadioButton JRB_NomeLivros;
    private javax.swing.JTextField JTF_PesquisarDiscos;
    private javax.swing.JTextField JTF_PesquisarLivros;
    private javax.swing.JTabbedPane JTP_TabelaLivroDiscos;
    private javax.swing.JTable JT_Discos;
    private javax.swing.JTable JT_Livros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
