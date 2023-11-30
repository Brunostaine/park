package com.brunostaine.api.park.web.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsuarioSenhaDTO {

    private String senhaAtual;
    private String novaSenha;
    private String confirmaSenha;
}
