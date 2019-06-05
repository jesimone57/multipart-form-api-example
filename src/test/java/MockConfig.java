import com.jsimone.controller.FileUploadController;
import com.jsimone.controller.HelloController;
import com.jsimone.service.PersonCSVReaderService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableAutoConfiguration
//@PropertySource("application.properties")
public class MockConfig {

    // Services  go here ...
    @Bean
    public PersonCSVReaderService personCSVReaderService() {
        return new PersonCSVReaderService();
    }

    // Controllers ...
    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public FileUploadController fileUploadController() {
        return new FileUploadController();
    }
}
