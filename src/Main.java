public class Main {
    public static void main(String[] args) {
        FileAccountManager file = new FileAccountManager();

        //Регистрация нового аккаунта.
        Account account1 = new Account("Мария Александровна Турчинович", "05.06.2002", "mashaturch@gmail.com", "1234");
        try {
            file.register(account1);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(FileService.getInstance().readFile());

        //Проверка метода FailedLoginCounter (такой почты нет, метод не должен вести подсчет).
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(file.login("mashat@gmail.com", "12345"));

            } catch (AccountBlockedException | WrongCredentialsException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(FailedLoginCounter.getInstance("mashat@gmail.com"));

        //Верная попытка входа в аккаунт
        try {
            System.out.println(file.login("mashaturch@gmail.com", "1234"));
            System.out.println(FailedLoginCounter.getInstance("mashaturch@gmail.com"));
        } catch (AccountBlockedException | WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }

        // Проверка метода FailedLoginCounter.
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(file.login("mashaturch@gmail.com", "123"));

            } catch (AccountBlockedException | WrongCredentialsException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(FailedLoginCounter.getInstance("mashaturch@gmail.com"));

        //Попытка входа в заблокиированный аккаунт.
        try {
            System.out.println(file.login("mashaturch@gmail.com", "12345"));
        } catch (AccountBlockedException | WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}
