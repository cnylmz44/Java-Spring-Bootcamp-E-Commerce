package spring.demo.business.abstracts;

import org.springframework.data.jpa.repository.Query;
import spring.demo.core.utilities.results.DataResult;
import spring.demo.core.utilities.results.Result;
import spring.demo.entities.concretes.Product;
import spring.demo.entities.dtos.ProductWithCategoryDto;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAll(int pageNo, int pageSize);//for the limited data of the page
    DataResult<List<Product>> getAllSorted();
    Result add(Product product);

    DataResult<List<Product>> getByProductName(String productName);
    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);
    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
    DataResult<List<Product>> getByProductNameContains(String productName);
    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId);
    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
