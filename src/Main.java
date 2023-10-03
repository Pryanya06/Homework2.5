import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {


    private static final String VALIDATE_PATTERN = "^[a-zA-Z0-9_]+$";
    public static void main(String[] args) throws WrongLoginException {
        check("login", "password", "password");
        check( "loginLoginLoginLoginLoginLogin", "password" , "password");
        check("login!", "password", "password");
        check("login", "password1", "password");

    }
    private static boolean check(String login, String password, String confirmPassword) throws WrongLoginException {
       boolean isValid = true;

        try {
            checkLogin(login);
            checkPassword(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Неверный логин:" + e.getMessage());
            isValid = false;
        } catch ( WrongPasswordException e) {
            System.out.println("Неверный пароль:" + e.getMessage());
            isValid = false;
        }

        if ( isValid) {
            System.out.println(" Логин и пароль введены верно");
        }

        return isValid;
    }

    private static void checkLogin(String login) throws WrongPasswordException, WrongLoginException {
        if (!login.matches(VALIDATE_PATTERN)) {
          throw new WrongLoginException(" Логин может содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (login.length() > 20 ) {
            throw new WrongPasswordException(" Логин должен быть не более 20 символов");
        }
    }

    private static void checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches(VALIDATE_PATTERN)) {
            throw new WrongPasswordException(" Пароль может содержать в себе только латинские буквы, цифры и знак подчеркивания.");
        } else if (password.length() > 20 ) {
            throw new WrongPasswordException(" Пароль должен быть не более 20 символов");
        } else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException(" Пароли должны совпадать");
        }
    }
}