package io.vinnie.palette;

import android.support.v7.graphics.Palette;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vmagro on 12/2/14.
 */
public class PaletteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
//        resp.setStatus(405);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String line = null;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(req.getInputStream()));
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//        }

        BufferedImage image = null;

        String url = req.getParameter("url");
        for (Object param : req.getParameterMap().keySet()) {
            System.out.println(param);
        }
        System.out.println(url);
        if (url != null) {
            URLConnection connection = new URL(url).openConnection();
            image = ImageIO.read(connection.getInputStream());
        } else {
            image = ImageIO.read(req.getInputStream());
        }

        if (image == null) {
            resp.sendError(500, "Couldn't load image");
            return;
        }

        Palette palette = Palette.generate(image);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Palette.Swatch.class, new SwatchConverter());
        Gson gson = gsonBuilder.create();

        Map<String, Palette.Swatch> swatches = new HashMap<String, Palette.Swatch>();

        swatches.put("darkVibrant", palette.getDarkVibrantSwatch());
        swatches.put("darkMuted", palette.getDarkMutedSwatch());
        swatches.put("lightMuted", palette.getLightMutedSwatch());
        swatches.put("lightVibrant", palette.getLightVibrantSwatch());
        swatches.put("muted", palette.getMutedSwatch());
        swatches.put("vibrant", palette.getVibrantSwatch());

        resp.setContentType("application/json");
        resp.getWriter().write(gson.toJson(swatches));
    }
}
