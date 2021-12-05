package bean;

import javax.management.MXBean;

@Configuration
public class Test {
    //2.配置类装配bean
    @Bean
    public Student getStudent(){
        return new Student();
    }
}
