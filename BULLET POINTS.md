# Head First Android Development

## 1. Meet Android
* Get your Android development environment up and running!
* It's a good idea to add the SDK directory to your path (while you're in a configuration mindset) so you can easily run Android tools later from the command line
* Setup an emulator configuration for your target Android version. And don't limit yourself: feel free to setup a bunch of them!
* Create new Android projects using the "New Android Project" Wizard. From there, modify the generated app to make it your own
* Layouts are defined in XML and you can find them in `/res/layout`
* Values (like strings) are defined in Android Resource XML files. They can be found in `/res/values`
* When you open an Android XML file, you'll see a graphical editor to help you modify these files. If you want to view or edit the raw XML text, click on the right tab on the bottom of the editor
* You can go back and forth editing XML files in the graphical editor or text. Just remember to save your files when you use the graphical editor!

* Installation Check List
    * Install Eclipse
    * Install the Android SDK
    * Install the ADT Eclipse Plugin
    * Install the SDK packages
    * Configure the ADT
    * Build your Android app!
    
* Project Contents
    * Screen layouts and resources (defined in XML)
    * App behavior (defined in Java source code)
    * Binary assets (like images and fonts) included directly in the project
    * Configuration files (mostly XML)

## 2. Adding Behavior
* Use the graphical layout editor to make adding new View easy
* Add new String resources when you need them (and add them to Strings.xml)
* Use the `@string/` prefix in your XML layout to refer to String resources
* Explore the online documentation for all of the attributes you can set in your XML layouts
* If you know what you're looking for but don't know where to find it, use the documentation search
* Get references to Views on screen by calling `findViewById` and passing in that `View`'s ID constant from the R file
* Make sure your Views in your XML layout have android:id attributes set if you need to get references using `findViewById`
* Use the `android:onClick` property on `Button` to add an action method. That action method will be called on the Activity that launched the screen, so make so to add the method
* Remember all of the Java source is in the `/src` folder

* Making a Button Action
    * Use the Button onClick attribute to declare the name of the action method
    * Open the Activity that displays the layout with the Button
    * Add a method with a name matching the onClick attribute value
    * Make sure the method takes in a single View as a parameter

## 3. Work with feeds
* When working with RSS feeds, download a sample of the feed and decide what content in the feed you want to use in your app
* Start with `SAX` parsing, but explore the `DOM` and `XMLPULL` parsers to see if they will work better in your app
* It's a good practice to break your app down into small development pieces. For RSS feed apps that rely on the Internet, it's perfectly acceptable (and even a good idea) to build out your app with test data and plug in the Internet services later
* Add image resources to the `res/drawable-hdm` directory (for now). Thes will get picked up by the Android compiler and the images will be available to your application
* Use `ImageView` to display images in your app
* Use `ScrollView` when your app's content is too big for the screen. (Just remember that `ScrollView` can have only one child)
* When things go wrong, use `LogCat` to look at Android errors and log statements
* Make sure your app has the proper permissions configured in *AndroidManifest.xml*
* Use `HierarchyViewer` to debug your layouts when your apps isn't displaying correctly

* Built-in Problem Solvers
    * Use LogCat to view code log statements and errors from your apps
    * Use HierarchyViewer to analyze your views and layouts. This can be extremely helpful when layouts or views aren't behaving as you might expect them to
    
* View Roundup
    * Use TextView to display text. You can use it for small text like labels, or really big text like the Image descriptions
    * Use ImageView to display images. You can add your own images to the res directory and display them in an ImageView
    * Use ScrollView to make your content scroll on screen. ScrollView can have only one child View, so wrap multiple child views in a layout to make them all scroll

## 4. Long-running processes
* Use extended properties of `LinearLayout` to fine-tune your screens (`padding`, `margin`, `background`, `gravity`, and more)
* Define layout width and height using `fill_parent` and `wrap_content`. Use `fill_parent` to maximize the size to fill the parent. Use `warp_content` to make a View as big as its needs to be
* Use Density Independent Pixels (DIPs) when you need to define sizing or dimensions. This will ensure your layouts work on the most possible number of devices
* Layouts can nest (you can add layouts as Views to other layouts). Just remember that too much nesting will slow down the layout and rendering of your screens. So use nested layouts with caution.
* Use the **debugger** to trace code in the emulator or a device
* Use a `ProgressDialog` to block users and display progress
* Use `Toast` to passively notify users of progress
* Both `Toast` and `ProgressDialog` can be extensively customized for your app
* Keep expensive work off the UI thread, and UI work only on the UI thread
* Use `Handler` to add UI work to the UI thread's queue from non-UI threads

* The UI Thread
    * Keep expensive work off the UI threads, otherwise, the responsiveness of the UI will suffer
    * Make sure all UI work occurs only on the UI thread. Calling UI code from non-UI threads will throw exceptions throughout your code
    
* Give your users feedback
    * Toast: Use toast to passively display a message to your users
    * ProgressDialog: Use a ProgressDialog when you want to block user input and display a message and progress on the screen

## 5. Multiple-device support
* Create multiple AVDs for different screen sizes
* Change emulator orientation by pressing CTRL F12
* Create landscape layouts using the New Android XML file wizard and adding the landscape qualifier
* Create small, normal, and large screen layouts using the New Android XML file wizard and adding the landscape qualifier
* You can combine qualifiers and make layouts just for one size and orientation, like small and landscape
* Adjust the pixel density as you create new AVDs to test the correct resource loading
* Create custom resources for each pixel density you support
* You can edit AVDs after you create them to adjust screen size and pixel density. But it's still a good idea to have a few AVDs created with configurations for testing
* Replace icon.png with a custom icon for you app, noting the specific icon sizes for each pixel density

* Screen Size
    * small screens are at least 426dpx320dp
    * normal screens are at least 470dpx320dp
    * large screens are at least 640dpx480dp
    * xlarge screens are at least 960dpx720dp
    * **dp is density independent pixels**

* Pixel Density
    * ldpi is around 120dpi
    * mdpi is around 160dpi
    * hdpi is around 240dpi
    * xhdpi is around 320dpi
    * **dpi is dots per inch**

## 6. Optimizing for tables

## 7. Lists and Adapters

## 8. Multi-screen Apps

## 9. Database persistence

## 10. RelativeLayout

## 11. Tweaking your UI

## 12. Content Providers