# Chapter 02 - The Plugins SDK 

## Installing the DSK 
* Download and Unzip

## Ant Configuration
* Setup ANT_HOME

## Plugins SDK Configuration
* Create build.[username].properties
* app.server.dir = [full path to Tomcat server]

## Structure of the SDK
* Each folder in the Plugin SDK contains scripts for creating new plugins of that type
* liferay-plugins-version/ - Plugins SDK root directory
    * clients/ - client applications directory
    * dist/ - archived plugins for distribution and deployment
    * ext/ - Ext plugins directory
    * hooks/ - hook plugins directory
    * layouttpl/ - layout templates directory
    * lib/ - commonly referenced libraries
    * misc/ - development configuration files
    * portlets/ - portlet plugins directory
    * themes/ - themes plugins directory
    * tools/ - plugin templates and utilities
    * webs/ - web plugins directory
    * build.properties - default SDK properties
    * build.[username].properties - override SDK properties
    * build.xml - contains targets to invoke in the SDK
    * build-common.xml - contains common targets and properties referenced throughout the SDK
    * build-common-plugin.xml - contains common targets and properties referenced by each plugin
    * build-common-plugins.xml - contains common targets and properties referenced by each plugin type
* There's an Ant build file (build.xml) in each of the plugins directories:
    * build-service - builds the service layer for a plugin, using Liferay Service Builder
    * clean - cleans the residual files created by the invocations of the compilation, archiving, and deployment targets
    * compile - compiles the plugin source code
    * deploy - builds and deploys the plugin to your application server
    * format-source - formats the source code per Liferay's source code guidelines
    * format-javadoc - formats the Javadoc per Liferay's Javadoc guidelines

## Best Practices

## Summary
