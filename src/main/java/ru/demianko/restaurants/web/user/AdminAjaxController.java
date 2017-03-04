package ru.demianko.restaurants.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.demianko.restaurants.LoggedUser;
import ru.demianko.restaurants.model.Role;
import ru.demianko.restaurants.model.User;
import ru.demianko.restaurants.to.UserTo;
import ru.demianko.restaurants.util.UserUtil;
import ru.demianko.restaurants.web.ExceptionInfoHandler;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController extends AbstractUserController{
    @Autowired
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createOrUpdate(@Valid UserTo userTo) {
        try {
            if (userTo.getId() == 0) {
                super.create(UserUtil.createFromTo(userTo));
            } else {
                super.update(userTo);
            }
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(messageSource.getMessage("exception.duplicate_email", null, LocaleContextHolder.getLocale()));
        }
    }
}