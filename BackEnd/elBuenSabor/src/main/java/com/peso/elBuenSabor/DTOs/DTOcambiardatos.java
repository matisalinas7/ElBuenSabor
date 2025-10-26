package com.peso.elBuenSabor.DTOs;
import com.peso.elBuenSabor.enums.Role;
import lombok.Data;
@Data
public class DTOcambiardatos {
    private Long id;
    private String email;
    private Role role;
    private String nombre;
    private String apellido;
    private String telefono;
}
