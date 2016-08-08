package KosmoKos.jba.service;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;

import KosmoKos.jba.entity.Item;
import KosmoKos.jba.exception.RssEcxeption;
import KosmoKos.jba.rss.ObjectFactory;
import KosmoKos.jba.rss.TRss;
import KosmoKos.jba.rss.TRssChannel;
import KosmoKos.jba.rss.TRssItem;

@Service
public class RssService {
	
	public List<Item> getItems(File file) throws RssEcxeption{
		return getItems(new StreamSource(file));
		
	}	

	public List<Item> getItems(String url) throws RssEcxeption{
		return getItems(new StreamSource(url));
		
	}
	
	private List<Item> getItems(Source source) throws RssEcxeption{
		ArrayList<Item> list = new ArrayList<Item>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			JAXBElement<TRss> jaxbElement = unmarshaller.unmarshal(source, TRss.class);
			TRss rss = jaxbElement.getValue();
			
			List<TRssChannel> channels = rss.getChannel();
			for (TRssChannel channel : channels) {
				List<TRssItem> items = channel.getItem();
				for (TRssItem rssItem : items) {
					Item item = new Item();
					item.setTitle(rssItem.getTitle());
					item.setDescription(rssItem.getDescription());
					item.setLink(rssItem.getLink());
					Date pubDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH).parse(rssItem.getPubDate());
					item.setPublishedDate(pubDate);
					list.add(item);
				}
			}
		} catch (JAXBException e) {
			throw new RssEcxeption(e);
		} catch (ParseException e) {
			throw new RssEcxeption(e);
		}
		return list;
	}
	
}
