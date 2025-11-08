package bo.com.lite.curso.msproducto.domain;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
public class Producto implements Serializable {
    private Long id;
    private String nombre;
    private BigDecimal precio;
}
