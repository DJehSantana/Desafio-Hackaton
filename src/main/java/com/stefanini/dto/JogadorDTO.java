package com.stefanini.dto;

import java.util.List;
import java.math.BigDecimal;

public class JogadorDTO {
    private Long id;
    private String nickname;
    private String password;
    private BigDecimal saldo;
    private List stefamons;

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public List getStefamons() {
        return stefamons;
    }

    public void setStefamons(List stefamons) {
        this.stefamons = stefamons;
    }

    public JogadorDTO() {
    }
}
