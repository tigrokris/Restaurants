package ru.demianko.restaurants.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Дмитрий on 07.05.2016.
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
