/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author fengl
 */
public class RankingBoard implements Comparable {

    String userName;
    double totalSaving;

    public RankingBoard() {
    }

    public RankingBoard(String userName) {
        this.userName = userName;
        this.totalSaving = 0;
    }

    public RankingBoard(String userName, double totalSaving) {
        this.userName = userName;
        this.totalSaving = totalSaving;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getTotalSaving() {
        return totalSaving;
    }

    public void setTotalSaving(double totalSaving) {
        this.totalSaving = totalSaving;
    }

    public void adjustTotalSaving(double adjValue) {
        this.totalSaving += adjValue;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RankingBoard)) {
            return false;
        }
        RankingBoard other = (RankingBoard) object;
        if (this.totalSaving != other.totalSaving) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object object) {
        if (!(object instanceof RankingBoard)) {
            return -1;
        } else {
            RankingBoard otherRB = (RankingBoard)object;
            if (this.totalSaving > otherRB.totalSaving) {
                return 1;
            } else if (this.totalSaving == otherRB.totalSaving) {
                return 0;
            } else {
                return -1;
            }
        }
    }

}
