package by.alex.proclamation.controller;

import com.google.gson.Gson;
import by.alex.proclamation.persistence.dto.LetterDto;
import by.alex.proclamation.service.LetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/mail")
@RequiredArgsConstructor
@Slf4j
@Validated
public class MailController {
    private final LetterService letServ;
    private final Gson gson;

    @PostMapping(value = "/send", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String sendLetter(@Valid @RequestBody LetterDto letDto) {
     return    gson.toJson(letServ.createApplication(letDto));

    }

}
