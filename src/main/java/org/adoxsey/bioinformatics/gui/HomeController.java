package org.adoxsey.bioinformatics.gui;

import java.util.ArrayList;
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
		System.out.println("Rendering home view");
		return new ModelAndView("home");
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public ModelAndView submit(HttpServletRequest request, HttpServletResponse response) {
		try {
			String targetGeneString = request.getParameter("targetGene");
			String speciesNameString = request.getParameter("speciesName");
			if ((targetGeneString.isEmpty()) || (targetGeneString == null) || (speciesNameString == null)
					|| speciesNameString.isEmpty()) {
				return new ModelAndView("home");
			}
			if ((targetGeneString.toLowerCase().matches("cftr")) || (targetGeneString.toLowerCase().matches("capza2"))) {
				TargetGene targetGene = init.createGeneAndSetUpstreamGenes(targetGeneString, speciesNameString);
				String targetGeneName = targetGene.getTargetDisplayName();
				String targetGeneStrand = targetGene.getTargetStrand().toString();
				String eitherUpstreamGeneName = init.getEitherUpstreamGeneName(targetGene);
				String eitherUpstreamGeneStrand = init.getEitherUpstreamGeneStrand(targetGene);
				String targetStableID = init.getTargetGeneStableId();
				String upstreamStableID = init.getEitherUpstreamGeneStableId();
				String eitherUpstreamSequence = init.getEitherSequenceString(targetGene);
				int eitherUpstreamSequenceLength = init.getEitherSequenceLength();
				System.out.println("length is " + eitherUpstreamSequenceLength);
				int div = (int) Math.ceil(eitherUpstreamSequenceLength / 60);
				System.out.println("div is " + div);
				Map<String, Object> modelMap = new TreeMap<String, Object>();
				int i = 0;
				int j = 0;
				String eitherUpstreamSubsequence = "";
				List<String> entireSequence = new ArrayList<String>();

				while (i <= div) {
					while (j <= div) {
						if (i + 60 >= eitherUpstreamSequenceLength) {
							int diff = (i + 60) - eitherUpstreamSequenceLength;
							eitherUpstreamSubsequence = eitherUpstreamSequence.substring(i, i + diff);
							entireSequence.add(eitherUpstreamSubsequence);
							break;
						}
						eitherUpstreamSubsequence = eitherUpstreamSequence.substring(i, i + 60);
						entireSequence.add(eitherUpstreamSubsequence);
						i = i + 60;
						j++;
					}
				}
				modelMap.put("targetStableID", targetStableID);
				modelMap.put("upstreamStableID", upstreamStableID);
				modelMap.put("entireSequence", entireSequence);
				modelMap.put("eitherUpstreamGeneName", eitherUpstreamGeneName);
				modelMap.put("eitherUpstreamGeneStrand", eitherUpstreamGeneStrand);
				modelMap.put("targetGeneName", targetGeneName.toUpperCase());
				modelMap.put("targetGeneStrand", targetGeneStrand);
				System.out.println("Rendering submit view");
				return new ModelAndView("submit", modelMap);
			}
			else{
				return new ModelAndView("homeModified");
			}
		} catch (Exception e) {
			return new ModelAndView("error");
		}
		
	}
	
	@RequestMapping(value = "/homeModified", method = RequestMethod.GET)
	public ModelAndView homeModified(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("homeModified");
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView about(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("about");
	}

	@RequestMapping(value = "/ensemblInstructions", method = RequestMethod.GET)
	public ModelAndView ensemblInstructions(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("ensemblInstructions");
	}
}