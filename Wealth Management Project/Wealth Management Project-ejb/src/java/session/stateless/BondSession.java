/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Bond;
import error.NoResultException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vanessaloh
 */
@Stateless
public class BondSession implements BondSessionLocal {

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;
    
    public BondSession() {
    }
    
    @Override
    public List<Bond> retrieveAllBonds() throws NoResultException {
        try {
            Query query = em.createQuery("SELECT b FROM Bonds b");
            List<Bond> bonds = query.getResultList();

            return bonds;
        } catch (Exception ex) {
            throw new NoResultException("Bonds cannot be retrieved: "+ex);
        }
    }
    
    @Override
    public Bond retrieveBondById(Long id) throws NoResultException {
        try {
            Query query = em.createQuery("SELECT b FROM Bonds b WHERE b.bondID =: inBondID");
            query.setParameter("inBondID", id);
            return (Bond) query.getSingleResult();
        } catch (Exception ex) {
            throw new NoResultException("Bond "+id+"cannot be retrieved: "+ex);
        }
    }
    
    @Override
    public Long createBond(Bond newBond) {
        em.persist(newBond);
        em.flush();
        em.refresh(newBond);
        return newBond.getBondID();
    }
    
    @Override
    public void updateBond(Bond bond) throws NoResultException {
        if (bond.getBondID()!= null) {
            Bond updateBond = retrieveBondById(bond.getBondID());
            updateBond.setBondIssuer(bond.getBondIssuer());
            updateBond.setBondName(bond.getBondName());
            updateBond.setBondType(bond.getBondType());
            updateBond.setCoupon(bond.getCoupon());
            updateBond.setCurrency(bond.getCurrency());
            updateBond.setInterestPayable(bond.getInterestPayable());
            updateBond.setInvestmentDate(bond.getInvestmentDate());
            updateBond.setIssueDate(bond.getIssueDate());
            updateBond.setMaturityDate(bond.getMaturityDate());
            updateBond.setMinInvestmentAmount(bond.getMinInvestmentAmount());
            updateBond.setYieldToMaturity(bond.getYieldToMaturity());
            em.flush();
            em.refresh(updateBond);
        } else {
            throw new NoResultException("No such bond to update. ");
        }
    }
    
    @Override
    public void deleteBond(Long id) throws NoResultException {
        if (id != null) {
            Bond deleteBond = retrieveBondById(id);
//            deleteBond.setActive(Boolean.FALSE);
        } else {
            throw new NoResultException("Bond cannot be deleted. ");
        }
    }
}
