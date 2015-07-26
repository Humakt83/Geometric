package fi.ukkosnetti.geometric;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import fi.ukkosnetti.geometric.content.GeomContent;
import fi.ukkosnetti.geometric.model.Geom;

/**
 * A fragment representing a single geom detail screen.
 * This fragment is either contained in a {@link GeomListActivity}
 * in two-pane mode (on tablets) or a {@link GeomDetailActivity}
 * on handsets.
 */
public class GeomDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Geom mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GeomDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = GeomContent.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geom_detail, container, false);

        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((ImageView) rootView.findViewById(R.id.geom_detail)).setImageResource(mItem.picture);
        }

        return rootView;
    }
}
