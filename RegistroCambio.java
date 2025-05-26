import java.time.LocalDateTime;

public class RegistroCambio {
    private ParteHardware parte;
    private String tipoCambio;
    private int cantidadAnterior;
    private LocalDateTime fechaHora;

    public RegistroCambio(ParteHardware parte, String tipoCambio, int cantidadAnterior) {
        this.parte = parte;
        this.tipoCambio = tipoCambio;
        this.cantidadAnterior = cantidadAnterior;
        this.fechaHora = LocalDateTime.now();
    }

    public ParteHardware getParte() {
        return parte;
    }

    public String getTipoCambio() {
        return tipoCambio;
    }

    public int getCantidadAnterior() {
        return cantidadAnterior;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return "RegistroCambio{" +
                "parte=" + parte.getNombre() +
                ", tipoCambio='" + tipoCambio + '\'' +
                ", cantidadAnterior=" + cantidadAnterior +
                ", fechaHora=" + fechaHora +
                '}';
    }
} 