package com.peso.elBuenSabor.DTOs;
import com.peso.elBuenSabor.enums.Rol;
import lombok.Data;
@Data
public class DTOcambiardatos {
    private Long id;
    private String email;
    private Rol rol;
    private String nombre;
    private String apellido;
    private String telefono;
}
