package billing_system_db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity@Table(name = "bank_accounts")
public class BankAccount extends BasicBillingDetail{
    private String bankname;
    private String swiftCode;


    @Column(name = "bank")
    public String getBankname() {
        return this.bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    @Column(name = "swift_code")
    public String getSwiftCode() {
        return this.swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
