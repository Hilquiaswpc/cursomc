package com.hilquias.services.validation;


import com.hilquias.domain.Cliente;
import com.hilquias.dto.ClienteNewDTO;
import com.hilquias.enums.TipoCliente;
import com.hilquias.repositories.ClienteRepository;
import com.hilquias.resources.Exception.FieldMessage;
import com.hilquias.services.validation.Utils.BR;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
    @Autowired
    private ClienteRepository repo;

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {



        List<FieldMessage> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCNPJ())) {
            list.add(new FieldMessage("cpfOuCNPJ", "CPF inválido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCNPJ())) {
            list.add(new FieldMessage("cpfOuCNPJ", "CNPJ inválido"));
        }

        Cliente aux = repo.findByEmail(objDto.getEmail());
        if(aux != null){
            list.add(new FieldMessage("email", " Email já existente"));
        }
        Cliente tip = repo.findByNome(objDto.getNome());
        if(tip != null){
            list.add(new FieldMessage("nome", " Nome já existente"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }

        return list.isEmpty();
    }
}