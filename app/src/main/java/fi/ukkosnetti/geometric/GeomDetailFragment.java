package fi.ukkosnetti.geometric;

import android.os.Bundle;
import android.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fi.ukkosnetti.geometric.content.GeomContent;
import fi.ukkosnetti.geometric.model.Geom;
import fi.ukkosnetti.geometric.model.Shape;
import fi.ukkosnetti.geometric.model.ShapeFactory;

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

    private Geom mItem;

    private List<EditText> inputFields = new ArrayList<>();

    @Bind(R.id.valuesOutput)
    protected TextView valuesOutputView;

    @Bind(R.id.inputsLabel)
    protected TextView inputsLabel;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public GeomDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mItem = (Geom) getArguments().getSerializable(ARG_ITEM_ID);
    }

    @OnClick(R.id.calculateButton)
    public void calculate() {
        double[] arguments = new double[mItem.shape.argumentAmount];
        try {
            for (int i = 0; i < arguments.length; i++) {
                arguments[i] = Double.parseDouble(inputFields.get(i).getText().toString());
                if (arguments[i] <= 0) {
                    throw new IllegalArgumentException("All values must be greater than zero");
                }
            }
            Shape shape = ShapeFactory.generate(mItem.shape, arguments);
            valuesOutputView.setText(String.format("Perimeter: %.2f, Area: %.2f", shape.perimeter(), shape.area()));
        } catch (Exception e) {
            Toast.makeText(this.getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_geom_detail, container, false);
        ButterKnife.bind(this, rootView);
        if (mItem != null) {
            ((ImageView) rootView.findViewById(R.id.geom_detail)).setImageResource(mItem.picture);
        }
        inputsLabel.setText(mItem.shape.message);

        LinearLayout inputs = (LinearLayout) rootView.findViewById(R.id.inputFields);
        for (int i = 0; i < mItem.shape.argumentAmount; i++) {
            EditText editText = new EditText(this.getContext());
            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
            editText.setMinWidth(150);
            editText.setSingleLine();
            editText.setPadding(15, 15, 15, 15);
            inputFields.add(editText);
            inputs.addView(editText);
        }

        return rootView;
    }
}
