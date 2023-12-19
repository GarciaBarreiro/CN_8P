package gal.usc.grei.cn.compras.modelo;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


@Document(collection = "compras") // Ojala no se necesita @Bean, porque no funciona
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Compra {
    @Id
    private String id;
    private String fecha;
    @NotEmpty(message = "El símbolo no puede ser vacío")
    private String simbolo;
    @NotNull(message = "El volumen no puede ser vacío")
    private Long volumen;
    @NotNull(message = "El precio por unidad no puede ser vacío")
    private Float unidad;
    @NotNull(message = "El precio total no puede ser vacío")
    private Float total;
    private String comprador; // Nombre del comprador
    private String modoPago; // Tarjeta, Efectivo, Online
    private String estado; // ACEPTADO, RECHAZADO

    public String getComprador() {
        return comprador;
    }

    public Compra setComprador(String comprador) {
        this.comprador = comprador;
        return this;
    }

    public String getModoPago() {
        return modoPago;
    }

    public Compra setModoPago(String modoPago) {
        this.modoPago = modoPago;
        return this;
    }

    public String getEstado() {
        return estado;
    }

    public Compra setEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public String getId() {
        return id;
    }

    public Compra setId(String id) {
        this.id = id;
        return this;
    }

    public String getFecha() {
        return fecha;
    }

    public Compra setFecha(String fecha) {
        this.fecha = fecha;
        return this;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public Compra setSimbolo(String simbolo) {
        this.simbolo = simbolo;
        return this;
    }

    public Long getVolumen() {
        return volumen;
    }

    public Compra setVolumen(Long volumen) {
        this.volumen = volumen;
        return this;
    }

    public Float getUnidad() {
        return unidad;
    }

    public Compra setUnidad(Float unidad) {
        this.unidad = unidad;
        return this;
    }

    public Float getTotal() {
        return total;
    }

    public Compra setTotal(Float total) {
        this.total = total;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(getId(), compra.getId()) && Objects.equals(getFecha(), compra.getFecha()) && Objects.equals(getSimbolo(), compra.getSimbolo()) && Objects.equals(getVolumen(), compra.getVolumen()) && Objects.equals(getUnidad(), compra.getUnidad()) && Objects.equals(getTotal(), compra.getTotal()) && Objects.equals(getComprador(), compra.getComprador()) && Objects.equals(getModoPago(), compra.getModoPago()) && Objects.equals(getEstado(), compra.getEstado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFecha(), getSimbolo(), getVolumen(), getUnidad(), getTotal(), getComprador(), getModoPago(), getEstado());
    }

    @Override
    public String toString() {
        return "Compra{" +
                "id='" + id + '\'' +
                ", fecha='" + fecha + '\'' +
                ", simbolo='" + simbolo + '\'' +
                ", volumen=" + volumen +
                ", unidad=" + unidad +
                ", total=" + total +
                ", comprador='" + comprador + '\'' +
                ", modoPago='" + modoPago + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
