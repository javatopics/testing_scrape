package org.hrd.sctape;

import java.io.File;
import java.io.FileWriter;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ScrapeModule {

	public static void main(String[] args) {
		ScrapeModule scrape=new ScrapeModule();
		try{
			//Document doc = Jsoup.connect("https://www.tripadvisor.com/Inspiration").get();
			//System.out.println(doc.toString());
			
			/*String html="<div><p>Smaple Content</p></div>";
			Document document = Jsoup.parseBodyFragment(html);
			Element body =document.body();
			Elements paragraphs = body.getElementsByTag("p");
			for(Element paragraph : paragraphs){
				System.out.println(paragraph.text());
			}*/
			
			//scrape.writeToFile(doc.toString());
			//System.out.println("Done!");
			 /*String html = "<html><head><title>Sample Title</title></head>"
			         + "<body>"
			         + "<p>Sample Content</p>"
			         + "<p>body content</p>"
			         + "<div id='sampleDiv'><a href='www.google.com'>Google</a></div>"
			         + "<a href='www.bing.com'>bing</a></div>"
			         + "<a href='www.bing.com'>bing</a>"
			         +"</body></html>";
		     Document document = Jsoup.parse(html);
		     Elements sampleDiv=document.getElementsByTag("a");
		     System.out.println(sampleDiv);
		     for(Element link : sampleDiv){
		    	 System.out.println("href: "+link.attr("href"));
		     }*/
		   
		      
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//scrape.extractDataByClassSelector("https://www.yp.com.kh/search_results?q=restuarant", "img_section col-xs-2 nopad");
		//scrape.extractDataBySelector("https://www.yp.com.kh/search_results?q=restuarant", "span.sm-block ");
		scrape.extractDataBySelector("https://www.yp.com.kh/search_results?q=restuarant", "h2 > b");
		
	
	}
	
	private Document connectUrl(String url){
		Document document=null;
		try{
			Connection conn=Jsoup.connect(url);
			//Thread.sleep(5000);
			document=conn
					.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
					.get();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return document;
		
	}
	
	private void extractDataByIdSelector(String url,String id){
		Document document=connectUrl(url);
		System.out.println(document);
		this.writeToFile("E:\\Scrape\\agoda\\index.html",document.toString());
		try{
			Element artical= document.getElementById(id);
			System.out.println(artical);
			Elements imgs=artical.getElementsByTag("img");
			for(Element img: imgs){
				System.out.println(img);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void extractDataByClassSelector(String url,String cl){
		Document document=connectUrl(url);
		//System.out.println(document);
		this.writeToFile("E:\\Scrape\\yp\\search-result.html",document.toString());
		try{
			Elements articals= document.getElementsByClass(cl);
			System.out.println(articals.get(0));
			for(Element artical : articals){
				System.out.println();
			}
			/*Elements imgs=artical.getElementsByTag("img");
			for(Element img: imgs){
				System.out.println(img);
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private void extractDataBySelector(String url,String selector){
		Document document=connectUrl(url);
		//System.out.println(document);
		this.writeToFile("E:\\Scrape\\yp\\search-result.html",document.toString());
		try{
			Elements articals= document.select(selector);
			
			System.out.println(articals.get(0));
			
			for(Element artical : articals){
				System.out.println(artical);
			}
			/*Elements imgs=artical.getElementsByTag("img");
			for(Element img: imgs){
				System.out.println(img);
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	private void writeToFile(String f,String text){
		
		File file=new File(f);
		
		try(FileWriter w= new FileWriter(file);){
			
			if(!file.exists()){
				file.createNewFile();
			}
			
			w.write(text);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		/*Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]"); 
		for (Element image : images) { 
			System.out.println("\nsrc : " + image.attr("src")); 
			System.out.println("height : " + image.attr("height")); 
			System.out.println("width : " + image.attr("width")); 
			System.out.println("alt : " + image.attr("alt")); 
		}*/

		
	}
}
