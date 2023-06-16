package site.infinityflow.adapters.smtp;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import site.infinityflow.usecases.smtp.SmtpUseCase;

@Component
public class EnviarAviso {

    @Autowired
    private SmtpUseCase smtp;

    @Scheduled(cron = "0 56 21 ? * *")
    public void execute() throws MessagingException {
        smtp.sendAvisoPresenca();
    }
}
