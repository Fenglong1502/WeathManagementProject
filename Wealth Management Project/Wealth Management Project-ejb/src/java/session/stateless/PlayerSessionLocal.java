/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session.stateless;

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
    
}
