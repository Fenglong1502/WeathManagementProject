/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fengl
 */
@Entity
public class Rewards implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rewardID;
    private String name;
    private int points;
    @Temporal(TemporalType.DATE)
    private Date expiredDate;
    private boolean isClaimed;

    public Long getRewardID() {
        return rewardID;
    }

    public void setRewardID(Long rewardID) {
        this.rewardID = rewardID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public boolean isIsClaimed() {
        return isClaimed;
    }

    public void setIsClaimed(boolean isClaimed) {
        this.isClaimed = isClaimed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rewardID != null ? rewardID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rewards)) {
            return false;
        }
        Rewards other = (Rewards) object;
        if ((this.rewardID == null && other.rewardID != null) || (this.rewardID != null && !this.rewardID.equals(other.rewardID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rewards[ rewardID=" + rewardID + " ]";
    }

}
