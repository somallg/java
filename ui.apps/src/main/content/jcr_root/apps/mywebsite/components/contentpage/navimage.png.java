package apps.mywebsite.components.contentpage;
 
import java.awt.Color; 
import java.awt.Paint; 
import java.awt.geom.Rectangle2D; 
 
import java.io.IOException;  
import javax.jcr.RepositoryException; 
  
import com.day.cq.wcm.api.Page; 
import com.day.cq.wcm.api.PageManager; 
import com.day.cq.wcm.api.components.Component; 
import com.day.cq.wcm.api.designer.Designer;
 
import com.day.cq.commons.SlingRepositoryException; 
import com.day.cq.wcm.commons.WCMUtils; 
import com.day.cq.wcm.commons.AbstractImageServlet; 
import com.day.cq.commons.ImageHelper; 
 
import com.day.image.Font; 
import com.day.image.Layer; 
 
import org.apache.sling.api.SlingHttpServletRequest; 
import org.apache.sling.api.SlingHttpServletResponse; 
import org.apache.sling.api.resource.Resource; 
import org.apache.sling.api.servlets.SlingSafeMethodsServlet; 
 
/**
  * Renders the navigation image
  */
public class navimage_png extends AbstractImageServlet {
 
      protected Layer createLayer(ImageContext ctx)
             throws RepositoryException, IOException {
         PageManager pageManager = ctx.resolver.adaptTo(PageManager.class);
         Page currentPage = pageManager.getContainingPage(ctx.resource);
 
         /* constants for image appearance */
         int scale = 6;
         int paddingX = 24;
         int paddingY = 24;
         Color bgColor = new Color(0x004a565c, true);
          
         /* obtain the page title */
         String title = currentPage.getTitle();
         if (title == null) {
             title = currentPage.getName();
         }
          
         /* format the title text */
         title = title.toUpperCase();
         Paint titleColor = Color.WHITE;
         Font titleFont = new Font("Myriad Pro", 10 * scale, Font.BOLD);
         int titleBase = 10 * scale;
 
         /* obtain and format the page subtitle */
         String subtitle = currentPage.getProperties().get("subtitle", "");
         Paint subtitleColor = new Color(0xffa9afb1, true);
         Font subTitleFont = new Font("Tahoma", 7);
         int subTitleBase = 20;
 
         /* create a layer that contains the background image from the mywebsite design */
         Designer dg = ctx.resolver.adaptTo(Designer.class);
         String imgPath = new String(dg.getDesignPath(currentPage)+"/images/navimage_bg.jpg");
         Layer bg = ImageHelper.createLayer(ctx.resolver.resolve(imgPath));
 
         /* draw the title text (4 times bigger) */
         Rectangle2D titleExtent = titleFont.getTextExtent(0, 0, 0, 0, title, Font.ALIGN_LEFT, 0, 0);
         Rectangle2D subtitleExtent = subTitleFont.getTextExtent(0, 0, 0, 0, subtitle, Font.ALIGN_LEFT, 0, 0);
 
         /* ensure subtitleExtent is wide enough */
         if ( subtitle.length() > 0 ) {
             int titleWidth = (int)titleExtent.getWidth() / scale;
             if ( subtitleExtent.getWidth() > titleWidth && subtitleExtent.getWidth() + 2 * paddingX >
 bg.getWidth() ) {
                 int charWidth = (int)subtitleExtent.getWidth() / subtitle.length();
                 int maxWidth = (bg.getWidth() > titleWidth + 2  * paddingX ? bg.getWidth() - 2 * paddingX : titleWidth);
                 int len = (maxWidth - ( 2 * charWidth) ) / charWidth;
                 subtitle = subtitle.substring(0, len) + "...";
                 subtitleExtent = subTitleFont.getTextExtent(0, 0, 0, 0, subtitle, Font.ALIGN_LEFT, 0, 0);
             }
         }
         int width = Math.max((int) titleExtent.getWidth(), (int) subtitleExtent.getWidth());
        /* create the text layer */
         Layer text = new Layer(width, (int) titleExtent.getHeight() + 40, new Color(0x01ffffff, true));
         text.setPaint(titleColor);
         text.drawText(0, titleBase, 0, 0, title, titleFont, Font.ALIGN_LEFT | Font.ALIGN_BASE, 0, 0);
         text.resize(text.getWidth() / scale, text.getHeight() / scale);
         text.setX(0);
         text.setY(0);
 
         if (subtitle.length() > 0) {
             /* draw the subtitle normal sized */
             text.setPaint(subtitleColor);
             text.drawText(0, subTitleBase, 0, 0, subtitle, subTitleFont, Font.ALIGN_LEFT | Font.ALIGN_BASE, 0, 0); 
         }
 
         /* merge the image and text layers */
         text.setY(paddingY);
         text.setX(paddingX);
         text.setBackgroundColor(bgColor);
 
         int bgWidth = bg.getWidth();
         if ( text.getWidth() + 2 * paddingX > bgWidth ) {
             bgWidth = text.getWidth() + 2 * paddingX;
             bg.resize(bgWidth, bg.getHeight());
         }
         bg.merge(text);
 
         return bg;
     }
 }