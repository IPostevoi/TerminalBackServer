package server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import server.transporting.MessageSenderImpl;

@Controller
public class BackServerController {

//    @Autowired
//    MessageSenderImpl sender;
//
//    @RequestMapping(value = "/validateClient", method = RequestMethod.POST)
//    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//
//    @RequestMapping(value = "/validate", method = RequestMethod.POST)
//    public ModelAndView validate(String pin) {
//        if (pin.equals("1488")) {
//            sender.send(pin);
//            return new ModelAndView("/pinValid");
//        }
//        return new ModelAndView("/pinInvalid");
//    }

}