package devApp.entity.user.model;

import javax.persistence.*;

import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Objects;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
@SuppressWarnings("unused")
public abstract class TestModel implements Serializable, UserDetails {

    private static final long serialVersionUID = 1L;
    private Long id = null;

    private String userName = null;
    private String password = null;

    protected User() {
        super();
    }

    protected User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Id
    @GeneratedValue
    @Column(name = "USER_ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "USER_NAME", unique = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof User)) {
            return false;
        }

        User user = (User) o;

        if (!userName.equals(user.userName)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserName());
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
