public class Customer {
    private Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public String getCustomerName() {
        return account.getName();
    }
}
