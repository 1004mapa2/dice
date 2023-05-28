package dice.dice1.controller;

import dice.dice1.domain.TestDomain;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class TestController {

    @GetMapping("/test")
    public String test(Model model) {

        TestDomain testDomain = new TestDomain();
        model.addAttribute("testDomain", testDomain);

        return "home";
    }

}
