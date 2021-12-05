import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDataApplicationTests {
    //数据源
    @Autowired
    //自动装配
     DataSource dataSource;
    @ Test
    public void contextLoads() throws SQLException {
//       查看默认数据源 class com.zaxxer.hikari.HikariDataSource
        System.out.println(dataSource.getClass());
        //获取数据库连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
//        关闭连接
        connection.close();
    }
}
