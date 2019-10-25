/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Bond;
import entity.Expenses;
import entity.Income;
import entity.Player;
import entity.RankingBoard;
import error.NoResultException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import session.stateless.BondSessionLocal;
import session.stateless.ExpensesSessionLocal;
import session.stateless.IncomeSessionLocal;
import session.stateless.PlayerSessionLocal;

/**
 *
 * @author fengl
 */
@ManagedBean
@javax.faces.bean.SessionScoped
public class bondsManagedBean implements Serializable {

    /**
     * Creates a new instance of bondsManagedBean
     */
    @EJB
    BondSessionLocal bondSessionLocal;
    @EJB
    ExpensesSessionLocal expenseSessionLocal;
    @EJB
    PlayerSessionLocal playerSessionLocal;
    @EJB
    IncomeSessionLocal incomeSessionLocal;

    private String expenseActivity;
    private String date;
    private double expenseAmount;

    private String bondName;
    private String crMoodyBond;
    private String bondIssuer;
    private String yieldToMaturity;

    private String incomeActivity;
    private String incomeDate;
    private double incomeAmount;

    @ManagedProperty(value = "#{authenticationManagedBean}")
    private AuthenticationManagedBean authBean;

    public AuthenticationManagedBean getAuthBean() {
        return authBean;
    }

    public void setAuthBean(AuthenticationManagedBean authBean) {
        this.authBean = authBean;
    }

