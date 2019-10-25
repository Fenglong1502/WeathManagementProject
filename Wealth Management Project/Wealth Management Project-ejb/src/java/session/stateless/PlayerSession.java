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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author vanessaloh
 */
@Stateless
public class PlayerSession implements PlayerSessionLocal {

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;

    public PlayerSession() {
    }

    @Override
    public Player createPlayer(Player player) throws NoResultException {
        try {
            em.persist(player);
            em.flush();
            em.refresh(player);
            return player;
        } catch (PersistenceException ex) {
            if (ex.getCause() != null
                    && ex.getCause().getCause() != null
                    && ex.getCause().getCause().getClass().getSimpleName().equals("MySQLIntegrityConstraintViolationException")) {
                throw new NoResultException("Customer with same id already exists!");
            } else {
                throw new NoResultException("An unexpected error has occured: " + ex.getMessage());

            }
        } catch (Exception ex) {
            throw new NoResultException("An unexpected error has occured: " + ex.getMessage());
        }
    }

    @Override
    public List<Player> retrieveAllPlayers() {
        Query query = em.createQuery("SELECT p FROM Player p ORDER BY p.playerID ASC");
        return query.getResultList();
    }

    @Override
    public Player retrievePlayerById(Long playerId) throws NoResultException {
        Player player = em.find(Player.class, playerId);
        if (player != null) {
            return player;
        } else {
            throw new NoResultException("Player ID " + playerId + " does not exist!");
        }
    }

    @Override
    public void updatePlayer(Player player) throws NoResultException {
        try {
            if (player.getPlayerID() != null) {
                Player playerToUpdate = retrievePlayerById(player.getPlayerID());
                playerToUpdate.setEmail(playerToUpdate.getEmail());
                playerToUpdate.setPassword(playerToUpdate.getPassword());
                playerToUpdate.setPoints(playerToUpdate.getPoints());
                playerToUpdate.setFirstName(playerToUpdate.getFirstName());
                playerToUpdate.setLastName(playerToUpdate.getLastName());
                playerToUpdate.setAccountStatus(playerToUpdate.isAccountStatus());
                playerToUpdate.setGender(playerToUpdate.getGender());
                playerToUpdate.setLastLogin(playerToUpdate.getLastLogin());
                playerToUpdate.setConsecutiveLogin(playerToUpdate.getConsecutiveLogin());
                playerToUpdate.setRiskAppetite(playerToUpdate.getRiskAppetite());
                playerToUpdate.setExpensesList(player.getExpensesList());
                playerToUpdate.setIncomeList(player.getIncomeList());
                playerToUpdate.setJoinedDate(player.getJoinedDate());
                playerToUpdate.setRecommendedBonds(player.getRecommendedBonds());
                playerToUpdate.setRewardsList(player.getRewardsList());
                playerToUpdate.setTrackedBonds(player.getTrackedBonds());
                em.flush();
                em.refresh(playerToUpdate);
            } else {
                throw new NoResultException("ID not provided for player information to be updated");
            }
        } catch (PersistenceException ex) {
            if (ex.getCause() != null
                    && ex.getCause().getCause() != null
                    && ex.getCause().getCause().getClass().getSimpleName().equals("MySQLIntegrityConstraintViolationException")) {
                throw new NoResultException("Player already exists!\n");
            }
        }
    }

    @Override
    public boolean login(Player p) {
        Query q = em.createQuery("SELECT p FROM Player p WHERE "
                + "LOWER(p.email) = :email");
        q.setParameter("email", p.getEmail().toLowerCase());

        if (!q.getResultList().isEmpty()) {
            Player checkP = (Player) q.getResultList().get(0);
            if (checkP.getPassword().equals(p.getPassword())) {
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override
    public Player getPlayerByEmail(String email) throws NoResultException {
        Query q;
        q = em.createQuery("SELECT p FROM Player p WHERE "
                + "LOWER(p.email) = :email");
        q.setParameter("email", email.toLowerCase());

        if (!q.getResultList().isEmpty()) {
            return (Player) q.getResultList().get(0);
        } else {
            throw new NoResultException("Player not found.");
        }
    }

    @Override
    public void addExpenses(long id, Expenses e) {
        Player p = em.find(Player.class, id);
        try {
            p.addExpenses(e);
            em.flush();
        } catch (Exception ex) {
            Logger.getLogger(PlayerSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addIncome(long id, Income i) {
        Player p = em.find(Player.class, id);
        try {
            p.addIncome(i);
            em.flush();
        } catch (Exception ex) {
            Logger.getLogger(PlayerSession.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
