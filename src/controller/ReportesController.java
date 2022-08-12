/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.ListasDeLiderDao;
import dao.DeudasPorProyectoDao;
import dao.ProyectoBancoDao;
import java.io.IOException;
import java.util.List;
import vo.ListasDeLiderVo;
import vo.DeudasPorProyectoVo;
import vo.ProyectoBancoVo;
import java.sql.SQLException;

/**
 *
 * @author frank
 */

public class ReportesController {
    private final ProyectoBancoDao proyectoBancoDao;
    private final ListasDeLiderDao comprasDeLiderDao;
    private final DeudasPorProyectoDao pagadoPorProyectoDao;

    public ReportesController() {
        proyectoBancoDao = new ProyectoBancoDao();
        comprasDeLiderDao = new ListasDeLiderDao();
        pagadoPorProyectoDao = new DeudasPorProyectoDao();
    }

    public List<ProyectoBancoVo> listarProyectosPorBanco() throws SQLException, IOException {
        return proyectoBancoDao.listar();
    }

    public List<DeudasPorProyectoVo> listarTotalAdeudadoProyectos() throws SQLException, IOException {
        return pagadoPorProyectoDao.listar();
    }

    public List<ListasDeLiderVo> listarLideresQueMasGastan() throws SQLException, IOException {
        return comprasDeLiderDao.listar();
    }
}