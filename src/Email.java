import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private int defaultPasswordLength = 10;
    private String departement;
    private int mailboxCapacity = 500;
    private String altenateEmail;
    private String email;
    private String companySuffix = "aeycompany.com";

    //Constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastName);

        //Call a methode asking for department - return the department
        this.departement = setDepartement();
//        System.out.println("Departement: " + this.departement);

        //Call a methode that returns a random password
        this.password = randomPassword(defaultPasswordLength);
//        System.out.println("Your passwoed is:" + this.password);

        //Combine elements to generate email;
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + departement + "." + companySuffix;
//        System.out.println("Your emial is:" + email);
    }

    //Ask for the departement
    private String setDepartement() {
        System.out.println(" New worker:"+firstName+". Enter the departement:\n1 for Sales\n2 for Devlopment\n3 for Accounting\n0 for none");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }

    }


    //Generate a random password

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIGKLMNOPQRSTUVEYZ1234567890!@#$%^&*()_+";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }


    //Set the mailbox capacity

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity=capacity;
    }

    //Set the alternate email

    public void setAltenateEmail(String altEmail){
        this.altenateEmail=altEmail;
    }
    //Change the password


    public void ChangePassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAltenateEmail() {
        return altenateEmail;
    }

    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return "DISPLAY NAME: "+ firstName + " " + lastName+
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
