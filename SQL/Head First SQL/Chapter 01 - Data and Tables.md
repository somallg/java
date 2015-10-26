# Chapter 01 - Data and Tables
* A **database** is a container that holds tables and other SQL structures related to those tables

* The information inside the database is organized into **tables**
* A database contains tables
* A table is the structure inside your database that contains data, organized in **columns* and **rows**

* A **column** is a piece of data stored by your table. A **row** is a single set of columns that describe attributes of a single thing. Columns and rows together make up table
* Often **field** used instead of **column**. Also, **row** and **record** are often used interchangeably

* Capitalization and underscores help you program in SQL (even though SQL doesn't need them!)

# Bullet Points
* Break your data up in categories before you create your table. Pay special attention to the type of data for each column
* Use the **CREATE DATABASE** statement to create the database which will hold all of your tables
* Use the **USE DATABASE** statement to get inside your database to create your table
* All tables are created with a **CREATE TABLE** statement, containing column names and their corresponding data types
* Some of the most common datatypes are **CHAR**, **VARCHAR**, **BLOB**, **INT**, **DEC**, **DATE**, and **DATETIME**. Each has different rules for what goes inside

* **DROP TABLE** deletes your table and any data in it!

* To add data to your table, you'll use the INSERT statement. The values in the second set of parentheses have to be in the *same order as the column names*

* Variations on an INSERT statement
    * Changing the order of columns. So long as the values match the column names, the order you INSERT them in doesn't matter to you, or your SQL RDMBS
    * Omitting column names. You must include **All the values**, and in **the Exact Order** that they are in the table
    * Leaving some columns out. You need to tell it by specifying the column names and values that you are entering

* NULL value - A value can be NULL, but it never **equals** NULL because NULL is an undefined value

# Controlling your inner NULL
* Just add the words NOT NULL right after the data type
* If you use these, you *must* provide a value for the column in your INSERT statement. If you don't, you'll get an error
* If you have a column that you know will need to be filled in later, you may want to allow NULL values in it

# NOT NULL appears in DESC

# Fill in the blanks with DEFAULT
* Using a **DEFAULT** value fills the empty columns with a specified value

# SQL in review
* CREATE DATABASE - Use this statement to set up the database that will hold all your tables
* USE DATABASE - Gets you inside the database to set up all your tables

* CREATE TABLE - Starts setting up your table, but you'll also need to know your COLUMN NAMES and DATA TYPES. You should have worked these out by analyzing the kind fo data you'll be putting in your table

* NULL and NOT NULL - You'll also need to have an idea which columns should not accept NULL values to help you sort and search your data. You'll need to set the columns to NOT NULL when you create your table
* DEFAULT - Lets you specify a default value for a column, used if you don't supply a value for the column when you insert a record

* DROP TABLE - Lets you delete a table if you make a mistake, but you'll need to do this before you start using INSERT statements, which let you add the values for each column

# Bullet Points
* If you want to see the structure of your table, use the **DESC** statement
* The **DROP TABLE** statement can be used to throw away your table. Use it with care!
* To get your data inside your table, use one of the several varieties of **INSERT** statements
* A **NULL** value is an undefined value. It does not equal zero or an empty value. A column with a **NULL** value **IS NULL**, but **does not EQUAL NULL**
* Columns that are not assigned values in your **INSERT** statements are set to **NULL** by default
* You can change a column to not accept a **NULL** value by using the keywords **NOT NULL** when you create your table
* Using a **DEFAULT** value when you **CREATE** your table fills the column with that value if you insert a record with no value for that column
