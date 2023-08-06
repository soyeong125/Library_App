package com.group.libraryapp.service.book;

<<<<<<< HEAD
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
=======
import com.group.libraryapp.domain.book.Book;
import com.group.libraryapp.domain.book.BookRepository;
import com.group.libraryapp.domain.user.User;
import com.group.libraryapp.domain.user.UserRepository;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistory;
import com.group.libraryapp.domain.user.loanhistory.UserLoanHistoryRepository;
import com.group.libraryapp.dto.book.request.BookCreateRequest;
import com.group.libraryapp.dto.book.request.BookLoanRequest;
import com.group.libraryapp.dto.book.request.BookReturnRequest;
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
<<<<<<< HEAD
@RequiredArgsConstructor
=======
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
public class BookService {
    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

<<<<<<< HEAD

=======
    public BookService(BookRepository bookRepository,UserLoanHistoryRepository userLoanHistoryRepository,UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    }
<<<<<<< HEAD

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

=======
    @Transactional
    public void loanBook(BookLoanRequest request){
        //1.책 정보를 가져옴
        Book book =  bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException::new);

        //3. 만약 대출중이면 예외 발생
        if(userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(),false)){
            throw new IllegalArgumentException(String.format("진작 대출되어 있는 책입니다."));
        }

        //4. 유저 정보 가져온다.
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);

        user.loanBook(book.getName());
        //5. 유저 정보와 책 정보를 기반으로 UserLoanHistory 테이블 저장
        //userLoanHistoryRepository.save(new UserLoanHistory(user,book.getName()));
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
    }

    @Transactional
    public void returnBook(BookReturnRequest request){
<<<<<<< HEAD
        User user =  userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        user.returnBook(request.getBookName());
//        UserLoanHistory history =  userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//
//        history.doReturn();
    }

=======
        //1. userid 찾기
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException::new);
        //2. user id와 book name을 가지고 대출 기록 찾기
//        UserLoanHistory history =  userLoanHistoryRepository.findByUserIdAndBookName(user.getId(),request.getBookName())
//                .orElseThrow(IllegalArgumentException::new);
//        //3. 반납 처리
//        history.doReturn();
        user.returnBook(request.getBookName());
    }
>>>>>>> f34a76a4d4726c82cd5de0bf452e7c0ae8848ea0
}
