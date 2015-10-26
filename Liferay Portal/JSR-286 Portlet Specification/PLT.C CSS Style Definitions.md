# PLT.C CSS Style Definitions
* To achieve a common look and feel throughout the Portal page, all Portlets in the Portal page should use a common CSS style sheet when generating content

## PLT.C.1 Links (Anchor)
* A custom CSS class is not defined for *a* tag. The entity should use the default classes when embedding anchor tags

## PLT.C.2 Fonts
* *portlet-font* - font attributes for the *normal* fragment font
* *portlet-font-dim* - font attributes similar to the *portlet-font* but the color is lighter

## PLT.C.3 Messages
* Message style definitions affect the rendering of a paragraph (alignment, borders, background color, etc) as well as text attributes
* *portlet-msg-status* - status of current operation
* *portlet-msg-info* - help messages, general additional information, etc..
* *portlet-msg-error* - Error messages
* *portlet-msg-alert* - Warning messages
* *portlet-msg-success* - verification of the successful completion of a task

## PLT.C.4 Sections
* Section style definition affect the rendering of markup sections such as table, div and span (alignment, borders, background color) as well as their text attributes:
* *portlet-section-header* - table or section header
* *portlet-section-body* - normal text in a table cell
* *portlet-section-alternate* - test in every other row in the cell
* *portlet-section-selected* - text in the selected cell range
* *portlet-section-subheader* - text of a subheading
* *portlet-section-footer* - table or section footnote
* *portlet-section-text* - text that belongs to the table but does not fall in one of the other categories

## PLT.C.5 Tables
* Table style definition affect the rendering as well as their text attributes
* *portlet-table-header*
* *portlet-table-body*
* *portlet-table-alternate*
* *portlet-table-selected*
* *portlet-table-subheader*
* *portlet-table-footer*
* *portlet-table-text*

## PLT.C.6 Forms
* Form style define the look-and-feel of the element in an HTML form
* *portlet-form-label* - text used for descriptive label of the whole form
* *portlet-form-input-field* - text of the user-input in an input field
* *portlet-form-button* - text on a button
* *portlet-icon-label* - text that appears beside a context dependent action icon
* *portlet-dlg-icon-label* - text appears beside a *standard* icon (e.g OK, or Cancel)
* *portlet-form-field-label
* *portlet-form-field*

## PLT.C.7 Menus
* Menu styles define the look-and-feel of the text and background of a menu structure
* *portlet-menu* - general menu settings such as background color, margins, etc
* *portlet-menu-item* - normal, unselected menu item
* *portlet-menu-item-selected*
* *portlet-menu-item-hover* 
* *portlet-menu-item-hover-selected*
* *portlet-menu-cascade* - general sub-menu setting
* *portlet-menu-cascade-item* - unselected menu item that has sub-menus 
* *portlet-menu-cascade-item-selected* 
* *portlet-menu-cascade-item-hover* 
* *portlet-menu-cascade-item-hover-selected* 
* *portlet-menu-separator* - separator between menu items
* *portlet-menu-cascade-separator* - separator between sub-menu items
* *portlet-menu-content* - content for a normal, unselected menu or sub-menu item
* *portlet-menu-indicator*
