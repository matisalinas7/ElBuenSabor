package com.peso.elBuenSabor.DTOs;
import lombok.Data;

import java.util.Objects;

@Data
public class DTORankingProducto {
    private Long idArticulo;
    private String nombre;
    private Long cantidad;

    public DTORankingProducto() {
    }

    public DTORankingProducto(Long idArtMan, String nombreArtMan, Long cantidad) {
        this.idArticulo = idArtMan;
        this.nombre = nombreArtMan;
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DTORankingProducto that = (DTORankingProducto) o;
        return Objects.equals(idArticulo, that.idArticulo) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArticulo, nombre, cantidad);
    }
}