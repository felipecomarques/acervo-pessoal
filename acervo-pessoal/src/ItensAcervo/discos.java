package ItensAcervo;
import BD.discosDAO;
import javax.swing.JOptionPane;

/*
SOBRE ESSA CLASSE: 
É uma subclasse dos itens. Possui todos os atributos e métodos dos itens, com algumas
diferenças nas classes para que seja possível usar o DAO dos discos. Se algo não funcionar,
vale a pena observar o DAO, o problema PODE ser ali.

Lembrando que, no final, os métodos executados serão estes, não o do DAO.
Por exemplo, para cadastrar um item, você deve executar o método 
casdastro(String, String, boolean) desta classe, e não save(discos) do DAO.
 */
public class discos extends Itens {

    // ATRIBUTOS //
    private boolean disco;

    // MÉTODOS //
    public boolean cadastro(String nome, String autor, boolean disco) {
        discosDAO dvdD = new discosDAO();
        super.cadastro(nome, autor);
        setDisco(disco);
        if (dvdD.save(this)) {
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
            return false;
        }
    }

    public boolean editar(int ID, String nome, String artista, boolean disco) {
        discosDAO dvdD = new discosDAO();
        super.editar(ID, nome, artista);
        setDisco(disco);
        if (dvdD.edição(this)) {
            JOptionPane.showMessageDialog(null, "Editado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao editar");
            return false;
        }
    }

    @Override
    public boolean deletar(int ID) {
        discosDAO dvdD = new discosDAO();
        super.deletar(ID);
        if (dvdD.delete(this)) {
            JOptionPane.showMessageDialog(null, "Deletado com sucesso!");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao deletar");
            return false;
        }
    }

    //CONCERTARASD
//    public void pesquisarTudoDiscos() {
//        discosDAO dvdD = new discosDAO();
//        for (discos d : dvdD.encontrarTodosDiscos()) {
//            System.out.println("Nome: " + d.getNome());
//            System.out.println("Artista: " + d.getAutor());
//            //System.out.println("Disco: " + d.isDisco());
//        }
//    }
//
//    public void pesquisarTudoCD() {
//        discosDAO dvdD = new discosDAO();
//        for (discos d : dvdD.encontrarTodosCDs()) {
//            System.out.println("Nome: " + d.getNome());
//            System.out.println("Artista: " + d.getAutor());
//            System.out.println("Disco: " + d.isDisco());
//        }
//    }

    // GET & SET //
    public boolean isDisco() {
        return disco;
    }

    public void setDisco(boolean disco) {
        this.disco = disco;
    }
}
