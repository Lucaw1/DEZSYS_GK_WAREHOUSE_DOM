package warehouse.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import warehouse.model.ProductData;

public interface WarehouseRepository extends MongoRepository<ProductData, String> {

    public List<ProductData> findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);

    List<ProductData> findByProductCategory(String category);

    List<ProductData> findByProductQuantityLessThan(double quantity);

    List<ProductData> findByWarehouseIDAndProductQuantityLessThan(String warehouseID, double quantity);

 }
