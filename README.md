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
* Index.jsp front
* Person Dao
* Employee Dao
* Customer Dao
* Car Dao
* Vehicle Dao
* Labor Dao
* Person form backend validation
* Customer, Employee form backend validation
* Car backend validation
* Backend validation on Vehicle form
* Labor backend validation
* Car domain test
* Person domain test

Next step:
* Vehicle domain test

To Do:
* Employee domain test
* Customer domain test
* Labor domain test
* Employee Dao, Service and Controller test
* Customer Dao, Service and Controller test
* Labor Dao, Service and Controller test
* Person Dao, Service and Controller test
* Car Dao, Service and Controller test
* Vehicle Dao, Service and Controller test
* make sure that equals and compareTo are consistent on domain classes (they are not)
* User stories - add new Employee
* User stories - add new Customer
* User stories - add new Vehicle
* User stories - add new Labor
* User stories - update Labor status
* User stories - find Labors by Customer name
* User stories - find Employees by Labor (with Labor.status)
* User stories - worked MH by Employees
* User stories - total profit by Labor
* Main page - current Labors
* Main page - all Customers by birthday and profit
* Main page - all Labors by date
* Main page - all Employees with details (Labor)
* Main page - reports
* Form verification on front


To consider:
* Mapper class should extract objects with Dao or Service class?
* Customer and Employee should not allow duplicate entries
* REST API Controller