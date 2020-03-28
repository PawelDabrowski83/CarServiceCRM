# CarServiceCRM

Simple CRM on Servlet+JSP, Dao implementation and data object separation.
CRUD - there is no Delete operation, only Update with set active = 0.
It is not Transactional yet.

Database model:
<ul>
<li>Person (basic data on everyone)<ul></li>
<li>Employee -> Person</li>
<li>Customer -> Person</li>
</ul>
<li>Vehicle basic<ul>
<li>Vehicle info -> Vehicle basic</li>
<li>Customer id</li></ul></li>
<li>Labor<ul>
<li>Employee id</li>
<li>Vehicle id</li></ul></li>
</ul>

Completed:
Index.jsp front
Person Dao
Employee Dao

Next step:
Customer Dao + Vehicle Dao

To Do:
Form verification on front
Form verification on backend

To consider:
Mapper class should extract objects with Dao or Service class?