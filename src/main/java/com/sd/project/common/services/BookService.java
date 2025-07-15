import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BookService extends Remote {
    void addBook(Book book) throws RemoteException;
    Book getBook(String isbn) throws RemoteException;
    List<Book> getAllBooks() throws RemoteException;
}