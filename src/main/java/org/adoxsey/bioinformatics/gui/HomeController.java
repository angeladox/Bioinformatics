package org.adoxsey.bioinformatics.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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
public class HomeController extends MultiActionController {

    @Autowired
    private Initializer init;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("home");
    }
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) {

        String targetGene = request.getParameter("targetGene");
        String thePlusGene = init.getUpstreamPlus(targetGene);    //this is what needs to be written to the either and same files.
        String theMinusGene = init.getUpstreamMinus(targetGene);
        String theGenes = thePlusGene + " " + theMinusGene;
        
        Map<String, Object> modelMap = new TreeMap<String, Object>();
        modelMap.put("chromosomeGene", theGenes);

        return new ModelAndView("submit", modelMap);
    }

    @RequestMapping(value = "/generateFile", method = RequestMethod.GET)
    public ModelAndView generateFile(HttpServletRequest request, HttpServletResponse response) {

       /* try {
            Writer output = null;
            File file = new File("either.txt");
            output = new BufferedWriter(new FileWriter(file));

            output.close();
            System.out.println("File has been written");

        } catch (Exception e) {
            System.out.println("Could not create file");
        }*/

        return new ModelAndView("home");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("about");
    }

}