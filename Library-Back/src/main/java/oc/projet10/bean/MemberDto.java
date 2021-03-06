package oc.projet10.bean;

import oc.projet10.Entity.Member;

public class MemberDto {

    private int memberId;
    private String name;

    private String surname;

    private String email;

    private String password;

    private boolean isAdmin;

    public MemberDto(Member member) {
        this.memberId = member.getId();
        this.name = member.getName();
        this.surname = member.getSurname();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.isAdmin = member.isAdmin();
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public MemberDto() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id=" + memberId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
