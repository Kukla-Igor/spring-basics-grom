package com.lesson6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ItemController extends HttpServlet {

    ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "get", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(itemService.doGet(req));
        }

    @RequestMapping(method = RequestMethod.POST, value = "post", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(itemService.doPost(req));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "put", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) {
        itemService.doPut(req);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        itemService.doDelete(req);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteByName", produces = "text/plain")
    public @ResponseBody
    void deleteByName(HttpServletRequest req) {
        itemService.deleteByName(req);
    }

}