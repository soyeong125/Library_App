package com.group.libraryapp.domian.user;

import jakarta.persistence.*;

@Entity
public class UserLoanHistory {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id = null;
    @ManyToOne
    private User user;
    private String bookName;
    private boolean isReturn;

    protected UserLoanHistory(){};
    public UserLoanHistory(User user, String bookName){
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public String getBookName() {
        return bookName;
    }

    public void doReturn(){
        this.isReturn = true;
    }
}
