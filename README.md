# CarServiceCRM

<p>Simple CRM on Servlet+JSP, Dao implementation and data object separation.</p> 
<p>There is no Spring or Hibernate on purpose, because I am practicing servlets.
CRUD - there is no Delete operation, only Update with set active = 0.</p>

Database model:
<ul>
<li>Person (basic data on everyone)<ul></li>
<li>Employee (of car workshop) -> Person</li>
<li>Customer -> Person</li>
</ul>
<li>Car (more like catalogue of possible cars)<ul>
<li>Vehicle -> Car</li>
<li>Vehicle -> Owner id (connection to Customer)</li></ul></li>
<li>Labor<ul>
<li>-> Vehicle (connected)</li>
<li>-> Employee (connected)</li></ul></li>
</ul>

Completed:
* Index.jsp front
* All Dao and domains
* All form backend validation
* Car, Vehicle, Person, Customer, Employee domain test
* All Service tested

Next step:
* VehicleMapperTest

To Do:
* Employee Dao and Controller test
* Customer Dao and Controller test
* Labor Dao and Controller test
* Person Dao and Controller test
* Car Dao and Controller test
* Vehicle Dao and Controller test
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