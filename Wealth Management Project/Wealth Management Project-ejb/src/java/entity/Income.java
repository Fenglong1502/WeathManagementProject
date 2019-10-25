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
public class Income implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long incomeID;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dateOfIncome;
    private double amount;

    public Income(){
        
    }

    public Income(String name, Date dateOfIncome, double amount) {
        this.name = name;
        this.dateOfIncome = dateOfIncome;
        this.amount = amount;
    }
   
    
    public Long getIncomeID() {
        return incomeID;
    }

    public void setIncomeID(Long incomeID) {
        this.incomeID = incomeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (incomeID != null ? incomeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Income)) {
            return false;
        }
        Income other = (Income) object;
        if ((this.incomeID == null && other.incomeID != null) || (this.incomeID != null && !this.incomeID.equals(other.incomeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Income[ incomeID=" + incomeID + " ]";
    }

}
