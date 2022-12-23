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

    public Account() {}

    public Account (String fio, String dateBirth, String email, String password) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.blocked = false;
    }

    public Account (String fio, String dateBirth, String email, String password, boolean blocked) {
        this.fio = fio;
        this.dateBirth = dateBirth;
        this.email = email;
        this.password = password;
        this.blocked = false;
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

    @Override
    public String toString (){
        return fio + "," + dateBirth+ "," + email+ "," + password+ "," + blocked;
    }
}
