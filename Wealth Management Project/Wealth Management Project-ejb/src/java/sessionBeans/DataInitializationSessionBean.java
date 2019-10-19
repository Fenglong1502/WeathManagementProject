/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import entity.Bond;
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
    private ExpensesSessionLocal expensesLocal;
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
            }
        }
    }

    public DataInitializationSessionBean() {
    }

    private void initializeData() throws ParseException {
        //Initialise new user
        Player p1 = new Player("test@test.com", encryptPassword("123456"))
        
        
        
        Bond b1 = new Bond("SG6SG8000006", "Jurong Shipyard Pte Ltd", "SMMSP 2.950% 10Sep2021 Corp (SGD)", "SISEEKER", "N.R", 2.95, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.95, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 2.993, "", "", 0);
        Bond b2 = new Bond("XS1725308859", "Times Property Holdings Limited", "TPHL 6.600% 02Mar2023 Corp (USD)", "HYSEEKER", "B1", 6.6, "USD", 1200000, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.625, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/2019"), 7.229196, "", "", 0);
        Bond b3 = new Bond("USQ0426RNB07", "Australia & New Zealand Banking Group Ltd", "ANZ 4.500% 19Mar2024 Corp (USD)", "SISEEKER", "Baa1", 4.5, "USD", 200000, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.517, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.896324, "", "", 0);
        Bond b4 = new Bond("SG7X40961493", "SP PowerAssets Ltd", "SPSP 3.140% 31Aug2022 Qsov (SGD)", "FDALT", "Aa2", 3.14, "SGD", 250000, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.14, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.21, "", "", 0);
        Bond b5 = new Bond("XS1796078324", "OUE Ltd", "OUESP 1.500% 13Apr2023 Corp (SGD)", "HYSEEKER", "N.R", 1.5, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.5,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.593017, "", "", 0);
        Bond b6 = new Bond("USY79985AD29", "Singapore Telecommunications Limited", "STSP 7.375% 01Dec2031 Corp (USD)", "SISEEKER", "A1", 7.375, "USD", 1000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.459,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.821, "", "", 0);
        Bond b7 = new Bond("XS1133586963", "New World China Land Limited", "NEWWOR 5.375% 06Nov2019 Corp (USD)", "SISEEKER", "N.R", 5.375, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.375,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.195, "", "", 0);
        Bond b8 = new Bond("SG7E60927286", "Public Utilities Board", "PUBLSP 3.520% 26Oct2020 Qsov (SGD)", "FDALT", "N.R", 3.52, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.52,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.932, "", "", 0);
        Bond b9 = new Bond("XS1538864825", "Bestgain Real Estate Lyra Ltd (Keepwell: China Vanke Co Ltd)", "VNKRLE 3.950% 23Dec2019 Corp (USD)", "SISEEKER", "Baa2", 3.95, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.586, "", "", 0);
        Bond b10 = new Bond("AQ6098125", "Heeton Holdings Ltd", "HTONSP 6.080% 19July2021 Corp (SGD)", "HYSEEKER", "N.R", 6.08, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.08,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.756, "", "", 0);
        Bond b11 = new Bond("XS1366918305", "OVPH Limited (Guarantor: Cheung Kong Infrastructure Holdings Limited)", "CKINF 5.875% Perpetual Corp (USD)", "SISEEKER", "N.R", 5.875, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.875,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.754641, "", "", 0);
        Bond b12 = new Bond("ZS6668207", "Wing Tai Holdings Ltd", "WINGTA 4.480% Perpetual Corp (SGD)", "HYSEEKER", "N.R", 4.48, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.48,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.241454, "", "", 0);
        Bond b13 = new Bond("XS1602480334", "Times Property Holdings Ltd", "TPHL 5.750% 26Apr2022 Corp (USD)", "HYSEEKER", "B1", 5.75, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.75,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.704099, "", "", 0);
        Bond b14 = new Bond("XS2033262895", "Longfor Group Holdings Limited", "LNGFOR 3.950% 16Sep2029 Corp (USD)", "SISEEKER", "Baa3", 3.95, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.064,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.157, "", "", 0);
        Bond b15 = new Bond("XS1023280271", "Wanda Properties International Co Ltd (Keepwell: Dalian Wanda Commercial Properties)", "DALWAN 7.250% 29Jan2024 Corp (USD)", "HYSEEKER", "Ba3", 7.25, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.393,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.559, "", "", 0);
        Bond b16 = new Bond("XS1763164206", "Korean Air Lines Co., Ltd.", "KOREAN 5.875% 06Mar2021 Corp (USD)", "HYSEEKER", "N.R", 5.875, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.261, "", "", 0);
        Bond b17 = new Bond("ZS3816676", "Keppel Corporation Limited", "KEPSP 3.660% 07May2029 Corp (SGD)", "SISEEKER", "N.R", 3.66, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.66,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.261, "", "", 0);
        Bond b18 = new Bond("USG8201FAA78", "Sirius International Group", "SIRINT 4.600% 01Nov2026 Corp (USD)", "SISEEKER", "N.R", 4.6, "USD", 2000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.7,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.869347, "", "", 0);
        Bond b19 = new Bond("AU3CB0256212", "Maurice Blackburn Pty Ltd", "MRBBAU 7.450% 31Aug2022 Corp (AUD)", "HYSEEKER", "N.R", 7.45, "AUD", 50000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.45,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 8.465668, "", "", 0);
        Bond b20 = new Bond("SG6OG5000008", "Suntec REIT MTN Pte Ltd", "SUNSP 3.350% 10Feb2020 Corp (SGD)", "SISEEKER", "Baa3", 3.35, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.35,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.8, "", "", 0);
        Bond b21 = new Bond("XS2027359756", "Vietnam Prosperity Joint Stock Commercial Bank", "VIPRJS 6.250% 17Jul2022 Corp (USD)", "HYSEEKER", "B1", 6.25, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.5,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.056, "", "", 0);
        Bond b22 = new Bond("SG31B6000003", "KrisEnergy Ltd", "KRISSP ZERO 31Jan2024 Corp (SGD) - Retail", "HYSEEKER", "N.R", 0, "SGD", 1000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 0 ,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 52.177, "", "", 0);
        Bond b23 = new Bond("JK8762326", "Perennial Real Estate Holdings Ltd", "PREHSP 4.550% 29Apr2020 Corp (SGD) - Retail", "HYSEEKER", "N.R", 4.55, "SGD", 1000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.55,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.337, "", "", 0);
        Bond b24 = new Bond("XS1784286327", "Fantasia Holdings Group Ltd", "FTHDGR 8.375% 08Mar2021 Corp (USD)", "HYSEEKER", "B3", 8.375, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 8.375,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 14.053, "", "", 0);
        Bond b25 = new Bond("AN2482916", "F&N Treasury Pte. Ltd.", "FNNSP 3.800% 21Apr2027 Corp (SGD)", "SISEEKER", "N.R", 3.8, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.8,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.498, "", "", 0);
        Bond b26 = new Bond("XS1226628961", "CLP Power Hong Kong Financing Ltd", "CHINLP 3.125% 06May2025 Corp (USD)", "SISEEKER", "A1", 3.125, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.243,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.529, "", "", 0);
        Bond b27 = new Bond("ZS3827715", "CDL Properties Ltd", "CDLPRP 2.958% 09May2024 Corp (SGD)", "SISEEKER", "N.R", 2.958, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.958,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.813, "", "", 0);
        Bond b28 = new Bond("XS1888985642", "Geely Sweden Finance AB", "GEELZ 4.875% 15Nov2021 Corp (USD)", "HYSEEKER", "N.R", 4.875, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.131, "", "", 0);
        Bond b29 = new Bond("SG7V35954653", "Temasek Financial (I) Limited", "TEMASE 3.785% 05Mar2025 Qsov (SGD)", "FDALT", "Aaa", 3.785, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.785,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.261, "", "", 0);
        Bond b30 = new Bond("US50126AAB70", "Kunlun Energy Co Ltd", "KUNLEG 3.750% 13May2025 Corp (USD)", "SISEEKER", "A2", 3.75, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.872,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.756, "", "", 0);
        Bond b31 = new Bond("XS1907273350", "Bank of China Limited, Hong Kong Branch", "BCHINA 4.450% 20Nov2021 Corp (CNH)", "SISEEKER", "A1", 4.45, "CNH", 1000000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.45,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.251, "", "", 0);
        Bond b32 = new Bond("XS1451270687", "China Railway XunJie Co. Limited", "CHRAIL 3.250% 28Jul2026 Corp (USD)", "SISEEKER", "A3", 3.25, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.369,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.813, "", "", 0);
        Bond b33 = new Bond("XS1960762554", "Greenland Global Investment Limited", "GRNLGR 7.250% 12Mar2022 Corp (USD)", "HYSEEKER", "Ba2", 7.25, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.25,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.999, "", "", 0);
        Bond b34 = new Bond("XS1171593293", "Phoenix Group Holdings PLC", "PHNXLN 6.625% 18Dec2025 Corp (GBP)", "SISEEKER", "N.R", 6.625, "GBP", 100000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.625,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.279, "", "", 0);
        Bond b35 = new Bond("AR6260640", "RCS Trust", "RCSTRU 3.200% 14Mar2025 Corp (SGD)", "SISEEKER", "N.R", 3.2, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.2,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.753, "", "", 0);
        Bond b36 = new Bond("UV8429663", "Land Transport Authority of Singapore", "LTAZSP 3.510% 18Sep2030 Qsov (SGD)", "FDALT", "N.R", 3.51, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.51,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.167, "", "", 0);
        Bond b37 = new Bond("USF43628C734", "Societe Generale SA", "SOCGEN 7.375% Perpetual Corp (USD)", "HYSEEKER", "Ba2", 7.375, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.375,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.413688, "", "", 0);
        Bond b38 = new Bond("SG7194910969", "Land Transport Authority of Singapore", "LTAZSP 2.900% 19Jun2023 Qsov (SGD)", "FDALT", "N.R", 2.9, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.9,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.939, "", "", 0);
        Bond b39 = new Bond("XS1882693036", "HSBC Holdings PLC", "HSBC 5.000% Perpetual Corp (SGD)", "SISEEKER", "Baa3", 5, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 4.326538, "", "", 0);
        Bond b40 = new Bond("XS1450327686", "Minmetals Bounteous Finance (BVI) Limited", "MINMET 3.125% 27Jul2021 Corp (USD)", "SISEEKER", "Baa1", 3.125, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.344,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.692, "", "", 0);
        Bond b41 = new Bond("NY05100N", "Singapore Government", "NY05100N; Coupon: 3.250%; Maturity: 01/09/2020", "FDALT", "Aaa", 3.25, "SGD", 1000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 3.335,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.698, "", "", 0);
        Bond b42 = new Bond("AS1837861", "Aspial Treasury Pte Ltd", "ASPSP 5.900% 19Apr2021 Corp (SGD)", "HYSEEKER", "N.R", 5.9, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.9,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 10.469, "", "", 0);
        Bond b43 = new Bond("USY8137FAP37", "The Democratic Socialist Republic of Sri Lanka", "SRILAN 7.850% 14Mar2029 Govt (USD)", "HYSEEKER", "B2", 7.85, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.85,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.805, "", "", 0);
        Bond b44 = new Bond("XS1508476055", "SDOE International Finance I Company Limited", "SHDMRN 5.450% 24Oct2020 Corp (USD)", "HYSEEKER", "N.R", 5.45, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.45,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.435, "", "", 0);
        Bond b45 = new Bond("XS1795479291", "China SCE Property Holdings Limited", "CHINSC 7.450% 17Apr2021 Corp (USD)", "HYSEEKER", "B2", 7.45, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 7.45,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.536308, "", "", 0);
        Bond b46 = new Bond("UV8462821", "Land Transport Authority of Singapore", "LTAZSP 2.730% 18Sep2020 Qsov (SGD)", "FDALT", "N.R", 2.73, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.73,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.959, "", "", 0);
        Bond b47 = new Bond("SG70I9000003", "DBS Group Holdings Ltd", "DBSSP 2.780% 11Jan2021 Corp (SGD)", "SISEEKER", "Aa2", 2.78, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.78,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.192, "", "", 0);
        Bond b48 = new Bond("XS1611005957", "China Aoyuan Group Limited", "CAPG 5.375% 13Sep2022 Corp (USD)", "HYSEEKER", "B2", 5.375, "USD", 200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 5.375,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 6.497512, "", "", 0);
        Bond b49 = new Bond("N518100E", "Singapore Government", "N518100E; Coupon: 1.750%; Maturity: 02/01/2023", "FDALT", "N.R", 1.75, "SGD", 1000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.86,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 1.647, "", "", 0);
        Bond b50 = new Bond("LW5288540", "Fullerton Healthcare Corporation Ltd", "FHCL 2.750% 07Jul2023 Corp (SGD)", "SISEEKER", "N.R", 2.75, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.75,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 2.655741, "", "", 0);
        Bond b51 = new Bond("XS1643556670","Gemstones International Limited","LVGEM 8.500% 15Aug2020 Corp (USD)","HYSEEKER","Caa1",8.5,"USD",200000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 8.5,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 11.974, "", "", 0);
        Bond b52 = new Bond("XS1725031105","Tahoe Group Global (Co.,) Limited","THHTGP 7.875% 17Jan2021 Corp (USD)","HYSEEKER","Caa1",7.875,"USD",200000, new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"),8,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 28.967803, "", "", 0);
        Bond b53 = new Bond("LW5288540", "Fullerton Healthcare Corporation Ltd", "FHCL 2.750% 07Jul2023 Corp (SGD)", "SISEEKER", "N.R", 2.75, "SGD", 250000,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 8.2,new SimpleDateFormat("dd/MM/yyyy").parse("09/01/20-19"), 16.190033, "", "", 0);

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
        bondSessionLocal.createBond(b28);
        bondSessionLocal.createBond(b29);
        bondSessionLocal.createBond(b30);
        bondSessionLocal.createBond(b31);
        bondSessionLocal.createBond(b32);
        bondSessionLocal.createBond(b33);
        bondSessionLocal.createBond(b34);
        bondSessionLocal.createBond(b35);
        bondSessionLocal.createBond(b36);
        bondSessionLocal.createBond(b37);
        bondSessionLocal.createBond(b38);
        bondSessionLocal.createBond(b39);
        bondSessionLocal.createBond(b40);
        bondSessionLocal.createBond(b41);
        bondSessionLocal.createBond(b42);
        bondSessionLocal.createBond(b43);
        bondSessionLocal.createBond(b44);
        bondSessionLocal.createBond(b45);
        bondSessionLocal.createBond(b46);
        bondSessionLocal.createBond(b47);
        bondSessionLocal.createBond(b48);
        bondSessionLocal.createBond(b49);
        bondSessionLocal.createBond(b50);
        bondSessionLocal.createBond(b51);
        bondSessionLocal.createBond(b52);
        bondSessionLocal.createBond(b53);

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
