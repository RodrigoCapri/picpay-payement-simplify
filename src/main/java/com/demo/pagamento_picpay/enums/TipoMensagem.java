package com.demo.pagamento_picpay.enums;

public enum TipoMensagem {

    ERRO(1),
    AVISO(2),
    SUCESSO(3);

    private int id;

    private TipoMensagem(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static TipoMensagem valueOf(int id) {
        for (TipoMensagem mensagem : values()) {
            if (mensagem.getId() == id) {
                return mensagem;
            }
        }
        throw new IllegalArgumentException("Tipo de mensagem invalido: " + id);
    }

}
