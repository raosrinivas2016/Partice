package sendingMail;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@RestController
public class EmailController {

@RequestMapping(value = "/sendEmail")
    public String sendEmail()throws AddressException , MessagingException, IOException{
    sendEmailWithAttachement();
    return "you man , u did sent email successfully.";
}
//@RequestMapping(value = "/sendEmailWithAttachment")
    public void sendEmailWithAttachement() throws AddressException , MessagingException, IOException {
    /* create properties object , store mail configuration setup like
    *  what host , what port , what to SSL or TLS
    *  difference between ssl & tls is different encyption alg's
    * tls is latest , supports different prots , developed by IETF(Internet Engineering Task Force), tls 1.0 is not compatible with ssl 3.0
    * ssl - secure sockey layer , developed by netscape , old protocol , mainly used in email
    *
    * */

    Properties props= new Properties();
    props.put("mail.smtp.auth","true");
    props.put("mail.smtp.starttls.enable","true");
    props.put("mail.smtp.host","smtp.gmail.com");
    props.put("mail.smtp.port","587");

    Session session =Session.getInstance(props, new javax.mail.Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
            return new PasswordAuthentication("rvemul04@gmail.com","knM&91fdC#r58");
        }
       });
    Message msg=new MimeMessage(session);
    msg.setFrom(new InternetAddress("rvemul04@gmail.com",false));
    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("rvemul04@gmail.com"));
    msg.setSubject("Tutorials point email");
    msg.setContent("Tutorials point email","text/html");
    msg.setSentDate(new Date());

    MimeBodyPart messageBodyPart = new MimeBodyPart();
    messageBodyPart.setContent("tutorials point email","text/html");

    Multipart multipart =new MimeMultipart();
    multipart.addBodyPart(messageBodyPart);
    MimeBodyPart attachPart = new MimeBodyPart();

    attachPart.attachFile("C:\\Users\\srinivas.vemulapalli\\Downloads\\1025007 - HW& Accuro.png");
    multipart.addBodyPart(attachPart);
    msg.setContent(multipart);
    Transport.send(msg);

    }

}
