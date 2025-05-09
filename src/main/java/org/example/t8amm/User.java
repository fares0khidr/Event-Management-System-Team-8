package org.example.t8amm;



public abstract class User  {
    protected String Username;
    private String Password;
    private String DateOfBirth;
    private Gender gender;
    protected static Wallet wallet;

    /// Setters & Getters
    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String username) {
        this.Username = username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public String getDateOfBirth() {
        return this.DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.DateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public User() {
    }

    public User(String username, String password, String dateOfBirth, Gender gender,double balance) {
        Username = username;
        Password = password;
        DateOfBirth = dateOfBirth;
        this.gender = gender;
        this.wallet = new Wallet(balance);
    }

    public Wallet getWallet() {
        return wallet;
    }

}

