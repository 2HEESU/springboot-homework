package com.likelion14.springhw.guestbook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuestbookUpdateRequest {

    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 100, message = "제목은 100자 이하로 작성해주세요.")
    private String title;

    @NotBlank(message = "본문은 필수입니다.")
    @Size(max = 500, message = "본문은 500자 이하로 작성해주세요.")
    private String content;

    @NotBlank(message = "작성자는 필수입니다.")
    @Size(max = 20, message = "작성자는 20자 이하로 작성해주세요.")
    private String writer;

    @Size(max = 200, message = "추신은 200자 이하로 작성해주세요.")
    private String ps;
}
