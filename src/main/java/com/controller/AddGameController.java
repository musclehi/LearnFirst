package com.controller;

import com.entity.Game;
import com.service.GameService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(
        urlPatterns = {"/addGameAction"}
)
public class AddGameController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String icon = request.getParameter("icon");
        String name = request.getParameter("name");
        String developer = request.getParameter("developer");
        int state = Integer.parseInt(request.getParameter("state"));
        int autoUpdate = Integer.parseInt(request.getParameter("autoupdate"));
        int isOfficial = Integer.parseInt(request.getParameter("isofficial"));
        Timestamp dateIssued = Timestamp.valueOf(request.getParameter("dateissued"));
        Timestamp updateTime = Timestamp.valueOf(request.getParameter("updatetime"));
        int activeComment = Integer.parseInt(request.getParameter("activecomment"));
        int downloadNum = Integer.parseInt(request.getParameter("downloadnum"));

        Game game = new Game();
        game.setType(type);
        game.setIcon(icon);
        game.setName(name);
        game.setDeveloper(developer);
        game.setState(state);
        game.setAutoUpdate(autoUpdate);
        game.setIsOfficial(isOfficial);
        game.setOperateTime(new Timestamp(System.currentTimeMillis()));
        game.setDateIssued(dateIssued);
        game.setUpdateTime(updateTime);
        game.setActiveComment(activeComment);
        game.setDownloadNum(downloadNum);
        System.out.println(game);
        int result = new GameService().addGame(game);
        if (result == 1) {
            response.sendRedirect("/gamelist.jsp?page=1");
        } else {
            System.out.println("test");
//            request.setAttribute("result",result);
//            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }
    }
}
