package spring.demo.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import spring.demo.business.abstracts.ProductService;
import spring.demo.core.utilities.results.DataResult;
import spring.demo.core.utilities.results.Result;
import spring.demo.core.utilities.results.SuccessDataResult;
import spring.demo.dataAccess.abstracts.ProductDao;
import spring.demo.entities.concretes.Product;
import spring.demo.entities.dtos.ProductWithCategoryDto;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired //Projede karşılık gelen sınıfı enjekte eder
    public ProductManager(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll() {
        //business codes
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Data listed");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessDataResult("Product is added");
    }

    @Override
    public DataResult<List<Product>> getByProductName(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductName(productName),"Data listed");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByCategoryIn(categories),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data listed");
    }

    @Override
    public DataResult<List<Product>> GetByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.GetByNameAndCategory(productName,categoryId),"Data listed");
    }

    @Override
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
        return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Data listed");
    }
}
