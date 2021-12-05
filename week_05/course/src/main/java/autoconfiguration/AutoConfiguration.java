package autoconfiguration;

import javax.management.MXBean;

@Configuration
@Import(Student.class)
public class AutoConfiguration {

    @Autowired
    Student student;

    @Bean
    public void info(){
        System.out.println(student.print());
    }
}
