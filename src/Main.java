import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileAccountManager file = new FileAccountManager();

        //Регистрация нового аккаунта.
        Account account1 = new Account("Мария Александровна Турчинович", "05.06.2002",
                "mashaturch@gmail.com", "1234");
        try {
            file.register(account1);
        } catch (AccountAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(FileService.getInstance().readFile());

        //Проверка метода FailedLoginCounter
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(file.login("mashaturch@gmail.com", "12345"));

            } catch (AccountBlockedException | WrongCredentialsException e) {
                System.out.println(e.getMessage());
            }
        }

        //Верная попытка входа в аккаунт
        try {
            System.out.println(file.login("mashaturch@gmail.com", "1234"));
            System.out.println(FailedLoginCounter.getInstance("mashaturch@gmail.com"));
        } catch (AccountBlockedException | WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }

        // Проверка метода FailedLoginCounter
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(file.login("mashaturch@gmail.com", "123"));

            } catch (AccountBlockedException | WrongCredentialsException e) {
                System.out.println(e.getMessage());
            }
        }

        // Попытка входа в уже заблокиированный аккаунт
        try {
            System.out.println(file.login("mashaturch@gmail.com", "12345"));
        } catch (AccountBlockedException | WrongCredentialsException e) {
            System.out.println(e.getMessage());
        }
    }
}