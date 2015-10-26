# The Composite View Pattern
* Problem:
    * Web pages share similar structure
    * Same layout but different content
    * Always placed in the same position
* The **Composite View** pattern formalizes this typical use

# How the pattern works
* Template organizes the page according to the layout, putting each "piece" in the needed place

# The role of the View Helper
* Each piece of the composed page can have a *view helper*
* Allows the preparation of the data to be displayed in a consistent way

# Composite View vs Decorator
* Composite view - creating template and organizing the pieces together
* Decorator - takes a simple HTML page, transform it adding the missing pieces and render it