package com.brunostaine.api.park.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioCreateDTO {

    private String username;
    private String password;
}
