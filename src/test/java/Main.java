import main.entity.Product;
import main.mapper.ProductMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis
 *
 * @author zhenxing liu
 * @create 2018-08-21 23:41
 **/
public class Main {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);
            List<Product> productList = productMapper.selectProductList();
            for (Product product : productList) {
                System.out.printf(product.toString());
            }
        } finally {
            sqlSession.close();
        }
    }
}
