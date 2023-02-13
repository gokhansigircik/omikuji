package com.form.omikuji;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

  @RequestMapping(value={"/", "/omikuji"})
  public String omikuji(){
    return "index.jsp";
  }

  @RequestMapping(value="/form", method = RequestMethod.POST)
  public String login(
    @RequestParam(value = "number") String number,
    @RequestParam(value = "city") String city,
    @RequestParam(value = "person") String person,
    @RequestParam(value = "hobby") String hobby,
    @RequestParam(value = "thing") String thing,
    @RequestParam(value = "good") String good,
    HttpSession session,

      RedirectAttributes redirectAttributes){
        if(person.length()<4){
          redirectAttributes.addFlashAttribute("personerror", "The person name must be at least 4 cracter");
          return "redirect:/";
        }

      session.setAttribute("number", number);
      session.setAttribute("city", city);
      session.setAttribute("person", person);
      session.setAttribute("hobby", hobby);
      session.setAttribute("thing", thing);
      session.setAttribute("good", good);
      return "redirect:/omikuji/show";
    }

    @RequestMapping("/omikuji/show")
    public String omikujiShow(){
      return "omikuji.jsp";
    }
  
}
