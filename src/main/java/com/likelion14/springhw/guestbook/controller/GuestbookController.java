package com.likelion14.springhw.guestbook.controller;

import com.likelion14.springhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion14.springhw.guestbook.service.GuestbookService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping("/api/guestbooks")
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbookSummaries();
    }

    @GetMapping("/api/guestbooks/count")
    public long getGuestbookCount() {
        return guestbookService.getGuestbookCount();
    }

    @GetMapping("/api/guestbooks/with-ps")
    public List<GuestbookSummaryResponse> getGuestbooksWithPs() {
        return guestbookService.getGuestbooksWithPs();
    }
}
