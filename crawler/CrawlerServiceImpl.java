package crawler;

import org.jsoup.Jsoup;

import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.IOException;

public class CrawlerServiceImpl implements CrawlerService{

    public void findNamesFromWeb() throws IOException{
        Document doc = Jsoup.connect(https://music.bugs.co.kr/chart).timeout
    }
    Element elems = doc.select("table.byChart");
    Iterator<Element> title = elems.select("p.title").iterator();
    Iterator<Element> artist = elems.select("p.artist").iterator();

    Iterator<Element> rank = elems.select("strong").iterator();
      while(rank.hasNext()){
          System.out.println(rank.next().text() + "위 " + artist.next().text() + " - " + title.next().text());
    }
}
