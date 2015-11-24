package fi.ukkosnetti.geometric;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import fi.ukkosnetti.geometric.model.Geom;


/**
 * An activity representing a list of geoms. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link GeomDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link GeomListFragment} and the item details
 * (if present) is a {@link GeomDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link GeomListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class GeomListActivity extends Activity
        implements GeomListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geom_list);

        if (findViewById(R.id.geom_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((GeomListFragment) getFragmentManager()
                    .findFragmentById(R.id.geom_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link GeomListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(Geom geom) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putSerializable(GeomDetailFragment.ARG_ITEM_ID, geom);
            GeomDetailFragment fragment = new GeomDetailFragment();
            fragment.setArguments(arguments);
            getFragmentManager().beginTransaction()
                    .replace(R.id.geom_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, GeomDetailActivity.class);
            detailIntent.putExtra(GeomDetailFragment.ARG_ITEM_ID, geom);
            startActivity(detailIntent);
        }
    }
}
