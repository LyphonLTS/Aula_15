package Controller;

import java.util.ArrayList;

import Interface.IObserver;
import Interface.ISubject;

public class Platform implements ISubject {
  private ArrayList<IObserver> actionObservers;
  private ArrayList<IObserver> comedyObservers;
  private ArrayList<IObserver> horrorObservers;
  private ArrayList<IObserver> animeObservers;
  private ArrayList<IObserver> fictionObservers;

  public Platform() {
    this.actionObservers = new ArrayList<>();
    this.comedyObservers = new ArrayList<>();
    this.horrorObservers = new ArrayList<>();
    this.animeObservers = new ArrayList<>();
    this.fictionObservers = new ArrayList<>();
  }

  @Override
  public void registerUser(IObserver observer, String genre) {
    switch (genre) {
      case "action" -> actionObservers.add(observer);
      case "comedy" -> comedyObservers.add(observer);
      case "horror" -> horrorObservers.add(observer);
      case "anime" -> animeObservers.add(observer);
      case "fiction" -> fictionObservers.add(observer);
    }
  }

  @Override
  public void removeUser(IObserver observer, String genre) {
    switch (genre) {
      case "action" -> actionObservers.remove(observer);
      case "comedy" -> comedyObservers.remove(observer);
      case "horror" -> horrorObservers.remove(observer);
      case "anime" -> animeObservers.remove(observer);
      case "fiction" -> fictionObservers.remove(observer);
    }
  }

  @Override
  public void notifyUser(String film, String genre) {
    ArrayList<IObserver> observers = switch (genre.toLowerCase()) {
      case "action" -> actionObservers;
      case "comedy" -> comedyObservers;
      case "horror" -> horrorObservers;
      case "anime" -> animeObservers;
      case "fiction" -> fictionObservers;
      default -> null;
    };

    if (observers != null) {
      for (IObserver observer : observers) {
        observer.update(film, genre);
      }
    }
  }

  public void addFilm(String film, String genre) {
    System.out.println("New fil added: " + film + " (Genre: " + genre + ")");
    notifyUser(film, genre);
  }
}
