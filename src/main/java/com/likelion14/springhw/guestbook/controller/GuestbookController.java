package com.likelion14.springhw.guestbook.controller;

import com.likelion14.springhw.guestbook.dto.GuestbookDetailResponse;
import com.likelion14.springhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion14.springhw.guestbook.dto.GuestbookUpdateRequest;
import com.likelion14.springhw.guestbook.entity.Guestbook;
import com.likelion14.springhw.guestbook.service.GuestbookService;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.likelion14.springhw.guestbook.dto.GuestbookCreateRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/guestbooks")
public class GuestbookController {

    private final GuestbookService guestbookService;

    public GuestbookController(GuestbookService guestbookService) {
        this.guestbookService = guestbookService;
    }

    @GetMapping
    public List<GuestbookSummaryResponse> getGuestbooks() {
        return guestbookService.getGuestbookSummaries();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GuestbookDetailResponse createGuestbook(
            @Valid @RequestBody GuestbookCreateRequest request
    ) {
        return guestbookService.createGuestbook(request);
    }

    @GetMapping("/{guestbookId}")
    public GuestbookDetailResponse getGuestbook(
            @PathVariable("guestbookId") Long guestbookId
    ) {
        return guestbookService.getGuestbook(guestbookId);
    }

    @PutMapping("/{guestbookId}")
    public GuestbookDetailResponse updateGuestbook(
            @PathVariable("guestbookId") Long guestbookId,
            @Valid @RequestBody GuestbookUpdateRequest request
            ) {
        return guestbookService.updateGuestbook(guestbookId, request);
    }

    @DeleteMapping("/{guestbookId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGuestbook(@PathVariable("guestbookId") Long guestbookId) {
        guestbookService.deleteGuestbook(guestbookId);
    }
}
