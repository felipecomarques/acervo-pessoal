package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
SOBRE ESSA CLASSE: 
O ConnectionFactory faz a conexão com o Banco de dados. Caso você tenha algum problema
para conectar com o banco, pode ser que seja algo daqui. Algumas coisas que podem acontecer:

1) O nome do banco de dados do seu PC estar diferente. É só trocar o final da URL.
EX.: "jdbc:mysql://localhost:3306/acervopessoal" OU "jdbc:mysql://localhost:3306/acervo_pessoal".

2) A senha do seu banco de dados ser diferente. Basta mudar o PASS.
EX.: "" OU "ifce" OU "123". Ou seja, a senha que está no seu MySQL.

OBS.: Se você não sabe o que está fazendo, não altere muito do ConnectionFactory. Isso pode
causar erros futuros.
 */
public class ConnectionFactory {

    // ATRIBUTOS //
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do JDBC
    private static final String URL = "jdbc:mysql://localhost:3306/acervopessoal" + "?useTimezone=true&serverTimezone=America/Sao_Paulo" + "&useSSL=false" + "&allowPublicKeyRetrieval=true"; //URL do banco, pode ser necessário alterar
    private static final String USER = "root"; //Usuário do SQL, pode ser necessário alterar
    private static final String PASS = "ifce"; //Senha do Localhost, pode ser necessário alterar

    // MÉTODOS //
    //Abre a conexão com o banco de dados//
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            //throw new RuntimeException("Erro na conexão" + ex);
            JOptionPane.showMessageDialog(null, "Erro: " + ex);
        }
        return null;
    }

    public static Connection getConnectionBD() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/" + "?useTimezone=true&serverTimezone=America/Sao_Paulo" + "&useSSL=false" + "&allowPublicKeyRetrieval=true", USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão" + ex);
        }
        return null;
    }

    //Fecha a conexão com o banco de dados//
    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
    }

    //Fecha a conexão com o banco de dados e o PreparedStatement//
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con);
    }

    //Fecha a conexão com o banco de dados, o PreparedStatement e o ResultSet//
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro: " + ex);
            }
        }
        closeConnection(con, stmt);
    }
}
