package bo.com.lite.curso.msproducto.infraestructure.rest;

import bo.com.lite.curso.msproducto.infraestructure.database.Producto;
import bo.com.lite.curso.msproducto.infraestructure.database.repository.ProductoApplication;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@RequestMapping("/producto")
public class ProductoController {

    private final ProductoApplication productoApplication;
    private final Logger log = Logger.getLogger(ProductoController.class.getName());

    @GetMapping("/")
    public List<Producto> productos() {
        return productoApplication.findAll();
    }
    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        log.info("ID: " + id);
        return productoApplication.findById(id).orElse(null);
    }
    @PostMapping("/new")
    public Producto addProducto(@RequestBody Producto producto) {
        return productoApplication.save(producto);
    }

    @PutMapping("/update/{id}")
    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoDb = productoApplication.findById(id).orElse(null);
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        return productoApplication.save(productoDb);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProducto(@PathVariable Long id) {
        Producto productoDb = productoApplication.findById(id).orElse(null);
        productoApplication.delete(productoDb);
    }

    @DeleteMapping("/update")
    public void updateProducto(@RequestBody Producto producto) {
        Producto productoDb = productoApplication.findById(producto.getId()).orElse(null);
        productoDb.setNombre(producto.getNombre());
        productoDb.setPrecio(producto.getPrecio());
        productoApplication.save(productoDb);
    }

    @GetMapping("")
    public Producto getProductoByIdAndNombre(@RequestParam(name = "id") Long id,
                                             @RequestParam(name = "nombre") String nombre) {
//        return Producto.builder().id(id).nombre(nombre).precio(new BigDecimal("10.00")).build();
        return new Producto();
    }
    @GetMapping("/get-body")
    public Producto getProductoBody(@RequestBody Producto producto) {
        return producto;
    }
}
