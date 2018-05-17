package gov.idaho.isp.bootvalidation;

import gov.idaho.isp.bootvalidation.domain.Widget;
import gov.idaho.isp.bootvalidation.domain.WidgetRepository;
import java.time.LocalDate;
import java.time.Month;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Bean
	public CommandLineRunner demo(WidgetRepository repository) {
		return (args) -> {
      log.info("=============Saving Widgets==============================");
			repository.save(new Widget("Jack", LocalDate.of(2018, Month.MAY, 17)));
			repository.save(new Widget("Jill", LocalDate.of(2019, Month.MAY, 17)));
      repository.save(new Widget("Rob", LocalDate.of(2020, Month.MAY, 17)));
      repository.save(new Widget("Bill", LocalDate.of(2021, Month.MAY, 17)));
		};
	}
}