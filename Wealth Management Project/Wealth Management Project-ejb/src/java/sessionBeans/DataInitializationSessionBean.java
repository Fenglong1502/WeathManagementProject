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
        Player p1 = new Player("test@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 100, "Tan", "Judy", true, "Female", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "High", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
        Player p2 = new Player("test2@test.com", encryptPassword("123456"), new SimpleDateFormat("dd/MM/yyyy").parse("09/02/2019"), 100, "Lim", "Peter", true, "Male", new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2, "High", new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());

        p1 = playerSessionLocal.createPlayer(p1);
        playerSessionLocal.createPlayer(p2);

        long pid = p1.getPlayerID();

        Income i1 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/01/2019"), 3000);
        Income i2 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/02/2019"), 3000);
        Income i3 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/03/2019"), 3000);
        Income i4 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019"), 3000);
        Income i5 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/05/2019"), 3000);
        Income i6 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/06/2019"), 3000);
        Income i7 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/07/2019"), 3000);
        Income i8 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/08/2019"), 3000);
        Income i9 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019"), 3000);
        Income i10 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/10/2019"), 3000);
        Income i11 = new Income("Salary", new SimpleDateFormat("dd/MM/yyyy").parse("06/11/2019"), 3000);
        Income i12 = new Income("Bonus", new SimpleDateFormat("dd/MM/yyyy").parse("06/04/2019"), 500);
        Income i13 = new Income("GST Voucher", new SimpleDateFormat("dd/MM/yyyy").parse("31/06/2019"), 300);
        Income i14 = new Income("Bonus", new SimpleDateFormat("dd/MM/yyyy").parse("06/09/2019"), 1000);

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
        
        Expenses e1 = new Expenses("Transport", "", 100, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses e2 = new Expenses("Food", "", 425, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses e3 = new Expenses("Entertainment", "", 210, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        Expenses e4 = new Expenses("Others", "", 532, new SimpleDateFormat("dd/MM/yyyy").parse("01/10/2019"));
        
        e1 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(e1));
        e2 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(e2));
        e3 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(e3));
        e4 = expensesSessionLocal.retrieveExpenseById(expensesSessionLocal.createExpenses(e4));

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
        
        playerSessionLocal.addExpenses(pid, e1);
        playerSessionLocal.addExpenses(pid, e2);
        playerSessionLocal.addExpenses(pid, e3);
        playerSessionLocal.addExpenses(pid, e4);
        
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
