/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

import entity.Rewards;
import error.NoResultException;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author vanessaloh
 */
@Local
public interface RewardsSessionLocal {

    public Rewards createRewards(Rewards reward) throws NoResultException;

    public List<Rewards> retrieveRewardsByPlayerId(Long playerId) throws NoResultException;

    public Rewards retrieveRewardById(Long rewardId) throws NoResultException;

    public void updateRewards(Rewards reward) throws NoResultException;

    public void deleteRewards(Long rewardId) throws NoResultException;
    
}
