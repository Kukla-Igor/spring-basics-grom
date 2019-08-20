package com.lesson6.homework.controlller;

import com.lesson6.homework.model.Plane;
import com.lesson6.homework.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ControllerPlane extends HttpServlet {
    PlaneService planeService;

    @Autowired
    public ControllerPlane(PlaneService planeService) {
        this.planeService = planeService;
    }



    @RequestMapping(method = RequestMethod.GET, value = "getPlane", produces = "text/plain")
    public @ResponseBody
    void doGet (HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(planeService.doGet(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "postPlane", produces = "text/plain")
    public @ResponseBody
    void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(planeService.doPost(req));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "putPlane", produces = "text/plain")
    public @ResponseBody
    void doPut(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(planeService.doPut(req));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deletePlane", produces = "text/plain")
    public @ResponseBody
    void doDelete(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(planeService.doDelete(req));
    }

    @RequestMapping(method = RequestMethod.GET, value = "oldPlanes", produces = "text/plain")
    public @ResponseBody
    List<Plane> oldPlane (){
        List<Plane> list = planeService.oldPlanes();
        System.out.println(list);
        return list;
    }

    @RequestMapping(method = RequestMethod.GET, value = "regularPlanes", produces = "text/plain")
    public @ResponseBody
    List<Plane> regularPlanes (HttpServletRequest req){
        List<Plane> list = planeService.regularPlanes(req);
        System.out.println(list);
        return list;
    }
}
