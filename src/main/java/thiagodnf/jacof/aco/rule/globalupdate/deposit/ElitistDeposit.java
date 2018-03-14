package thiagodnf.jacof.aco.rule.globalupdate.deposit;

import static com.google.common.base.Preconditions.checkArgument;

import thiagodnf.jacof.aco.ACO;
import thiagodnf.jacof.aco.ant.Ant;
import thiagodnf.jacof.aco.subset.many.AllAnts;

public class ElitistDeposit extends PartialDeposit {

	protected int weight;

	public ElitistDeposit(ACO aco, int weight) {
		super(aco, 1.0, new AllAnts(aco));

		checkArgument(weight >= 0, "The weight should be greater or equal than 0");
		
		this.weight = weight;
	}
	
	/**
	 * Default Constructor for weight=the number of ants
	 * 
	 * @param aco The ant colony optimization used
	 */
	public ElitistDeposit(ACO aco) {
		this(aco, aco.getNumberOfAnts());
	}

	@Override
	public double getTheNewValue(int i, int j) {
		if(aco.isUseGlobalRepository()) {
//			return aco.getGraph().getTau(i, j) + rate * getDeltaTau(i, j) + aco.getGlobalBestRepository().getDeltaTau(i, j);

			System.out.printf("VALUE: %f %f %f %f\n", aco.getGraph().getTau(i, j), super.getDeltaTau(i, j), getDeltaTauGlobalBest(i, j), aco.getGlobalBestRepository().getDeltaTau(i, j));

			double value = aco.getGraph().getTau(i, j) + super.getDeltaTau(i, j) + weight * getDeltaTauGlobalBest(i, j) + aco.getGlobalBestRepository().getDeltaTau(i, j);
			return value;
		} else {
			return aco.getGraph().getTau(i, j) + super.getDeltaTau(i, j) + weight * getDeltaTauGlobalBest(i, j);
		}

	}
	
	public double getDeltaTauGlobalBest(int i, int j) {

		Ant globalBest = aco.getGlobalBest();
		
		if (globalBest.path[i][j] == 1) {
			return aco.getMultiobjectiveProblem().getDeltaTau(globalBest.getId() % 2, globalBest.getTourLength(), i, j);
		}

		return 0.0;
	}
	
	@Override
	public String toString() {
		return ElitistDeposit.class.getSimpleName() + " with weight=" + weight;
	}
}
