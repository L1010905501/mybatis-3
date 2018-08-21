package main.mapper;

import main.entity.Product;

import java.util.List;

public interface ProductMapper {
    /**
     * 查询所有的产品
     * @return
     */
    List<Product> selectProductList();
}