package devApp.entity.user.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

import devApp.security.util.BaseUserSecurityUtil;
import devApp.security.util.SecurityRoleType;

@Entity
@Proxy(lazy=false)
@Table(name = "WEB_USER")
public class WebUser extends User {

    private static final long serialVersionUID = 1L;

    private String firstName = null;
    private String lastName = null;
    private String fullName = null;
    private String email = null;
    private String ipAddress = null;
    private SecurityRoleType securityRoleType = null;

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "FULL_NAME")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Column(name = "EMAIL_ADDRESS")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "IP_ADDRESS")
    public String getIpAddress() {
        return ipAddress;
    }
    
    @Column(name = "SECURITY_ROLE")
    @Enumerated(EnumType.STRING)
    public SecurityRoleType getSecurityRoleType() {
        return securityRoleType;
    }

    public void setSecurityRoleType(SecurityRoleType securityRoleType) {
        this.securityRoleType = securityRoleType;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WebUser{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", fullName='").append(fullName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", userName='").append(this.getUsername()).append('\'');
        sb.append(", password='").append(this.getPassword()).append('\'');
        sb.append(", id='").append(this.getId()).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    @Transient
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.getSecurityRoleType() != null) {
            return BaseUserSecurityUtil.createAuthorities(this.getSecurityRoleType());
        }
        return null;
    }

    @Override
    @Transient
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    @Transient
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @Transient
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @Transient
    public boolean isEnabled() {
        return true;
    }
}
