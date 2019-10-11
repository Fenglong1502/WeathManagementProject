/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Expenses;
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
public class ExpensesSession implements ExpensesSessionLocal {

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;

    public ExpensesSession() {
    }

    @Override
    public List<Expenses> retrieveUserExpenses(Long userId) throws NoResultException {
        try {
            Query query = em.createQuery("SELECT p FROM Player p WHERE p.playerID =: inPlayerID");
            query.setParameter("inPlayerID", userId);
            Player player = (Player) query.getSingleResult();

            return player.getExpnesesList();
        } catch (Exception ex) {
            throw new NoResultException("Player's expenses cannot be retrieved: "+ex);
        }
    }
    
    @Override
    public Expenses retrieveExpenseById(Long id) throws NoResultException {
        try {
            Query query = em.createQuery("SELECT e FROM Expenses e WHERE e.expensesID =: inExpenseID");
            query.setParameter("inExpenseID", id);
            return (Expenses) query.getSingleResult();
        } catch (Exception ex) {
            throw new NoResultException("Expense "+id+"cannot be retrieved: "+ex);
        }
    }
    
    @Override
    public Long createExpenses(Expenses newExpenses) {
        newExpenses.setDateTransact(new java.util.Date());
        em.persist(newExpenses);
        em.flush();
        em.refresh(newExpenses);
        return newExpenses.getExpensesID();
    }
    
    @Override
    public void updateExpenses(Expenses expense) throws NoResultException {
        if (expense.getExpensesID()!= null) {
            Expenses updateExpenses = retrieveExpenseById(expense.getExpensesID());
            updateExpenses.setAmount(expense.getAmount());
            updateExpenses.setDateTransact(expense.getDateTransact());
            updateExpenses.setName(expense.getName());
            updateExpenses.setType(expense.getType());
            em.flush();
            em.refresh(updateExpenses);
        } else {
            throw new NoResultException("No such expense to update. ");
        }
    }
    
    @Override
    public void deleteExpense(Long id) throws NoResultException {
        if (id != null) {
            Expenses deleteExpenses = retrieveExpenseById(id);
            em.remove(deleteExpenses);
            em.flush();
        } else {
            throw new NoResultException("Expense cannot be deleted. ");
        }
    }
    
}
