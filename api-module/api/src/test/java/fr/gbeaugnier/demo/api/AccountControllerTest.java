package fr.gbeaugnier.demo.api;

import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@Profile("dev")
class AccountControllerTest {

    @Karate.Test
    Karate testAccountApi() {
        return Karate
                .run("classpath:features/account.feature")
                .relativeTo(getClass());
    }
  
}