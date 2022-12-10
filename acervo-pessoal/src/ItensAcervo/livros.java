package ItensAcervo;

import BD.livrosDAO;
import java.util.List;
import javax.swing.JOptionPane;

/*
SOBRE ESSA CLASSE: 
É uma subclasse dos itens. Possui todos os atributos e métodos dos itens, com algumas
diferenças nas classes para que seja possível usar o DAO dos livros. Se algo não funcionar,
vale a pena observar o DAO, o problema PODE ser ali.

Lembrando que, no final, os métodos executados serão estes, não o do DAO.
Por exemplo, para cadastrar um item, você deve executar o método 
casdastro(String, String, int) desta classe, e não save(livros) do DAO.
 */
public class livros extends Itens {

    // ATRIBUTOS //
    private int edicao;

    // MÉTODOS //
    public boolean cadastro(String nome, String autor, int edicao) {
        livrosDAO livD = new livrosDAO();
        super.cadastro(nome, autor);
        setEdicao(edicao);
        if (livD.save(this)) {
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            return false;
        }
    }

    public boolean editar(int id, String nome, String autor, int edicao) {
        livrosDAO livD = new livrosDAO();
        super.editar(id, nome, autor);
        setEdicao(edicao);
        if (livD.edição(this)) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar");
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        livrosDAO livD = new livrosDAO();
        super.deletar(id);
        if (livD.delete(this)) {
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            return false;
        }
    }

//    public List<livros> pesquisar(String nome) { //REDUNTANTE DOIS PESQUISAR, COLOCAR EM UM SÓ
//        livrosDAO livD = new livrosDAO();
//        for (livros l : livD.encontrar(nome)) {
//            System.out.println("Nome: " + l.getNome());
//            System.out.println("Autor: " + l.getAutor());
//            System.out.println("Edição: " + l.getEdicao());
//        }
//    }

    // GET & SET //
    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

}
