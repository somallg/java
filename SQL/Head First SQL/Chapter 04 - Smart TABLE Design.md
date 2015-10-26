# Chapter 04 - Smart TABLE Design
* How you're going to use your data will affect how you set up your table

# A table is all about relationships
* SQL is known as a Relational Database Management System, or RDMBS
* You need to consider **how** the **columns relate** to each other **to describe a thing**
* The challenge is to describe the thing using columns in a way that makes getting the information out of it easy

* Pick your thing, **the one thing** you want your table to describe => What's the **main thing** you want your table to be about?
* Make a **list of the information** you need to know about your one thing when you're **using the table** => How will you **use** this table?
* Using the list, **break down the information** about your thing **into pieces** you can use for **organizing** your table => How can you most **easily query** this table

# Atomic data
* Atom - a little piece of information that can't or shouldn't be divided
* ATOMIC - smallest pieces of data that can't or shouldn't be divided

# Atomic data and your tables
* What is the **one thing** your table describes? 
* How will you **use** the table to **get at** the **one thing**?
* Do your **columns* contain **atomic data** to make your queries short and to the point?

# Rules of atomic data
* A column with atomic data can't have several values of the same type of data in that column
* A table with atomic data can't have multiple columns with the same type of data

# Reasons to be normal
* Making your tables NORMAL means they follow some standard rules your new designers will understand

* Making your data atomic is the first step in creating a **NORMAL** table

# The benefits of normal tables
* Normal tables won't have duplicate data, which will reduce the size of your database
* With less data to search through, your queries will be faster

* Even when your tables are tine, it add up. And tables grow. If you begin with a normalized table, you won't have to go back and change your table when your queries go too slowly

# Halfway to 1NF
* To be 1NF (FIRST NORMAL FORM), a table must follow these two rules:
    * Each row of data must contain atomic values
    * Each row of data must have a unique identifier, known as a **Primary Key**

# PRIMARY KEY rules
* A primary key is a **column* in your table that makes **each record unique**

* The primary key is used to uniquely indentify each record
* Which means that data in the primary key column can't be repeated

* A primary key can't be NULL
* The primary key must be given a value when the record is inserted
* The primary key must be compact. A primary key should contain only the information it needs to be unique and nothing extra
* The primary key values can't be changed

* The best primary key may be a *new* primary key
* When it comes to creating primary keys, your best bet may be to create a column that contains a unique number

* 
