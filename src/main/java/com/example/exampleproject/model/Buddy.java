package com.example.exampleproject.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "buddies")
public class Buddy {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buddy_id")
    private Friend friend ;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buddy_id")
    private BuddyLogin buddyLogin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buddy_id")
    private Wishlist wishlist ;

    @OneToMany(mappedBy = "buddy", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<Review> authors;

    @ManyToMany
    @JoinTable (name="wishlist",
            joinColumns=@JoinColumn (name="buddy_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    private List<Product> products;

    @ManyToMany
    @JoinTable (name="friend",
            joinColumns=@JoinColumn (name="buddy_id"),
            inverseJoinColumns=@JoinColumn(name="friend_id"))
    private List<Friend> friends;

    @Id
    @Column(name = "buddy_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int buddy_id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "city")
    private String city;
    @Column(name = "avatar_img")
    private String avatar_img;

    public Buddy() {

    }

    public int getBuddy_id() {
        return buddy_id;
    }

    public void setBuddy_id(int buddy_id) {
        this.buddy_id = buddy_id;
    }

    public Buddy(int buddy_id, String firstName, String lastName, int age, String city, String avatar_img) {
        this.buddy_id = buddy_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.avatar_img = avatar_img;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public String getAvatar_img() {
        return avatar_img;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAvatar_img(String avatar_img) {
        this.avatar_img = avatar_img;
    }
//
//    public BuddyLogin getBuddyLogin() {
//        return buddyLogin;
//    }
//
//    public void setBuddyLogin(BuddyLogin buddyLogin) {
//        this.buddyLogin = buddyLogin;
//    }

    @Override
    public String toString() {
        return "\nBuddy{" +
//                "buddyLogin=" + buddyLogin +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", avatar_img='" + avatar_img + '\'' +
                '}';
    }
}
