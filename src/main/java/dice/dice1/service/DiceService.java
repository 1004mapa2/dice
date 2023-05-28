package dice.dice1.service;

import dice.dice1.domain.DiceDomain;
import dice.dice1.repository.DiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class DiceService {

    private final DiceRepository diceRepository;

    public DiceDomain DiceNumberCreate() {

        DiceDomain diceDomain = new DiceDomain();
        diceDomain.setDiceNumber((int) (Math.random() * 6 + 1));

        return diceDomain;
    }

    public void lastNumberSave(DiceDomain diceDomain) {
        diceRepository.lastNumberSave(diceDomain);
    }

    public void diceStoreSave(DiceDomain diceDomain) {
        diceRepository.storeSave(diceDomain);
    }

    public Integer lastNumberGet() {
        return diceRepository.lastNumberGet();
    }

    public Map<Integer, Integer> diceStoreGet() {
        return diceRepository.storeGet();
    }

    /**
     *  db store 초기화
     */
    public void diceStoreClear() {
        diceRepository.clearStore();
    }
}
