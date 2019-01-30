package io.snippets;

public enum EnumMovements {

    DEPOSITO("Deposito"),
    SOLICITUD_RETIRO("Solicitud de retiro"),
    RETIRO("Retiro"),
    PAGO("Pago"),
    COMISION_ZIGO("Comisión Zigo"),
    COMPRA_CARTERA("Compra cartera"),
    VENTA_CARTERA("Venta cartera"),
    SOLICITUD_INVERSION("Solicitud de inversión"),
    ACEPTACION_INVERSION("Aceptación de inversión");

    private String description;

    EnumMovements(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
