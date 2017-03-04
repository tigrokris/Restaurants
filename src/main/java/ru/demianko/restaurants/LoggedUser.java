package ru.demianko.restaurants;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.demianko.restaurants.to.UserTo;
import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.util.UserUtil;
import static java.util.Objects.requireNonNull;

/**
 * Created by Дмитрий on 08.05.2016.
 */
public class LoggedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;
    private UserTo userTo;

    public LoggedUser(User user) {
        super(user.getEmail(), user.getPassword(), true,true, true, true, user.getRoles());
        this.userTo = UserUtil.asTo(user);
    }

    public static LoggedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object user = auth.getPrincipal();
        return (user instanceof LoggedUser) ? (LoggedUser) user : null;
    }

    public static LoggedUser get() {
        LoggedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int id() {
        return get().userTo.getId();
    }

    public UserTo getUserTo() {
        return userTo;
    }

    @Override
    public String toString() {
        return userTo.toString();
    }

    public void update(UserTo newTo) {
        userTo = newTo;
    }
}