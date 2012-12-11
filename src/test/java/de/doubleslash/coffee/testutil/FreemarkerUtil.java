package de.doubleslash.coffee.testutil;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.log.Logger;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 */
public class FreemarkerUtil {
    private FreemarkerUtil() {
    }

    public static Document parseFreemarkerDocument(String templateLocation,
                                                   Map<String, Object> context) throws Exception {
        String results = "<root>" + getFreemarkerResults(templateLocation, context) + "</root>";
        InputStream is = new ByteArrayInputStream(results.getBytes());

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        return dBuilder.parse(is);
    }

    public static String getFreemarkerResults(String templateLocation, Map<String, Object> context) {
        try {
            Logger.selectLoggerLibrary(Logger.LIBRARY_JAVA);
            Template template = configureFreeMarker(templateLocation);
            StringWriter writer = new StringWriter();
            template.process(context, writer);
            return writer.getBuffer().toString();
        } catch (IOException | TemplateException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Template configureFreeMarker(String templateLocation) throws IOException {
        Configuration freemarkerConfig = new Configuration();

        TemplateLoader loader = new ClassTemplateLoader(FreemarkerUtil.class, "/");

        try {
            Class<?> clazz = Class.forName("org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer");
            TemplateLoader[] loaders = new TemplateLoader[2];
            loaders[0] = loader;
            loaders[1] = new ClassTemplateLoader(clazz, "");
            loader = new MultiTemplateLoader(loaders);
        } catch (ClassNotFoundException cnfe) {
            // Spring not found
        }

        freemarkerConfig.setTemplateLoader(loader);
        return freemarkerConfig.getTemplate(templateLocation);
    }
}
