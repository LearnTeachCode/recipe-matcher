package devApp.security.util;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public class BaseUserSecurityUtil {

    private static final List<GrantedAuthority> ADMIN_ROLES =
            AuthorityUtils.createAuthorityList("ADMIN","USER");
    private static final List<GrantedAuthority> USER_ROLES =
            AuthorityUtils.createAuthorityList("USER");
    private static final List<GrantedAuthority> USER_GUEST =
            AuthorityUtils.createAuthorityList("GUEST");

    public static Collection<? extends GrantedAuthority> createAuthorities(SecurityRoleType securityRoleType) {

        switch (securityRoleType) {
            case ADMIN:
                return ADMIN_ROLES;
            case USER:
                return USER_ROLES;
            case GUEST:
                return USER_GUEST;
            default:
                return null;
        }
    }
}
