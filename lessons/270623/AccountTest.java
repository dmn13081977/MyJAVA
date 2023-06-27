public class AccountTest {
    public static void main(String[] args) {
        Account user = new Account("ivanov", "...", "...");

        Account current = Account.inputAccount();

        if (user.isValidUser(current)) {
            System.out.println("Access granted!");
        } else {
            System.out.println("Access denied!");
        }
    }
}
