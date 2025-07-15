import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.List;

public interface ReservationService extends Remote {
    void addReservation(Reservation reservation) throws RemoteException;
    Reservation getReservation(int id) throws RemoteException;
    List<Reservation> getAllReservations() throws RemoteException;
}