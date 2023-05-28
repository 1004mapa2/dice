package dice.dice1.repository;


import dice.dice1.domain.DiceDomain;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class DiceRepository {

    private static Map<Integer, Integer> store = new HashMap<>();
    private Integer lastNumber;

    public DiceRepository() {
        store.put(1, 0);
        store.put(2, 0);
        store.put(3, 0);
        store.put(4, 0);
        store.put(5, 0);
        store.put(6, 0);
        this.lastNumber = 0;
    }

    public Map<Integer, Integer> storeGet() {
        return store;
    }

    public void storeSave(DiceDomain diceDomain) {
        Integer diceNumber = diceDomain.getDiceNumber();
        store.replace(diceNumber, store.get(diceNumber) + 1);
    }

    public Integer lastNumberGet() {
        return lastNumber;
    }

    public void lastNumberSave(DiceDomain diceDomain) {
        lastNumber = diceDomain.getDiceNumber();
    }

    public void clearStore() {
        store.put(1, 0);
        store.put(2, 0);
        store.put(3, 0);
        store.put(4, 0);
        store.put(5, 0);
        store.put(6, 0);
    }
}
