
package com.mycompany.soap.model;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Usuario {
    private int idusuario;
    private String username;
    private String password;
    private int idpersona;
    private int idrol;
    private String fecha;
    private boolean estado;
}
