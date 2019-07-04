package sample.OldProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class users extends Observable {
    private List<String> loggedIn = new ArrayList<String>();

    public void login(String userName, String password) {
        if (!passwordValid(userName, password)) {
            throw new SecurityException("Пользователь с именем " + userName + " и паролем '" + password + "' - не найден!");
        }

        loggedIn.add(userName);
        setChanged();
        notifyObservers(userName);
    }

    public void logout(String userName) {
        loggedIn.remove(userName);
        setChanged();
        notifyObservers(userName);
    }


    /**
     * Проверка правильности имени и пароля.
     * Обратите внимание на то, что такого рода методы проверки
     * безопасности <b>всегда следует объявлять как final</b> для
     * предотвращения их умышленного переопределения с целью взолома
     * @param name - имя, логин пользователя
     * @param password - пароль пользователя
     * @return true/false
     */
    public final boolean passwordValid(String name, String password) {
        boolean res = false;
        /* ....
         * Проверка существования пользователя
         * с логином name и паролем password
         * ....
         * */
        return res;
    }

    public boolean loggedIn(String name) {
        return loggedIn.contains(name);
    }
}
