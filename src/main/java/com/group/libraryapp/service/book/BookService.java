package com.group.libraryapp.service.book;

import com.group.libraryapp.domian.book.Book;
import com.group.libraryapp.domian.book.BookRepository;
import com.group.libraryapp.domian.user.User;
import com.group.libraryapp.domian.user.UserLoanHistory;
import com.group.libraryapp.domian.user.UserLoanHistoryRepository;
import com.group.libraryapp.domian.user.UserRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;


    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }

    @Transactional
    public void loanBook(BookLoanRequest request){
        Book book =  bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)){
            throw new IllegalArgumentException("이미 대출중인 책입니다.");
        }

        User user =  userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        //userLoanHistoryRepository.save(new UserLoanHistory(user,book.getName()));
        user.loanBook(book.getName());

    }

    @Transactional
    public void returnBook(BookReturnRequest request){
        User user =  userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
//        UserLoanHistory history =  userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//
//        history.doReturn();
    }

}
