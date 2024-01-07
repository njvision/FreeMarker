package com.freemarker.application.FreeMarkerApplication;

import com.freemarker.application.data.Item;
import com.freemarker.application.data.Person;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class FreeMarkerRunner implements CommandLineRunner {

    @Autowired
    Configuration configuration;

    @Override
    public void run(String... args) throws Exception {
        setTemplatesPath();
        // using Maps and Objects
//        getTemplateWithData();
//        directivesOutput();
        showAuthorizedPerson();
    }

    private void getTemplateWithData() throws IOException, TemplateException {

        Template template = configuration.getTemplate("fileXml.ftl");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("title", "Sample Document");

        Map<String, String> author = new HashMap<>();
        author.put("name", "Bob Fisher");
        author.put("email", "bob.fisher@example.com");
        dataModel.put("author", author);

        dataModel.put("description", "This is a sample document.");

        // Using Map

//        List<Map<String, Object>> items = new ArrayList<>();
//        Map<String, Object> item1 = new HashMap<>();
//        item1.put("name", "Item 1");
//        item1.put("quantity", 2);
//        item1.put("price", 10.50);

        // Using Objects

        List<Item> items = new ArrayList<>();
        Item item1 = new Item("Item 1", 2, 10.50);
        items.add(item1);

        // Using Map

//        Map<String, Object> item2 = new HashMap<>();
//        item2.put("name", "Item 2");
//        item2.put("quantity", 3);
//        item2.put("price", 15.75);

        // Using Objects

        Item item2 = new Item("Item 2", 3, 15.89);
        items.add(item2);

        dataModel.put("items", items);
        StringWriter stringWriter = new StringWriter();
        template.process(dataModel, stringWriter);
        System.out.println(stringWriter.toString());
    }

    private void directivesOutput() throws IOException, TemplateException {
        Template template = configuration.getTemplate("directives.ftl");

        Map<String, Object> persons = new HashMap<>();
        List<Person> personList = List.of(
                new Person("Bob", 22, "example@mail.com", new Date()),
                new Person("Alice", 6, "example@mail.com", new Date()),
                new Person("Liman", 34, "example@mail.com", new Date()),
                new Person("Jack", 16, "example@mail.com", new Date())
        );
        persons.put("persons", personList);

        StringWriter stringWriter = new StringWriter();
        template.process(persons, stringWriter);
        System.out.println(stringWriter.toString());

    }

    private void showAuthorizedPerson() throws IOException, TemplateException {
        Template template = configuration.getTemplate("builtInFunctions.ftl");
        Map<String, Object> person = new HashMap<>();

        person.put("person", new Person("Claudiu", 35, "example@mail.com", new Date()));

        StringWriter stringWriter = new StringWriter();
        template.process(person, stringWriter);
        System.out.println(stringWriter.toString());
    }

    private void setTemplatesPath() {
        configuration.setClassForTemplateLoading(FreeMarkerRunner.class, "/templates");
    }
}

