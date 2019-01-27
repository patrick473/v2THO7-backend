package App.services;

import App.model.templatebs.Template;
import App.persistence.TemplateDAO;

import java.util.ArrayList;

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

    public ArrayList<Template> getTemplateByRuleTypeAndDatabaseType(int ruletypeid, int databasetypeid) {
        TemplateDAO tdao = new TemplateDAO();
        return tdao.getTemplateByRuleTypeAndDatabaseType(ruletypeid, databasetypeid);
    }

    public ArrayList<Template> getAllTemplates() {
        TemplateDAO tdao = new TemplateDAO();
        return tdao.getAllTemplates();
    }

    public Template getTemplate(int id){
        TemplateDAO tdao = new TemplateDAO();
        return tdao.getTemplate(id);
    }

    public boolean deleteTemplate(int id) {
        TemplateDAO tdao = new TemplateDAO();
        return tdao.deleteTemplate(id);
    }
}