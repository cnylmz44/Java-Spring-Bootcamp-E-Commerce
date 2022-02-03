package spring.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.demo.entities.concretes.Product;
import spring.demo.entities.dtos.ProductWithCategoryDto;

import java.util.List;

//<type of table, type of primary key>
public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> getByProductName(String productName);
    Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);
    List<Product> getByProductNameOrCategory_CategoryId(String productName, int categoryId);
    List<Product> getByCategoryIn(List<Integer> categories);
    List<Product> getByProductNameContains(String productName);
    List<Product> getByProductNameStartsWith(String productName);

    @Query("From Product where productName = :productName and category.categoryId = :categoryId")
    List<Product> GetByNameAndCategory(String productName, int categoryId);

    @Query("Select new spring.demo.entities.dtos.ProductWithCategoryDto"
            + "(p.id, p.productName, c.categoryName) "
            + "From Category c Inner Join c.products p")
    List<ProductWithCategoryDto> getProductWithCategoryDetails();

}
