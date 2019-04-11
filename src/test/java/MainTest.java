import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

class MainTest {
    @Test
    public void test001_testConnect() throws IOException{
        Reader myBatisConfigReader =  Resources.getResourceAsReader("com/mybatis/mybatis.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(myBatisConfigReader);
        SqlSession session = factory.openSession();
        session.close();
    }
}