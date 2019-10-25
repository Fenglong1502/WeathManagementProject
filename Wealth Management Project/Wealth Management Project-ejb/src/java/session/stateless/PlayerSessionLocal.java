/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Expenses;
import entity.Income;
import entity.Player;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vanessaloh
 */
@Local
public interface PlayerSessionLocal {

    public Player createPlayer(Player player) throws NoResultException;

    public List<Player> retrieveAllPlayers();

    public Player retrievePlayerById(Long playerId) throws NoResultException;

    public void updatePlayer(Player player) throws NoResultException;
    
    public boolean login(Player p);
    
    public Player getPlayerByEmail(String email) throws NoResultException;
    
    public void addExpenses(long id , Expenses e);
    
    public void addIncome(long id , Income i);
    
    
}
