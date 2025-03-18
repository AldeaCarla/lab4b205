import java.util.Random;
public class PasswordMaker {
    private static final int MAGIC_NUMBER = 8;  // Orice valoare dorita
    private static final String MAGIC_STRING = StringRandomizer.getRandomString(20);
    private static PasswordMaker instance;
    private static int instanceAccessCount = 0;
    private final String password;

    static {
        instance = new PasswordMaker("Default");
    }

    private PasswordMaker(String name) {
        Random random = new Random();

        // 1. Random string de lungime MAGIC_NUMBER
        String randomPart = StringRandomizer.getRandomString(MAGIC_NUMBER);

        // 2. Alfabet din 10 caractere random din MAGIC_STRING
        StringBuilder alphabetPart = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            alphabetPart.append(MAGIC_STRING.charAt(random.nextInt(MAGIC_STRING.length())));
        }

        // 3. Lungimea numelui ca String
        String nameLengthPart = String.valueOf(name.length());

        // 4. Numar intreg random intre 0 si 50
        int randomNumber = random.nextInt(51);

        // Concatenare pentru generarea parolei
        this.password = randomPart + alphabetPart + nameLengthPart + randomNumber;
    }

    public static PasswordMaker getInstance(String name) {
        instanceAccessCount++;
        return instance;
    }

    public String getPassword() {
        return password;
    }

    public static int getInstanceAccessCount() {
        return instanceAccessCount;
    }

}

