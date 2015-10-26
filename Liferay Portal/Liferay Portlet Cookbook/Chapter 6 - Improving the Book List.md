# Chapter 6 - Improving the Book List
* This Chapter Covers:
    * HTML table to Search Container
    * Referring to Portal's TLDs and JARs
    * Adding link to delete book
    * Adding "Actions" on a book
    * Editing a book
    * Viewing book details
    * Showing details as a popup
    * Sortable Columns
    * Performing an action on a set of items

## 6.1 HTML table to Search Container
* Liferay provides a very good UI alternative for displaying a grid in our Portlet

### 6.1.1 The "search-container" tags
* search-container: this is the main container, instantiating the "searchContainer" object
* search-container-results: has two main attributes
    * total: total number of items in your list
    * results: this is where you input the results, "results" should be of type List
* search-container-row: represents one row of the list. It has three main attributes:
    * className: the type of Object in your List
    * keyProperty: primary Key of the record (optional)
    * modelVar: the name of the variable to represent your model
* search-container-column-text: the item that represents a column in the row. This is equivalent to HTML td tag of tr:
    * name
    * value
    * href
    * orderable
    * title
    * property: the attribute of the modelVar this column should render
* search-iterator: this is what actually iterates through and displays the List

### 6.1.2 Fixing the Pagination issue
* Insert attribute for "search-container", iteratorURL

## 6.2 Referring to Portal's TLDs and JARs
* Check folder **webapps** of our tomcat installation
* The main context, "ROOT" where Liferay Portal is running has got so many third party jars and taglib definitions (**tld**)

### 6.2.1 Other benefits of "liferay-plugin-package.properties"
* Contains many packaging information about the plugin

## 6.3 Adding link to delete book
* Create new deleteBookURL 
* deleteBookURL.setParameter to ACTION_DELETE

## 6.4 Adding "Actions" on a Book
* Create ActionURL
* Add liferay-ui:icon-menu

## 6.5 Editing a book
* Set editBookURL.setParameter("bookId")
* Set editBookURL.setParameter("jspPage")

### 6.5.1 Modifying the book information
* Send bookId (hidden) in input form
* In Portlet, get book from bookId => modify

### 6.5.2 Redirect to another page after update
* URL.setParameter("jspPage", ...)
* actionResponse.sendRedirect(URL)

### 6.5.3 Moving "modifyBook" to LocalServiceImpl Class
* Move modifyBook to LocalServiceImpl
* Use LocalServiceImplUtil to access modifyBook

### 6.5.4 Introducing a new audit field - "modifiedDate"
* Add column in "service.xml"

## 6.6 Viewing book details
* Add detail.jsp page
* Add href in bookTitle
* Create bookDetailsURL
* Set bookDetailsURL jspPage to detail.jsp

### 6.6.1 Back URL to list view
* set themeDisplay.getURLCurrent to backURL
* set link backURL in detail.jsp

### 6.6.2 Objects injected by "liferay-theme" tag
* Default Available:
    * application
    * config
    * out
    * page
    * pageContext
    * request
    * response
    * session
* Injected by portlet:defineObjects:
    * actionRequest
    * actionResponse
    * eventRequest
    * eventResponse
    * liferayPortletRequest
    * liferayPortletResponse
    * portletConfig
    * portletName
    * portletPreferences
    * portletPreferencesValues
    * portletSession
    * portletSessionScope
    * renderRequest
    * renderResponse
    * resourceRequest
    * resourceResponse
* Injected by liferay-theme:defineObjects:
    * account
    * colorScheme
    * company
    * contact
    * layout
    * layouts
    * layoutTypePortlet
    * locale
    * permissionChecker
    * plid
    * portletDisplay
    * portletGroupId
    * realUser
    * scopeGroupId
    * theme
    * themeDisplay
    * timeZone
    * user

## 6.7 Showing details as a popup
* Popups play a very important role in building Rich Internet Applications (RIA) based on the concepts of Web 3.0 and Single Page Application (SPA)

### 6.7.1 Implementing the popup
* Liferay has two types of popups: Window popup and Floating Div popup
* Window popup:
    * Add JS popup

### 6.7.2 Removing header from popup
* setParameter("showHeader") to false     

## 6.8 Sortable Columns
* orderable="true" orderableProperty="abc" 
* orderByCol and orderByType
* Set orderByCol and orderByType
* Add **commons-beanutils.jar** and **commons-collections.jar**
* Add BeanComparator and Collections.sort
* Add **orderByCol** and **orderByType** in liferay-ui:search-container

## 6.9 Performing an action on a set of items
* add *rowChecker* in liferay-ui:search-container
