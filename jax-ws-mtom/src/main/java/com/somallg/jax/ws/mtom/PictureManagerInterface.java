package com.somallg.jax.ws.mtom;

import javax.jws.WebService;
import java.awt.*;

/**
 * Created by somallg on 12/1/14.
 */

@WebService
public interface PictureManagerInterface {
    Image retrievePicture(int inImageNumber);

    String supplyPicture(Image inImage);
}
