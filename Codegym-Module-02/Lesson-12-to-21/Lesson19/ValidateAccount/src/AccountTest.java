public class AccountTest {
    public static final String[] TestAccount = new String[]{"devil_Monkey159", "_Atomica153", "aPolar00_","12312"};

    public static void main(String[] args) {
        AccountRegex accountRegex = new AccountRegex();
        for(String account : TestAccount){
            boolean isValid = accountRegex.validate(account);
            System.out.println("Account is "+ account + " is: "+isValid);
        }
    }
}
