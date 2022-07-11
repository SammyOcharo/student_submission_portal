package com.studentAssignment.student_assignment.Entity;


import com.studentAssignment.student_assignment.TokenGeneration.TokenEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Table(name = "application_users")
public class ApplicationUSerEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(length = 15, columnDefinition = "varchar(32) default 'NORMAL_USER'")
    @Enumerated(EnumType.STRING)
    private ApplicationUserRole applicationUserRole = ApplicationUserRole.NORMAL_USER;
    private boolean enabled=false;

    @OneToOne(mappedBy = "applicationUSerEntity")
    private TokenEntity tokenEntity;


    public ApplicationUSerEntity(String username,
                                 String email,
                                 String password,
                                 ApplicationUserRole applicationUserRole,
                                 boolean enabled,
                                 TokenEntity tokenEntity) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.applicationUserRole = applicationUserRole;
        this.enabled = enabled;
        this.tokenEntity = tokenEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(applicationUserRole.name());
        return Collections.singleton(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
