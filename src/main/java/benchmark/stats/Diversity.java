package benchmark.stats;

import benchmark.visualization.chart.LineChart;
import thiagodnf.jacof.aco.ACO;

public class Diversity {

    private ACO aco;
    private LineChart lineChart;
    private long iteration;

    private double pheromoneRatio;

    public Diversity(ACO aco) {
        this.aco = aco;
        this.lineChart = new LineChart("Chart");
        this.iteration = 0;
        lineChart.display();
    }

    public void update() {
        updatePheremoneRatio();
        updateAtractivnessDispersion();
        updateAttracivnessRatio();
    }

    private void updatePheremoneRatio() {
        iteration++;
        long countEdgesWithPheromone = 0;
        long countAllEdges = 0;
        double[][] edges = aco.getGraph().getTau();
//        double initalPheromoneValue = aco.getGraphInitialization().getT0();
        double initalPheromoneValue = getAverageThresold();
        int x;
        int y;
        double[] currentRow;

        for(x = 0; x < edges.length; x++) {
            currentRow = edges[x];
            for(y = x + 1; y < currentRow.length; y++) {
                countAllEdges++;
                if(currentRow[y] >= initalPheromoneValue) countEdgesWithPheromone++;
            }
        }

        pheromoneRatio = ((double)countEdgesWithPheromone/countAllEdges)*100;
        lineChart.update(pheromoneRatio);
    }

    private double getAverageThresold() {
        double[][] edges = aco.getGraph().getTau();
        int x;
        int y;
        double[] currentRow;
        double everyEdgePheromoneSum = 0;
        int countAllEdges = 0;
        for(x = 0; x < edges.length; x++) {
            currentRow = edges[x];
            for(y = x + 1; y < currentRow.length; y++) {
                countAllEdges++;
                everyEdgePheromoneSum += currentRow[y];
            }
        }

        return everyEdgePheromoneSum / countAllEdges;
    }


    private void updateAtractivnessDispersion() {
    }


    private void updateAttracivnessRatio() {
    }

    public double getPheromoneRatio() {
        return pheromoneRatio;
    }

    public void setPheromoneRatio(double pheromoneRatio) {
        this.pheromoneRatio = pheromoneRatio;
    }
}
