# Fundamental Components

## View
* User interface (UI) elements that form the basic building blocks of a user interface
* A view can be a button, a label, a text field, or many other UI elements
* Everything you see is a view

## Activity
* UI concept that usually represents a single screen in your application
* Contains one or more views, but doesn't have to
* Helps user to do one thing, could be viewing data, creating data, or editing data

## Fragment
* Sub-activities, and an activity can display one or more fragments on the screen at the same time

## Intent
* Defines an "intention" to do some work
* Encapsulate several concepts, you can use intents to perform the following tasks
    * Broadcast a message
    * Start a service
    * Launch an activity
    * Display a web page or a list of contacts
    * Dial a phone number or answer a phone call
* Intents loosely couple the action and action handler

## Content Provider
* Data sharing among mobile applications on the device is common
* Through content provides, you can expose your data and have your applications use data from other applications

## Service
* Background processes that can potentially run for a long time
* Defines two types of services: local services and remote services

## AndroidManifest.xml
* Similar to the web.xml file in the J2EE world, defines the contents and behavior of your application
* Example, it lists your application's activities and services, along with the permissions and features the application needs to run

## Android Virtual Devices
* AVD allows developers to test their application without hooking up an actual Android device

## Running on a Real Device

## Exploring the Structure of an Android Application
