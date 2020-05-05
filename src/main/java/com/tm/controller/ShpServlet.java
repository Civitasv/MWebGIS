package com.tm.controller;

import com.tm.dao.ShpDao;
import com.tm.dao.impl.ShpDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/shp")
public class ShpServlet extends HttpServlet {

    private ShpDao shpDao = new ShpDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        String geojson = shpDao.getBoundaryChn2PShp();
        PrintWriter out = response.getWriter();
        out.println(geojson);
        out.close();
    }
}
