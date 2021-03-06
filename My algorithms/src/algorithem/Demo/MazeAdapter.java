package algorithem.Demo;

import algorithms.search.Searchable;
import algorithms.search.State;
import mazeGenerators.Coordinate;
import mazeGenerators.Maze3d;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by orrko_000 on 02/09/2016.
 * @MazeAdapter taking Maze3d Object and do adaptation to @Searchable<Coordinate>
 */
public class MazeAdapter implements Searchable<Coordinate> {
    public Maze3d myMaze;

    /**
     * @MazeAdapter C'tor
     * @Maze3d get to install local variable
     */
    public MazeAdapter(Maze3d newMaze) {
        this.myMaze=new Maze3d(newMaze);
    }

    /**
     * @getStartState
     * @State return installed StartCoordinate
     */
    @Override
    public State getStartState() {
        Coordinate start=new Coordinate(myMaze.getEntry());
        State <Coordinate> startState=new State<Coordinate>(start);
        return startState;
    }

    /**
     * getGoalState
     *
     * @return State object with Start Coordinate on it
     */
    @Override
    public State getGoalState() {
        Coordinate exit=new Coordinate(myMaze.getExit());
        State <Coordinate> exitState=new State<Coordinate>(exit);
        return exitState;
    }

    /**
     * getGoalState
     * @return List coordinates (installed on States objects) of any  PossibleStates on the current coordinate
     */
    @Override
    public List<State<Coordinate>> getAllPossibleStates(State<Coordinate> s)    {
        List<State<Coordinate>> movesList=new ArrayList<State<Coordinate>>();
        if (!myMaze.WallExist(s.getValue().UP())) {
            movesList.add(new State<Coordinate>(s.getValue().UP()));}

        if (!myMaze.WallExist(s.getValue().DOWN())) {
            movesList.add(new State<Coordinate>(s.getValue().DOWN()));}

        if (!myMaze.WallExist(s.getValue().LEFT())) {
            movesList.add(new State<Coordinate>(s.getValue().LEFT()));}

        if (!myMaze.WallExist(s.getValue().RIGHT())) {
            movesList.add(new State<Coordinate>(s.getValue().RIGHT()));}

        if (!myMaze.WallExist(s.getValue().BACKWORDS())) {
            movesList.add(new State<Coordinate>(s.getValue().BACKWORDS()));}

        if (!myMaze.WallExist(s.getValue().STRAIGHT())) {
            movesList.add(new State<Coordinate>(s.getValue().STRAIGHT()));}

        return movesList;
    }

    /**
     * getGoalState
     * @param s-change value on the copy maze to know later that the algorithm that all ready been there
     */
    @Override
    public void setValue(State<Coordinate> s) {
        myMaze.setValueByCoor(s.getValue(), 1);
    }

    /**
     * getMoveCost
     * @param currState-calculate the time from one coordinate to :
     * @param neighbor-the end coordinate of the path
     *
     */
    @Override
    public double getMoveCost(State currState, State neighbor) {
        return 0;
    }

}
