package ItensAcervo;

/*
SOBRE ESSA CLASSE: 
É uma superclasse dos itens. Possui todos os atributos e métodos comuns à livros
e discos/cds. 
 */
public class Itens {

    // ATRIBUTOS //
    private int id;
    private String nome;
    private String autor;

    // MÉTODOS //
    public boolean cadastro(String nome, String autor) {
        setNome(nome);
        setAutor(autor);
        return true;
    }

    public boolean editar(int id, String nome, String autor) {
        setNome(nome);
        setAutor(autor);
        setId(id);
        return true;
    }

    public boolean deletar(int id) {
        setId(id);
        return true;
    }

    public void pesquisar() {

    }

    // GET & SET //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
