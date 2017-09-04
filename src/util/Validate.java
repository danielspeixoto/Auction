package util;

import model.pojo.Auction;
import model.pojo.Item;
import model.pojo.User;

import java.util.regex.Pattern;

// Realiza validações, caso seja válido retorna Validate.OK
// caso contrário, retorna o erro
public class Validate {

    public static final String OK = "ok";
    public static final String NOT_VALID = "Formato n�o v�lido";
    private static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?" +
            "^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-" +
            "\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\" +
            "x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*" +
            "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]" +
            "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]" +
            "*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-" +
            "\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    private static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";

    private static final String NAME_REGEX = "^[\\p{L}\\s'.-]+$";

    public static String validate(User user) {
        String result = OK;
        user.setEmail(user.getEmail().toLowerCase().trim());
        result = email(user.getEmail());
        if (!result.equals(OK)) {
            return result;
        }
        if (!Pattern.matches(NAME_REGEX, user.getName())) {
            result = "O nome não está escrito propriamente";
            return result;
        }
        return result;
    }

    public static String numeric(String num) {
        if(num.matches(NUMERIC_REGEX)) {
            return OK;
        }
        return NOT_VALID;
    }

    public static String email(String email) {
        String result = OK;
        email = email.toLowerCase().trim();
        if (!Pattern.matches(EMAIL_REGEX, email)) {
            result = "Formato de e-mail incorreto";
        }
        return result;
    }

    public static String validate(Item item) {
        String result = OK;
        if (!Pattern.matches(NAME_REGEX, item.getName())) {
            result = "Descri��o inv�lida!";
            return result;
        }
        return result;
    }

    public static String validate(Auction auction) {
        String result = OK;
        return result;
    }

    public static String integer(String str) {
        String result = OK;
        if (Pattern.matches("[0-9]*", result) && str.length() > 0) {
            result = "Não é um número valído";
        }
        return result;
    }
}
