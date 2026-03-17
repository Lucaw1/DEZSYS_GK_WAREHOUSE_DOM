package warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import warehouse.model.ProductData;
import warehouse.repository.WarehouseRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private WarehouseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

    @Override
    public void run(String... args) {

        // 🔥 Alte Daten löschen
        repository.deleteAll();

        System.out.println("🚀 Generating test data...");

        // Kategorien
        String[] categories = {
                "Getraenk",
                "Waschmittel",
                "Tierfutter",
                "Reinigung",
                "Elektronik",
                "Lebensmittel"
        };

        java.util.Random random = new java.util.Random();

        // 🔥 300 Produkte erzeugen
        for (int i = 1; i <= 300; i++) {

            String warehouseID = String.valueOf(random.nextInt(5) + 1); // Lager 1–5
            String productID = "P-" + i;
            String productName = "Produkt-" + i;
            String productCategory = categories[random.nextInt(categories.length)];
            double productQuantity = random.nextInt(500); // 0–499 Stück

            repository.save(new ProductData(
                    warehouseID,
                    productID,
                    productName,
                    productCategory,
                    productQuantity
            ));
        }

        System.out.println("✅ 300 Testdaten erfolgreich erzeugt!");

        // 🔥 Kontrolle (optional, aber gut für Debug)
        System.out.println("\n📦 Alle Produkte:");
        for (ProductData product : repository.findAll()) {
            System.out.println(product);
        }
    }

}
