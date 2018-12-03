/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.Utils;

import br.com.caelum.stella.boleto.Banco;
import br.com.caelum.stella.boleto.Beneficiario;
import br.com.caelum.stella.boleto.Boleto;
import br.com.caelum.stella.boleto.Datas;
import br.com.caelum.stella.boleto.Endereco;
import br.com.caelum.stella.boleto.Pagador;
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto;
import br.com.caelum.stella.boleto.transformer.GeradorDeBoletoHTML;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Email;

/**
 *
 * @author root
 */
public class GerarBoleto {
    public static void main(String[] args) {
        new Email().sendAttachEmail("tallys.prado@gmail.com", "Teste", "Olá, o boleto", "Boleto.pdf");
    }
    public void geraBoleto(String endBen, String nomeBen, String nBol, String endPag, String nomePag,
            String agencia, String dig, String cpfPag, String valor){
        Date data = new Date();
        System.out.println(data);
        Datas datas = Datas.novasDatas()
                .comDocumento(data.getDay(), data.getMonth(), data.getYear())
                .comProcessamento(data.getDay(), data.getMonth(), data.getYear())
                .comVencimento(data.getDay()+3, data.getMonth(), data.getYear());  

        Endereco enderecoBeneficiario = Endereco.novoEndereco()
        		.comLogradouro(endBen);  
        		

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario(nomeBen)  
                .comAgencia(agencia).comDigitoAgencia(dig)  
                .comNumeroConvenio("NÚMERO DO CONVÊNIO P/ IDENTIFICAÇÃO DO EMISSOR - ESPECIFICADO PELO BANCO")  
                .comCarteira("18")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero(nBol);  

        Endereco enderecoPagador = Endereco.novoEndereco()
        		.comLogradouro(endPag);
        
        //Quem paga o boleto
        Pagador pagador = Pagador.novoPagador()  
                .comNome(nomePag)  
                .comDocumento(cpfPag)
                .comEndereco(enderecoPagador);

        Banco banco = new BancoDoBrasil();  

        Boleto boleto = Boleto.novoBoleto()  
                .comBanco(banco)  
                .comDatas(datas)  
                .comBeneficiario(beneficiario)  
                .comPagador(pagador)  
                .comValorBoleto(valor)  
                .comNumeroDoDocumento("NÚMERO DO DOCUMENTO P/ IDENTIFICAÇÃO DO CLIENTE- ESPECIFICADO PELO BANCO")  
                .comInstrucoes("ARQUIVO GERADO PELO TECHFIN 1.0", "AO PAGAR ATUALIZAR INFORMAÇÕES NA SESSÃO DE VALIDAÇÃO")  
                .comLocaisDePagamento("Casas lotéricas", "Banco do Brasil", "Caixas eletrônicos");  

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

        // Para gerar um boleto em PDF  
        gerador.geraPDF("BancoDoBrasil.pdf");  

        // Para gerar um boleto em PNG  
        gerador.geraPNG("BancoDoBrasil.png");  

        // Para gerar um array de bytes a partir de um PDF  
        
        byte[] bPDF = gerador.geraPDF();
        File arquivo = new File("/home/tallys/teste/TechFin/src/pagamentos/Utils/Boleto.pdf");
        gerador.geraPDF(arquivo);
        GeradorDeBoletoHTML gHTML = new GeradorDeBoletoHTML(boleto);
        new Email().sendEmail(0, dig);
        // Para gerar um array de bytes a partir de um PNG  
        byte[] bPNG = gerador.geraPNG();
        
        
        
    }  
}
