package com.sd.project.client;

import com.sd.project.common.models.User;
import com.sd.project.common.models.Book;
import com.sd.project.common.models.Reservation;
import com.sd.project.common.services.BookService;
import com.sd.project.common.services.ReservationService;
import com.sd.project.common.services.UserService;

import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            UserService userService = (UserService) Naming.lookup("rmi://localhost:1099/UserService");
            BookService bookService = (BookService) Naming.lookup("rmi://localhost:1099/BookService");
            ReservationService reservationService = (ReservationService) Naming.lookup("rmi://localhost:1099/ReservationService");

            int choice;
            do {
                reservationService.checkAndFinalizeReservations();

                System.out.println("\n======== LIBRARY RMI ========");
                System.out.println("1. Registrar usuário");
                System.out.println("2. Ver usuários registrados");
                System.out.println("3. Buscar usuário pelo ID");
                System.out.println("5. Adicionar livro");
                System.out.println("6. Visualizar livro pelo ISBN");
                System.out.println("7. Visualizar todos os livros");
                System.out.println("8. Realizar reserva");
                System.out.println("9. Visualizar reserva pelo ID");
                System.out.println("10. Visualizar todas as reservas");
                System.out.println("0. Sair");
                System.out.println("================================");
                System.out.print("Escolha uma opção: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Digite o nome do usuário: ");
                        String name = scanner.nextLine();
                        System.out.print("Digite o email do usuário: ");
                        String email = scanner.nextLine();
                        User user = new User(name, email);
                        userService.addUser(user);
                        System.out.println("Usuário registrado com sucesso!");
                        break;
                    case 2:
                        System.out.println("Usuários registrados: " + userService.getAllUsers());
                        break;
                    case 3:
                        System.out.print("Digite o ID do usuário: ");
                        int userId = scanner.nextInt();
                        User foundUser = userService.getUser(userId);
                        if (foundUser == null) {
                            System.out.println("Usuário não encontrado.");
                            break;
                        }
                        System.out.println("Usuário encontrado: " + foundUser);
                        break;
                    case 5:
                        System.out.print("Digite o título do livro: ");
                        String bookTitle = scanner.nextLine();
                        System.out.print("Digite o autor do livro: ");
                        String bookAuthor = scanner.nextLine();
                        System.out.print("Digite o ISBN do livro: ");
                        String bookIsbn = scanner.nextLine();
                        Book book = new Book(bookTitle, bookAuthor, bookIsbn);
                        bookService.addBook(book);
                        System.out.println("Livro adicionado com sucesso!");
                        break;
                    case 6:
                        System.out.print("Digite o ISBN do livro: ");
                        String isbn = scanner.nextLine();
                        Book foundBook = bookService.getBook(isbn);
                        if (foundBook == null) {
                            System.out.println("Livro não encontrado.");
                            break;
                        }
                        System.out.println("Livro encontrado: " + foundBook);
                        break;
                    case 7:
                        System.out.println("Todos os livros: " + bookService.getAllBooks());
                        break;
                    case 8:
                        System.out.print("Digite o ISBN do livro para reserva: ");
                        String reserveIsbn = scanner.nextLine();
                        System.out.print("Digite o ID do usuário para reserva: ");
                        int reserveUserId = scanner.nextInt();


                        boolean isReserved = reservationService.isBookReserved(reserveIsbn);
                        if (isReserved) {
                            System.out.println("Livro já está reservado.");
                        } else {
                            Reservation reservation = new Reservation(reserveUserId, reserveIsbn);
                            reservationService.addReservation(reservation);
                            System.out.println("Reserva realizada com sucesso!");
                        }
                        break;
                    case 9:
                        System.out.print("Digite o ID da reserva: ");
                        int reservationId = scanner.nextInt();
                        Reservation foundReservation = reservationService.getReservation(reservationId);
                        if (foundReservation == null) {
                            System.out.println("Reserva não encontrada.");
                            break;
                        }
                        System.out.println("Reserva encontrada: " + foundReservation);
                        break;
                    case 10:
                        System.out.println("Todas as reservas: " + reservationService.getAllReservations());
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }

            } while (choice != 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}