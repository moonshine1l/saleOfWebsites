package ru.moonshine1l.saleOfWebsites.rep;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.moonshine1l.saleOfWebsites.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
