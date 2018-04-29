package thiagodnf.jacof.aco.ant.exploration.anttypebased;

import thiagodnf.jacof.aco.ACO;
import thiagodnf.jacof.aco.ant.Ant;
import thiagodnf.jacof.aco.ant.exploration.AbstractAntExploration;
import thiagodnf.jacof.aco.ant.exploration.QSelection;
import thiagodnf.jacof.aco.ant.selection.AbstractAntSelection;
import thiagodnf.jacof.aco.ant.selection.RandomSelection;
import thiagodnf.jacof.aco.ant.selection.RouletteWheel;
import thiagodnf.jacof.aco.graph.AntType;

import java.util.HashMap;
import java.util.Map;

public class AntTypeBasedExploration extends AbstractAntExploration {

    private Map<AntType, AbstractAntExploration> antExplorationMap = new HashMap<>();

    public AntTypeBasedExploration(ACO aco) {
        super(aco);
    }

    public AntTypeBasedExploration addRule(AntType antType, AbstractAntExploration abstractAntExploration) {
        antExplorationMap.put(antType, abstractAntExploration);
        return this;
    }

    @Override
    public int getNextNode(Ant ant, int currentNode) {
        AntType antType = ant.getAntType();
        return antExplorationMap.get(antType).getNextNode(ant, currentNode);
    }

    @Override
    public double getNodeAttractiveness(int i, int j) {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}