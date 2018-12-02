/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Boleto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Boleto.findAll", query = "SELECT b FROM Boleto b")
    , @NamedQuery(name = "Boleto.findByCodBoleto", query = "SELECT b FROM Boleto b WHERE b.codBoleto = :codBoleto")
    , @NamedQuery(name = "Boleto.findByDataVencimento", query = "SELECT b FROM Boleto b WHERE b.dataVencimento = :dataVencimento")
    , @NamedQuery(name = "Boleto.findByDataDocumento", query = "SELECT b FROM Boleto b WHERE b.dataDocumento = :dataDocumento")
    , @NamedQuery(name = "Boleto.findByDataProcessamento", query = "SELECT b FROM Boleto b WHERE b.dataProcessamento = :dataProcessamento")
    , @NamedQuery(name = "Boleto.findByValorBoleto", query = "SELECT b FROM Boleto b WHERE b.valorBoleto = :valorBoleto")})
public class Boleto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codBoleto")
    private Integer codBoleto;
    @Column(name = "DataVencimento")
    private String dataVencimento;
    @Column(name = "DataDocumento")
    private String dataDocumento;
    @Column(name = "DataProcessamento")
    private String dataProcessamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Valor_Boleto")
    private BigDecimal valorBoleto;
    @OneToMany(mappedBy = "codBoleto")
    private Collection<Pagamentos> pagamentosCollection;
    @JoinColumn(name = "Id_Cliente", referencedColumnName = "Id_Cliente")
    @ManyToOne
    private Cliente idCliente;

    public Boleto() {
    }

    public Boleto(Integer codBoleto) {
        this.codBoleto = codBoleto;
    }

    public Integer getCodBoleto() {
        return codBoleto;
    }

    public void setCodBoleto(Integer codBoleto) {
        this.codBoleto = codBoleto;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDataDocumento() {
        return dataDocumento;
    }

    public void setDataDocumento(String dataDocumento) {
        this.dataDocumento = dataDocumento;
    }

    public String getDataProcessamento() {
        return dataProcessamento;
    }

    public void setDataProcessamento(String dataProcessamento) {
        this.dataProcessamento = dataProcessamento;
    }

    public BigDecimal getValorBoleto() {
        return valorBoleto;
    }

    public void setValorBoleto(BigDecimal valorBoleto) {
        this.valorBoleto = valorBoleto;
    }

    @XmlTransient
    public Collection<Pagamentos> getPagamentosCollection() {
        return pagamentosCollection;
    }

    public void setPagamentosCollection(Collection<Pagamentos> pagamentosCollection) {
        this.pagamentosCollection = pagamentosCollection;
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
        hash += (codBoleto != null ? codBoleto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Boleto)) {
            return false;
        }
        Boleto other = (Boleto) object;
        if ((this.codBoleto == null && other.codBoleto != null) || (this.codBoleto != null && !this.codBoleto.equals(other.codBoleto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pagamentos.model.Boleto[ codBoleto=" + codBoleto + " ]";
    }
    
}
