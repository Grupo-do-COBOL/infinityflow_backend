package site.infinityflow.usecases.smtp;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;


@Service
public class SmtUseCase {
    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmacaoRegistro(TabelaUsuariosRequestDTO requestDTO) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("gamartins013@gmail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, requestDTO.getEmail());
        message.setSubject("Confirmação de Registro!!");

        String htmlContent = "<h1>Parabéns " +requestDTO.getNome()+", seu cadastro foi realizado com sucesso!</h1>" +
                "<p>Acesse https://www.infinityflow.site/ para poder fazer o seu login</p>";
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }

}
