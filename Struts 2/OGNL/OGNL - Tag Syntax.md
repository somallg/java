# Tag Syntax
* The tags are designed to display dynamic data. The create a input field that displays the property *portalCode*, we'd pass the String *postalCode* to the textfield tag
* s:textfield name="postalCode"
* If there is a *postalCode* property on the value stack, its value will be set to the input field. When the field is submitted back to the framework, the value of the control will be set back to the *postalCode* property

# 1. Non-String Attributes
* To make using non-String attributes intuitative, the framework evaluates **all** non-String attributes as an expression

# 2. value in an Object!
