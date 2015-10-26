# Application Server Install

## Default behavior when installing AEM in an Application Server
* AEM came as a single war file to deploy
* If deployed the following will happen by default
	* run mode is *author*
	* the instance (Repository, Felix OSGI, bundles) is installed in ${user.dir}/crx-quickstart where ${user.dir} is the current working directory, this path to crx-quickstart is called sling.home
	* context root is the war file name

## Configuration
* Change the default behavior
	* run mode: configure sling.run.modes in WEB-INF/web.xml file of the war file before deployment
	* sling.home: configure sling.home in the WEB-INF/web.xml
	* context root: rename AEM war file