# CarServiceCRM

Simple CRM on Servlet+JSP, Dao implementation and data object separation.
CRUD - there is no Delete operation, only Update with set active = 0.
It is not Transactional yet.

Database model:
<ul>
<li>Person (basic data on everyone)<ul></li>
<li>Employee extends Person</li>
<li>Customer extends Person</li>
</ul>
<li>Vehicle basic<ul>
<li>Vehicle info</li>
<li>Customer id</li></ul></li>
<li>Labor<ul>
<li>Employee id</li>
<li>Vehicle id</li></ul></li>
</ul>

Completed:
Index.jsp front + Person class Dao

Next step:
Customer and Employee Dao