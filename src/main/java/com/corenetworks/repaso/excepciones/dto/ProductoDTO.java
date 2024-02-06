package com.corenetworks.repaso.excepciones.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProductoDTO {
    @NotNull
    private int idProducto;

    @NotEmpty
    @Size(min = 3, message = "{nombres.size}")
    private String nombres;
}
