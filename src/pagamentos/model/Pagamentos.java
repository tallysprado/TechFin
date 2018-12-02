/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
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
    , @NamedQuery(name = "Pagamentos.findByDataPagamento", query = "SELECT p FROM Pagamentos p WHERE p.dataPagamento = :dataPagamento")})
public class Pagamentos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPagamentos")
    private Integer idPagamentos;
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
        Integer oldIdPagamentos = this.idPagamentos;
        this.idPagamentos = idPagamentos;
        changeSupport.firePropertyChange("idPagamentos", oldIdPagamentos, idPagamentos);
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        String oldDataPagamento = this.dataPagamento;
        this.dataPagamento = dataPagamento;
        changeSupport.firePropertyChange("dataPagamento", oldDataPagamento, dataPagamento);
    }

    public Boleto getCodBoleto() {
        return codBoleto;
    }

    public void setCodBoleto(Boleto codBoleto) {
        Boleto oldCodBoleto = this.codBoleto;
        this.codBoleto = codBoleto;
        changeSupport.firePropertyChange("codBoleto", oldCodBoleto, codBoleto);
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        Cliente oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
