/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import br.com.persistor.abstractClasses.Entity;
import br.com.persistor.annotations.PrimaryKey;
import br.com.persistor.enums.INCREMENT;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author marcosvinicius
 */
public class Contatos extends Entity
{

    private int id;

    @NotNull(message = "O nome é obrigatório")
    @NotEmpty(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
    private String nome;

    @NotNull(message = "O email é obrigatório")
    @NotEmpty(message = "O email é obrigatório")
    @Size(max = 100, message = "O email não pode conter mais de 100 caracteres")
    private String email;
    
    @Size(max = 15, message = "O telefone não pode ter mais de 15 caracteres")
    private String telefone;
    
    @Size(max = 100, message = "O endereço não pode ter mais de 100 caracteres")
    private String endereco;

    @PrimaryKey(increment = INCREMENT.MANUAL)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEndereco()
    {
        return endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

}