    public String addExpenses() throws ParseException, NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);

        Expenses e = new Expenses();
        e.setType(expenseActivity);
        e.setAmount(expenseAmount);
        e.setDateTransact(new SimpleDateFormat("yyyy-MM-dd").parse(date));

        long newExpenseID = expenseSessionLocal.createExpenses(e);

        e = expenseSessionLocal.retrieveExpenseById(newExpenseID);
        playerSessionLocal.addExpenses(pid, e);

        expenseAmount = 0;
        date = null;

        return "index.xhtml?faces-redirect=true";
    }

    public List<Bond> getRecommendedBonds() throws NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);
        Player p = playerSessionLocal.retrievePlayerById(pid);

        List<Bond> returnList = new ArrayList<>();
        List<Bond> lowRiskBondsList = bondSessionLocal.retrieveAllLowRiskBonds();
        List<Bond> mediumRiskBondsList = bondSessionLocal.retrieveAllMediumRiskBonds();
        List<Bond> highRiskBondsList = bondSessionLocal.retrieveAllHighRiskBonds();

        Random rand = new Random();
        if (p.getRiskAppetite().equals("Low")) {
            Bond b1 = lowRiskBondsList.remove(rand.nextInt(lowRiskBondsList.size()));
            Bond b2 = lowRiskBondsList.remove(rand.nextInt(lowRiskBondsList.size()));
            Bond b3 = lowRiskBondsList.remove(rand.nextInt(lowRiskBondsList.size()));
            Bond b4 = mediumRiskBondsList.remove(rand.nextInt(mediumRiskBondsList.size()));
            returnList.add(b1);
            returnList.add(b2);
            returnList.add(b3);
            returnList.add(b4);

        } else if (p.getRiskAppetite().equals("Medium")) {
            Bond b1 = lowRiskBondsList.remove(rand.nextInt(lowRiskBondsList.size()));
            Bond b2 = mediumRiskBondsList.remove(rand.nextInt(mediumRiskBondsList.size()));
            Bond b3 = mediumRiskBondsList.remove(rand.nextInt(mediumRiskBondsList.size()));
            Bond b4 = highRiskBondsList.remove(rand.nextInt(highRiskBondsList.size()));
            returnList.add(b1);
            returnList.add(b2);
            returnList.add(b3);
            returnList.add(b4);
        } else {
            Bond b1 = mediumRiskBondsList.remove(rand.nextInt(mediumRiskBondsList.size()));
            Bond b2 = mediumRiskBondsList.remove(rand.nextInt(mediumRiskBondsList.size()));
            Bond b3 = highRiskBondsList.remove(rand.nextInt(highRiskBondsList.size()));
            Bond b4 = highRiskBondsList.remove(rand.nextInt(highRiskBondsList.size()));
            returnList.add(b1);
            returnList.add(b2);
            returnList.add(b3);
            returnList.add(b4);
        }

        return returnList;
    }

    public String addIncome() throws ParseException, NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);

        Income i = new Income();
        i.setName(incomeActivity);
        System.out.println(incomeDate);
        i.setDateOfIncome(new SimpleDateFormat("yyyy-MM-dd").parse(incomeDate));
        i.setAmount(incomeAmount);

        long newIncomeID = incomeSessionLocal.createIncome(i);

        i = incomeSessionLocal.retrieveIncomeById(newIncomeID);
        playerSessionLocal.addIncome(pid, i);

        incomeActivity = null;
        incomeDate = null;
        incomeAmount = 0;

        return "index.xhtml?faces-redirect=true";
    }

    public List<RankingBoard> getTopTenRanking() {
        List<RankingBoard> returnList = new ArrayList<>();
        for (Player p : playerSessionLocal.retrieveAllPlayers()) {
            RankingBoard rb = new RankingBoard(p.getLastName() + " " + p.getFirstName());
            for (Income i : p.getIncomeList()) {
                rb.adjustTotalSaving(i.getAmount());
            }
            for (Expenses e : p.getExpensesList()) {
                rb.adjustTotalSaving(-e.getAmount());
            }
            returnList.add(rb);
        }

        Collections.sort(returnList, Collections.reverseOrder());
        if (returnList.size() > 10) {
            return returnList.subList(0, 10);
        } else {
            return returnList;
        }
    }

    public double getUserIncomeByMonth(int month) throws NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);
        Player p1 = playerSessionLocal.retrievePlayerById(pid);

        double incomeOfTheMonth = 0;

        List<Income> playerIncome = p1.getIncomeList();
        for (Income i : playerIncome) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(i.getDateOfIncome());
            int checkMonth = cal.get(Calendar.MONTH);
            if (checkMonth + 1 == month) {
                incomeOfTheMonth += i.getAmount();
            }
        }
        return incomeOfTheMonth;
    }

    public double getUserExpensesByType(String type) throws NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);
        Player p1 = playerSessionLocal.retrievePlayerById(pid);

        double totalExpenses = 0;

        List<Expenses> playerExpenses = p1.getExpensesList();
        for (Expenses e : playerExpenses) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(e.getDateTransact());
            int checkYear = cal.get(Calendar.YEAR);
            cal.setTime(new java.util.Date());
            int currentYear = cal.get(Calendar.YEAR);
            if ((checkYear == currentYear) && (e.getType().equals(type))) {
                totalExpenses += e.getAmount();
            }
        }
        return totalExpenses;
    }

    public double getUserExpensesByMonth(int month) throws NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);
        Player p1 = playerSessionLocal.retrievePlayerById(pid);

        double totalExpenses = 0;

        List<Expenses> playerExpenses = p1.getExpensesList();
        for (Expenses e : playerExpenses) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(e.getDateTransact());
            int checkMonth = cal.get(Calendar.MONTH);
            if (checkMonth + 1 == month) {
                totalExpenses += e.getAmount();
            }
        }
        return totalExpenses;
    }

    public String convertDateToString(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, 2);
        Date modifiedDate = cal.getTime();

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return (dateFormat.format(modifiedDate));
    }

    public bondsManagedBean() {
    }

    public List<Bond> getLowRiskBonds() {
        return bondSessionLocal.retrieveAllLowRiskBonds();
    }

    public List<Bond> getMediumRiskBonds() {
        return bondSessionLocal.retrieveAllMediumRiskBonds();
    }

    public List<Bond> getHighRiskBonds() {
        return bondSessionLocal.retrieveAllHighRiskBonds();
    }

    public BondSessionLocal getBondSessionLocal() {
        return bondSessionLocal;
    }

    public void setBondSessionLocal(BondSessionLocal bondSessionLocal) {
        this.bondSessionLocal = bondSessionLocal;
    }

    public String getBondName() {
        return bondName;
    }

    public void setBondName(String bondName) {
        this.bondName = bondName;
    }

    public String getCrMoodyBond() {
        return crMoodyBond;
    }

    public void setCrMoodyBond(String crMoodyBond) {
        this.crMoodyBond = crMoodyBond;
    }

    public String getBondIssuer() {
        return bondIssuer;
    }

    public void setBondIssuer(String bondIssuer) {
        this.bondIssuer = bondIssuer;
    }

    public String getYieldToMaturity() {
        return yieldToMaturity;
    }

    public void setYieldToMaturity(String yieldToMaturity) {
        this.yieldToMaturity = yieldToMaturity;
    }

    public String getExpenseActivity() {
        return expenseActivity;
    }

    public void setExpenseActivity(String expenseActivity) {
        this.expenseActivity = expenseActivity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public void setExpenseAmount(double expenseAmount) {
        this.expenseAmount = expenseAmount;
    }

    public ExpensesSessionLocal getExpenseSessionLocal() {
        return expenseSessionLocal;
    }

    public void setExpenseSessionLocal(ExpensesSessionLocal expenseSessionLocal) {
        this.expenseSessionLocal = expenseSessionLocal;
    }

    public PlayerSessionLocal getPlayerSessionLocal() {
        return playerSessionLocal;
    }

    public void setPlayerSessionLocal(PlayerSessionLocal playerSessionLocal) {
        this.playerSessionLocal = playerSessionLocal;
    }

    public String getIncomeActivity() {
        return incomeActivity;
    }

    public void setIncomeActivity(String incomeActivity) {
        this.incomeActivity = incomeActivity;
    }

    public String getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(String incomeDate) {
        this.incomeDate = incomeDate;
    }

    public double getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(double incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

}
