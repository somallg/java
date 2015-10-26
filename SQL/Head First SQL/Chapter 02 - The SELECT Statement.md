# Chapter 02 - The SELECT Statement

# A better SELECT
* **WHERE clause that gives the RDBMS something specific to search for**
* It narrows down the results for us and **only returns the rows that match the condition**

* **WHERE** tells your SQL that you want to look at something specific

* The start is telling the RDBMS to give you back the values from **all** of the columns in your table
* When you see SELECT *, think of it like asking your SQL to SELECT ALL THE COLUMNS

# How to query your data types
* The **VARCHAR**, **CHAR**, **BLOB**, **DATE**, and **TIME** data types need single quotes
* The numeric types, **DEC** and **INT**, do not

# Single quotes are special characters
* The single quote is a *reversed* SQL character, that means it has a specific function in the language
* It's used to tell your SQL where a text string begins and ends

# INSERT data with single quotes in it
* Handle quotes with a backslash - Telling SQL that a single quote is part of a text string by putting a backslash in front of it is called "escaping" it
* Handle quotes with an extra single quote

# SELECT specific data
* You need to know how to only SELECT the columns you wish to see

# SELECT specific columns to limit results
* Just as you use a WHERE clause to limit the number of rows, you can use column selection to limit the number of column

# SELECT specific columns for faster results
* As your tables get larger, is speeds up retrieval of your results

# Bullet Points
* Use single quotes in your WHERE clause when selecting from text fields
* Don't use single quotes when selecting from numeric values
* Use the * in your SELECT when you want to select all of the columns
* If you've entered your query and your RDMBS doesn't finish processing it, check for a missing single quote
* When you can, select specific columns in your table, rather than using SELECT *

# Combining your queries
* Use the word AND to combine your two WHERE clauses

# Comparison Operators
* The EQUAL = sign looks for exact matches. This does us no good when we want to find out if something is less than or greater than something else

* The NOT EQUAL <> returns precisely the opposite results of the EQUAL sign. Two values are either equal, or they are not equal
 
* The LESS THAN < sign looks at the values in the column on the left and compares them to the value on the right. If the column value is *less than* the value on the right, that row is returned

* The GREATER THAN > sign is the reverse of the less than

* The LESS THAN OR EQUAL <= - column values equal to the condition value are also returned

# Text data roping with Comparison Operators
* Comparing text data works in a similar way with yur text columns like CHAR and VARCHAR. The comparison operators evaluate everything **alphabetically**

# To be OR not to be
* You can combine two queries using OR. This condition returns records when **any** of the conditions are met

# Don't get your ANDs and ORs confused!
* When you wall **ALL** of your conditions to be true, use **AND**
* When you want **ANY** of your conditions to be true, use **OR**

# Use IS NULL to find NULLs

# Saving time with a single keyword: LIKE
* The keyword LIKE used with a wildcard, looks for part of a text string and returns any matches
* The *percent* is a *stand-in* for *any number* of unknown characters
* The *underscore* is a *stand-in* for *just one* unknown character

# Selecting ranges using AND and comparison operators
* We can use the BETWEEN keyword. BETWEEN is equivalent to using the <= and >= symbols, but not the < and > symbols
* The smaller number must always be first for the BETWEEN to be interpreted the way you expect

# After the dates, you can either IN...
* Use IN with a set of values in parentheses. When the value in the column matches one of the values in the set, the row or specified columns are returned

# ... or you are NOT IN
* Using the keywords NOT IN tells SQL that the results aren't in the set of terms

# More NOT
* You can use NOT with BETWEEN and LIKE just as you can with IN
* The important thing to keep in mind is that **NOT goes right after WHERE** in your statement
* When you use NOT with AND or OR, it goes right after the AND or OR

# SQL in review
* SELECT * - Use this to select all the columns in a table
* Escape with ' and \ - Escape out apostrophes in your text data with an extra apostrophe or black-slash in front of it

* = <> < > <= >= - You've got a whole bunch equality and inequality operators at your disposal
* IS NULL - Use this to create a condition to test for that pesky NULL values

* AND and OR
* With AND and OR, you can combine your conditional statements in your WHERE clauses for more precision
* NOT - NOT lets you negate your results and get the opposite values

* BETWEEN - Lets you select ranges of values
* LIKE with % and _ - Use LIKE with the wildcards to search through parts of text strings