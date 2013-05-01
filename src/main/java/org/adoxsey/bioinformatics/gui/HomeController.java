package org.adoxsey.bioinformatics.gui;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.adoxsey.bioinformatics.Initializer;
import org.adoxsey.bioinformatics.model.TargetGene;
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

        String targetGeneString = request.getParameter("targetGene");
        String speciesNameString = request.getParameter("speciesName");
        TargetGene targetGene = init.createGeneAndSetUpstreamGenes(targetGeneString, speciesNameString);
        
        String targetGeneName = targetGene.getTargetDisplayName();
        String targetGeneStrand = targetGene.getTargetStrand().toString();
        String eitherUpstreamGeneName = init.getEitherUpstreamGeneName(targetGene);
        String eitherUpstreamGeneStrand = init.getEitherUpstreamGeneStrand(targetGene);

        Map<String, Object> modelMap = new TreeMap<String, Object>();
        modelMap.put("eitherUpstreamGeneName", eitherUpstreamGeneName);
        modelMap.put("eitherUpstreamGeneStrand", eitherUpstreamGeneStrand);
        modelMap.put("targetGeneName", targetGeneName);
        modelMap.put("targetGeneStrand", targetGeneStrand);

        return new ModelAndView("submit", modelMap);
    }

    @RequestMapping(value = "/generateEitherFile", method = RequestMethod.GET)
    public ModelAndView generateEitherFile(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("about");
    }

}