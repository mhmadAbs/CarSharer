<!--
When user enters info and clicks submit, hello will be called.
We have set HelloServlet to handle hello in it's class.
-->

<html>
<head><title>Hello World</title>
 
 
<!--
action : is where the input is submitted to.
name   : give us the ability to access the input.
we can add required attribute to make submitting empty fields permitted. 
-->  
<body>
  <form name="user" action="hello" method="post">
    Firstname: <input type="text" name="firstname" /> <br/>
    Lastname:  <input type="text" name="lastname" /> <br/>
    <input type="submit" value="Save" />
  </form>
 
  <table class="datatable">
    <tr>
        <th>Firstname</th>  <th>Lastname</th>
    </tr>
    <#list users as user>
    <tr>
        <td>${user.firstname}</td> <td>${user.lastname}</td>
    </tr>
    </#list>
  </table>
</body>
</html>