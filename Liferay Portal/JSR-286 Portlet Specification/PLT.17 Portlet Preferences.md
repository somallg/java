# PLT.17 Portlet Preferences
* Portlets are commonly configured to provide a customized view or behavior for different users
* This configuration is represented as a persistent set of name-value pairs and it is referred to as portlet preferences
* The Portlet container is responsible for the details of retrieving and storing these preferences
* Portlet preferences are intended to store basic configuration data for portlets
* It is not the purpose of the Portlet preferences to replace general purpose databases

## PLT.17.1 PortletPreferences Interface
* Portlets have access to their preferences attributes through the *PortletPreferences* interface
* Portlet have access to the associated *PortletPreferences* object while they are processing requests
* Portlet may only *modify* preferences attributes during *processAction*, *processEvent*, or *serveResource* invocation
* Preference attributes are *String* array objects. Preferences attributes can be set to *null*
* To access and manipulate preference attributes, the *PortletPreferences* interface provides the following methods:
    * getNames
    * getValue (returns first value)
    * setValue
    * getValues
    * setValues
    * getMap (returns an immutable *Map* of *String* keys and *String[]* values containing all current preference values. Preferences values must not be modified if the values in the *Map* are altered)
    * isReadOnly
    * reset (reset a preference attribute to its default value. If there is no default value, the preference attribute must be deleted)
    * store (must persist all the changes made to the *PortletPreferences* object in the persistent mode)
* If a preference attribute is read only, the *setValue* and *reset* methods must throw a *ReadOnlyException* when the Portlet is in any of the standard modes
* All changes made to *PortletPreferences* object not followed by a call to the *store* method must be discarded when the Portlet finishes the *processAction*, *processEvent*, or *serveResource* method
* If the *store* method is invoked within the scope of a *render* method invocation, it must throw an *IllegalStateException*
* *PortletPreferences* object must reflect the current values of the persistent store when the Portlet container invokes the *processAction*, *processEvent*, *render* and *serveResource* methods of the Portlet

## PLT.17.2 Preference Attributes Scopes
* Portlet Specification assumes preference attributes are user specific, it does not make any provision at API level or at semantic level for sharing preferences attributes among users, but enables sharing of preferences and different levels or Portlet entities
* If a Portal/Portlet-container implementation provides an extension mechanism for sharing preference attributes, it should be well documented how the sharing of preference attributes works
* Sharing preference attributes may have significant impact on the behavior of a Portlet
* In many circumstances it could be inappropriate sharing attributes that are meant to be private or confidential to the user

## PLT.17.3 Preference Attributes definition
* Portlet definition may define the preference attributes a Portlet uses
* A Preference attribute definition may include initial default values, and may also indicate if the attribute is read only
* Portlets are not restricted to use preference attributes defined in the deployment descriptor
* They can programmatically add preference attributes using names not defined in the deployment descriptor
* These preferences attributes must be treated as modifiable attributes
* Portal administration and configuration tools may use and change, default preference attributes when creating a new Portlet preferences objects
* In addition, Portal may further constrain the modifiability of preferences values

### PLT.17.3.1 Localizing Preference Attributes
* Portlet Specification does not define a specific mechanism for localizing preference attributes
* It leverages the J2SE ResourceBundle classes
* To enable localization support of preference attributes for administration and configuration tools, developers should adhere to the following naming convention for entries in the Portlet's *ResourceBundle*:
    * Entries for preference attribute descriptions should be constructed as *javax.portlet.preference.description.attribute-name
    * Entries for preference attribute names should be constructed as *javax.portlet.preference.name.attribute-name*
    * Entries for preference attribute values that require localization should be constructed as *javax.portlet.preference.value.attribute-name.attribute-value

## PLT.17.4 Validating Preference values
* A class implementation the *PreferencesValidator* interface can be associated with the preferences definition in the deployment descriptor using the *preferences-validator* element
* *PreferencesValidator* implementation must be coded in a thread safe manner as the Portlet container may invoke concurrently from several request
* When a validator is associated with the Preferences of a Portlet definition, the *store* method of the *PortletPreferences* implementation must invoke the *validate* method of the validator before writing the changes to the persistent store
* If the validation fails, the *PreferencesValidator* implementation must throw a *ValidatorException*, the Portlet container must cancel the store operation and it must propagate the exception to the Portlet
* If the validation is successful, the store operation must be completed
* Portlet preferences should not be modified when they are being validated by a *PreferencesValidator* object
* When creating a *ValidatorException*, Portlet developers may include the set of preference attributes that caused the validator to fail
* It is left to the developers to indicate the first preference attribute that failed or the name of all invalid preference attributes
