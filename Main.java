import java.util.ArrayList;
import java.util.Scanner;

import Controller.Platform;
import Controller.User;

class Main {
  public static void main(String[] args) {
    String continuar = "sim";
    Platform plataforma = new Platform();
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> users = new ArrayList<>();

    // Adicionado usuários
    users.add(new User("João"));
    users.add(new User("Maria"));
    users.add(new User("Carlos"));
    users.add(new User("Ana"));
    users.add(new User("Pedro"));

    System.out.println("Bem vindo a plataforma on-demand");

    do {
      System.out.println("**Menu de opções**");
      System.out.println("1 - Acompanhar gênero");
      System.out.println("2 - Cancelar inscrição");
      System.out.println("0 - Sair");
      String opcao = scanner.nextLine();

      switch (opcao) {
        case "1":
          System.out.println("Digite o nome de usuário: ");
          String name = scanner.nextLine();

          System.out.println("Digite o gênero desejado");
          System.out.println("action");
          System.out.println("comedy");
          System.out.println("horror");
          System.out.println("anime");
          System.out.println("fiction");
          String genero = scanner.nextLine();

          for (User user : users) {
            if (user.getName().toLowerCase().equals(name.toLowerCase())) {
              plataforma.registerUser(user, genero);
            }
          }
          break;
        case "2":
          System.out.println("Digite o nome de usuário: ");
          name = scanner.nextLine();

          System.out.println("Digite o gênero desejado");
          System.out.println("action");
          System.out.println("comedy");
          System.out.println("horror");
          System.out.println("anime");
          System.out.println("fiction");
          genero = scanner.nextLine();

          for (User user : users) {
            if (user.getName().toLowerCase().equals(name.toLowerCase())) {
              plataforma.removeUser(user, genero);
            }
          }
          break;

        default:
          break;
      }

      // Adicionando filmes
      plataforma.addFilm("Vingadores: Ultimato", "ação");
      plataforma.addFilm("Todo Mundo em Pânico", "comédia");
      plataforma.addFilm("Invocação do Mal", "terror");
      plataforma.addFilm("Naruto", "anime");
      plataforma.addFilm("Interestelar", "ficção científica");

      if (opcao.equals("0"))
        continuar = "não";
    } while (continuar.toLowerCase().equals("sim"));

    scanner.close();
  }
}