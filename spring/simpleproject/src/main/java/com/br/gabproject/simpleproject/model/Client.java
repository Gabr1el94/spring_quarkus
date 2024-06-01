package com.br.gabproject.simpleproject.model;

import java.io.Serializable;

import com.br.gabproject.simpleproject.model.mapper.RoleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Client implements Serializable {

    @JsonProperty("idPessoa")
    private int idPessoa;

    @JsonProperty("name")
    private String name;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("role")
    private RoleEnum role;

    public Client() {
    }

    public Client(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = RoleEnum.valueOf(role);
    }

    /**
     * @return int return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return RoleEnum return the role
     */
    public String getRole() {
        return role.name();
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = RoleEnum.valueOf(role);
    }

    @Override
    public String toString() {
        return "{" +
                " idPessoa='" + getIdPessoa() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", password='" + getPassword() + "'" +
                "}";
    }

}
