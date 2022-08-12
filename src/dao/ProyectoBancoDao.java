/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import util.JDBCUtilities;
import vo.ProyectoBancoVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author frank
 */
public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar() throws SQLException {
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<>();
        java.sql.Connection conn = JDBCUtilities.getConnection();
        PreparedStatement stmt = null;
        ResultSet rset = null;
        String consulta = "SELECT P.ID_PROYECTO AS ID, P.CONSTRUCTORA, P.CIUDAD, P.CLASIFICACION,"
                + "       T.ESTRATO, L.NOMBRE||' '||L.PRIMER_APELLIDO||' '||L.SEGUNDO_APELLIDO AS LIDER"
                + " FROM PROYECTO P"
                + " JOIN TIPO T ON (P.ID_TIPO = T.ID_TIPO)"
                + " JOIN LIDER L ON (P.ID_LIDER = L.ID_LIDER)"
                + " WHERE P.BANCO_VINCULADO = ?"
                + " ORDER BY FECHA_INICIO DESC, CIUDAD, CONSTRUCTORA";
        try {
            stmt = conn.prepareStatement(consulta);
         
            rset = stmt.executeQuery();
            while (rset.next()) {
                ProyectoBancoVo vo = new ProyectoBancoVo();
                vo.setId(rset.getInt("id"));
                vo.setConstructora(rset.getString("constructora"));
                vo.setCiudad(rset.getString("ciudad"));
                vo.setClasificacion(rset.getString("clasificacion"));
                vo.setEstrato(rset.getInt("estrato"));
                vo.setLider(rset.getString("lider"));

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