package App.templatebs.services;

import App.templatebs.model.Template;
import App.templatebs.persistence.TemplateDAO;

import java.util.ArrayList;

/**
 * TemplateService
 */
public class TemplateService {

    private TemplateDAO tdao = new TemplateDAO();

    public Template createNewTemplate(Template template){
        if(tdao.createTemplate(template)) {
            return template;
        }
        else {
            return null;
        }
    }

    public ArrayList<Template> getTemplateByRuleTypeAndDatabaseType(int ruletypeid, int databasetypeid) {
        return tdao.getTemplateByRuleTypeAndDatabaseType(ruletypeid, databasetypeid);
    }

    public ArrayList<Template> getAllTemplates() {
        return tdao.getAllTemplates();
    }

    public Template getTemplate(int id){
        return tdao.getTemplate(id);
    }

    public boolean deleteTemplate(int id) {
        return tdao.deleteTemplate(id);
    }

    public Template updateTemplate(Template template) {
        return tdao.updateTemplate(template);
    }
}