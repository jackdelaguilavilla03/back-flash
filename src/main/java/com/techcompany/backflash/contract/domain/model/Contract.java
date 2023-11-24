package com.techcompany.backflash.contract.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@With
@Getter
@Setter
public class Contract {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    private String id = UUID.randomUUID().toString();
    private String clientId;
    private String companyId;
    private String nombre;
    private String foto;
    private String nombreServicio;
    private String fechaHoy;
    private String servicios;
    private String direccionEntrega;
    private String direccionDestino;
    private String fechaServicio;
    private String horaServicio;
    private String numeroTarjeta;
    private String cvvTarjeta;
    private String vencimientoTarjeta;
    private String estado;
    private String rejectedPermanent;
    private String costoServicio;
    private String aceptado;
    private String estadoPermanente;

    public Contract(String clientId, String companyId, String nombre, String foto, String nombreServicio, String fechaHoy, String servicios, String direccionEntrega, String direccionDestino, String fechaServicio, String horaServicio, String numeroTarjeta, String cvvTarjeta, String vencimientoTarjeta, String estado, String rejectedPermanent, String costoServicio, String aceptado, String estadoPermanente) {
        this.clientId = clientId;
        this.companyId = companyId;
        this.nombre = nombre;
        this.foto = foto;
        this.nombreServicio = nombreServicio;
        this.fechaHoy = fechaHoy;
        this.servicios = servicios;
        this.direccionEntrega = direccionEntrega;
        this.direccionDestino = direccionDestino;
        this.fechaServicio = fechaServicio;
        this.horaServicio = horaServicio;
        this.numeroTarjeta = numeroTarjeta;
        this.cvvTarjeta = cvvTarjeta;
        this.vencimientoTarjeta = vencimientoTarjeta;
        this.estado = estado;
        this.rejectedPermanent = rejectedPermanent;
        this.costoServicio = costoServicio;
        this.aceptado = aceptado;
        this.estadoPermanente = estadoPermanente;
    }
}
