package edu.mak.course.form;

import lombok.*;

import java.time.LocalDate;

/**
 * @author sonnyako <Makydon Sofiia>
 * @version 1.0.0
 * @since 1.0.0
 */

public class TravellerForm {
    private String id;
    private String name;
    private String birthday;
    private String documentNumber;
    private String phoneNumber;

    public TravellerForm(String name, String birthday, String documentNumber, String phoneNumber) {
        this.name = name;
        this.birthday = birthday;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
    }

    public TravellerForm() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
