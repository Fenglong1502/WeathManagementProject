/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Income;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vanessaloh
 */
@Local
public interface IncomeSessionLocal {

    public List<Income> retrieveUserIncome(Long userId) throws NoResultException;

    public Income retrieveIncomeById(Long id) throws NoResultException;

    public Long createIncome(Income newIncome);

    public void updateIncome(Income income) throws NoResultException;

    public void deleteIncome(Long id) throws NoResultException;
    
}
