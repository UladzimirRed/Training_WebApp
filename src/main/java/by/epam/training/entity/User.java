package by.epam.training.entity;

/**
 * The type User.
 */
public class User extends Entity{
    private int id;
    private String login;
    private String password;
    private RoleType role;
    private Transport transport;
    private double rating;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param login the login
     */
    public User(String login) {
        this.login = login;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param login    the login
     * @param password the password
     * @param role     the role
     */
    public User(int id, String login, String password, RoleType role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     * @param role     the role
     */
    public User(String login, String password, RoleType role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    /**
     * Instantiates a new User.
     *
     * @param login     the login
     * @param password  the password
     * @param role      the role
     * @param transport the transport
     */
    public User(String login, String password, RoleType role, Transport transport) {
        this.login = login;
        this.password = password;
        this.role = role;
        this.transport = transport;
    }

    /**
     * Instantiates a new User.
     *
     * @param id        the id
     * @param login     the login
     * @param password  the password
     * @param role      the role
     * @param transport the transport
     * @param rating    the rating
     */
    public User(int id, String login, String password, RoleType role, Transport transport, double rating) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.transport = transport;
        this.rating = rating;
    }

    /**
     * Instantiates a new User.
     *
     * @param login    the login
     * @param password the password
     */
    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param id        the id
     * @param login     the login
     * @param role      the role
     * @param transport the transport
     * @param rating    the rating
     */
    public User(int id, String login, RoleType role, Transport transport, double rating) {
        this.id = id;
        this.login = login;
        this.role = role;
        this.transport = transport;
        this.rating = rating;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public RoleType getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(RoleType role) {
        this.role = role;
    }

    /**
     * Gets transport.
     *
     * @return the transport
     */
    public Transport getTransport() {
        return transport;
    }

    /**
     * Sets transport.
     *
     * @param transport the transport
     */
    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public double getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (Double.compare(user.rating, rating) != 0) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (role != user.role) return false;
        return transport == user.transport;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (transport != null ? transport.hashCode() : 0);
        temp = Double.doubleToLongBits(rating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", role=").append(role);
        sb.append(", transport=").append(transport);
        sb.append(", rating=").append(rating);
        sb.append('}');
        return sb.toString();
    }
}
