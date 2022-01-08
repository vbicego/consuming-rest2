package de.evoila.consumingrest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Todo todoToPrint = new RestTemplate().getForObject("https://jsonplaceholder.typicode.com/todos/5", Todo.class);
        log.info(todoToPrint.toString());
    }

//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }

//    @Bean
//    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//        return args -> {
//            Todo todo = restTemplate.getForObject(
//                    "https://jsonplaceholder.typicode.com/todos/5", Todo.class);
//            log.info(todo.toString());
//        };
//    }


}
