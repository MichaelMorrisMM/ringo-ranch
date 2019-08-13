package ringoranch.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectController {

   @RequestMapping(method = {RequestMethod.OPTIONS, RequestMethod.GET}, path = {"/game/**"})
   public RedirectView forwardAngularRoutes() {
      // TODO
      return new RedirectView("http://localhost:4200");
   }

}
