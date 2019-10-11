/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Player;
import entity.Rewards;
import error.NoResultException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 *
 * @author vanessaloh
 */
@Stateless
public class RewardsSession implements RewardsSessionLocal {

    @EJB(name = "PlayerSessionLocal")
    private PlayerSessionLocal playerSession;

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;

    public RewardsSession() {
    }
    
    @Override
    public Rewards createRewards(Rewards reward) throws NoResultException {
        try {
            em.persist(reward);
            em.flush();
            em.refresh(reward);
            return reward;
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
    public List<Rewards> retrieveRewardsByPlayerId(Long playerId) throws NoResultException {
        Player player = playerSession.retrievePlayerById(playerId);
        return player.getRewardsList();
    }
    
    @Override
    public Rewards retrieveRewardById(Long rewardId) throws NoResultException {
        Rewards reward = em.find(Rewards.class, rewardId);
        if (reward != null) {
            return reward;
        } else {
            throw new NoResultException("Reward ID " + rewardId + " does not exist!");
        }
    }
    
    @Override
    public void updateRewards(Rewards reward) throws NoResultException {
        try {
            if (reward.getRewardID() != null) {
                Rewards rewardToUpdate = retrieveRewardById(reward.getRewardID());
                rewardToUpdate.setName(rewardToUpdate.getName());
                rewardToUpdate.setPoints(rewardToUpdate.getPoints());
                rewardToUpdate.setExpiredDate(rewardToUpdate.getExpiredDate());
                rewardToUpdate.setIsClaimed(rewardToUpdate.isIsClaimed());
            } else {
                throw new NoResultException("ID not provided for rewards information to be updated");
            }
        } catch (PersistenceException ex) {
            if (ex.getCause() != null
                    && ex.getCause().getCause() != null
                    && ex.getCause().getCause().getClass().getSimpleName().equals("MySQLIntegrityConstraintViolationException")) {
                throw new NoResultException("Reward already exists!\n");
            }
        }
    }
    
    @Override
    public void deleteRewards(Long rewardId) throws NoResultException {
        if (rewardId != null) {
            Rewards rToDelete = retrieveRewardById(rewardId);
            em.remove(rToDelete);
        } else {
            throw new NoResultException("ID not provided for brand to be deleted");
        }
    }
}