package dice.dice1.controller;

import dice.dice1.domain.DiceDomain;
import dice.dice1.service.DiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class DiceController {

    private final DiceService diceService;


    @GetMapping("/")
    public String stay(Model model) {
        Integer lastDiceNumber = diceService.lastNumberGet();
        model.addAttribute("lastDiceNumber", lastDiceNumber);
        Map<Integer, Integer> diceStore = diceService.diceStoreGet();
        model.addAttribute("diceStore", diceStore);

        return "home";
    }

    @GetMapping("/roll")
    public String roll() {
        DiceDomain diceDomain = diceService.DiceNumberCreate();
        diceService.diceStoreSave(diceDomain);
        diceService.lastNumberSave(diceDomain);
        return "redirect:/";
    }

    @GetMapping("/clear")
    public String clear() {
        diceService.diceStoreClear();

        return"redirect:/";
    }
}
