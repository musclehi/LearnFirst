package com.controller;

import com.entity.Game;
import com.service.GameService;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

@WebServlet(
        urlPatterns={"/gameList"}
)
public class GameList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        int page = (Integer)session.getAttribute("page");
        List<Game> gamelist;

        if(page == 1&& (action == null || action.contentEquals("previous"))){
             gamelist  = new GameService().gameList(1);
        }else if(action.contentEquals("previous")){
             gamelist  = new GameService().gameList(--page);
        }else{
            gamelist  = new GameService().gameList(++page);
        }

        System.out.println("gamelist"+gamelist.get(0).getOperateTime());
        session.setAttribute("page",page);
        Gson gson=new Gson();
        PrintWriter out = response.getWriter();
//        Map<String,String> map = new HashMap<String, String>();
        String info=gson.toJson(gamelist);
//        map.put("list",info);
//        map.put("page",String.valueOf(page));
//        System.out.println(page);
//        String result=gson.toJson(map);
        response.setCharacterEncoding("utf-8");
        out.write(info);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        System.out.println(page);
        doPost(req, resp);
    }
}
