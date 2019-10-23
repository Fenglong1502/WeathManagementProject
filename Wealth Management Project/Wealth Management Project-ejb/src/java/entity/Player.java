/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author fengl
 */
@Entity
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerID;
    private String email;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    private int points;
    private String firstName;
    private String lastName;
    private boolean accountStatus;
    private String gender;
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    private int consecutiveLogin;
    private String riskAppetite;

    @OneToMany
    private List<Expenses> expensesList;
    @OneToMany
    private List<Income> incomeList;
    @OneToMany
    private List<Rewards> rewardsList;
    @OneToMany
    private List<Bond> trackedBonds;
    @OneToMany
    private List<Bond> recommendedBonds;

    public Player() {
    }

    public Player(String email, String password) {
        this.email = email;
        this.password = password;
        this.joinedDate = new Date();
        this.points = 0;
        this.firstName = "mr";
        this.lastName = "tester";
        this.accountStatus = true;
        this.gender = "gay";
        this.lastLogin = new Date();
        this.consecutiveLogin = 1;
        this.riskAppetite = "";
        this.expensesList = new ArrayList<Expenses>();
        this.incomeList = new ArrayList<Income>();
        this.rewardsList = new ArrayList<Rewards>();
        this.trackedBonds = new ArrayList<Bond>();
        this.recommendedBonds = new ArrayList<Bond>();
    }

    public Long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Long playerID) {
        this.playerID = playerID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getConsecutiveLogin() {
        return consecutiveLogin;
    }

    public void setConsecutiveLogin(int consecutiveLogin) {
        this.consecutiveLogin = consecutiveLogin;
    }

    public String getRiskAppetite() {
        return riskAppetite;
    }

    public void setRiskAppetite(String riskAppetite) {
        this.riskAppetite = riskAppetite;
    }

    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }
    
    public List<Income> getIncomeList() {
        return incomeList;
    }

    public void setIncomeList(List<Income> incomeList) {
        this.incomeList = incomeList;
    }

    public List<Rewards> getRewardsList() {
        return rewardsList;
    }

    public void setRewardsList(List<Rewards> rewardsList) {
        this.rewardsList = rewardsList;
    }

    public List<Bond> getTrackedBonds() {
        return trackedBonds;
    }

    public void setTrackedBonds(List<Bond> trackedBonds) {
        this.trackedBonds = trackedBonds;
    }

    public List<Bond> getRecommendedBonds() {
        return recommendedBonds;
    }

    public void setRecommendedBonds(List<Bond> recommendedBonds) {
        this.recommendedBonds = recommendedBonds;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerID != null ? playerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerID == null && other.playerID != null) || (this.playerID != null && !this.playerID.equals(other.playerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Player[ playerID=" + playerID + " ]";
    }
}
