package org.adoxsey.bioinformatics.gui;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.adoxsey.bioinformatics.Initializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class HomeController extends MultiActionController{
        
        @Autowired
        private Initializer init;
                
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public ModelAndView home(HttpServletRequest request,
                HttpServletResponse response) {
            return new ModelAndView("home");
        }
        
        @RequestMapping(value = "/submit", method = RequestMethod.POST)
        public ModelAndView submit(HttpServletRequest request,
                HttpServletResponse response) {

            String targetGene = request.getParameter("targetGene");
            String theGene = init.start(targetGene);
            
            Map<String, Object> modelMap = new TreeMap<String, Object>();
            modelMap.put("chromosomeGene", theGene);

            return new ModelAndView("submit", modelMap);
        }
        
        @RequestMapping(value = "/about", method = RequestMethod.GET)
        public ModelAndView about(HttpServletRequest request,
                HttpServletResponse response) {
            return new ModelAndView("about");
        }
        
        
        
        
}