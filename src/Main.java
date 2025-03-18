

public static void main(String[] args) {
    PasswordMaker pm1 = PasswordMaker.getInstance("Alice");
    System.out.println("Generated Password: " + pm1.getPassword());

    PasswordMaker pm2 = PasswordMaker.getInstance("Bob");
    System.out.println("Generated Password: " + pm2.getPassword());

    System.out.println("Instance accessed: " + PasswordMaker.getInstanceAccessCount() + " times");
}

