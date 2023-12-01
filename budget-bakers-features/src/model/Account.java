package model;

public class Account {
    private Integer id_account;
    private String username;
    private Integer number;
    private Integer balance;
    private String status;



    public Account(Integer id_account, String username, Integer number, Integer balance, String status) {
        this.id_account = id_account;
        this.username = username;
        this.number = number;
        this.balance = balance;
        this.status = status;
    }
    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return  "id_account= " + id_account +
                ", username= '" + username + '\'' +
                ", number= " + number +
                ", balance= " + balance +
                ", status= '" + status + '\'' + "\n";
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
