package de.doubleslash.coffee.web;

import de.doubleslash.coffee.domain.BecherPool;
import de.doubleslash.coffee.domain.BecherPoolImpl;
import de.doubleslash.coffee.domain.KaffeeGroesse;
import de.doubleslash.coffee.testutil.FreemarkerUtil;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by IntelliJ IDEA.
 */
public class BecherPoolTemplateTest {

    @Test
    public void testBecherPool() throws Exception {
        ConcurrentHashMap<KaffeeGroesse, Integer> inventory = new ConcurrentHashMap<>();
        inventory.put(KaffeeGroesse.TASSE, 10);
        BecherPool becherPool = new BecherPoolImpl(inventory);

        Document doc = renderTemplate(becherPool);

        assertEquals("root", doc.getDocumentElement().getNodeName());
        NodeList tdNodes = doc.getElementsByTagName("td");
        for (int temp = 0; temp < tdNodes.getLength(); temp++) {

            Node nNode = tdNodes.item(temp);

            String tagId = ((Element) nNode).getAttribute("id");
            String content = nNode.getTextContent();
            if (tagId.equals("KaffeeGroesse_0")) {
                assertEquals("TASSE", content);
            } else if (tagId.equals("Anzahl_0")) {
                assertEquals("10", content);
            } else {
                fail("Wrong td tag!");
            }
        }

    }

    private Document renderTemplate(BecherPool becherPool) throws Exception {
        Map<String, Object> context = new HashMap<>();
        context.put("becherPool", becherPool);
        return FreemarkerUtil.parseFreemarkerDocument("/web/ftl/BecherPool.ftl", context);
    }
}
