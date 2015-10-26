# Working With Struts 2 Actions
* In Struts 2, you'll spend most of your time working with actions. The action class contains business logic, retrieve resource bundle, hold the data, validation, and select the view result page that should send back to the user

## 1. Action
* Struts 2 actions don't force you to implement any interface or extends class, it's only required you to implement an **execute()** method that returns a string to indicate which result page should return

* In the **struts.xml**, configure the action class the the **action tag* and **class attribute**
* Define which result page should return to the user with **result tag** and the name of the action you can use to access this action class with **name attribute**

## 2. Optional Action interface
* Struts 2 comes with an optional action interface (**com.opensymphony.xwork2.Action**). By implements this interface, it bring more convenient benefits

## 3. ActionSupport
* Support class, a common practice to provide default implementation of interfaces
* The ActionSupport (**com.opensymphony.xwork2.ActionSupport**), a very powerful and convenience class that provides default implementation of few of the importan interfaces
* The **ActionSupport** class give you the ability to do:
	* **Validation** - declared a validate() method and put the validation code inside
	* **Text localization** - use GetText() method to get the message from resource bundle