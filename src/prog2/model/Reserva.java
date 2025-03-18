package model;

import java.time.LocalDate;

/**
 * Classe que representa una reserva en el sistema.
 */
public class Reserva {
    private Allotjament allotjament;
    private Client client;
    private LocalDate dataEntrada;
    private LocalDate dataSortida;

    /**
     * Constructor de la classe Reserva.
     * @param allotjament L'allotjament reservat.
     * @param client El client que fa la reserva.
     * @param dataEntrada Data d'entrada de la reserva.
     * @param dataSortida Data de sortida de la reserva.
     */
    public Reserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) {
        this.allotjament = allotjament;
        this.client = client;
        this.dataEntrada = dataEntrada;
        this.dataSortida = dataSortida;
    }

    /**
     * Obté l'allotjament de la reserva.
     * @return L'allotjament reservat.
     */
    public Allotjament getAllotjament() {
        return allotjament;
    }

    /**
     * Obté el client que ha fet la reserva.
     * @return El client de la reserva.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Obté la data d'entrada de la reserva.
     * @return La data d'entrada.
     */
    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    /**
     * Obté la data de sortida de la reserva.
     * @return La data de sortida.
     */
    public LocalDate getDataSortida() {
        return dataSortida;
    }

    /**
     * Retorna una representació en format String de la reserva.
     * @return Cadena de text amb la informació de la reserva.
     */
    @Override
    public String toString() {
        return "Reserva{" +
                "allotjament=" + allotjament.getId() +
                ", client=" + client.getNom() +
                ", dataEntrada=" + dataEntrada +
                ", dataSortida=" + dataSortida +
                '}';
    }
}