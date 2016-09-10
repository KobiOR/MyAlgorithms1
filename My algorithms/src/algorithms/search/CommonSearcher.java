/**
 * COOMONSERACHER  CLASS
 * itarative algorithem
 * @param openList-a QUEUE FOR STATE<T>
 * @param closedList  this is the LIST for the algorithem-USE FOR KNOW WHO IS OUT&IN
 *
 */
package algorithms.search;

import java.util.List;

public abstract class CommonSearcher<T> implements Searcher {

	protected int evaluatedNodes;

	@Override
	    public int getNumberOfNodesEvaluated() {
		return evaluatedNodes;
	}
		protected Solution<T> backTrace(State<T> goalState) {
		Solution<T> sol = new Solution<T>();
		
		State<T> currState = goalState;
		List<State<T>> states = sol.getStates();
		while (currState != null) {
			evaluatedNodes++;
			states.add(0, currState);
			currState = currState.getCameFrom();
		}

		return sol;
	}

}