package io.vinnie.palette;

import android.support.v7.graphics.Palette;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

/**
 * Created by vmagro on 12/2/14.
 */
public class SwatchConverter implements JsonSerializer<Palette.Swatch> {

    @Override
    public JsonElement serialize(Palette.Swatch swatch, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject json = new JsonObject();
        json.addProperty("red", swatch.getRed());
        json.addProperty("green", swatch.getGreen());
        json.addProperty("blue", swatch.getBlue());

        //substring at 2 to cut off the transparency which is always ff
        json.addProperty("rgb", Integer.toHexString(swatch.getRgb()).substring(2));

        return json;
    }
}
