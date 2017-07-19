package org.hrd.sctape.sabay;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by RATHANA on 19-Jul-17.
 */
public class SabayScrape {

    public static void main(String ...args){
        SabayScrape demo= new SabayScrape();
        demo.extractContentTitle("http://news.sabay.com.kh/topics/sport","");

    }


    public Document connecting(String url){
        Document document =null;
        try{
            document = Jsoup.connect(url).get();
        }catch (Exception e){
            e.printStackTrace();
        }
        return document;
    }
    public void extractContentTitle(String url, String selector){

        Document document=this.connecting(url);
        try{
            Elements els=document.select("div.list-item");
            for(Element el : els){
                System.out.println("---------------");
                System.out.println(el.select("a[href]").attr("href"));
                System.out.println(el.select("a").select("div.title").select("span.web").text());
                System.out.println(el.select("a").select("p.detail").text());
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
