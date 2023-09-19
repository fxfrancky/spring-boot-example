package com.fxfrancky;

import com.fxfrancky.customer.Customer;
import com.fxfrancky.customer.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@SpringBootApplication
public class SpringRealApplication {

    // db


    public static void main(String[] args) {
//        System.out.println("Hello World !!!! 🎉 ");
//        System.out.println(customers);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringRealApplication.class, args);
//        printBeans(applicationContext);

        // List the names of the beans
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
//            Customer alex = new Customer(
//                    "Alex",
//                    "alex@gmail.com",
//                    21
//            );
//
//            Customer jamila = new Customer(
//                    "Jamila",
//                    "jamila@gmail.com",
//                    19
//            );

            Faker faker = new Faker();
            Random random = new Random();
            String firstName = faker.name().firstName();
            String lastName = faker.name().lastName();
            Customer alex = new Customer(
                    firstName + " " + lastName,
                    faker.name().firstName().toLowerCase() +"."+ faker.name().lastName().toLowerCase()+"@amigoscode.com",
                    random.nextInt(16,65)
            );

            firstName = faker.name().firstName();
            lastName = faker.name().lastName();

            Customer jamila = new Customer(
                    firstName + " " + lastName,
                    faker.name().firstName().toLowerCase() +"."+ faker.name().lastName().toLowerCase()+"@amigoscode.com",
                    random.nextInt(16,65)
            );

            List<Customer> customers = List.of(alex, jamila);
            customerRepository.saveAll(customers);
        };
}

//    private static void printBeans(ConfigurableApplicationContext ctx){
//
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames){
//            System.out.println(beanDefinitionName);
//        }
//    }

//    @Bean("foo")
//    public Foo getFoo(){
//        return new Foo("bar");
//    }

//    record Foo(String name){}

    //    @GetMapping("/greet")
//    public GreetResponse greet(@RequestParam(value = "name", required = false) String name){
//        String greetMessage = name==null || name.isBlank() ? "Hello" : "Hello " + name;
//        GreetResponse response = new GreetResponse(
//                     greetMessage,
//                     List.of("Java", "Golang", "JavaScript"),
//                     new Person("Alex", 28, 30_000)
//                );
//        return response;
//    }
//
//    record Person(String name, int age, double savings){}
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person
//    ){
//    }

//    class GreetResponse {
//        private final String greet;
//        GreetResponse(String greet){
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof GreetResponse that)) return false;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//    }
}
