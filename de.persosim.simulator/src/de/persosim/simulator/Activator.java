package de.persosim.simulator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	static private BundleContext context;

	@Override
	public void start(BundleContext arg0) throws Exception {
		context = arg0;
		
//		PersoSim p = new PersoSim();
//		p.startSimulator();
		
	}

	@Override
	public void stop(BundleContext arg0) throws Exception {
		// TODO Auto-generated method stub

	}
	
	public static BundleContext getContext() {
		return context;
	}

}
