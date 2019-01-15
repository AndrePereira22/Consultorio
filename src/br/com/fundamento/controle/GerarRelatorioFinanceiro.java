package br.com.fundamento.controle;

import static br.com.fundamento.controle.ControleCaixa.getC;
import br.com.fundamento.dao.DaoCaixa;
import br.com.fundamento.dao.DaoContaPagar;
import br.com.fundamento.dao.DaoPagamento;
import br.com.fundamento.fachada.Fachada;
import br.com.fundamento.fachada.IFachada;
import br.com.fundamento.modelos.Caixa;
import br.com.fundamento.modelos.ContaPagar;
import br.com.fundamento.modelos.Pagamento;
import br.com.fundamento.view.ContaReceber;
import br.com.fundamento.view.FluxodeCaixa;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GerarRelatorioFinanceiro {

    public void criar(String nome,String data, String date) {
        
        

        IFachada fachada1 = Fachada.getInstance();
        
        List<Pagamento> pagamentos = new DaoPagamento().buscarpagamentoPeriodo(data,date);
        List<ContaPagar> contaaPagars = new DaoContaPagar().BuscarContaporPeriodo(data,date);
        List<Pagamento> pagamentoss = new DaoPagamento().buscarpagamentoNaoPagoPeriodo(data,date);
        List<Caixa> caixas = new DaoCaixa().buscarCaixaPorPeriodo(data, date);
        
        double valorAbertura =caixas.get(0).getValor_abertura();
        double valorFechamento=0;
    
       

        ArrayList<Paragraph> list1 = new ArrayList<Paragraph>();
        ArrayList<Paragraph> list2 = new ArrayList<Paragraph>();
        ArrayList<Paragraph> list3 = new ArrayList<Paragraph>();

        for (Pagamento p : pagamentos) {
            String a = new String(p.getValor_total() + "\t                 " + p.getQuantidade_parcelas() + "\t                    " + p.getForma_pagamento());
            list1.add(new Paragraph(a, FontFactory.getFont(FontFactory.COURIER, 12)));
        }
        for (Pagamento pa : pagamentoss) {
            String a = new String(pa.getValor_total() + "\t                 " + pa.getQuantidade_parcelas() + "\t                    " + pa.getForma_pagamento());
            list3.add(new Paragraph(a, FontFactory.getFont(FontFactory.COURIER, 12)));
        }
        for (ContaPagar c : contaaPagars) {
            String a = new String(c.getData() + "\t             " + c.getValor() + "\t            " + c.getDescricao());
            list2.add(new Paragraph(a, FontFactory.getFont(FontFactory.COURIER, 12)));
        }
       int indice = caixas.size()-1;
            valorFechamento=caixas.get(indice).getValor_fechamento();
        

        // criação do objeto documento
        Document document = new Document();

      
        try {
 
           File f = new File("src\\br\\com\\fundamento\\relatorios\\"+ nome+ ".pdf");
            PdfWriter.getInstance(document, new FileOutputStream(f));

            document.open();

            // adicionando um parágrafo ao documento
            document.add(new Paragraph("                                Fluxo de Caixa \t                           "+"De "+data+ " a " + date ));
            document.add(new Paragraph("     "));

            // adicionando um parágrafo com fonte diferente ao arquivo
            document.add(new Paragraph("Pagamento Recebidos \t", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("Valor         Quantidade Parcelas           Forma de Pagamento", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            for (Paragraph pa : list1) {
                document.add(pa);
            }
            document.add(new Paragraph("     "));
            document.add(new Paragraph("Despesas pagas", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("Data de Vencimento      Valor         Descriçao", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));

            for (Paragraph pa : list2) {
                document.add(pa);
            }

            document.add(new Paragraph("     "));
            document.add(new Paragraph("Pagamento a Receber", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("Valor         Quantidade Parcelas           Forma de Pagamento", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));

            for (Paragraph pa : list3) {
                document.add(pa);
            }
            document.add(new Paragraph("     "));
            document.add(new Paragraph("Lucro diario", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("Valor de abertura        Valor de fechamento      Lucro do Periodo  ", FontFactory.getFont(FontFactory.COURIER, 12)));
            document.add(new Paragraph("________________________________________________________________", FontFactory.getFont(FontFactory.COURIER, 12)));
            String a = new String(valorAbertura+"                    "+valorFechamento+"                     "+ (valorFechamento-valorAbertura));
            document.add(new Paragraph(a, FontFactory.getFont(FontFactory.COURIER, 12)));

        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        } finally {
            document.close();
        }
    }
}
