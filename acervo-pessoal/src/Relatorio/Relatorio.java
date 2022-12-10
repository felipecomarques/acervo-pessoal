package Relatorio;

import ItensAcervo.discos;
import ItensAcervo.livros;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.JFileChooser;
public class Relatorio {
    //Gera um relatório em PDF dos livros ou discos//
    
    // Relatório dos livros //
    public void gerarLivros(List<livros> listaLivros) {
        try {
            Document document = new Document();

            JFileChooser seletor = new JFileChooser();
            seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            seletor.showSaveDialog(seletor);
            seletor.setVisible(true);

            PdfWriter.getInstance(document, new FileOutputStream(
                    seletor.getSelectedFile().getAbsolutePath() + "\\Livros.pdf"));
            document.open();
            document.newPage();

            Font f = new Font(FontFamily.TIMES_ROMAN, 50.0f, Font.BOLD, BaseColor.BLACK);
            Font f2 = new Font(FontFamily.TIMES_ROMAN, 14.0f, Font.BOLD, BaseColor.BLACK);

            Paragraph Título = new Paragraph("Relatório de Livros\n", f);
            Título.setAlignment(Element.ALIGN_CENTER);
            document.add(Título);

            document.add(new Paragraph("\n \n"));

            PdfPTable tabela = new PdfPTable(3);
            PdfPCell cell1 = new PdfPCell(new Phrase("Nome", f2));
            PdfPCell cell2 = new PdfPCell(new Phrase("Autor", f2));
            PdfPCell cell3 = new PdfPCell(new Phrase("Edição", f2));
            tabela.addCell(cell1);
            tabela.addCell(cell2);
            tabela.addCell(cell3);
            for (livros ls : listaLivros) {
                tabela.addCell(ls.getNome());
                tabela.addCell(ls.getAutor());
                tabela.addCell(String.valueOf(ls.getEdicao()));
            }
            document.add(tabela);
            document.close();
        } catch (java.lang.NullPointerException | DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // Relatório dos discos //
    public void gerarDiscos(List<discos> listaDiscos) {
        try {
            Document document = new Document();

            JFileChooser seletor = new JFileChooser();
            seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            seletor.showSaveDialog(seletor);
            seletor.setVisible(true);

            PdfWriter.getInstance(document, new FileOutputStream(
                    seletor.getSelectedFile().getAbsolutePath() + "\\Discos.pdf"));
            document.open();
            document.newPage();

            Font f = new Font(FontFamily.TIMES_ROMAN, 50.0f, Font.BOLD, BaseColor.BLACK);
            Font f2 = new Font(FontFamily.TIMES_ROMAN, 14.0f, Font.BOLD, BaseColor.BLACK);

            Paragraph Título = new Paragraph("Relatório de Discos\n", f);
            Título.setAlignment(Element.ALIGN_CENTER);
            document.add(Título);

            document.add(new Paragraph("\n \n"));

            PdfPTable tabela = new PdfPTable(3);
            PdfPCell cell1 = new PdfPCell(new Phrase("Nome", f2));
            PdfPCell cell2 = new PdfPCell(new Phrase("Artista", f2));
            PdfPCell cell3 = new PdfPCell(new Phrase("Tipo", f2));
            tabela.addCell(cell1);
            tabela.addCell(cell2);
            tabela.addCell(cell3);
            for (discos ds : listaDiscos) {
                tabela.addCell(ds.getNome());
                tabela.addCell(ds.getAutor());
                String tipo;
                if (ds.isDisco()) {
                    tipo = "Disco";
                } else {
                    tipo = "CD";
                }
                tabela.addCell(tipo);
            }
            document.add(tabela);
            document.close();
        } catch (java.lang.NullPointerException | DocumentException | HeadlessException | FileNotFoundException e) {
            System.out.println(e);
        }
    }
}
