package org.atch.tb_grupo1.dto;

import java.time.LocalDate;

public class ObtenerIngresosMensualesDTO {
    private String mes;
    private float ingresos_mensuales;

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public float getIngresos_mensuales() {
        return ingresos_mensuales;
    }

    public void setIngresos_mensuales(float ingresos_mensuales) {
        this.ingresos_mensuales = ingresos_mensuales;
    }
}
