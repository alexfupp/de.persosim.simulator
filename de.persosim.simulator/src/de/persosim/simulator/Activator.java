package de.persosim.simulator;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
	
	private static BundleContext context;
	
	public static BundleContext getContext() {
		return context;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		Activator.context = context;
		context.registerService(Simulator.class.getName(), new PersoSim(), new Hashtable<String, String>());
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		context = null;
	}
	
}
