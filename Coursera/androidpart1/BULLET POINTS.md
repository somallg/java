# Programming Mobile Applications for Android Handheld Systems: Part 1

# 4. User Interface Classes
* Activities usually display a user interface
* Android provides many classes for constructing user interfaces

## 4.1 Views & View Events
* Key building block for UI components
* Occupy a rectangular space on screen
* Responsible for drawing themselves and handling events

* Some predefined Views
    * Button - View than can be clicked on to perform an Action
    * ToggleButton - A 2-State Button, checked/not checked state, light indicator showing state
    * CheckBox - Another kind of 2-state Button, checked/not checked
    * RatingBar - A view comprising a row of Stars, user can click or drag the stars to highlight some numbers of them
    * AutoCompleteTextView - An editable text field that provides completion suggestions as the user types in text
    
* Common View Operations
    * Set Visibility: show or hide view
    * Set Checked State
    * Set Listeners: code that should be executed when specific events occur
    * Set Properties: Opacity, Background, Rotation
    * Manage input focus: allow View to take focus, request focus
    
* View Event Sources
    * User Interaction
        * Touch
        * Keyboard/TrackBall/D-Pad
    * System Control
        * Lifecycle changes
        
* Handling View Events
    * Often handle events with listeners
    * Numerous Listener Interfaces defined by the View class
    
* View Listener Interfaces
    * OnClickListener: onClick()
        * View has been Clicked
    * OnLongClickListener: onLongClick()
        * View has been pressed and held
    * OnFocusChangeListener: onFocusChange()
        * View has received or lost focus
    * OnKeyListener: onKey()
        * View about to receive a hardware key press
        
* Displaying Views
    * Views are organized in a Tree
    * Displaying has multiple steps
        * Measure - Get dimensions of each View
        * Layout - Position each View
        * Draw - Draw each View
    * Custom View SubClasses can override various View methods
    * Handling View Events
        * onMeasure() - Determine the size of this View and its children
        * onLayout() - View must assign a size and position to all its children
        * onDraw() - View should render its content
        * onFocusChanged() - View's focus state has changed
        * onKeyUp(), onKeyDown() - a hardware key event has occurred
        * onWindowVisibilityChanged() - Window containing View has changed its visibility status

## 4.2 View Groups, AdapterViews and Layouts
* An Invisible View that contains other view
* Used for grouping & organizing a set of Views
* Base Class for View containers & Layouts

* Some Predifined ViewGroups
	* RadioGroup
		* A ViewGroup containing a set of Radio Buttons (CheckBoxes)
		* Only one Button can be selected at one instant
	* TimePicker
		* A ViewGroup that allows the user to select a time
	* DatePicker
		*  A ViewGroup that allows the user to select a date
	* WebView
		* A ViewGroup that displays a web page
	* MapView
		* A ViewGroup that displays a Map
	* Gallery
	* Spinner
	
* Adapters & AdapterViews
	* AdapterViews are Views whose children and data are managed by an Adapter
	* Adapter manages the data and provides data views to AdapterView
	* AdapterView displays the data Views

* ListView
	* AdapterView displaying a scrollable list of selectable items
	* Items managed by a ListAdapter
	* ListView can filter the list of items based on text input
	
* Spinner
	* An AdapterView that provides a scrollable list of items
	* User can select one item from the list
	* Items managed by a SpinnerAdapter

* Gallery
    * A ViewGroup showing a horizontally scrolling list
    * Items managed by a SpinnerAdapter

## 4.3 Menus & ActionBar

## 4.4 Dialogs

