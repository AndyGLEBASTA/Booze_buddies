package com.example.exampleproject.model;

import javax.persistence.*;

@Entity
@Table
public class Review {

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "buddy_id", insertable = false, updatable = false)
    private Buddy buddy;

    @OneToOne (optional=false, mappedBy="review")
    private ProductReview productReview;

    @OneToOne (optional=false, mappedBy="review")
    private BusinessReview businessReview;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id", nullable = false)
    private int review_id;

    @Column(name = "buddy_id")
    private int buddy_id;

    @Column(name = "productReview_id")
    private int productReview_id;

    @Column(name = "businessReview_id")
    private int businessReview_id;

    public Review() {}

    public Review(int review_id, int buddy_id, int productReview_id, int businessReview_id) {
        this.review_id = review_id;
        this.buddy_id = buddy_id;
        this.productReview_id = productReview_id;
        this.businessReview_id = businessReview_id;
    }

    public int getReview_id() {
        return review_id;
    }

    public int getBuddy_id() {
        return buddy_id;
    }

    public int getProductReview_id() {
        return productReview_id;
    }

    public int getBusinessReview_id() {
        return businessReview_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }

    public void setBuddy_id(int buddy_id) {
        this.buddy_id = buddy_id;
    }

    public void setProductReview_id(int productReview_id) {
        this.productReview_id = productReview_id;
    }

    public void setBusinessReview_id(int businessReview_id) {
        this.businessReview_id = businessReview_id;
    }
}