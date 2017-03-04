package ru.demianko.restaurants.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import ru.demianko.restaurants.LoggedUser;
import ru.demianko.restaurants.to.UserTo;
import ru.demianko.restaurants.util.UserUtil;
import ru.demianko.restaurants.web.user.AbstractUserController;

import javax.validation.Valid;

/**
 * Created by Dmitriy on 10.02.2017.
 */
@Controller
public class RootController  extends AbstractUserController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "redirect:dishes";
    }

    //    @Secured("ROLE_ADMIN")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/dishes", method = RequestMethod.GET)
    public String dishesList() {
        return "dishList";
    }

    @RequestMapping(value = "/restaurantsList", method = RequestMethod.GET)
    public String restaurantList() {
        return "restaurantList";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap model,
                        @RequestParam(value = "error", required = false) boolean error,
                        @RequestParam(value = "message", required = false) String message) {

        model.put("error", error);
        model.put("message", message);
        return "login";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "profile";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String updateProfile(@Valid UserTo userTo, BindingResult result, SessionStatus status) {
        if (!result.hasErrors()) {
            try {
                userTo.setId(LoggedUser.id());
                super.update(userTo);
                LoggedUser.get().update(userTo);
                status.setComplete();
                return "redirect:dishes";
            } catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "exception.duplicate_email");
            }
        }
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(ModelMap model) {
        model.addAttribute("userTo", new UserTo());
        model.addAttribute("register", true);
        return "profile";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveRegister(@Valid UserTo userTo, BindingResult result, SessionStatus status, ModelMap model) {
        if (!result.hasErrors()) {
            try {
                super.create(UserUtil.createFromTo(userTo));
                status.setComplete();
                return "redirect:login?message=app.registered";
            } catch (DataIntegrityViolationException ex) {
                result.rejectValue("email", "exception.duplicate_email");
            }
        }
        model.addAttribute("register", true);
        return "profile";
    }
}
