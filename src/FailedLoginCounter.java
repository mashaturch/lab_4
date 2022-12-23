public class FailedLoginCounter {

    /*
    В этом классе происходит проверка пароля на количество неверных введений
     */
    private static FailedLoginCounter instance;


    private FailedLoginCounter() {
    }


    public static FailedLoginCounter getInstance(String email) {
        if (instance == null) {
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void wrong_login(Account account) { account.unCorrectLogin(); } //если неверно, то +1

    public void right_login(Account account) { account.correctLogin(0); } // обновление счётчика
}
