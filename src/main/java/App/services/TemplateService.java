package App.services;

import App.model.templatebs.Template;

/**
 * TemplateService
 */
public class TemplateService {

    public boolean createNewTemplate(Template template){
        System.out.print(template.templatestring());
        return true;
    }
    public Template getTemplate(int id){

        Template template = new Template(1, 1, 1, "TEMPLATE");
        return template;
    }
}