/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBean;

import entity.Bond;
import entity.Expenses;
import entity.Income;
import error.NoResultException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
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
        e.setDateTransact(new SimpleDateFormat("dd/MM/yyyy").parse(date));

        long newExpenseID = expenseSessionLocal.createExpenses(e);

        e = expenseSessionLocal.retrieveExpenseById(newExpenseID);
        playerSessionLocal.addExpenses(pid, e);

        expenseAmount = 0;
        date = null;

        return "index.xhtml?faces-redirect=true";
    }

    public String addIncome() throws ParseException, NoResultException {
        FacesContext context = FacesContext.getCurrentInstance();
        Long pid = (Long) context.getApplication().createValueBinding("#{authenticationManagedBean.id}").getValue(context);
        
        Income i = new Income();
        i.setName(incomeActivity);
        i.setDateOfIncome(new SimpleDateFormat("dd/MM/yyyy").parse(incomeDate));
        i.setAmount(incomeAmount);
        
        long newIncomeID = incomeSessionLocal.createIncome(i);
        
        i= incomeSessionLocal.retrieveIncomeById(newIncomeID);
        playerSessionLocal.addIncome(pid, i);
        
        incomeActivity = null;
        incomeDate = null;
        incomeAmount = 0;
        
        return "index.xhtml?faces-redirect=true";
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
