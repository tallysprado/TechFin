/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Pagamentos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamentos.findAll", query = "SELECT p FROM Pagamentos p")
    , @NamedQuery(name = "Pagamentos.findByIdPagamentos", query = "SELECT p FROM Pagamentos p WHERE p.idPagamentos = :idPagamentos")
    , @NamedQuery(name = "Pagamentos.findByBeneficiario", query = "SELECT p FROM Pagamentos p WHERE p.beneficiario = :beneficiario")
    , @NamedQuery(name = "Pagamentos.findByValor", query = "SELECT p FROM Pagamentos p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pagamentos.findByDataPagamento", query = "SELECT p FROM Pagamentos p WHERE p.dataPagamento = :dataPagamento")})
public class Pagamentos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPagamentos")
    private Integer idPagamentos;
    @Column(name = "Beneficiario")
    private String beneficiario;
    @Column(name = "Valor")
    private String valor;
    @Column(name = "DataPagamento")
    private String dataPagamento;
    @JoinColumn(name = "codBoleto", referencedColumnName = "codBoleto")
    @ManyToOne
    private Boleto codBoleto;
    @JoinColumn(name = "Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne
    private Cliente idCliente;

    public Pagamentos() {
    }

    public Pagamentos(Integer idPagamentos) {
        this.idPagamentos = idPagamentos;
    }

    public Integer getIdPagamentos() {
        return idPagamentos;
    }

    public void setIdPagamentos(Integer idPagamentos) {
        this.idPagamentos = idPagamentos;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Boleto getCodBoleto() {
        return codBoleto;
    }

    public void setCodBoleto(Boleto codBoleto) {
        this.codBoleto = codBoleto;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamentos != null ? idPagamentos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamentos)) {
            return false;
        }
        Pagamentos other = (Pagamentos) object;
        if ((this.idPagamentos == null && other.idPagamentos != null) || (this.idPagamentos != null && !this.idPagamentos.equals(other.idPagamentos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pagamentos.model.Pagamentos[ idPagamentos=" + idPagamentos + " ]";
    }
    
}
