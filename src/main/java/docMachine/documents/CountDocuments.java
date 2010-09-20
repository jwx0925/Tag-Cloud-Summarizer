package docMachine.documents;

import com.coremedia.cap.content.Content;

/**
 * User: avelinsk
 * Date: 02.08.2010
 *
 */
public class CountDocuments extends AbstractDocuments {
  private final static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(CountDocuments.class);
  private int counter = 0;

  @Override
  public void processText(Content content){
    counter++;
  }
  
  public int getCount(){
    log.info("Number of sections/texts: "+counter);
    
    return counter;
  }

}