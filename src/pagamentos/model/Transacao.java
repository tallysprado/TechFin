/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    , @NamedQuery(name = "Transacao.findByUsuario", query = "SELECT t FROM Transacao t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "Transacao.findByValorTransacao", query = "SELECT t FROM Transacao t WHERE t.valorTransacao = :valorTransacao")
    , @NamedQuery(name = "Transacao.findByDataTransacao", query = "SELECT t FROM Transacao t WHERE t.dataTransacao = :dataTransacao")})
public class Transacao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codTransacao")
    private Integer codTransacao;
    @Column(name = "Usuario")
    private String usuario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ValorTransacao")
    private BigDecimal valorTransacao;
    @Column(name = "DataTransacao")
    private String dataTransacao;
    @ManyToMany(mappedBy = "transacaoCollection")
    private Collection<Cliente> clienteCollection;

    public Transacao() {
    }

    public Transacao(Integer codTransacao) {
        this.codTransacao = codTransacao;
    }

    public Integer getCodTransacao() {
        return codTransacao;
    }

    public void setCodTransacao(Integer codTransacao) {
        Integer oldCodTransacao = this.codTransacao;
        this.codTransacao = codTransacao;
        changeSupport.firePropertyChange("codTransacao", oldCodTransacao, codTransacao);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        String oldUsuario = this.usuario;
        this.usuario = usuario;
        changeSupport.firePropertyChange("usuario", oldUsuario, usuario);
    }

    public BigDecimal getValorTransacao() {
        return valorTransacao;
    }

    public void setValorTransacao(BigDecimal valorTransacao) {
        BigDecimal oldValorTransacao = this.valorTransacao;
        this.valorTransacao = valorTransacao;
        changeSupport.firePropertyChange("valorTransacao", oldValorTransacao, valorTransacao);
    }

    public String getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(String dataTransacao) {
        String oldDataTransacao = this.dataTransacao;
        this.dataTransacao = dataTransacao;
        changeSupport.firePropertyChange("dataTransacao", oldDataTransacao, dataTransacao);
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
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
        return "pagamentos.model.Transacao[ codTransacao=" + codTransacao + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
