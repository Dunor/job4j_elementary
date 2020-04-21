package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    //добавление пользователя.
    public void addUser(User user) {
        users.putIfAbsent(user,  new ArrayList<>());
    }

    //добавить счёт пользователю.
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            users.get(user).add(account);
        }

    }

    //поиск пользователя по паспорту
    public User findByPassport(String passport) {
        User user = null;
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                user = entry.getKey();
                break;
            }
        }
        return user;
    }

    //поиск счета по реквизитам
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
                if (entry.getKey().equals(user)) {
                    for (Account tmpAccount : entry.getValue()) {
                        if (tmpAccount.getRequisite().equals(requisite)) {
                            account = tmpAccount;
                            break;
                        }
                    }
                }
            }
        }
        return account;
    }

    // удаление пользователя.
    public void deleteUser(User user) {
        users.remove(user);
    }

    //метод для перечисления денег с одного счёта на другой счёт
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account dstAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && dstAccount != null) {
            rsl = srcAccount.transfer(dstAccount, amount);
        }
        return rsl;
    }

}
