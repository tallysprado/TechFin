/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Transacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transacao.findAll", query = "SELECT t FROM Transacao t")
    , @NamedQuery(name = "Transacao.findByCodTransacao", query = "SELECT t FROM Transacao t WHERE t.codTransacao = :codTransacao")
    , @NamedQuery(name = "Transacao.findByPagador", query = "SELECT t FROM Transacao t WHERE t.pagador = :pagador")
    , @NamedQuery(name = "Transacao.findByBeneficiario", query = "SELECT t FROM Transacao t WHERE t.beneficiario = :beneficiario")
    , @NamedQuery(name = "Transacao.findByValorTransacao", query = "SELECT t FROM Transacao t WHERE t.valorTransacao = :valorTransacao")
    , @NamedQuery(name = "Transacao.findByDataTransacao", query = "SELECT t FROM Transacao t WHERE t.dataTransacao = :dataTransacao")})
public class Transacao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTransacao")
    private Integer codTransacao;
    @Column(name = "Pagador")
    private String pagador;
    @Column(name = "Beneficiario")
    private String beneficiario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorTransacao")
    private BigDecimal valorTransacao;
    @Column(name = "DataTransacao")
    private String dataTransacao;

    public Transacao() {
    }

    public Transacao(Integer codTransacao) {
        this.codTransacao = codTransacao;
    }

    public Integer getCodTransacao() {
        return codTransacao;
    }

    public void setCodTransacao(Integer codTransacao) {
        this.codTransacao = codTransacao;
    }

    public String getPagador() {
        return pagador;
    }

    public void setPagador(String pagador) {
        this.pagador = pagador;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        this.valorTransacao = valorTransacao;
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        this.dataTransacao = dataTransacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTransacao != null ? codTransacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacao)) {
            return false;
        }
        Transacao other = (Transacao) object;
        if ((this.codTransacao == null && other.codTransacao != null) || (this.codTransacao != null && !this.codTransacao.equals(other.codTransacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pagamentos.Transacao[ codTransacao=" + codTransacao + " ]";
    }
    
}
