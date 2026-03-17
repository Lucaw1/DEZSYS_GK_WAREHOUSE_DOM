package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private WarehouseRepository repository;

    // 🔥 POST: neues Produkt
    @PostMapping
    public ProductData createProduct(@RequestBody ProductData product) {
        return repository.save(product);
    }

    // 🔥 GET: alle Produkte
    @GetMapping
    public List<ProductData> getAllProducts() {
        return repository.findAll();
    }

    // 🔥 GET: Produkt nach ID
    @GetMapping("/{id}")
    public List<ProductData> getProductByProductID(@PathVariable String id) {
        return repository.findByProductID(id);
    }

    // 🔥 DELETE: Produkt löschen
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        List<ProductData> products = repository.findByProductID(id);
        repository.deleteAll(products);
    }

    // 🔥 Produkte nach Kategorie
    @GetMapping("/category/{category}")
    public List<ProductData> getByCategory(@PathVariable String category) {
        return repository.findByProductCategory(category);
    }

    // 🔥 Produkte unter bestimmtem Lagerbestand
    @GetMapping("/lowstock/{quantity}")
    public List<ProductData> getLowStock(@PathVariable double quantity) {
        return repository.findByProductQuantityLessThan(quantity);
    }
}