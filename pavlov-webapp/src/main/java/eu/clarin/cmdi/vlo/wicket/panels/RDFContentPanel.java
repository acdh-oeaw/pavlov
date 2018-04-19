/*
 * Copyright (C) 2016 CLARIN
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package eu.clarin.cmdi.vlo.wicket.panels;

import eu.clarin.cmdi.vlo.config.FieldNameService;
import eu.clarin.cmdi.vlo.config.VloConfig;
import eu.clarin.cmdi.vlo.wicket.model.RDFVisualizerURLModel;
import eu.clarin.cmdi.vlo.wicket.model.SolrFieldStringModel;
import org.apache.solr.common.SolrDocument;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import eu.clarin.cmdi.vlo.FieldKey;

/**
 *
 * @author @author Wolfgang Walter SAUER (wowasa) &lt;wolfgang.sauer@oeaw.ac.at&gt;
 */
public class RDFContentPanel extends GenericPanel<SolrDocument> {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @SpringBean
    private FieldNameService fieldNameService;
    
    @SpringBean
    private VloConfig vloConfig;
    
    public RDFContentPanel(String id, IModel<SolrDocument> model) {
        super(id, model);
      
        WebMarkupContainer iframe = new WebMarkupContainer("rdfvisualizer");
        iframe.add(new AttributeAppender("src", new RDFVisualizerURLModel(new SolrFieldStringModel(model, fieldNameService.getFieldName(FieldKey.ID), true), vloConfig.getHomeUrl()), " "));
        //iframe.add(new AttributeAppender("scrolling", "no", " "));
        
        add(iframe);
    }
}
