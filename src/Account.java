public class Account {

    /**
     * fio - ФИО пользователя
     * dateBirth - дата рождения
     * email - почта пользователя
     * password - пароль пользователя
     * blocked - типа boolean, по умолчанию значение false, когда true, то пользователь заблокирован
     */

    private String fio;
    private String dateBirth;
    private String email;
    private String password;
    private boolean blocked;

    private int count = 0;
    public Account() {}

    public Account (String fio, String dateBirth, String email, String password) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.blocked = false;
        this.count = 0;
    }

    public Account (String fio, String dateBirth, String email, String password, boolean blocked) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.blocked = false;
        this.count = 0;
    }

    public String getFio(){
        return fio;
    }

    public String getDateBirth(){
        return dateBirth;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public boolean getBlocked(){
        return blocked;
    }

    public int getCount() {
        return count;
    }

    public void unCorrectLogin () { this.count++; }

    public void correctLogin(Integer zero) { this.count = zero; }

    @Override
    public String toString (){
        return fio + "," + dateBirth+ "," + email+ "," + password+ "," + blocked;
    }
}
