/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author root
 */
@Entity
@Table(name = "Cliente_tem_Transacao", catalog = "db", schema = "")
@NamedQueries({
    @NamedQuery(name = "ClientetemTransacao.findAll", query = "SELECT c FROM ClientetemTransacao c")
    , @NamedQuery(name = "ClientetemTransacao.findByIdCliente", query = "SELECT c FROM ClientetemTransacao c WHERE c.clientetemTransacaoPK.idCliente = :idCliente")
    , @NamedQuery(name = "ClientetemTransacao.findByCodTransacao", query = "SELECT c FROM ClientetemTransacao c WHERE c.clientetemTransacaoPK.codTransacao = :codTransacao")})
public class ClientetemTransacao implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClientetemTransacaoPK clientetemTransacaoPK;

    public ClientetemTransacao() {
    }

    public ClientetemTransacao(ClientetemTransacaoPK clientetemTransacaoPK) {
        this.clientetemTransacaoPK = clientetemTransacaoPK;
    }

    public ClientetemTransacao(int idCliente, int codTransacao) {
        this.clientetemTransacaoPK = new ClientetemTransacaoPK(idCliente, codTransacao);
    }

    public ClientetemTransacaoPK getClientetemTransacaoPK() {
        return clientetemTransacaoPK;
    }

    public void setClientetemTransacaoPK(ClientetemTransacaoPK clientetemTransacaoPK) {
        this.clientetemTransacaoPK = clientetemTransacaoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clientetemTransacaoPK != null ? clientetemTransacaoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientetemTransacao)) {
            return false;
        }
        ClientetemTransacao other = (ClientetemTransacao) object;
        if ((this.clientetemTransacaoPK == null && other.clientetemTransacaoPK != null) || (this.clientetemTransacaoPK != null && !this.clientetemTransacaoPK.equals(other.clientetemTransacaoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pagamentos.view.ClientetemTransacao[ clientetemTransacaoPK=" + clientetemTransacaoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
