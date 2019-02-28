/**
 * Created by Shreyas on 6/29/2018.
 */
package com.itil.vm;

public class registeration {
    private String email;
    private String password;
    private String companyName;
    private  String phone_number;
    private String CompanyAddress;
    private String Name;

    private  String usrtype;

    public registeration() {
    }

    public registeration(String email, String password, String companyName, String phone_number, String CompanyAddress, String Name, String usrtype) {
        this.email = email;
        this.password = password;
        this.companyName = companyName;
        this.phone_number = phone_number;
        this.CompanyAddress = CompanyAddress;
        this.Name = Name;
        this.usrtype = usrtype;
    }

    public String getemail() {
        return email;
    }

    public String getpassword() {
        return password;
    }

    public String getcompanyName() {
        return companyName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getCompanyAddress() {
        return CompanyAddress;
    }

    public String getName() {
        return Name;
    }

    public String getUsrtype() {
        return usrtype;
    }
}
