package org.adoxsey.bioinformatics.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
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
        TargetGene targetGene = init.start(targetGeneString);

        // String thePlusGene = init.getUpstreamPlus(targetGene);
        // String theMinusGene = init.getUpstreamMinus(targetGene);

        String sameSequence = init.getSameSequenceString(targetGene);
        // String eitherSequence = init.getEitherSequenceString(targetGene);

        Map<String, Object> modelMap = new TreeMap<String, Object>();
        // modelMap.put("thePlusGene", thePlusGene);
        // modelMap.put("theMinusGene", theMinusGene);
        modelMap.put("sameSequence", sameSequence);
        // modelMap.put("eitherSequence", eitherSequence);

        return new ModelAndView("submit", modelMap);
    }

    @RequestMapping(value = "/generateEitherFile", method = RequestMethod.GET)
    public ModelAndView generateEitherFile(HttpServletRequest request, HttpServletResponse response) {

        // construct the complete absolute path of the file
        String fullPath = "C:/Projects/APRIL/Bioinformatics/CurationAutomation/src/main/downloads";
        FileOutputStream fop = null;
        File file;
        String content = "This is the text content";
 
        try {
 
            file = new File(fullPath + "/either.txt");
            fop = new FileOutputStream(file);
 
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
 
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();
 
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
 
            System.out.println("Done");
 
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
/*        String appPath = request.getServletPath();
        System.out.println("appPath = " + appPath);

        // construct the complete absolute path of the file
        String fullPath = appPath + "/downloads/either.txt";
        File file = new File(fullPath);
        String content = "This is the text content";
        FileOutputStream fop = null;

        try {
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("The first line");
        writer.println("The second line");
        writer.close();
*/
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("about");
    }

}