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
		System.out.println("Rendering home view");
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
		String eitherUpstreamSequence = init.getEitherSequenceString(targetGene);
		int eitherUpstreamSequenceLength = init.getEitherSequenceLength();
		System.out.println("length is " + eitherUpstreamSequenceLength);
		int div = (int) Math.floor(eitherUpstreamSequenceLength / 60);
		System.out.println("div is " + div);
		Map<String, Object> modelMap = new TreeMap<String, Object>();
		int i = 0;
		int j = 0;
		String eitherUpstreamSubsequence = "";
		while (i <= div) {
			while (j<=div){
			eitherUpstreamSubsequence = eitherUpstreamSequence.substring(i, i + 60);
			//System.out.println("sequence is " + eitherUpstreamSequence);
			modelMap.put("eitherUpstreamSequence" + i, eitherUpstreamSubsequence);
			//System.out.println("Dividing sequence is at nucleotide " + i);
			//System.out.println("Label sequence is at " + j);
			i=i+60;
			j++;
			}
		}

		/*
		 * modelMap.put("eitherUpstreamGeneName", eitherUpstreamGeneName);
		 * modelMap.put("eitherUpstreamGeneStrand", eitherUpstreamGeneStrand);
		 */
		modelMap.put("targetGeneName", targetGeneName);
		modelMap.put("targetGeneStrand", targetGeneStrand);
		System.out.println("Rendering submit view");
		return new ModelAndView("submit", modelMap);
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("about");
	}
}