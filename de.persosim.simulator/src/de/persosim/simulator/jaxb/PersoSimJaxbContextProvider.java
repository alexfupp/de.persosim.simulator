package de.persosim.simulator.jaxb;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlRootElement;

import org.osgi.framework.wiring.BundleWiring;

import de.persosim.simulator.Activator;

/**
 * This class provides a singleton {@link JAXBContext} that is initialized to be
 * used with all de.persosim classes known to the current classloader.
 * <p/>
 * Note: as the provided JAXBContext is not Thread-safe neither this singleton
 * implementation is nor needs to be.
 * 
 * @author amay
 * 
 */
public class PersoSimJaxbContextProvider {
	// create/cache JAXBContext

	private static JAXBContext context;

	public static JAXBContext getContext() throws JAXBException {
		if (context == null) {
			context = JAXBContext.newInstance(getJaxbClasses().toArray(
					new Class<?>[] {}));
		}
		return context;
	}

	/**
	 * Returns a collection containing all classes that are JAXB annotated.
	 * 
	 * @return a collection containing all classes that are JAXB annotated
	 */
	public static Collection<Class<?>> getJaxbClasses() {
		Collection<Class<?>> allClasses = getAllPersoSimClassFromBundle();
		return getJaxbAnnotatedClasses(allClasses);
	}

	/**
	 * Returns a Collection of all PersoSim classes.
	 * <p/>
	 * The implementation extracts loadable classes from the bundle class loader
	 * and tries to return according Class objects.
	 * 
	 * @return
	 * @throws IOException
	 */
	private static Collection<Class<?>> getAllPersoSimClassFromBundle() {

		Collection<Class<?>> persoSimClasses = new ArrayList<>();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		BundleWiring wiring = Activator.getContext().getBundle().adapt(BundleWiring.class);
		Collection<String> resources = wiring.listResources("/de/persosim", "*.class", BundleWiring.LISTRESOURCES_RECURSE);

		for (String resource : resources) {
			try {
				persoSimClasses.add(classLoader.loadClass(resource.replaceAll("/", ".").replaceAll("\\.class", "")));
			} catch (ClassNotFoundException e) {
				// ignore classes that can't be found
			}
		}	
		
		return persoSimClasses;
	}

	/**
	 * Filters the provided Collection of classes and returns a new Collection
	 * containing only those classes that are usable by JAXB (according to its
	 * Annotations).
	 * 
	 * @param allClasses
	 *            Collection of classes to be searched
	 * @return Collection containing the subset of classes from allClasses that
	 *         contain JAXB Annotations
	 */
	private static Collection<Class<?>> getJaxbAnnotatedClasses(
			Collection<Class<?>> allClasses) {
		ArrayList<Class<?>> annotatedClasses = new ArrayList<>();
		for (Class<?> curClass : allClasses) {
			for (Annotation curAnnotation : curClass.getAnnotations()) {
				if (curAnnotation.annotationType() == XmlRootElement.class) {
					annotatedClasses.add(curClass);
					System.out.println("annotatedClasses.add("+curClass.getName()+".class);");
					break;
				}
			}
		}
		
		return annotatedClasses;
	}
}