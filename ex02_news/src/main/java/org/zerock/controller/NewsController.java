package org.zerock.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/news/*")
public class NewsController {

	@GetMapping("/naver")
	public void naver(Model model) throws IOException {

//		String url = "https://n.news.naver.com/mnews/article/215/0001161053";
//
//		Document doc = Jsoup.connect(url).timeout(5000).get();
//		
//		Elements elementsTitle = doc.select("#title_area");
//		
//		model.addAttribute("title", elementsTitle);
//
//		Elements elementsContent = doc.select("#dic_area");
//
//		model.addAttribute("content", elementsContent);
		
		String address = "https://news.naver.com/section/105";
		
		Document doc = Jsoup.connect(address).timeout(5000).get();
		
		Elements elements = doc.select(".sa_text");
		
		log.info("######elements갯수는: " + elements.size());
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i < elements.size(); i++) {
			
			Element element = elements.get(i);
			log.info("i = "+ i + element.text());
			
			Elements contentATags = element.select(".sa_text a"); 
			
			String viewPageUrl = contentATags.first().attr("abs:href");
			
			log.info("viewPageUrl = "+ viewPageUrl);
			
			Document doc2 = Jsoup.connect(viewPageUrl).timeout(5000).get();
			
			Elements eleTitle = doc2.select("#title_area");
			Elements eleContext = doc2.select("#dic_area");
			
			model.addAttribute("title", eleTitle);
			
			model.addAttribute("content", eleContext);
			
			map.put(eleTitle.toString(), eleContext.toString());
			
		}
		 //model.addAttribute("title", eleTitle);
		 //model.addAttribute("content", eleContext);
			model.addAttribute("mapdata", map);

//        String address = "https://news.naver.com/section/105";
//        Document doc = Jsoup.connect(address).timeout(5000).get();
//        //log.info(doc);
//        Elements elements = doc.select(".sa_text");
//        //log.info(elements);
//        
//        //elements.size();
//        
//        for(int inx=0; inx<1/*elements.size()*/;inx++) {
//        	Element element = elements.get(inx);
//        	Elements contentATags = doc.select(".sa_text a"); 
//
//        	String viewPageUrl = contentATags.first()
//        	                                  .attr("abs:href");
//
//        	log.info("URL: " + viewPageUrl);  
//        	
//        	log.info("TITLE: " + element.text());
//        	
//        	Document docContent = Jsoup.connect(viewPageUrl).timeout(5000).get();
//        	
//        	//log.info("CONTENT: " + docContent.text());
//        	
//        	Elements elContext = docContent.select("#dic_area");
//        	
//        	log.info(elContext.text());
//        	
//        	
//        }
//        
		// elements.forEach(a -> log.info(a));

//        Elements a = doc.select("#dic_area");
//		log.info(a);
		// model.addAttribute("title", elements);
		// model.addAttribute("content", a);

		// https://news.naver.com/section/105
	}

}
