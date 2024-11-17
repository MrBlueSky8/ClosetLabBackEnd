package org.atch.tb_grupo1.dto;

public class ObtenerFrecuenciaMetodosPagoDTO {
    private String metodo_pago;
    private int frecuencia_uso;

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public int getFrecuencia_uso() {
        return frecuencia_uso;
    }

    public void setFrecuencia_uso(int frecuencia_uso) {
        this.frecuencia_uso = frecuencia_uso;
    }
}
