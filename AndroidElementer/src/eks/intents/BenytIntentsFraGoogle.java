package eks.intents;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

/**
 *
 * @author Jacob Nordfalk
 */
public class BenytIntentsFraGoogle extends Activity implements OnClickListener {

	Button kortvisning, rutevisning, gadevisning, dokumentation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TableLayout tl = new TableLayout(this);

		kortvisning = new Button(this);
		kortvisning.setText("Vis kort");
		tl.addView(kortvisning);

		rutevisning = new Button(this);
		rutevisning.setText("Vis rute");
		tl.addView(rutevisning);

		gadevisning = new Button(this);
		gadevisning.setText("Gadevisning");
		tl.addView(gadevisning);

		dokumentation = new Button(this);
		dokumentation.setText("Dokumentation om intents");
		tl.addView(dokumentation);

		kortvisning.setOnClickListener(this);
		rutevisning.setOnClickListener(this);
		gadevisning.setOnClickListener(this);
		dokumentation.setOnClickListener(this);

		setContentView(tl);
	}

	public void onClick(View hvadBlevDerKlikketPå) {
		try {
			if (hvadBlevDerKlikketPå == kortvisning) {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("geo:55.65407,12.493775?z=3"));
				startActivity(i);
			} else if (hvadBlevDerKlikketPå == rutevisning) {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://maps.google.com/maps?saddr=55.65407,12.493775&daddr=55.66,12.5"));
				startActivity(i);
			} else if (hvadBlevDerKlikketPå == gadevisning) {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("google.streetview:cbll=55.65407,12.493775&cbp=1"));
				startActivity(i);
			} else if (hvadBlevDerKlikketPå == dokumentation) {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://developer.android.com/guide/appendix/g-app-intents.html"));
				startActivity(i);
			}
		} catch (ActivityNotFoundException e) {
			Toast.makeText(this, "Du mangler Googles udvidelser på denne telefon:\n" + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
