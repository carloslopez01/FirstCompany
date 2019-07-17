<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Empleado"%>
<%@page import="modelo.EmpleadoDAO"%>
<div class="container-fluid">
    <table class="table-bordered"> 
            <% 
                EmpleadoDAO listempleado = new EmpleadoDAO(); 
                List<Empleado> listaEmp = new ArrayList();
                listaEmp = listempleado.mostartEmpleados();
                int i = listaEmp.size();
                for(Empleado empleado:listaEmp)
                {
            %>
        <tr>
            <td><% empleado.getPrimerNombre(); %></td>
            <td><% empleado.getSegundoNombre(); %></td>
            <td><% empleado.getPrimerApellido(); %></td>
            <td><% empleado.getSegundoApellido(); %></td>
            <td><% empleado.getDireccion(); %></td>
            <td><% empleado.getTelefonoCelular(); %></td>
            <td><% empleado.getTelefonoCasa(); %></td>
            <td><% empleado.getSalario(); %></td>
            <td><% empleado.getCargo(); %></td>
        </tr>
            <%        
                }
            %>
    </table>
</div>