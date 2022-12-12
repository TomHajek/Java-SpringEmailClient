package spring.email;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class JavaSpringEmailClientApplication {

	@Autowired
	private EmailService emailService;


	public static void main(String[] args) {
		SpringApplication.run(JavaSpringEmailClientApplication.class, args);
	}


	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
		emailService.sendEmailWithAttachment(
				"spring.email.to@gmail.com",
				"Sending you email with attachment",
				"This email has attachment",
				"C:\\Users\\public\\picture.jpeg");
	}

}
