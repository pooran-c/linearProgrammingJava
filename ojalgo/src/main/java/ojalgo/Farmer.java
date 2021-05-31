package ojalgo;

import org.ojalgo.OjAlgoUtils;
import org.ojalgo.netio.BasicLogger;
import org.ojalgo.optimisation.Expression;
import org.ojalgo.optimisation.ExpressionsBasedModel;
import org.ojalgo.optimisation.Optimisation;
import org.ojalgo.optimisation.Variable;

public class Farmer {
	
	public static void main(String[] args) {

		BasicLogger.debug();
		BasicLogger.debug(Farmer.class);
		BasicLogger.debug(OjAlgoUtils.getTitle());
		BasicLogger.debug(OjAlgoUtils.getDate());
		BasicLogger.debug();

		ExpressionsBasedModel model = new ExpressionsBasedModel();

		Variable X = model.addVariable("Area for Wheat").weight(50);
		Variable Y = model.addVariable("Area for barley").weight(120);

		Expression cost = model.addExpression("Cost")//
				.upper(10000)//
				.lower(0);
		cost.set(X, 100).set(Y, 200);

		Expression manDays = model.addExpression("ManDays")//
				.upper(1200)//
				.lower(0);
		manDays.set(X, 10).set(Y, 30);

		Expression totalArea = model.addExpression("TotalArea")//
				.upper(110)//
				.lower(0);
		totalArea.set(X, 1).set(Y, 1);

		Optimisation.Result result = model.maximise();

		// Print the result, and the model
		BasicLogger.debug();
		BasicLogger.debug(result);
		BasicLogger.debug();
		BasicLogger.debug(model);
		BasicLogger.debug();

	}

}
