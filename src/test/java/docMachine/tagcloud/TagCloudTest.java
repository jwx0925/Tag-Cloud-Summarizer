package docMachine.tagcloud;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mcavallo.opencloud.Cloud;
import org.mcavallo.opencloud.Tag;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: avelinsk Date: 03.09.2010
 */
public class TagCloudTest {
  TagCloud tc;
  
  @Before
  public void init(){
    tc = new TagCloud();
  }

  @Test
  public void testHashMap(){
    Map<String, Double> tags = new HashMap<String, Double>();
    tags.put("CoreMedia", (double) 5);
    tags.put("content", (double) 4);
    tags.put("server", 3.5);

    double weight;
    for (Object o : tags.entrySet()) {
      Map.Entry<String,Double> entry = (Map.Entry) o;
      String word = entry.getKey();
      System.out.println(word);
      weight = entry.getValue();
      System.out.println(weight);
      Tag tag = new Tag(word, weight);
    }
  }

  @Test
  public void testTagCloud(){
    Map<String, Double> tags = new HashMap<String, Double>();
    tags.put("CoreMedia", (double) 5);
    tags.put("content", (double) 4);
    tags.put("server", 3.5);

    tc.generateCloud(5.0, 20, tags, 1.0);
    
    File dir = new File("opencloud");
    if (!dir.exists()){
      Assert.assertTrue(dir.mkdir());
    }
    File file = new File(dir,"cloud.html");
    if (!file.exists()){
      try {
        Assert.assertTrue(file.createNewFile());
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }

    tc.serializeCloud(file);

    Cloud c2 = tc.deserializeCloud(file);
    c2.getWordPattern();
  }

  @After
  public void terminate(){
    tc = null;
  }

}