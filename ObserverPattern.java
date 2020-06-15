import java.util.ArrayList;

public class ObserverPattern {
    public static void main(String[] args) {
        GameSubject gameSubject = new GameSubject();
        GameObserver gameObserver = new GameObserver(gameSubject);
        gameSubject.setScore(new Pair<Integer, Integer>(1, 0));
        gameSubject.setScore(new Pair<Integer, Integer>(1, 1));
        gameSubject.removeObserver(gameObserver);
        gameSubject.setScore(new Pair<Integer, Integer>(1, 2));
        gameSubject.addObserver(gameObserver);
    }    
}

class Pair<T, U> {
    public T first;
    public U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return this.first + " - " + this.second;
    }
}

interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}

// subject
class GameSubject implements Subject {
    private ArrayList<Observer> observers;
    private Pair<Integer, Integer> score;

    public GameSubject() {
        this.observers = new ArrayList<Observer>();
        this.score = new Pair<Integer, Integer>(0, 0);
    }

    public void setScore(Pair<Integer, Integer> score) { 
        this.score = score; 
        notifyObservers();
    }

    public void addObserver(Observer o) { observers.add(o); }
    
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) observers.remove(i);
    }
    
    public void notifyObservers() {
        for(int i = 0; i < observers.size(); i++) {
            observers.get(i).setScore(score);
        }
    }
}

interface Observer {
    public void setScore(Pair<Integer, Integer> score);
}

// observer
class GameObserver implements Observer {
    private Pair<Integer, Integer> score;

    public GameObserver(Subject s) {
        s.addObserver(this);
    }

    public void getScore() { System.out.println(this.score.toString()); }

    public void setScore(Pair<Integer, Integer> score) {
        this.score = score;
        getScore();
    }
}