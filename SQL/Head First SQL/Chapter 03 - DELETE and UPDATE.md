# Chapter 03 - DELETE and UPDATE
* With UPDATE, you **can change data**, and DELETE lets you **get rid of data**

* You can use WHERE clauses with DELETE statements the same way you use them with INSERT statements

# DELETE rules
* You can't use DELETE to delete the value from a single column or tableful of columns
* You can use DELETE to delete a single row or multiple rows, depending on the WHERE clause
* You've seen how to delete a single row from a table. We can also delete multiple rows from a table. For that, we use a WHERE clause to tell our DELETE which rows to choose. This WHERE clause is exactly the same as the one you used in Chapter 2 with your SELECT statements. It can use everything you used it with in Chapter 2, such as LIKE, IN, BETWEEN, and all the conditionals to tell your RDMBS precisely which rows to delete
* And, watch out for this one, you can delete every row from a table with: DELET FROM your_table

# Be carefully with your DELETE
* Use DELETE carefully. Make sure you include a precise WHERE clause to target the exact rows you really want to delete
* Unless you're absolutely certain that your WHERE clause will delete the rows you want it to, you should use a SELECT first to make sure
* Change only the records you mean to by using a SELECT statement first

# UPDATE rules
* You can use UPDATE to change the value of a single column or tableful of columns. Add more column = value pairs, to the SET clause, and put a comma after each
* You can use UPDATE to update a single row or multiple rows, depending on the WHERE clause

* UPDATE statements can replace DELETE/INSERT combinations

* UPDATE statements can be used on *multiple records* in your table. Use them with *basic math operators* to manipulate your numeric values

* Data does change, so knowing how to update your data is crucial

# SQL in review
* DELETE - this is your tool for deleting rows of data from your table. Use it with a WHERE clause to precisely pinpoint the rows you want to remove
* UPDATE - this statement updates an existing column or columns with a new value. It also uses a WHERE clause
* SET - This keyword belongs in an UPDATE statement and is used to change the value of an existing column  
 