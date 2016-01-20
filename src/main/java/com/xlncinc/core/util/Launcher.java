/**
 * 
 */
package com.xlncinc.core.util;

import java.util.Date;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * @author PAmbure
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		Date launch = new Date();
		String port = "9999";
		int portNum = Integer.parseInt(port, 10);
		Server server = new Server(portNum);

		server.setAttribute("org.eclipse.jetty.webapp.configuration",
				new String[] { "org.eclipse.jetty.webapp.WebInfConfiguration",
						"org.eclipse.jetty.webapp.WebXmlConfiguration", "org.eclipse.jetty.webapp.MetaInfConfiguration",
						"org.eclipse.jetty.webapp.FragmentConfiguration",
						"org.eclipse.jetty.plus.webapp.EnvConfiguration",
						"org.eclipse.jetty.webapp.JettyWebXmlConfiguration",
						"org.eclipse.jetty.annotations.AnnotationConfiguration" });
		WebAppContext context = new WebAppContext();

		// Important: To make sure Jetty scans all classes under ./classes to
		// look for annotations.
		context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern", ".*/classes/.*");

		context.setDescriptor(
				Thread.currentThread().getContextClassLoader().getResource("WEB-INF/web.xml").toExternalForm());
		context.setResourceBase("src/main/webapp");
		context.setContextPath("/");
		server.setHandler(context);

		server.start();
		Long timeToReadyInSecs = (new Date().getTime() - launch.getTime()) / 1000;
		System.err.printf("Ready!....Time Taken: %d secs or %d:%d\n", timeToReadyInSecs, timeToReadyInSecs / 60,
				timeToReadyInSecs % 60);
		server.join();
	}

}
