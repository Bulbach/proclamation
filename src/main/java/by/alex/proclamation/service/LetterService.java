package by.alex.proclamation.service;

import by.alex.proclamation.exeption.CustomAppException;
import by.alex.proclamation.persistence.dto.LetterDto;
import by.alex.proclamation.persistence.mapper.LetterMapper;
import by.alex.proclamation.persistence.model.Cover;
import by.alex.proclamation.persistence.repository.LetterRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import java.util.Locale;

@Slf4j
@Service
public class LetterService {
    private final LetterRepository letRep;
    private final LetterMapper letMap;
    @Autowired
    private Cover cover;

    public LetterService(LetterRepository letRep, LetterMapper letMap) {
        this.letRep = letRep;
        this.letMap = letMap;
    }


    public String createApplication(LetterDto letDto) {
        String done;
        if (!letRep.existsByEmailAndProf(letDto.getEmail(), letDto.getProf())) {
            sendMail(letDto);
            letRep.save(letMap.toModel(letDto));
            log.warn("Заявка отправлена и сохранена" + letDto);
            done = "Все хорошо! Ваша заявка отправлена.";
        } else {
            log.warn("Была получена повторная заявка с одинакового емейла");
//            done = "Заявка с таким email на эту вакансию уже была отправлена";
            throw new CustomAppException("Заявка с таким email на эту вакансию уже была отправлена");
        }
        return done;
    }

    private void sendMail(LetterDto letterDto) {
        Message email = cover.createEmail();
        try {
            email.setSubject("Заявка на " + letterDto.getProf().toUpperCase(Locale.ROOT));
            email.setText(
                    String.format("Заявка от получателя %s , электронная почта %s , телефон = %s"
                            , letterDto.getName(), letterDto.getEmail(), letterDto.getPhone()));
            log.warn("Создана заявка " + email + " и отпралено письмом");
            Transport.send(email);
        } catch (MessagingException e) {
            log.debug("Проблемы при заполнении данных из заявки в письмо", e);
            throw new CustomAppException(e);
        }
    }
}
