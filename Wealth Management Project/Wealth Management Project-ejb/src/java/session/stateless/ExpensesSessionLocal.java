/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Expenses;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vanessaloh
 */
@Local
public interface ExpensesSessionLocal {

    public List<Expenses> retrieveUserExpenses(Long userId) throws NoResultException;
    
    public List<Expenses> retrieveAllExpenses();

    public Expenses retrieveExpenseById(Long id) throws NoResultException;

    public Long createExpenses(Expenses newExpenses);

    public void updateExpenses(Expenses expense) throws NoResultException;

    public void deleteExpense(Long id) throws NoResultException;
    
}
