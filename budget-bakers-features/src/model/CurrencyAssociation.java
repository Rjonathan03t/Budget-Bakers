package model;

public class CurrencyAssociation {
    private Integer id_association;
    private Integer id_account;
    private Integer id_currency;

    public CurrencyAssociation(Integer id_association, Integer id_account, Integer id_currency) {
        this.id_association = id_association;
        this.id_account = id_account;
        this.id_currency = id_currency;
    }

    public Integer getId_association() {
        return id_association;
    }

    public void setId_association(Integer id_association) {
        this.id_association = id_association;
    }

    public Integer getId_account() {
        return id_account;
    }

    public void setId_account(Integer id_account) {
        this.id_account = id_account;
    }

    public Integer getId_currency() {
        return id_currency;
    }

    public void setId_currency(Integer id_currency) {
        this.id_currency = id_currency;
    }

    @Override
    public String toString() {
        return "CurrencyAssociation{" +
                "id_association=" + id_association +
                ", id_account=" + id_account +
                ", id_currency=" + id_currency +
                '}';
    }
}
