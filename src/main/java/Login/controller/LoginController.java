package Login.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Login.service.LoginServiceInterface;
import Login.Model.User;

@Controller
public class LoginController {

    @Autowired
    private LoginServiceInterface loginServiceInterface;

    @RequestMapping("toLogin")
    public String toLogin(Model model) {
        // Make sure to add model of UserBean in which login
        // userName and password will be stored from the login form
        model.addAttribute("userBean", new User());
        // "login" will be resolved to login.jsp
        // where login-form is presented to user
        return "login";
    }

    @RequestMapping("doLogin")
    public ModelAndView doLogin(@Valid@ModelAttribute("userBean") User userBean,BindingResult result) {
        ModelAndView view = new ModelAndView("login");
        // If input bean does not have any validation error then proceed
        if(!result.hasFieldErrors()) {
            // If not a valid user then add error
            // else proceed to user welcome page
            if(!loginServiceInterface.authenticateUser(userBean)) {
                result.addError(new ObjectError("err", "Invalid Credentials"));


            } else {


                view=new ModelAndView("welcome", "userBean", userBean);
            }

        }

        return view;
    }
}