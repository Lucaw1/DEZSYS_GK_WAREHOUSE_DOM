package warehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import warehouse.model.ProductData;
import warehouse.repository.WarehouseRepository;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseRepository repository;

    // 🔥 GET: alle Lager
    @GetMapping
    public List<ProductData> getAllWarehouses() {
        return repository.findAll();
    }

    // 🔥 GET: Lager nach ID
    @GetMapping("/{id}")
    public List<ProductData> getWarehouseById(@PathVariable String id) {
        return repository.findByWarehouseID(id);
    }

    // 🔥 DELETE: Lager löschen
    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable String id) {
        List<ProductData> data = repository.findByWarehouseID(id);
        repository.deleteAll(data);
    }
}