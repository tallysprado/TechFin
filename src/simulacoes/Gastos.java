/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacoes;

import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;

import pagamentos.model.Cliente;

/**
 *
 * @author root
 */
public class Gastos extends javax.swing.JPanel {

    /**
     * Creates new form Gastos
     */
    Cliente u;

    public Gastos(Cliente u) {
        initComponents();
        this.u = u;
        grafico();
    }

    public void grafico() {

        try {

            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://127.0.0.1/db";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "tallys", "teste");

            //String search = "SELECT * FROM Cliente WHERE User='" + beneficiarioField.getText() + "'";
            String search = "SELECT * FROM Transacao NATURAL JOIN Cliente_tem_Transacao WHERE Cliente_tem_Transacao.Id_Cliente='" + u.getIdCliente() + "'";

            Statement st = (Statement) conn.createStatement();

            ResultSet rs = st.executeQuery(search);

            DefaultCategoryDataset ds = new DefaultCategoryDataset();
            
            ArrayList<Double> transacaoList = new ArrayList<Double>();
            ArrayList<String> dataList = new ArrayList<String>();
            while (rs.next()) {
                
                transacaoList.add(rs.getDouble("ValorTransacao"));
                dataList.add(rs.getString("DataTransacao"));

            }
            
            
            
            
            /*
            String search2 = "SELECT * FROM Transacao NATURAL JOIN Cliente_tem_Transacao WHERE Cliente_tem_Transacao.Id_Cliente='" + u.getIdCliente() + "'";
            Statement st2 = conn.createStatement();
            ResultSet rs2 = st2.executeQuery(search2);

            
            while (rs2.next()) {
                System.out.println(rs2.getString("DataTransacao"));
                dataList.add(rs2.getString("DataTransacao"));
            }
             */
            String searchGasto = "SELECT * FROM Transacao WHERE Pagador='"+u.getUser()+"'";
            Statement st4 = conn.createStatement();
            ResultSet rs4 = st4.executeQuery(searchGasto);
            ArrayList<Double> gastoList = new ArrayList<Double>();
            ArrayList<String> data2List = new ArrayList<String>();
            
            
            while (rs4.next()) {
                gastoList.add(rs4.getDouble("ValorTransacao"));
                data2List.add(rs4.getString("DataTransacao"));
                
            }
            
            
            /*
            String searchData = "SELECT DataTransacao FROM Transacao NATURAL RIGHT JOIN Cliente_tem_Transacao WHERE Cliente_tem_Transacao.Id_Cliente='" + u.getIdCliente() + "'";
            Statement st5 = conn.createStatement();
            ResultSet rs5 = st5.executeQuery(searchData);
            
            while (rs5.next()) {
                data2List.add(rs5.getString("DataTransacao"));
            }
            */
            
            /*int j = 0;
            if(gastoList.size()>transacaoList.size()){
                j = gastoList.size();
            }
            if(transacaoList.size()>gastoList.size()){
                j = transacaoList.size();
            }
            
            if(transacaoList.size()==gastoList.size()){
                j = transacaoList.size();
            }*/
            
            
            for (int i = 0; i < gastoList.size(); i++) {
                ds.addValue(gastoList.get(i), "Gastos", data2List.get(i));
                
                
                
                System.out.println(gastoList);
                System.out.println(data2List);
                System.out.println(transacaoList);
                System.out.println(dataList);
            }
            for( int i = 0; i< transacaoList.size(); i++){
                ds.addValue(transacaoList.get(i), "Ganhos", dataList.get(i));
            }
            

            JFreeChart grafico = ChartFactory.createLineChart("Meu Grafico", "Dia", "Valor", ds, PlotOrientation.VERTICAL, true, true, false);
            
            ChartPanel cp = new ChartPanel(grafico);
            this.setLayout(new BorderLayout());
            
            this.add(cp, BorderLayout.CENTER);
            this.validate();
            //OutputStream arquivo = new FileOutputStream("grafico.png");
            //ChartUtilities.writeChartAsPNG(arquivo, grafico, 550, 400);
            Thread.sleep(1000);

            //ImageIcon icon = new ImageIcon("grafico.png");
            //labelImage.setIcon(icon);
            //arquivo.close();

        } catch (SQLException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Gastos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 323, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
