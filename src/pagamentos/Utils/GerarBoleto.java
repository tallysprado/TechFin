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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import login.Email;

/**
 *
 * @author root
 */
public class GerarBoleto {
    
    public void geraBoleto(String endBen, String nomeBen, String nBol, String endPag, String nomePag,
            String agencia, String dig, String cpfPag, String valor){
       
        
        Date data = new Date();
        
        Datas datas = Datas.novasDatas()
                .comDocumento(1, 5, 2008)
                .comProcessamento(1, 5, 2008)
                .comVencimento(2, 5, 2008);  
                
        Endereco enderecoBeneficiario = Endereco.novoEndereco()
        		.comLogradouro(endBen)  
        		.comBairro("Bairro Grande")  
        		.comCep("01234-555")  
        		.comCidade("São Paulo")  
        		.comUf("SP");  

        //Quem emite o boleto
        Beneficiario beneficiario = Beneficiario.novoBeneficiario()  
                .comNomeBeneficiario(nomeBen)  
                .comAgencia(agencia).comDigitoAgencia(dig)  
                .comCodigoBeneficiario("76000")  
                .comDigitoCodigoBeneficiario("5")  
                .comNumeroConvenio("1207113")  
                .comCarteira("18")  
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero(nBol);  

        Endereco enderecoPagador = Endereco.novoEndereco()
        		.comLogradouro(endPag)  
        		.comBairro("Bairro Teste")  
        		.comCep("01234-111")  
        		.comCidade("São Paulo")  
        		.comUf("SP");  
        
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
                .comNumeroDoDocumento("1234")  
                .comInstrucoes("instrucao 1", "instrucao 2", "instrucao 3", "instrucao 4", "instrucao 5")  
                .comLocaisDePagamento("local 1", "local 2");  

        GeradorDeBoleto gerador = new GeradorDeBoleto(boleto);  

        // Para gerar um boleto em PDF  
        gerador.geraPDF("BancoDoBrasil.pdf");  

        // Para gerar um boleto em PNG  
        gerador.geraPNG("BancoDoBrasil.png");  

        // Para gerar um array de bytes a partir de um PDF  
        byte[] bPDF = gerador.geraPDF();  

        // Para gerar um array de bytes a partir de um PNG  
        byte[] bPNG = gerador.geraPNG();
        
        File arquivo = new File("/home/tallys/teste/TechFin/src/pagamentos/Utils/Boleto.pdf");
        gerador.geraPDF(arquivo);
        
        
        
    }  
}
