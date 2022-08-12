/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ReportesController;
import java.util.List;
import javax.swing.JFrame;
import vo.ListasDeLiderVo;
import vo.DeudasPorProyectoVo;
import vo.ProyectoBancoVo;

/**
 *
 * @author frank
 */
public class ReportesView extends JFrame{
    private static ReportesController controller;

    public ReportesView() {
        controller = new ReportesController();
      
    }

   

    public void proyectosFinanciadosPorBanco() {
        
        
            try {
                
                List<ProyectoBancoVo> proyectos = controller.listarProyectosPorBanco();
                for (ProyectoBancoVo proyecto : proyectos) {
                    System.out.println(proyecto);
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
                ex.printStackTrace();
            }
        }
    

    public void totalAdeudadoPorProyectosSuperioresALimite() {
        
            try {
                List<DeudasPorProyectoVo> proyectos = controller.listarTotalAdeudadoProyectos();
                for (DeudasPorProyectoVo proyecto : proyectos) {
                    System.out.println(proyecto);
                }
            } catch (Exception ex) {
                System.err.println("Error: " + ex);
                ex.printStackTrace();
            }
        }
    

    public void lideresQueMasGastan() {
        
        try {
            List<ListasDeLiderVo> comprasLideres = controller.listarLideresQueMasGastan();
            for (ListasDeLiderVo comprasLider : comprasLideres) {
                System.out.println(comprasLider);
            }
        } catch (Exception ex) {
            System.err.println("Error: " + ex);
            ex.printStackTrace();
        }
    }
}