package com.likelion14.springhw.guestbook.repository;

import com.likelion14.springhw.guestbook.entity.Guestbook;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestbookRepository extends JpaRepository<Guestbook, Long>{
    List<Guestbook> findByPsIsNotNull();
}
