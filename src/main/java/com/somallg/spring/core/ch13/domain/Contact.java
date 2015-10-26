package com.somallg.spring.core.ch13.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "CONTACT")
@NamedQueries({
        @NamedQuery(name = "Contact.findById",
                query = "select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.hobbies h where c.id = :id"),
        @NamedQuery(name = "Contact.findAllWithDetail",
                query = "select distinct c from Contact c left join fetch c.contactTelDetails t left join fetch c.contactInterests i left join fetch c.hobbies h")
})
public class Contact {

    private Long id;

    private int version;

    private String firstName;

    private String lastName;

    private Date birthDate;

    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();

    private Set<ContactInterest> contactInterests = new HashSet<ContactInterest>();

    private Set<Hobby> hobbies = new HashSet<Hobby>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            targetEntity = ContactTelDetail.class, orphanRemoval = true)
    public Set<ContactTelDetail> getContactTelDetails() {
        return contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail) {
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    public void removeContactTelDetail(ContactTelDetail contactTelDetail) {
        getContactTelDetails().remove(contactTelDetail);
    }

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            targetEntity = ContactInterest.class, orphanRemoval = true)
    public Set<ContactInterest> getContactInterests() {
        return contactInterests;
    }

    public void setContactInterests(Set<ContactInterest> contactInterests) {
        this.contactInterests = contactInterests;
    }

    @ManyToMany
    @JoinTable(name = "CONTACT_HOBBY_DETAIL", joinColumns = @JoinColumn(name = "CONTACT_ID"), inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    public Set<Hobby> getHobbies() {
        return hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", version=" + version +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", contactTelDetails=" + contactTelDetails +
                ", contactInterest=" + contactInterests +
                ", hobbies=" + hobbies +
                '}';
    }
}
