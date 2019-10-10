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
public class Bond implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bondID;
    private String bondName;
    private String bondIssuer;
    private String bondType;
    private String investmentDate;
    @Temporal(TemporalType.DATE)
    private Date maturityDate;
    private double yieldToMaturity;
    private double interestPayable;
    private double coupon;
    @Temporal(TemporalType.DATE)
    private Date issueDate;
    private String currency;
    private double minInvestmentAmount;

    public Long getBondID() {
        return bondID;
    }

    public void setBondID(Long bondID) {
        this.bondID = bondID;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getBondIssuer() {
        return bondIssuer;
    }

    public void setBondIssuer(String bondIssuer) {
        this.bondIssuer = bondIssuer;
    }

    public String getBondType() {
        return bondType;
    }

    public void setBondType(String bondType) {
        this.bondType = bondType;
    }

    public String getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(String investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    public double getYieldToMaturity() {
        return yieldToMaturity;
    }

    public void setYieldToMaturity(double yieldToMaturity) {
        this.yieldToMaturity = yieldToMaturity;
    }

    public double getInterestPayable() {
        return interestPayable;
    }

    public void setInterestPayable(double interestPayable) {
        this.interestPayable = interestPayable;
    }

    public double getCoupon() {
        return coupon;
    }

    public void setCoupon(double coupon) {
        this.coupon = coupon;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getMinInvestmentAmount() {
        return minInvestmentAmount;
    }

    public void setMinInvestmentAmount(double minInvestmentAmount) {
        this.minInvestmentAmount = minInvestmentAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bondID != null ? bondID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bond)) {
            return false;
        }
        Bond other = (Bond) object;
        if ((this.bondID == null && other.bondID != null) || (this.bondID != null && !this.bondID.equals(other.bondID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bond[ bondID=" + bondID + " ]";
    }

}
