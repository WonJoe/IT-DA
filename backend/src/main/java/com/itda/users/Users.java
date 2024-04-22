package com.itda.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Users implements Serializable {

    @Id
    @Column(name = "user_no")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @SequenceGenerator(name = "user_seq_generator", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long userNo;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_nickname")
    private String userNickname;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_gender")
    private String userGender;

    @Column(name = "user_age")
    private int userAge;

    @Column(name = "user_height")
    private int userHeight;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_hobby")
    private String userHobby;

    @Column(name = "user_tel")
    private String userTel;

    @Column(name = "user_weight")
    private int userWeight;

    @Column(name = "user_profile")
    private String userProfile;

    @Column(name = "user_grade")
    private String userGrade;

    @Column(name = "user_MBTI")
    private String userMBTI;

    @Column(name = "user_category")
    private String userCategory;

    @Column(name = "user_black")
    private boolean userBlack;

    @Column(name = "dia_qty")
    private int diaQty;

    @Column(name = "pinn_qty")
    private int pinnQty;

    public Long getUserNo() {
        return userNo;
    }

    public void setUserNo(Long userNo) {
        this.userNo = userNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getUserHeight() {
        return userHeight;
    }

    public void setUserHeight(int userHeight) {
        this.userHeight = userHeight;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public int getUserWeight() {
        return userWeight;
    }

    public void setUserWeight(int userWeight) {
        this.userWeight = userWeight;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserMBTI() {
        return userMBTI;
    }

    public void setUserMBTI(String userMBTI) {
        this.userMBTI = userMBTI;
    }

    public String getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public boolean isUserBlack() {
        return userBlack;
    }

    public void setUserBlack(boolean userBlack) {
        this.userBlack = userBlack;
    }

    public int getDiaQty() {
        return diaQty;
    }

    public void setDiaQty(int diaQty) {
        this.diaQty = diaQty;
    }

    public void decreaseDiaQty(int amount) {
        this.diaQty -= amount;
    }

    public int getPinnQty() {
        return pinnQty;
    }

    public void setPinnQty(int pinnQty) {
        this.pinnQty = pinnQty;
    }

    public void decreasePinnQty(int amount) {
        this.pinnQty -= amount;
    }
}