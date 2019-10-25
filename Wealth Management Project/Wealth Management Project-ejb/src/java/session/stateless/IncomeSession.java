/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Income;
import entity.Player;
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
public class IncomeSession implements IncomeSessionLocal {

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;

    public IncomeSession() {
    }

    @Override
    public List<Income> retrieveUserIncome(Long userId) throws NoResultException {
        try {
            Query query = em.createQuery("SELECT p FROM Player p WHERE p.playerID =: inPlayerID");
            query.setParameter("inPlayerID", userId);
            Player player = (Player) query.getSingleResult();

            return player.getIncomeList();
        } catch (Exception ex) {
            throw new NoResultException("Player's income cannot be retrieved: " + ex);
        }
    }

    @Override
    public Income retrieveIncomeById(Long id) throws NoResultException {
        Income income = em.find(Income.class, id);
        if (income != null) {
            return income;
        } else {
            throw new javax.persistence.NoResultException("Not found");
        }
    }

    @Override
    public Long createIncome(Income newIncome) {
//        newIncome.setDateOfIncome(new java.util.Date());
        em.persist(newIncome);
        em.flush();
        em.refresh(newIncome);
        return newIncome.getIncomeID();
    }

    @Override
    public void updateIncome(Income income) throws NoResultException {
        if (income.getIncomeID() != null) {
            Income updateIncome = retrieveIncomeById(income.getIncomeID());
            updateIncome.setAmount(income.getAmount());
            updateIncome.setDateOfIncome(income.getDateOfIncome());
            updateIncome.setName(income.getName());
            em.flush();
            em.refresh(updateIncome);
        } else {
            throw new NoResultException("No such income to update. ");
        }
    }

    @Override
    public void deleteIncome(Long id) throws NoResultException {
        if (id != null) {
            Income deleteIncome = retrieveIncomeById(id);
            em.remove(deleteIncome);
            em.flush();
        } else {
            throw new NoResultException("Income cannot be deleted. ");
        }
    }

    @Override
    public List<Income> retrieveAllIncome() {
        Query q;
        q = em.createQuery("SELECT i FROM Income i");
        return q.getResultList();
    }

}
