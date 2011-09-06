/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Matrimony.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author TuyenDN
 */
@ManagedBean
@RequestScoped
public class MotherTongueController {

    /** Creates a new instance of MotherTongueController */
    public MotherTongueController() {
    }
    
    public List<String> getListMotherTongue() {
        List<String> list = new ArrayList<String>();
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            ExternalContext ec = faces.getExternalContext();
            String src = ec.getRealPath("/xml/mothertongue.xml");
            File fXmlFile = new File(src);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            Element docEle = doc.getDocumentElement();
            NodeList nList = docEle.getElementsByTagName("mothertongue");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element eElement = (Element) nList.item(temp);
                list.add(eElement.getTextContent());
            }
        } catch (Exception ex) {
            return null;
        }
        return list;

    }
}
