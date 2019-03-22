package com.ttn.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) {
        Author author=new Author();
        author.setFirstname("bcd");
        author.setLastname("efg");
        Address address=new Address();
        address.setLocation("Noida");
        address.setState("Utter Pradesh");
        address.setStreetNumber(12);
        author.setAge(24);
        author.setDate(Date.valueOf("1999-12-12"));
        author.setAddress(address);
        author.setSubject(new HashSet<>(Arrays.asList("Math","Physics","Arts")));
        Book book=new Book();
        book.setBookName("Complete Reference Java ");
        author.setBooks(Arrays.asList(book));

        Author author1=new Author();
        author1.setFirstname("cde");
        author1.setLastname("fgh");
        author1.setAge(24);
        author1.setDate(Date.valueOf("1999-12-12"));
        author1.setAddress(address);
        author1.setSubject(new HashSet<>(Arrays.asList("Math","Physics","Arts")));
        Book book1=new Book();
        book1.setBookName("Little Marrim");
        author1.setBooks(Arrays.asList(book,book1));

        Author author2=new Author();
        author2.setFirstname("def");
        author2.setLastname("ghi");
        author2.setAge(24);
        author2.setDate(Date.valueOf("1999-12-12"));
        author2.setAddress(address);
        author2.setSubject(new HashSet<>(Arrays.asList("Math","Physics","Arts")));
        Book book2=new Book();
        book2.setBookName("Two States");
        author2.setBooks(Arrays.asList(book,book1,book2));

        Author author3=new Author();
        author3.setFirstname("efg");
        author3.setLastname("hij");
        author3.setAge(24);
        author3.setDate(Date.valueOf("1999-12-12"));
        author3.setAddress(address);
        author3.setSubject(new HashSet<>(Arrays.asList("Math","Physics","Arts")));
        Book book3=new Book();
        book3.setBookName("Last Night");
        author3.setBooks(Arrays.asList(book,book1,book2,book3));


        SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session=sessionFactory.openSession().getSession();
        session.beginTransaction();

        /*curd  create*//*
        session.save(author);
        session.save(book);
        session.save(author1);
        session.save(book1);
        session.save(author2);
        session.save(book2);
        session.save(author3);
        session.save(book3);*/
        session.persist(author);
        session.persist(author1);
        session.persist(author2);
        session.persist(author3);
        /*curd read*/
//        Author author=session.get(Author.class,"ABC");

        /*curd update*/
//        author.setLastname("ghi");
//        session.update(author);

        /*curd delete*/
//        session.delete(author);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        /*SessionFactory sessionFactory1=new Configuration().configure().buildSessionFactory();
        Session session1=sessionFactory1.openSession().getSession();
        Author author1=session1.get(Author.class,"bcd");
        System.out.println(author1);
        session1.close();
        sessionFactory1.close();*/
    }
}
