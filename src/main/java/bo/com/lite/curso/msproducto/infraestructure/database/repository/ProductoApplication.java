package bo.com.lite.curso.msproducto.infraestructure.database.repository;

import bo.com.lite.curso.msproducto.infraestructure.database.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoApplication extends JpaRepository<Producto, Long> {
}
