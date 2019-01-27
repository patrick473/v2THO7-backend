package App.services;

import App.model.templatebs.Template;
import App.persistence.TemplateDAO;

/**
 * TemplateService
 */
public class TemplateService {

    public Template createNewTemplate(Template template){
        TemplateDAO tdao = new TemplateDAO();
        if(tdao.createTemplate(template)) {
            return template;
        }
        else {
            return null;
        }
    }
    public Template getTemplate(int id){

        Template template = new Template(1, 1, 1, "TEMPLATE",false);
        return template;
    }

    public boolean deleteTemplate(int id) {
        TemplateDAO tdao = new TemplateDAO();
        return tdao.deleteTemplate(id);
    }
}