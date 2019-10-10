/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fengl
 */
@Entity
public class Expenses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long expensesID;
    private String type;
    private String name;
    private double amount;
    @Temporal(TemporalType.DATE)
    private Date dateTransact;

    public Long getExpensesID() {
        return expensesID;
    }

    public void setExpensesID(Long expensesID) {
        this.expensesID = expensesID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateTransact() {
        return dateTransact;
    }

    public void setDateTransact(Date dateTransact) {
        this.dateTransact = dateTransact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expensesID != null ? expensesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Expenses)) {
            return false;
        }
        Expenses other = (Expenses) object;
        if ((this.expensesID == null && other.expensesID != null) || (this.expensesID != null && !this.expensesID.equals(other.expensesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Expenses[ expensesID=" + expensesID + " ]";
    }

}
