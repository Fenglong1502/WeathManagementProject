/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Bond;
import error.NoResultException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import session.stateless.BondSessionLocal;

/**
 *
 * @author fengl
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class bondsManagedBean implements Serializable {

    /**
     * Creates a new instance of bondsManagedBean
     */
    @EJB
    BondSessionLocal bondSessionLocal;

    private String bondName;
    private String crMoodyBond;
    private String bondIssuer;
    private String yieldToMaturity;

    public bondsManagedBean() {
    }

    public List<Bond> getLowRiskBonds() {
        return bondSessionLocal.retrieveAllLowRiskBonds();
    }
    
    public List<Bond> getMediumRiskBonds() {
        return bondSessionLocal.retrieveAllMediumRiskBonds();
    }
    
    public List<Bond> getHighRiskBonds() {
        return bondSessionLocal.retrieveAllHighRiskBonds();
    }

    public BondSessionLocal getBondSessionLocal() {
        return bondSessionLocal;
    }

    public void setBondSessionLocal(BondSessionLocal bondSessionLocal) {
        this.bondSessionLocal = bondSessionLocal;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getCrMoodyBond() {
        return crMoodyBond;
    }

    public void setCrMoodyBond(String crMoodyBond) {
        this.crMoodyBond = crMoodyBond;
    }

    public String getBondIssuer() {
        return bondIssuer;
    }

    public void setBondIssuer(String bondIssuer) {
        this.bondIssuer = bondIssuer;
    }

    public String getYieldToMaturity() {
        return yieldToMaturity;
    }

    public void setYieldToMaturity(String yieldToMaturity) {
        this.yieldToMaturity = yieldToMaturity;
    }
    
    

}
