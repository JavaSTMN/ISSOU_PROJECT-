import java.util.Iterator;

public interface IObservable {
	void addObserver(IObserver observer);
	void notifyObservable();
}
