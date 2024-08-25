package signal.minervini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {
    public String handleError() {
        try {
            return "error";
        } catch (Exception e) {
            return "e";
        }
    }
}
