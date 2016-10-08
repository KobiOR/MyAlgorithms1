package algorithms.search

import algorithem.Demo.MazeAdapter
import mazeGenerators.Coordinate
import mazeGenerators.GrowingTreeGenerator
import mazeGenerators.Maze3dGenerator


class BFSTest {
    void testSearch() {
        BFS<Coordinate> BFSSearcher = new BFS<>();
        Maze3dGenerator mg = new GrowingTreeGenerator();

        MazeAdapter maze = null;
        Solution<Coordinate> BFSsolution;
        BFSsolution = BFSSearcher.search(maze);
        assertNull(BFSsolution);

        maze = new MazeAdapter(3, 0, 32);
        maze.maze3d = mg.generate(3, 24, 32);
        BFSsolution = BFSSearcher.search(maze);
        assertNotNull(BFSsolution);

        maze.maze3d = mg.generate(0, -2, -7);
        BFSsolution = BFSSearcher.search(maze);
        assertNotNull(BFSsolution);

    }


}
