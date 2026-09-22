package com.likelion14.springhw.guestbook.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class GuestbookDetailResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String writer;
    private final LocalDateTime createdAt;
    private final String ps;

}
