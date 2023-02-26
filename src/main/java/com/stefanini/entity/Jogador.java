package com.stefanini.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "tb_jogador", uniqueConstraints = @UniqueConstraint(columnNames = { "nickname" }))
public class Jogador {

    @Id
    @Column(name = "id_jogador")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo é obrigatório")
    @Size(min = 4, max = 10, message = "O nickName deve ter de 4 a 10 caracteres")
    @Column(unique = true)
    private String nickname;

    @NotBlank(message = "Campo é obrigatório")
    @Column
    private String password;

    @Column
    private BigDecimal saldo;

    @ManyToMany
    @JoinTable(name = "Jogador_Stefamon", joinColumns = { @JoinColumn(name = "IdJogador") }, inverseJoinColumns = {
            @JoinColumn(name = "IdStefamon") })
    private List<Stefamon> stefamons = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public List<Stefamon> getStefamons() {
        return stefamons;
    }

    public void setStefamons(List<Stefamon> stefamons) {
        this.stefamons = stefamons;
    }

    public Jogador() {
    }
}
