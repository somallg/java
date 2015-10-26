package com.somallg.spring.core.ch10.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "HOBBY")
public class Hobby {

    private String hoobyId;

    private Set<Contact> contacts = new HashSet<Contact>();

    @Id
    @Column(name = "HOBBY_ID")
    public String getHoobyId() {
        return hoobyId;
    }

    public void setHoobyId(String hoobyId) {
        this.hoobyId = hoobyId;
    }

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL", joinColumns = @JoinColumn(name = "HOBBY_ID"), inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "Hobby [hoobyId=" + hoobyId + "]";
    }
}
