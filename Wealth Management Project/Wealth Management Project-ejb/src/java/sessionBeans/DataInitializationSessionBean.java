/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entity.Bond;
import entity.Expenses;
import entity.Income;
import entity.Player;
import error.NoResultException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import session.stateless.BondSessionLocal;
import session.stateless.ExpensesSessionLocal;
import session.stateless.IncomeSessionLocal;
import session.stateless.PlayerSessionLocal;
import session.stateless.RewardsSessionLocal;

/**
 *
 * @author dk349
 */
@Singleton
@LocalBean
@Startup
public class DataInitializationSessionBean {

    @PersistenceContext(unitName = "Wealth_Management_Project-ejbPU")
    private EntityManager em;

    @EJB
    private BondSessionLocal bondSessionLocal;
    @EJB
    private ExpensesSessionLocal expensesSessionLocal;
    @EJB
    private IncomeSessionLocal incomeSessionLocal;
    @EJB
    private PlayerSessionLocal playerSessionLocal;
    @EJB
    private RewardsSessionLocal rewardSessionLocal;

    @PostConstruct
    public void postConstruct() {
        if (em.find(Player.class, 1l) == null) {
            try {
                initializeData();
            } catch (ParseException ex) {
                Logger.getLogger(DataInitializationSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NoResultException ex) {
                Logger.getLogger(DataInitializationSessionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DataInitializationSessionBean() {
    }

    private void initializeData() throws ParseException, NoResultException {
        //Initialise new user
        Player p1 = new Player("test@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 100, "Tan", "Judy", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Low", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p2 = new Player("test2@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Lim", "Peter", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "High", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p3 = new Player("test3@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Huat", "Ah", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Medium", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p4 = new Player("test4@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Lian", "Ah", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Medium", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p5 = new Player("test5@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Hui", "Ah", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Low", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p6 = new Player("test6@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Lester", "Moe", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Low", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p7 = new Player("test7@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "bin Suparman", "Batman", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Low", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p8 = new Player("test8@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "James", "Edmund", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "High", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p9 = new Player("test9@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Lim", "Steven", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Medium", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p10 = new Player("test10@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Kan", "Nina", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Low", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p11 = new Player("test11@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Chow", "Jackie", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "Medium", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p12 = new Player("test12@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Ang", "Rose", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "High", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());

        p1 = playerSessionLocal.createPlayer(p1);
        p2 = playerSessionLocal.createPlayer(p2);
        p3 = playerSessionLocal.createPlayer(p3);
        p4 = playerSessionLocal.createPlayer(p4);
        p5 = playerSessionLocal.createPlayer(p5);
        p6 = playerSessionLocal.createPlayer(p6);
        p7 = playerSessionLocal.createPlayer(p7);
        p8 = playerSessionLocal.createPlayer(p8);
        p9 = playerSessionLocal.createPlayer(p9);
        p10 = playerSessionLocal.createPlayer(p10);
        p11 = playerSessionLocal.createPlayer(p11);
        p12 = playerSessionLocal.createPlayer(p12);

        long pid = p1.getPlayerID();
        long pid2 = p2.getPlayerID();
        long pid3 = p3.getPlayerID();
        long pid4 = p4.getPlayerID();
        long pid5 = p5.getPlayerID();
        long pid6 = p6.getPlayerID();
        long pid7 = p7.getPlayerID();
        long pid8 = p8.getPlayerID();
        long pid9 = p9.getPlayerID();
        long pid10 = p10.getPlayerID();
        long pid11 = p11.getPlayerID();
        long pid12 = p12.getPlayerID();

        Income i1 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2019"), 4500);
        Income i2 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/02/2019"), 4500);
        Income i3 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/03/2019"), 4500);
        Income i4 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019"), 4500);
        Income i5 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2019"), 4500);
        Income i6 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/06/2019"), 4500);
        Income i7 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2019"), 4500);
        Income i8 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/08/2019"), 4500);
        Income i9 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019"), 4500);
        Income i10 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2019"), 4500);
        Income i11 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/11/2019"), 4500);
        Income i12 = new Income("Bonus", new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019"), 2000);
        Income i13 = new Income("GST Voucher", new SimpleDateFormat("dd/MM/yyyy").parse("31/06/2019"), 300);
        Income i14 = new Income("Bonus", new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019"), 1500);

        Income ip2 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2019"), 67000);
        Income ip3 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/03/2019"), 52000);
        Income ip4 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019"), 49500);
        Income ip5 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2019"), 58500);
        Income ip6 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/06/2019"), 60000);
        Income ip7 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2019"), 62500);
        Income ip8 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/08/2019"), 56500);
        Income ip9 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019"), 54060);
        Income ip10 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2019"), 52000);
        Income ip11 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/11/2019"), 65200);
        Income ip12 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/02/2019"), 47000);

        i1 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i1));
        i2 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i2));
        i3 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i3));
        i4 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i4));
        i5 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i5));
        i6 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i6));
        i7 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i7));
        i8 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i8));
        i9 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i9));
        i10 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i10));
        i11 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i11));
        i12 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i12));
        i13 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i13));
        i14 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(i14));

        ip2 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip2));
        ip3 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip3));
        ip4 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip4));
        ip5 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip5));
        ip6 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip6));
        ip7 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip7));
        ip8 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip8));
        ip9 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip9));
        ip10 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip10));
        ip11 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip11));
        ip12 = incomeSessionLocal.retrieveIncomeById(incomeSessionLocal.createIncome(ip12));

        Expenses et1 = new Expenses("Transport", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
        Expenses ef1 = new Expenses("Food", "", 320, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
        Expenses ee1 = new Expenses("Entertainment", "", 420, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
        Expenses eo1 = new Expenses("Others", "", 200, new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2019"));
        Expenses et2 = new Expenses("Transport", "", 110, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2019"));
        Expenses ef2 = new Expenses("Food", "", 450, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2019"));
        Expenses ee2 = new Expenses("Entertainment", "", 365, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2019"));
        Expenses eo2 = new Expenses("Others", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2019"));
        Expenses et3 = new Expenses("Transport", "", 150, new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019"));
        Expenses ef3 = new Expenses("Food", "", 400, new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019"));
        Expenses ee3 = new Expenses("Entertainment", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019"));
        Expenses eo3 = new Expenses("Others", "", 520, new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019"));
        Expenses et4 = new Expenses("Transport", "", 100, new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019"));
        Expenses ef4 = new Expenses("Food", "", 460, new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019"));
        Expenses ee4 = new Expenses("Entertainment", "", 200, new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019"));
        Expenses eo4 = new Expenses("Others", "", 200, new SimpleDateFormat("dd/MM/yyyy").parse("01/04/2019"));
        Expenses et5 = new Expenses("Transport", "", 110, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
        Expenses ef5 = new Expenses("Food", "", 428, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
        Expenses ee5 = new Expenses("Entertainment", "", 325, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
        Expenses eo5 = new Expenses("Others", "", 245, new SimpleDateFormat("dd/MM/yyyy").parse("01/05/2019"));
        Expenses et6 = new Expenses("Transport", "", 100, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ef6 = new Expenses("Food", "", 350, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ee6 = new Expenses("Entertainment", "", 400, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses eo6 = new Expenses("Others", "", 350, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses et7 = new Expenses("Transport", "", 110, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"));
        Expenses ef7 = new Expenses("Food", "", 320, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"));
        Expenses ee7 = new Expenses("Entertainment", "", 320, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"));
        Expenses eo7 = new Expenses("Others", "", 310, new SimpleDateFormat("dd/MM/yyyy").parse("01/07/2019"));
        Expenses et8 = new Expenses("Transport", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2019"));
        Expenses ef8 = new Expenses("Food", "", 420, new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2019"));
        Expenses ee8 = new Expenses("Entertainment", "", 390, new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2019"));
        Expenses eo8 = new Expenses("Others", "", 200, new SimpleDateFormat("dd/MM/yyyy").parse("01/08/2019"));
        Expenses et9 = new Expenses("Transport", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2019"));
        Expenses ef9 = new Expenses("Food", "", 360, new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2019"));
        Expenses ee9 = new Expenses("Entertainment", "", 120, new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2019"));
        Expenses eo9 = new Expenses("Others", "", 210, new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2019"));
        Expenses et10 = new Expenses("Transport", "", 110, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses ef10 = new Expenses("Food", "", 425, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses ee10 = new Expenses("Entertainment", "", 210, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses eo10 = new Expenses("Others", "", 532, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses et11 = new Expenses("Transport", "", 90, new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2019"));
        Expenses ef11 = new Expenses("Food", "", 520, new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2019"));
        Expenses ee11 = new Expenses("Entertainment", "", 300, new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2019"));
        Expenses eo11 = new Expenses("Others", "", 412, new SimpleDateFormat("dd/MM/yyyy").parse("01/11/2019"));
        
        Expenses ep2 = new Expenses("Others", "", 11220, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep3 = new Expenses("Others", "", 13200, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep4 = new Expenses("Others", "", 18300, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep5 = new Expenses("Others", "", 25000, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep6 = new Expenses("Others", "", 15290, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep7 = new Expenses("Others", "", 22540, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep8 = new Expenses("Others", "", 17500, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep9 = new Expenses("Others", "", 24300, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep10 = new Expenses("Others", "", 23230, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep11 = new Expenses("Others", "", 18920, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
        Expenses ep12 = new Expenses("Others", "", 23050, new SimpleDateFormat("dd/MM/yyyy").parse("01/06/2019"));
       
        

        et1 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et1));
        ef1 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef1));
        ee1 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee1));
        eo1 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo1));
        et2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et2));
        ef2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef2));
        ee2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee2));
        eo2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo2));
        et3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et3));
        ef3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef3));
        ee3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee3));
        eo3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo3));
        et4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et4));
        ef4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef4));
        ee4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee4));
        eo4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo4));
        et5 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et5));
        ef5 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef5));
        ee5 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee5));
        eo5 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo5));
        et6 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et6));
        ef6 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef6));
        ee6 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee6));
        eo6 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo6));
        et7 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et7));
        ef7 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef7));
        ee7 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee7));
        eo7 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo7));
        et8 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et8));
        ef8 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef8));
        ee8 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee8));
        eo8 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo8));
        et9 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et9));
        ef9 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef9));
        ee9 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee9));
        eo9 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo9));
        et10 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et10));
        ef10 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef10));
        ee10 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee10));
        eo10 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo10));
        et11 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(et11));
        ef11 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ef11));
        ee11 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ee11));
        eo11 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(eo11));
        
        
        ep2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep2));
        ep3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep3));
        ep4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep4));
        ep5 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep5));
        ep6 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep6));
        ep7 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep7));
        ep8 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep8));
        ep9 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep9));
        ep10 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep10));
        ep11 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep11));
        ep12 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(ep12));

        playerSessionLocal.addIncome(pid, i1);
        playerSessionLocal.addIncome(pid, i2);
        playerSessionLocal.addIncome(pid, i3);
        playerSessionLocal.addIncome(pid, i4);
        playerSessionLocal.addIncome(pid, i5);
        playerSessionLocal.addIncome(pid, i6);
        playerSessionLocal.addIncome(pid, i7);
        playerSessionLocal.addIncome(pid, i8);
        playerSessionLocal.addIncome(pid, i9);
        playerSessionLocal.addIncome(pid, i10);
        playerSessionLocal.addIncome(pid, i11);
        playerSessionLocal.addIncome(pid, i12);
        playerSessionLocal.addIncome(pid, i13);
        playerSessionLocal.addIncome(pid, i14);
        
        playerSessionLocal.addIncome(pid2, ip2);
        playerSessionLocal.addIncome(pid3, ip3);
        playerSessionLocal.addIncome(pid4, ip4);
        playerSessionLocal.addIncome(pid5, ip5);
        playerSessionLocal.addIncome(pid6, ip6);
        playerSessionLocal.addIncome(pid7, ip7);
        playerSessionLocal.addIncome(pid8, ip8);
        playerSessionLocal.addIncome(pid9, ip9);
        playerSessionLocal.addIncome(pid10, ip10);
        playerSessionLocal.addIncome(pid11, ip11);
        playerSessionLocal.addIncome(pid12, ip12);

        playerSessionLocal.addExpenses(pid, et1);
        playerSessionLocal.addExpenses(pid, ef1);
        playerSessionLocal.addExpenses(pid, ee1);
        playerSessionLocal.addExpenses(pid, eo1);
        playerSessionLocal.addExpenses(pid, et2);
        playerSessionLocal.addExpenses(pid, ef2);
        playerSessionLocal.addExpenses(pid, ee2);
        playerSessionLocal.addExpenses(pid, eo2);
        playerSessionLocal.addExpenses(pid, et3);
        playerSessionLocal.addExpenses(pid, ef3);
        playerSessionLocal.addExpenses(pid, ee3);
        playerSessionLocal.addExpenses(pid, eo3);
        playerSessionLocal.addExpenses(pid, et4);
        playerSessionLocal.addExpenses(pid, ef4);
        playerSessionLocal.addExpenses(pid, ee4);
        playerSessionLocal.addExpenses(pid, eo4);
        playerSessionLocal.addExpenses(pid, et5);
        playerSessionLocal.addExpenses(pid, ef5);
        playerSessionLocal.addExpenses(pid, ee5);
        playerSessionLocal.addExpenses(pid, eo5);
        playerSessionLocal.addExpenses(pid, et6);
        playerSessionLocal.addExpenses(pid, ef6);
        playerSessionLocal.addExpenses(pid, ee6);
        playerSessionLocal.addExpenses(pid, eo6);
        playerSessionLocal.addExpenses(pid, et7);
        playerSessionLocal.addExpenses(pid, ef7);
        playerSessionLocal.addExpenses(pid, ee7);
        playerSessionLocal.addExpenses(pid, eo7);
        playerSessionLocal.addExpenses(pid, et8);
        playerSessionLocal.addExpenses(pid, ef8);
        playerSessionLocal.addExpenses(pid, ee8);
        playerSessionLocal.addExpenses(pid, eo8);
        playerSessionLocal.addExpenses(pid, et9);
        playerSessionLocal.addExpenses(pid, ef9);
        playerSessionLocal.addExpenses(pid, ee9);
        playerSessionLocal.addExpenses(pid, eo9);
        playerSessionLocal.addExpenses(pid, et10);
        playerSessionLocal.addExpenses(pid, ef10);
        playerSessionLocal.addExpenses(pid, ee10);
        playerSessionLocal.addExpenses(pid, eo10);
        playerSessionLocal.addExpenses(pid, et11);
        playerSessionLocal.addExpenses(pid, ef11);
        playerSessionLocal.addExpenses(pid, ee11);
        playerSessionLocal.addExpenses(pid, eo11);

        playerSessionLocal.addExpenses(pid2, ep2);
        playerSessionLocal.addExpenses(pid3, ep3);
        playerSessionLocal.addExpenses(pid4, ep4);
        playerSessionLocal.addExpenses(pid5, ep5);
        playerSessionLocal.addExpenses(pid6, ep6);
        playerSessionLocal.addExpenses(pid7, ep7);
        playerSessionLocal.addExpenses(pid8, ep8);
        playerSessionLocal.addExpenses(pid9, ep9);
        playerSessionLocal.addExpenses(pid10, ep10);
        playerSessionLocal.addExpenses(pid11, ep11);
        playerSessionLocal.addExpenses(pid12, ep12);
        
        Bond b1 = new Bond("SG7X40961493", "SP PowerAssets Ltd", "SPSP 3.140% 31Aug2022 Qsov (SGD)", "FDALT", "Aa2", 3.14, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("26/05/2014"), 3.14, new SimpleDateFormat("dd/MM/yyyy").parse("26/05/2165"), 2.21, "", "", 0);
        Bond b2 = new Bond("USY79985AD29", "Singapore Telecommunications Limited", "STSP 7.375% 01Dec2031 Corp (USD)", "SISEEKER", "A1", 7.375, "USD", 1000, new SimpleDateFormat("dd/MM/yyyy").parse("19/11/2001"), 7.459, new SimpleDateFormat("dd/MM/yyyy").parse("30/11/2031"), 2.821, "", "", 0);
        Bond b3 = new Bond("XS1226628961", "CLP Power Hong Kong Financing Ltd", "CHINLP 3.125% 06May2025 Corp (USD)", "SISEEKER", "A1", 3.125, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2015"), 3.243, new SimpleDateFormat("dd/MM/yyyy").parse("05/05/2025"), 2.529, "", "", 0);
        Bond b4 = new Bond("SG7V35954653", "Temasek Financial (I) Limited", "TEMASE 3.785% 05Mar2025 Qsov (SGD)", "FDALT", "Aaa", 3.785, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("04/03/2010"), 3.785, new SimpleDateFormat("dd/MM/yyyy").parse("04/03/2025"), 2.261, "", "", 0);
        Bond b5 = new Bond("US50126AAB70", "Kunlun Energy Co Ltd", "KUNLEG 3.750% 13May2025 Corp (USD)", "SISEEKER", "A2", 3.75, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2015"), 3.872, new SimpleDateFormat("dd/MM/yyyy").parse("12/05/2025"), 2.756, "", "", 0);
        Bond b6 = new Bond("XS1907273350", "Bank of China Limited, Hong Kong Branch", "BCHINA 4.450% 20Nov2021 Corp (CNH)", "SISEEKER", "A1", 4.45, "CNH", 1000000, new SimpleDateFormat("dd/MM/yyyy").parse("19/11/2018"), 4.45, new SimpleDateFormat("dd/MM/yyyy").parse("19/11/2021"), 3.251, "", "", 0);
        Bond b7 = new Bond("XS1451270687", "China Railway XunJie Co. Limited", "CHRAIL 3.250% 28Jul2026 Corp (USD)", "SISEEKER", "A3", 3.25, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("27/07/2016"), 3.369, new SimpleDateFormat("dd/MM/yyyy").parse("27/07/2026"), 2.813, "", "", 0);
        Bond b8 = new Bond("NY05100N", "Singapore Government", "NY05100N; Coupon: 3.250%; Maturity: 01/09/2020", "FDALT", "Aaa", 3.25, "SGD", 1000, new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2005"), 3.335, new SimpleDateFormat("dd/MM/yyyy").parse("31/08/2020"), 1.698, "", "", 0);
        Bond b9 = new Bond("SG70I9000003", "DBS Group Holdings Ltd", "DBSSP 2.780% 11Jan2021 Corp (SGD)", "SISEEKER", "Aa2", 2.78, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2016"), 2.78, new SimpleDateFormat("dd/MM/yyyy").parse("10/01/2021"), 2.192, "", "", 0);
        Bond b10 = new Bond("XS1725308859", "Times Property Holdings Limited", "TPHL 6.600% 02Mar2023 Corp (USD)", "HYSEEKER", "B1", 6.6, "USD", 1200000, new SimpleDateFormat("dd/MM/yyyy").parse("29/11/2017"), 6.625, new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2023"), 7.229196, "", "", 0);
        Bond b11 = new Bond("USQ0426RNB07", "Australia & New Zealand Banking Group Ltd", "ANZ 4.500% 19Mar2024 Corp (USD)", "SISEEKER", "Baa1", 4.5, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("18/03/2014"), 4.517, new SimpleDateFormat("dd/MM/yyyy").parse("18/03/2024"), 2.896324, "", "", 0);
        Bond b12 = new Bond("XS1538864825", "Bestgain Real Estate Lyra Ltd (Keepwell: China Vanke Co Ltd)", "VNKRLE 3.950% 23Dec2019 Corp (USD)", "SISEEKER", "Baa2", 3.95, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2016"), 4, new SimpleDateFormat("dd/MM/yyyy").parse("22/12/2019"), 2.586, "", "", 0);
        Bond b13 = new Bond("XS1602480334", "Times Property Holdings Ltd", "TPHL 5.750% 26Apr2022 Corp (USD)", "HYSEEKER", "B1", 5.75, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("25/04/2017"), 5.75, new SimpleDateFormat("dd/MM/yyyy").parse("25/04/2022"), 6.704099, "", "", 0);
        Bond b14 = new Bond("XS2033262895", "Longfor Group Holdings Limited", "LNGFOR 3.950% 16Sep2029 Corp (USD)", "SISEEKER", "Baa3", 3.95, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2019"), 4.064, new SimpleDateFormat("dd/MM/yyyy").parse("15/09/2029"), 4.157, "", "", 0);
        Bond b15 = new Bond("XS1023280271", "Wanda Properties International Co Ltd (Keepwell: Dalian Wanda Commercial Properties)", "DALWAN 7.250% 29Jan2024 Corp (USD)", "HYSEEKER", "Ba3", 7.25, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2014"), 7.393, new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2024"), 7.559, "", "", 0);
        Bond b16 = new Bond("SG6OG5000008", "Suntec REIT MTN Pte Ltd", "SUNSP 3.350% 10Feb2020 Corp (SGD)", "SISEEKER", "Baa3", 3.35, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2014"), 3.35, new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2020"), 2.8, "", "", 0);
        Bond b17 = new Bond("XS2027359756", "Vietnam Prosperity Joint Stock Commercial Bank", "VIPRJS 6.250% 17Jul2022 Corp (USD)", "HYSEEKER", "B1", 6.25, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("16/07/2019"), 6.5, new SimpleDateFormat("dd/MM/yyyy").parse("16/07/2022"), 7.056, "", "", 0);
        Bond b18 = new Bond("XS1784286327", "Fantasia Holdings Group Ltd", "FTHDGR 8.375% 08Mar2021 Corp (USD)", "HYSEEKER", "B3", 8.375, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("07/03/2018"), 8.375, new SimpleDateFormat("dd/MM/yyyy").parse("07/03/2021"), 14.053, "", "", 0);
        Bond b19 = new Bond("XS1960762554", "Greenland Global Investment Limited", "GRNLGR 7.250% 12Mar2022 Corp (USD)", "HYSEEKER", "Ba2", 7.25, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2019"), 7.25, new SimpleDateFormat("dd/MM/yyyy").parse("11/03/2022"), 5.999, "", "", 0);
        Bond b20 = new Bond("USF43628C734", "Societe Generale SA", "SOCGEN 7.375% Perpetual Corp (USD)", "HYSEEKER", "Ba2", 7.375, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("12/09/2016"), 7.375, new SimpleDateFormat("dd/MM/yyyy").parse("12/09/2165"), 7.413688, "", "", 0);
        Bond b21 = new Bond("XS1882693036", "HSBC Holdings PLC", "HSBC 5.000% Perpetual Corp (SGD)", "SISEEKER", "Baa3", 5, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2018"), 5, new SimpleDateFormat("dd/MM/yyyy").parse("23/09/2165"), 4.326538, "", "", 0);
        Bond b22 = new Bond("XS1450327686", "Minmetals Bounteous Finance (BVI) Limited", "MINMET 3.125% 27Jul2021 Corp (USD)", "SISEEKER", "Baa1", 3.125, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("26/07/2016"), 3.344, new SimpleDateFormat("dd/MM/yyyy").parse("26/07/2021"), 2.692, "", "", 0);
        Bond b23 = new Bond("USY8137FAP37", "The Democratic Socialist Republic of Sri Lanka", "SRILAN 7.850% 14Mar2029 Govt (USD)", "HYSEEKER", "B2", 7.85, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2019"), 7.85, new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2029"), 7.805, "", "", 0);
        Bond b24 = new Bond("XS1795479291", "China SCE Property Holdings Limited", "CHINSC 7.450% 17Apr2021 Corp (USD)", "HYSEEKER", "B2", 7.45, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("16/04/2018"), 7.45, new SimpleDateFormat("dd/MM/yyyy").parse("16/04/2021"), 6.536308, "", "", 0);
        Bond b25 = new Bond("XS1611005957", "China Aoyuan Group Limited", "CAPG 5.375% 13Sep2022 Corp (USD)", "HYSEEKER", "B2", 5.375, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("12/09/2017"), 5.375, new SimpleDateFormat("dd/MM/yyyy").parse("12/09/2022"), 6.497512, "", "", 0);
        Bond b26 = new Bond("XS1643556670", "Gemstones International Limited", "LVGEM 8.500% 15Aug2020 Corp (USD)", "HYSEEKER", "Caa1", 8.5, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("14/08/2017"), 8.5, new SimpleDateFormat("dd/MM/yyyy").parse("14/08/2020"), 11.974, "", "", 0);
        Bond b27 = new Bond("XS1725031105", "Tahoe Group Global (Co.,) Limited", "THHTGP 7.875% 17Jan2021 Corp (USD)", "HYSEEKER", "Caa1", 7.875, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("16/01/2018"), 8, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2021"), 28.967803, "", "", 0);

        bondSessionLocal.createBond(b1);
        bondSessionLocal.createBond(b2);
        bondSessionLocal.createBond(b3);
        bondSessionLocal.createBond(b4);
        bondSessionLocal.createBond(b5);
        bondSessionLocal.createBond(b6);
        bondSessionLocal.createBond(b7);
        bondSessionLocal.createBond(b8);
        bondSessionLocal.createBond(b9);
        bondSessionLocal.createBond(b10);
        bondSessionLocal.createBond(b11);
        bondSessionLocal.createBond(b12);
        bondSessionLocal.createBond(b13);
        bondSessionLocal.createBond(b14);
        bondSessionLocal.createBond(b15);
        bondSessionLocal.createBond(b16);
        bondSessionLocal.createBond(b17);
        bondSessionLocal.createBond(b18);
        bondSessionLocal.createBond(b19);
        bondSessionLocal.createBond(b20);
        bondSessionLocal.createBond(b21);
        bondSessionLocal.createBond(b22);
        bondSessionLocal.createBond(b23);
        bondSessionLocal.createBond(b24);
        bondSessionLocal.createBond(b25);
        bondSessionLocal.createBond(b26);
        bondSessionLocal.createBond(b27);
    }

    private static String encryptPassword(String password) {
        String sha1 = "";
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(password.getBytes("UTF-8"));
            sha1 = byteToHex(crypt.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }
}
