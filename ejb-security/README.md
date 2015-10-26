# ejb-security: Using Java EE Declarative Security to Control Access to EJB 3
==================

# What is it?
* This example demonstrates the use of Java EE declarative security to control access to Servlets and EJBs in Red Hat JBoss Enterprise Application Platform.

This quickstart takes the following steps to implement EJB security:

1. Define the security domain. This can be done either in the `security` subsytem of the `standalone.xml` configuration file or in the `WEB-INF/jboss-web.xml` configuration file. This quickstart uses the `other` security domain which is provided by default in the `standalone.xml` file:

        <security-domain name="other" cache-type="default">
            <authentication>
                <login-module code="Remoting" flag="optional">
                    <module-option name="password-stacking" value="useFirstPass"/>
                </login-module>
                <login-module code="RealmDirect" flag="required">
                    <module-option name="password-stacking" value="useFirstPass"/>
                </login-module>
            </authentication>
        </security-domain>

2. Add the `@SecurityDomain("other")` security annotation to the EJB declaration to tell the EJB container to apply authorization to this EJB.
3. Add the `@RolesAllowed({ "guest" })` annotation to the EJB declaration to authorize access only to users with `guest` role access rights.
4. Add the `@RolesAllowed({ "guest" })` annotation to the Servlet declaration to authorize access only to users with `guest` role access rights.
5. Add a `<login-config>` security constraint to the `WEB-INF/web.xml` file to force the login prompt.
6. Add an application user with `guest` role access rights to the EJB. This quickstart defines a user `quickstartUser` with password `quickstartPwd1!` in the `guest` role. The `guest` role matches the allowed user role defined in the `@RolesAllowed` annotation in the EJB.
7. Add a second user that has no `guest` role access rights.
