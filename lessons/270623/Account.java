import java.util.Objects;
import java.util.Scanner;

public class Account {
    private String user;
    private String password;
    private String ticket;

    public Account(String user, String password, String ticket) {
        setUser(user);
        setPassword(password);
        setTicket(ticket);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        Objects.requireNonNull(user);
        this.user = user;
    }

    public Account withUser(String user) {
        setUser(user);
        return this;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Objects.requireNonNull(password);
        this.password = password;
    }

    public Account withPassword(String password) {
        setPassword(password);
        return this;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        Objects.requireNonNull(ticket);
        this.ticket = ticket;
    }

    public Account withTicket(String ticket) {
        setTicket(ticket);
        return this;
    }

    public boolean isValidUser(Account other) {
        return user.equals(other.user)
                && password.equals(other.password)
                && ticket.equals(other.ticket);
    }

    public static Account inputAccount() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("User:");
        String user = scanner.nextLine();

        System.out.print("Password:");
        String password = scanner.nextLine();

        System.out.print("Ticket:");
        String ticket = scanner.nextLine();

        return new Account(user, password, ticket);
    }
}
