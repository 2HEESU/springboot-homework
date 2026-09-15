package com.likelion14.springhw.guestbook.service;

import com.likelion14.springhw.guestbook.dto.GuestbookSummaryResponse;
import com.likelion14.springhw.guestbook.entity.Guestbook;
import com.likelion14.springhw.guestbook.repository.GuestbookRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GuestbookService {

    private final GuestbookRepository guestbookRepository;

    public GuestbookService(GuestbookRepository guestbookRepository) {
        this.guestbookRepository = guestbookRepository;
    }

    public List<GuestbookSummaryResponse> getGuestbookSummaries() {
        List<Guestbook> guestbooks = guestbookRepository.findAll();
        List<GuestbookSummaryResponse> responses = new ArrayList<>();

        for(Guestbook guestbook : guestbooks) {
            GuestbookSummaryResponse response = new GuestbookSummaryResponse(
                    guestbook.getTitle(),
                    guestbook.getWriter(),
                    guestbook.getPs()
            );
            responses.add(response);
        }

        return responses;
    }

    public long getGuestbookCount() {
        return guestbookRepository.count();
    }

    public List<GuestbookSummaryResponse> getGuestbooksWithPs() {
        List<Guestbook> guestbooks = guestbookRepository.findByPsIsNotNull();
        List<GuestbookSummaryResponse> responses = new ArrayList<>();

        for(Guestbook guestbook : guestbooks) {
            GuestbookSummaryResponse response = new GuestbookSummaryResponse(
                    guestbook.getTitle(),
                    guestbook.getWriter(),
                    guestbook.getPs()
            );
            responses.add(response);
        }
        return responses;
    }
}
