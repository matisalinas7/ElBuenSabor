package com.peso.elBuenSabor.DTOs;
import lombok.Data;

@Data
public class DTOcambiarcontreseña {
    private Long id;
    private String contraseniaActual;
    private String contraseniaNueva;

}
