/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagamentos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author root
 */
@Embeddable
public class ClientetemTransacaoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "Id_Cliente")
    private int idCliente;
    @Basic(optional = false)
    @Column(name = "codTransacao")
    private int codTransacao;

    public ClientetemTransacaoPK() {
    }

    public ClientetemTransacaoPK(int idCliente, int codTransacao) {
        this.idCliente = idCliente;
        this.codTransacao = codTransacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCodTransacao() {
        return codTransacao;
    }

    public void setCodTransacao(int codTransacao) {
        this.codTransacao = codTransacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idCliente;
        hash += (int) codTransacao;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientetemTransacaoPK)) {
            return false;
        }
        ClientetemTransacaoPK other = (ClientetemTransacaoPK) object;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        if (this.codTransacao != other.codTransacao) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pagamentos.view.ClientetemTransacaoPK[ idCliente=" + idCliente + ", codTransacao=" + codTransacao + " ]";
    }
    
}
