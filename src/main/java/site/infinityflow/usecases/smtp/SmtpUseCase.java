package site.infinityflow.usecases.smtp;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import site.infinityflow.adapters.mysql.repository.PresencasRepository;
import site.infinityflow.adapters.rest.tabelausuarios.dto.request.TabelaUsuariosRequestDTO;


@Service
public class SmtpUseCase {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PresencasRepository presencasRepository;

    public void sendConfirmacaoRegistro(TabelaUsuariosRequestDTO requestDTO) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("noreply.infinityflow@gmail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, requestDTO.getEmail());
        message.setSubject("Confirmação de Registro!!");

        String htmlContent = "<h1>Parabéns " + requestDTO.getNome() + ", seu cadastro foi realizado com sucesso!</h1>" +
                "<p>Acesse https://www.infinityflow.site/ para poder fazer o seu login</p>";
        message.setContent(htmlContent, "text/html; charset=utf-8");

        mailSender.send(message);
    }

    public void sendAvisoPresenca() throws MessagingException {

        var alunosFaltantes = presencasRepository.findAlunosFaltantes();

        for (var a : alunosFaltantes) {
            try {
                MimeMessage message = mailSender.createMimeMessage();

                message.setFrom(new InternetAddress("noreply.infinityflow@gmail.com"));
                message.setRecipients(MimeMessage.RecipientType.TO, (String) a[3]);
                message.setSubject("Aviso importante sobre o Aluno: " + a[0] + "!");

                String htmlContent = "<h1>Atenção, Sr(a). " + a[2] + "!</h1>" +
                        "<p>O Aluno: " + a[0] + ", está com " + a[4] + "% de presença na disciplina de " + a[1] + ".</p>" +
                        "<p>Informamos que ele poderá reprovar por faltas se a porcentagem de presença for menor que 75%.</p>" +
                        "<br>" +
                        "<p>Atenciosamente,</p>" +
                        "<p>Secretaria da Escola Infinito</p>";

                message.setContent(htmlContent, "text/html; charset=utf-8");

                System.out.println("Email enviado para: " + a[3]);
                mailSender.send(message);
            } catch (Exception e) {
                System.out.println("Problemas ao enviar email para: " + a[3]);
            }
        }
    }
}
