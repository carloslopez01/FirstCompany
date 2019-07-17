/*
 * Copyright (C) 2019 PC1
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * @author Carlos Lopez
 * Version: 0.1 Alpha
 * Contacto: cl640900@gmail.com || carlos.lopez17@itca.edu.sv
 */
public class EmpleadoDAO extends Conexion{
    private final List<Empleado> listaEmpleados = new ArrayList();
    private ResultSet res = null;
    private String sql = "";
    private PreparedStatement pst = null;
    
    public List<Empleado> mostartEmpleados()
    {
        sql = "SELECT * FROM empleados";
        try {
            this.conectarBD();
            pst = this.getConection().prepareCall(sql);
            res = pst.executeQuery();
            
            while( res.next() ){
                Empleado empleado = new Empleado();
                
                empleado.setIdEmpleado( res.getInt(0) );
                empleado.setPrimerNombre( res.getString(1) );
                empleado.setSegundoApellido( res.getString(2) );
                empleado.setPrimerApellido( res.getString(3) );
                empleado.setSegundoApellido( res.getString(4) );
                empleado.setDireccion( res.getString(5) );
                empleado.setTelefonoCelular( res.getString(6) );
                empleado.setTelefonoCasa( res.getString(7) );
                empleado.setSalario( res.getDouble(8) );
                empleado.setCargo( res.getString(9) );
                
                listaEmpleados.add(empleado);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Causa: " + e.getCause()
                   + "\nMensaje: " + e.getMessage(), "Error al Mostrar Empleados",
                   JOptionPane.ERROR_MESSAGE);
        }finally{
            this.desconectarDB();
        }
        return listaEmpleados;
    }
}
