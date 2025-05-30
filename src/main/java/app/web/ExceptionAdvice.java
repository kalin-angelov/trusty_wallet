package app.web;

import app.exception.UsernameAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class ExceptionAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({AccessDeniedException.class, NoResourceFoundException.class})
    public ModelAndView handleNotFoundExceptions (Exception exception) {

        return new ModelAndView("not-found");
    }

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ModelAndView handleUsernameIsAlreadyExistingException(RedirectAttributes redirectAttributes, UsernameAlreadyExistException exception) {

        String errorMessage = exception.getMessage();
        redirectAttributes.addFlashAttribute("usernameAlreadyExistMessage", errorMessage);

        return new ModelAndView("redirect:/register");
    }
}
