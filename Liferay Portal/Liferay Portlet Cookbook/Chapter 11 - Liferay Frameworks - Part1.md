# Chapter 11 - Liferay Frameworks - Part 1
* This Chapter Covers:
    * Security and Permissions
    * Portlet Permission
    * More Security Layers and Custom Utility
    * Model Permissions
    * Liferay Asset Framework
    * Attaching Tags and Categories
    * Publishing Assets through Asset Publisher
    * Asset Publisher for Books, Final Touches

## 11.1 Security and Permissions
* JSR-286 (Portlet 2.0) spec defines a simple security scheme using portlet roles and their mapping to portal roles

### 11.1.1 Overview of Portlet 2.0 Security
* The default roles are *administrator*, *guest*, *user* and *power-user*
* For these four rules defined in *portlet.xml* there is a set of corresponding entries in *liferay-portlet.xml*
* In your Portlet code, you can then use methods as defined in Portlet spec, for checking the permission

### 11.1.2 Overview of Liferay's Permission System
* Resource: a generic term for any object represented in the portal
* Permission: action on a resource
* Action
* Permission in Liferay can be achieved at six levels:
    * Server level
    * Portal level
    * Page level
    * Portlet level
    * Action level
    * Data level

### 11.1.3 Liferay's Permissioning Algorithm

## 11.2 Portlet Permissions

### 11.2.1 Understanding the backend tables

### 11.2.2 BitWise permissioning unleashed

### 11.2.3 Adding New Portlet Permissions
* Adding permissions to any Portlet consists of four main steps, also known as DRAC:
* Define al resources and their permissions (XML file)
* Register all the resources, *adding resources*
* Associate the necessary permissions with resources
* Check permission before returning resource

## 11.3 More Security Layers and Custom Utility

### 11.3.1 Level-2 Security for Protecting Resources
* A Portlet level
* Override the *doView* or *render* to check for permission before process

### 11.3.2 Level-3 Security Protection for Local/Remote API's
* At Service level
* Check permission before performing a data operation or calling a localService API
* In **EntityServiceImpl** a method is already available for getting an instance of permissionChecker object - *getPermissionChecker()*
* In **EntityLocalServiceImpl**, this method is not available and we have to reply on the *serviceContext*

### 11.3.3 Writing a Custom Permission Class

## 11.4 Model Permissions

### 11.4.1 Defining and Registering Model Permissions
* Same four steps of Define, Register, Associate and Check (DRAC)

### 11.4.2 Setting permissions While Adding Book

### 11.4.3 UI to Control Permissions of Every Book in List

### 11.4.4 Showing Only those Books with VIEW Permission

## 11.5 Liferay Asset Framework
* Asset is used as a generic way to refer to any type of content regardless of whether it's purely text, an external file,a URL, an image, a record

### 11.5.1 Library Book as an Asset

### 11.5.2 Resources vs Assets

