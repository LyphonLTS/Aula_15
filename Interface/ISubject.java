package Interface;

public interface ISubject {
  public void registerUser(IObserver observer, String genre);

  public void removeUser(IObserver observer, String genre);

  public void notifyUser(String film, String genre);
}
