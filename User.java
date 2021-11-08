

package quizer.pro;


//Class to represent CSIS user
public class User {
    //Variables that represent a user
    private String email; 
    private String password;
    private String fname;
    private String lname;
    private char accountType;
    private String classes;
    
   
    
   
    //Constructor for User
    public User(String[] s){
        //initialize variables
        email = s[0];
        password = s[1]; 
        fname = s[2];
        lname = s[3];
        accountType = s[4].charAt(0);
        
}
    
    //setter for email
    public void setEmail(String s){
        //set email to s
        email = s;
}

    //getter for email
    public String getEmail() {
        //return email
        return email;
    }

    //getter for password
    public String getPassword() {
        //return password
        return password;
    }

   //setter for password
    public void setPassword(String p) {
        //set password to p
        password = p;
    }

    //getter for fname
    public String getFname() {
        //return fname
        return fname;
    }

    //setter for fname
    public void setFname(String f) {
        //set fname to f
        fname = f;
    }

    //getter for lname
    public String getLname() {
        //return lname
        return lname;
    }

    //setter for lname
    public void setLname(String l) {
        //set lname to l
        lname = l;
    }
    
    //setter for account type
    public void setAccountType(String l){
        //set account type to the first character of l
        accountType = l.charAt(0);
    }
    
    //getter for account type
    public char getAccountType(){
        //return account type
        return accountType;
    }
    
    
}
