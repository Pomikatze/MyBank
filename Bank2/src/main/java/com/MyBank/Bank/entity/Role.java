package com.MyBank.Bank.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table (name = "role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn (name = "id")
    private User user;

    public Role(Long id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
