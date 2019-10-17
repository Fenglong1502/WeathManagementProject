/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Bond;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vanessaloh
 */
@Local
public interface BondSessionLocal {

    public List<Bond> retrieveAllBonds() throws NoResultException;

    public Bond retrieveBondById(Long id) throws NoResultException;

    public Long createBond(Bond newBond);

    public void updateBond(Bond bond) throws NoResultException;

    public void deleteBond(Long id) throws NoResultException;
    
}
