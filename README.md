# CarServiceCRM

<p>Simple CRM on Servlet+JSP, Dao implementation and data object separation.</p> 
<p>There is no Spring or Hibernate on purpose, because I am practicing servlets.<br/>

# Why I like this project:
<p>I implemented simple CRM without Spring and Hibernate, improving my JavaEE understanding. I have learned how to test classes with Mockito.</p>
<p>Also I have with class polimorhism and SQL querries. If you check new Customer/Employee form, there is a dropdown with only unmatched Persons to select. I feel a little clever with this, not super smart but clever.</p>
<p>In future I would like to make domain classes immutable and add front, because now eyes are bleeding.</p>

# Database model:
![Class diagram](https://github.com/PawelDabrowski83/CarServiceCRM/blob/master/class-diagram-v2.png)

# Project roadmap:
Completed:
* Index.jsp front
* All Dao and domains
* All form backend validation
* Car, Vehicle, Person, Customer, Employee domain test
* All Service tested

Next step:
* (bug) LaborMapperTest - EmployeeService is throwing NullPointer with no obvious reason
* (bug) findUnmatchedEmployees is not working, yet findUnmatchedCustomers works fine 

To Do:
* Tests on Dao - reseatching how to mock a Connection and ResultSet (they are provided by static method, and Mockito does not like static)
* Tests on Controllers - to do
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
