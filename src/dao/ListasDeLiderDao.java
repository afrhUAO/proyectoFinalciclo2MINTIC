/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import util.JDBCUtilities;
import java.sql.Statement;
import java.sql.Connection;
import vo.ListasDeLiderVo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListasDeLiderDao {

    public List<ListasDeLiderVo> listar() throws SQLException {
        ArrayList<ListasDeLiderVo> respuesta = new ArrayList<>();

        Connection conn = JDBCUtilities.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rset = null;
        String consulta = "";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
            while (rset.next()) {
                ListasDeLiderVo vo = new ListasDeLiderVo();
                vo.setId(rset.getInt("id"));
                vo.setNombre(rset.getString("nombre"));
                vo.setApellido(rset.getString("nombre"));
                vo.setCiudad(rset.getString("nombre"));

                respuesta.add(vo);
            }
        } finally {
            if (rset != null) {
                rset.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return respuesta;
    }
}
