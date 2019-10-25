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
import entity.Rewards;
import error.NoResultException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Named;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import session.stateless.PlayerSessionLocal;

/**
 *
 * @author fengl
 */
@ManagedBean
@SessionScoped
public class AuthenticationManagedBean implements Serializable {

    /**
     * Creates a new instance of AuthenticationManagedBean
     */
    @EJB
    PlayerSessionLocal playerSessionLocal;

    private String name;

    private String email;
    private String password;
    private String confirmPassword;
    private Date joinedDate;
    private int points;
    private String firstName;
    private String lastName;
    private boolean accountStatus;
    private String gender;
    private Date lastLogin;
    private int consecutiveLogin;
    private String riskAppetite;

    private List<Expenses> expensesList;
    private List<Income> incomeList;
    private List<Rewards> rewardsList;
    private List<Bond> trackedBonds;
    private List<Bond> recommendedBonds;

    private Player loggedInPlayer;

    private Long id = -1L;

    public AuthenticationManagedBean() {

    }
 public String register() throws IOException, NoResultException {

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        PrintWriter out = response.getWriter();

        if (password.equals(confirmPassword)) {
            Player p = new Player();
            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setEmail(email);
            p.setPassword(encryptPassword(password));
            p.setAccountStatus(true);
            p.setPoints(0);
            p.setGender(gender);
            
            p.setJoinedDate(java.util.Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
            playerSessionLocal.createPlayer(p);

            firstName = null;
            lastName = null;
            email = null;
            password = null;
            confirmPassword = null;
            
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Register Succesful!');");
            out.println("</script>");

            return "login.xhtml?faces-redirect=true";

        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Confirm Password doesn't match! !');");
            out.println("</script>");

            return "register.xhtml?faces-redirect=true";
        }

    }
    
    public String login() throws IOException, NoResultException {
        Player p = new Player(email, encryptPassword(password));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        PrintWriter out = response.getWriter();

        if (playerSessionLocal.login(p) == true) {
            if (playerSessionLocal.getPlayerByEmail(email).isAccountStatus()== false) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Your account has been banned! Please contact the administrator!');");
                out.println("</script>");
                return "/login.xhtml";
            } else {

                loggedInPlayer = playerSessionLocal.getPlayerByEmail(email);
                id = loggedInPlayer.getPlayerID();
                setName(loggedInPlayer.getLastName() + " " + loggedInPlayer.getFirstName());

                out.println("<script type=\"text/javascript\">");
                out.println("alert('Login Succesfull!');");
                out.println("</script>");
                return "/User/index.xhtml?faces-redirect=true";

            }
        } else {

            name = null;
            password = null;
            id = -1L;
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Email or password incorrect');");
            out.println("</script>");
            return "/login.xhtml";
        }
    }

    public String logout() {
        loggedInPlayer = null;
        id = -1L;

        return "index.xhtml?faces-redirect=true";
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

    public PlayerSessionLocal getPlayerSessionLocal() {
        return playerSessionLocal;
    }

    public void setPlayerSessionLocal(PlayerSessionLocal playerSessionLocal) {
        this.playerSessionLocal = playerSessionLocal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    public Player getLoggedInPlayer() {
        return loggedInPlayer;
    }

    public void setLoggedInPlayer(Player loggedInPlayer) {
        this.loggedInPlayer = loggedInPlayer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
}
