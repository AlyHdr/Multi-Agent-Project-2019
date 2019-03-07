// CArtAgO artifact code for project multi_agent_project_2019

package multi_agent_project_2019;

import cartago.*;

public class Community_1 extends Artifact {
	void init(int initialValue) {
		defineObsProperty("count", initialValue);
	}

	@OPERATION
	void inc() {
		ObsProperty prop = getObsProperty("count");
		prop.updateValue(prop.intValue()+1);
		signal("tick");
	}
}

