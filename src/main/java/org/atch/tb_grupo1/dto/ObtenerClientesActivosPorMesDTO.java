package org.atch.tb_grupo1.dto;

public class ObtenerClientesActivosPorMesDTO {
    private String mes;
    private int clientes_activos;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getClientes_activos() {
        return clientes_activos;
    }

    public void setClientes_activos(int clientes_activos) {
        this.clientes_activos = clientes_activos;
    }
}
