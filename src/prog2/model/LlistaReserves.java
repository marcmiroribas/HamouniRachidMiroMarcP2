package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import prog2.vista.ExcepcioReserva;
import prog2.model.InAllotjament;
import model.InLlistaReserves;

public class LlistaReserves implements InLlistaReserves {
    private List<Reserva> reserves;

    public LlistaReserves() {
        this.reserves = new ArrayList<>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L’allotjament amb identificador " + allotjament.getId() +
                    " no està disponible en la data demanada " + dataEntrada + " pel client " + client.getNom() +
                    " amb DNI: " + client.getDni() + ".");
        }

        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades pel client " + client.getNom() + " amb DNI: " +
                    client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " +
                    allotjament.getId() + ".");
        }

        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        reserves.add(novaReserva);
    }

    @Override
    public int getNumReserves() {
        return reserves.size();
    }

    private boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        for (Reserva reserva : reserves) {
            if (reserva.getAllotjament().equals(allotjament) &&
                    !(dataSortida.isBefore(reserva.getDataEntrada()) || dataEntrada.isAfter(reserva.getDataSortida()))) {
                return false;
            }
        }
        return true;
    }

    private boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        long diesEstada = java.time.temporal.ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        InAllotjament.Temp temporada = (dataEntrada.getMonthValue() >= 6 && dataEntrada.getMonthValue() <= 8) ?
                InAllotjament.Temp.ALTA : InAllotjament.Temp.BAIXA;
        return diesEstada >= allotjament.getEstadaMinima(temporada);
    }
}
