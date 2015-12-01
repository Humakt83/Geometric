package fi.ukkosnetti.geometric.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.ukkosnetti.geometric.R;
import fi.ukkosnetti.geometric.model.Geom;

public class GeomContent {

    public static List<Geom> ITEMS = new ArrayList<>();

    public static Map<Geom.Shape, Geom> ITEM_MAP = new HashMap<>();

    static {
        addItem(new Geom(R.drawable.nelio, Geom.Shape.RECTANGLE));
        addItem(new Geom(R.drawable.kolmio, Geom.Shape.TRIANGLE));
        addItem(new Geom(R.drawable.pallo, Geom.Shape.CIRCLE));
        addItem(new Geom(R.drawable.box, Geom.Shape.BOX));
        addItem(new Geom(R.drawable.pyramid, Geom.Shape.PYRAMID));
        addItem(new Geom(R.drawable.ball, Geom.Shape.BALL));
    }

    private static void addItem(Geom item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.shape, item);
    }
}
