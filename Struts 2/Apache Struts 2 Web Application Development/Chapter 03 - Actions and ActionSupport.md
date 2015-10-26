# Chapter 03 - Actions and ActionSupport

# 1. ActionSupport and its interfaces
* *ActionSupport* is an XWork class that provides default implementations of validation and I18N interfaces
* It's not required for our actions to subclass *ActionSupport*, but it's handy
* *ActionSupport* implements the following six interfaces:
	* Action
	* Validateable
	* ValidationAware
	* TextProvider
	* LocaleProvider
	* Serializable

## 1.1 The Action interfaces
* The *Action* interface defines a single method:
	* public String execute();
* One benefit of implementing *Action* is that reflection isn't required to check for the *execute()* method

## 1.2 Action's convenience strings
* *ActionSupport*, via the *Action* interface, exposes several typical result name strings

## 1.3 The TextProvider interface
* I18N supports is provided by the *TextProvider* implementation along with the *LocaleProvider*
	