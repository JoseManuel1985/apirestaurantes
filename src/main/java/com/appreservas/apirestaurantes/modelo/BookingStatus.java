package com.appreservas.apirestaurantes.modelo;

/**
 * Enumeración que representa los posibles estados de una reserva
 */
public enum BookingStatus {
    /** Reserva confirmada y activa */
    CONFIRMADA,
    /** Reserva cancelada por el usuario o el restaurante */
    CANCELADA
}
