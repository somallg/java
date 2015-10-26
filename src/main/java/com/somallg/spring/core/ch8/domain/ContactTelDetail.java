package com.somallg.spring.core.ch8.domain;

public class ContactTelDetail {

    private Long Id;

    private Long contactId;

    private String telType;

    private String telNumber;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "ContactTelDetail [Id=" + Id + ", contactId=" + contactId
                + ", telTypes=" + telType + ", telNumber=" + telNumber + "]";
    }
}
