package com.somallg.spring.core.ch9.domain;

import javax.persistence.*;

@Entity
@Table(name = "CONTACT_INTEREST")
public class ContactInterest {

    private Long id;

    private String interestType;

    private String interestNumber;

    private Contact contact;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "INTEREST_TYPE")
    public String getInterestType() {
        return interestType;
    }

    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    @Column(name = "INTEREST_NUMBER")
    public String getInterestNumber() {
        return interestNumber;
    }

    public void setInterestNumber(String interestNumber) {
        this.interestNumber = interestNumber;
    }

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactInterest [id=" + id + ", interestType=" + interestType
                + ", interestNumber=" + interestNumber + "]";
    }
}
