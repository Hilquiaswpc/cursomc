package com.hilquias.dto;

import com.hilquias.domain.Cliente;
import com.hilquias.services.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;


import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min=5, max = 120,message = "Nome entre 5 e 120 caracter")
    private String nome;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(message = "Email inválido")
    private String email;

    public ClienteDTO(){

    }

    public  ClienteDTO(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
