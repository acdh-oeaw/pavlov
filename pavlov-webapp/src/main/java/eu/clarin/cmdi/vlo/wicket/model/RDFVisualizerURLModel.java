package eu.clarin.cmdi.vlo.wicket.model;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.clarin.cmdi.vlo.config.FieldNameService;

/**
 * @author @author Wolfgang Walter SAUER (wowasa) &lt;wolfgang.sauer@oeaw.ac.at&gt;
 *
 */
public class RDFVisualizerURLModel extends AbstractReadOnlyModel<URL> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private static final Logger _logger = LoggerFactory.getLogger(AbstractReadOnlyModel.class);
    private IModel<String> model;
    private String homeURLString;
    
    public RDFVisualizerURLModel(IModel<String> model, String homeURLString) {
        this.model = model;
        this.homeURLString = homeURLString;
    }

    @Override
    public URL getObject() {
        String docId = model.getObject(); 
        
        
        URL url = null; 
        
        try {
            //url = new URL("http://localhost:8080/RDFVisualizer?docId={docId}&resource={docId}".replace("{docId}", URLEncoder.encode(docId, "utf-8")));
            url = new URL(this.homeURLString + "/RDFVisualizer?docId={docId}&resource={docId}".replace("{docId}", URLEncoder.encode(docId, "utf-8")));
        } catch (MalformedURLException | UnsupportedEncodingException ex) {
            // TODO Auto-generated catch block
            _logger.error("exception while generating URL for RDFVisualizer iframe", ex);
        } 

        return url;
    }


}
