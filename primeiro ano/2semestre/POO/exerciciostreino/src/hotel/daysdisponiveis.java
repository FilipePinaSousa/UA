package hotel;

import java.time.DayOfWeek;

public class daysdisponiveis implements interfacecalendario {
    private DayOfWeek feriados;
    private DayOfWeek daysdisponiveis;
    private int feriashotel;

    public boolean isFeriado() {
        return false;
        // Implementação do método isFeriado()
    }

    public boolean isFeriasHotel() {
        return false;
        // Implementação do método isFeriasHotel()
    }

    public boolean isDiaDisponivel() {
        if (!isFeriado() && !isFeriasHotel()) {
            return true;
        } else {
            return false;
        }
    }
}

