/** Интерфейс управления аккаунтами, для базы используется
 * текстовый файл в формате CSV */

public interface AccountManager {
    /**
     * Метод проверяет по полю email, что данный аккаунт в базе
     * отсутствует, и создает новую запись, в противном случае
     * выбрасывает ошибку AccountAlreadyExistsException
     */


    void register(Account newAccount) throws AccountAlreadyExistsException;

    Account login(String email, String password) throws AccountBlockedException, WrongCredentialsException;

    void removeAccount(String email, String password) throws WrongCredentialsException;
}