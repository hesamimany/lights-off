public class Tile {
    State state = State.OFF;

    public Tile(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public void click(){
        if(state.ordinal()==0){
            state = State.OFF;
        } else state = State.ON;
    }

    @Override
    public String toString() {
        return String.format("%3s, ",getState());
    }
    public Tile clone(){
        return new Tile(state);
    }
}
enum State {
    ON,OFF
}
