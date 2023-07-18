package by.alex.proclamation.controller;

import by.alex.proclamation.model.Letter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/mail")
public class MailController {

    @PostMapping(value = "/send", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String sendLetter(@RequestBody Letter letter){


        return "index";

    }
//
//        AuthorDto authorDto = new AuthorDto();
//        boolean isAdd = author.getId() == null;
//        try {
//            authorDto = service.save(author);
//        } catch (Exception e) {
//            logger.warn("Created author {} is not successful", author, e);
//        }
//        if (isAdd) {
//            model = new ModelAndView("redirect:/authors/" + authorDto.getId());
//
//        } else {
//            model = new ModelAndView("redirect:/authors");
//        }
//
//    }

}
