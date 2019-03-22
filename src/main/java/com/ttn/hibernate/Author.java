package com.ttn.hibernate;

import javax.persistence.*;
import java.util.*;

@Entity
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    @Column(name = "fname")
    private String firstname;
    @Transient
    @Column(name = "lname")
    private String lastname;
    @Column(name = "Age")
    private Integer age;
    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date date;
    @Embedded
    private Address address;
//    @OneToOne
//    @JoinColumn(name="book")
//    private Book book;
    /*@OneToMany //@OneToMany(cascade = CascadeType.PERSIST)
    @JoinTable(joinColumns = @JoinColumn(name="AUTH_ID"),inverseJoinColumns = @JoinColumn(name = "BOOK_ID"))
    private Set<Book> book;*/

    @ManyToMany(cascade = CascadeType.PERSIST)
    List<Book> books=new ArrayList<>();

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", address=" + address +
                ", books=" + books +
                ", subject=" + subject +
                '}';
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<String> getSubject() {
        return subject;
    }

    public void setSubject(Set<String> subject) {
        this.subject = subject;
    }

    @ElementCollection
    private Set<String> subject=new HashSet<>();

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
