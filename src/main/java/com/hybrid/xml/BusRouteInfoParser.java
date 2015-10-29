package com.hybrid.xml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hybrid.model.RouteInfoItem;

public class BusRouteInfoParser {

	static Log log = LogFactory.getLog(BusRouteInfoParser.class);

	DocumentBuilderFactory dfactory;
	DocumentBuilder builder;

	XPathFactory xFactory;

	TransformerFactory tFactory;

	public BusRouteInfoParser() throws ParserConfigurationException {
		dfactory = DocumentBuilderFactory.newInstance();
		builder = dfactory.newDocumentBuilder();

		xFactory = XPathFactory.newInstance();
		
		tFactory = TransformerFactory.newInstance();
	}

	public static void main(String[] args) {


		try {

			BusRouteInfoParser parser = new BusRouteInfoParser();
			List<RouteInfoItem> list = parser.getBusRouteList("6628");
			
			for(RouteInfoItem item : list){
				log.info(item.getBusRouteId());
				log.info(item.getBusRouteNm());
				log.info(item.getEdStationNm());
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		log.info("Program end...");

	}

	public List<RouteInfoItem> getBusRouteList(String strSrch) {
		log.info("getBusRouteList = " + strSrch);

		String url = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch=" + strSrch
				+ "&ServiceKey=8faAoSOaGcwudDnqo0PcEpOS7dEpeXVq8KDKAbCYnHHBM%2FBT%2FqvDKzQ6xbK1G1IIsqF6rFT5lhUPcC6CjlYeGQ%3D%3D";
		
		List<RouteInfoItem> model = new ArrayList<>();
		
		String result = null;
		try {

			// unMarshall (Deserialization)
			Document document = builder.parse(url);

			XPath xpath = xFactory.newXPath(); // 원하는 조건에 맞게 설정할 수 있는
			XPathExpression expr= xpath.compile("//itemList");
			/* expr = xpath.compile("/msgBody/itemList"); */
			
			NodeList list=(NodeList) expr.evaluate(document, XPathConstants.NODESET);

			log.info(list.getLength());
			
			for (int i = 0; i < list.getLength(); i++) {
				Element el = (Element) list.item(i);

				NodeList childs = el.getChildNodes();
				RouteInfoItem item = new RouteInfoItem();
				
				for (int j = 0; j < childs.getLength(); j++) {
					if (childs.item(j).getNodeType() == Node.ELEMENT_NODE) {
						

						if(childs.item(j).getNodeName().equals("busRouteId"))
							item.setBusRouteId(childs.item(j).getTextContent());
						if(childs.item(j).getNodeName().equals("busRouteNm"))
							item.setBusRouteNm(childs.item(j).getTextContent());
						if(childs.item(j).getNodeName().equals("edStationNm"))
							item.setEdStationNm(childs.item(j).getTextContent());
						
						
					}
					/*	
						log.info("child name = " + childs.item(j).getNodeName());
						log.info("child value = " + childs.item(j).getTextContent());
					*/
					
				}
				model.add(item);
				log.info("Element Name = "+el.getNodeName());
			}

			// Marshall (Serialization)
			tFactory.setAttribute("indent-number", 4);
			Transformer transformer = tFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource xmlSource = new DOMSource(document);

			StringWriter writer = new StringWriter();
			StreamResult outputTarget = new StreamResult(writer);
			transformer.transform(xmlSource, outputTarget);

			result = outputTarget.getWriter().toString();
			System.out.println(result);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return model;
	}

}
