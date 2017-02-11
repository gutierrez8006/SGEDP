package com.acme.pe.persistencia.util;

/**
 *
 * @author gutie026
 * @param <String>
 * @param <VALOR>
 */
public class AliasValor <String, VALOR>{
    private String alias;
    private VALOR valor;

    public AliasValor() {
    }

    public AliasValor(String alias, VALOR valor) {
        this.alias = alias;
        this.valor = valor;
    }
    
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public VALOR getValor() {
        return valor;
    }

    public void setValor(VALOR valor) {
        this.valor = valor;
    }
    
    
}
