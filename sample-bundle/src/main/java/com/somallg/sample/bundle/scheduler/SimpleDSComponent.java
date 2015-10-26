package com.somallg.sample.bundle.scheduler;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A simple DS component which is executed every 10 seconds
 *
 * @see <a href="https://sling.apache.org/documentation/bundles/scheduler-service-commons-scheduler.html">Scheduler Service</a>
 */
@Component
@Service
//@Property(name = "scheduler.period", longValue = 10)
public class SimpleDSComponent implements Runnable {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private BundleContext bundleContext;

	public void run() {
		logger.info("Running...");
	}

	protected void activate(ComponentContext ctx) {
		this.bundleContext = ctx.getBundleContext();
	}

	protected void deactivate(ComponentContext ctx) {
		this.bundleContext = null;
	}
}
