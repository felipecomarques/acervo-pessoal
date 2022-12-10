package Main;
import BD.admBD;
import UI.Menu;
import java.text.ParseException;

public class Main {

    // Aqui será executado o código, criando o BD se for preciso //
    public static void main(String[] args) throws ParseException {
        admBD adm = new admBD();
        adm.gerarBanco();
        adm.gerarTab("CREATE TABLE IF NOT EXISTS `discos` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` varchar(40) NOT NULL,\n"
                + "  `artista` varchar(40) NOT NULL,\n"
                + "  `disco` tinyint(1) NOT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;");
        adm.gerarTab("CREATE TABLE IF NOT EXISTS `livros` (\n"
                + "  `id` int(11) NOT NULL AUTO_INCREMENT,\n"
                + "  `nome` varchar(40) NOT NULL,\n"
                + "  `autor` varchar(40) NOT NULL,\n"
                + "  `edicao` bigint(20) DEFAULT NULL,\n"
                + "  PRIMARY KEY (`id`)\n"
                + ") ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;");
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        new Menu().setVisible(true);
    }

}
