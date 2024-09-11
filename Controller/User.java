package Controller;

import Interface.IObserver;

public class User implements IObserver {
  private String name;

  public User(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void update(String film, String genre) {
    System.out.println("Notify " + this.name + ": A new genre " + genre + " is added: " + film);
  }
}
