# Configuring OSGi
* You can manage the configuration settings by either
	* Adobe CQ Web console
		* standard interface for OSGi configuration. Has UI for editing various properties
		* Any configurations made with Web Console are applied immediately and applicable to the current instance, irrespective of the current run mode, or any subsequent changes to the run mode
	* content-nodes (sling:OsgiConfig) in the repository
		* requires manual configuration using CRXDE Lite
		* Can tie the configuration to a specific run mode
		* Any appropriate configurations are applied immediately
		
## OSGi Configuration with Web Console
* http://localhost:4502/system/console/configMgr

## OSGi Configuration in the Repository
* Creating **sling:OsgiConfig** nodes in the repository for the system to reference

### Adding a new Configuration to the Repository
* Need to know the following
	1. The **Persistent Identity (PID)** of the service. Reference the **Configurations** field in the Web console
	2. Whether a specific run mode is required. Create the folder
		* config - for all run modes
		* config.author - for author environment
		* config.publish - for publish environment
		* config.run-mode 
	3. Whether a **Configuration** or **Factory Configuration** is necessary
	4. Individual parameters to be configured
	5. Does a configuration already exists in libs?
	
## Configuration Details

### Resolution Order at Startup
1. Repository nodes under /apps/*/config... either with type sling:OsgiConfig or property files
2. Repository nodes with type sling:OsgiConfig under /libs/*/config...
3. Any .config files from crx-quickstart/launchpad/config... on the local file system

### Resolution Order at Runtime
1. Modifying a configuration in Web console take immediate effect
2. Modifying a configuration in /apps take immediate effect
3. Modifying a configuration in /libs take immediate effect, unless it is masked by a configuration in /apps

### Resolution of Multiple Run Modes
* Configurations will be applied if all run modes match a run mode defined at startup
* If multiple configurations for the same PID are applicable, the configuration with highest number of matching run modes is applied

## Configuration Persistence
* If you change a configuration through Web console
	* By default the configuration is written to /apps/system/config
	* If you editing a configuration which initially come from elsewhere, e.g /libs/foo/config/someconfig. The the updated configuration is written under the original location, e.g /apps/foo/config/someconfig
	
* Settings that are changed by **admin** ad saved in *.config files under: /crx-quickstart/launchpad/config
	* Never edit this folder directly