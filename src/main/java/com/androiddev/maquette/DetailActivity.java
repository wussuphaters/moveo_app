package com.androiddev.maquette;

import android.app.Activity;
import android.media.Rating;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends Activity {
    private static String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);
        Sportif sportifDetail=(Sportif)getIntent().getSerializableExtra("sportif");
        this.description=sportifDetail.getDescription();
        ImageView pp=(ImageView)findViewById(R.id.img);
        pp.setImageResource(sportifDetail.getImage());
        TextView description=(TextView)findViewById(R.id.description);
        TextView age=(TextView)findViewById(R.id.age);
        TextView nomEtPrenom=(TextView)findViewById(R.id.nomEtPrenom);
        TextView sports=(TextView)findViewById(R.id.sports);
        makeTextViewResizable(description,3,"...Plus",true);
        nomEtPrenom.setText(sportifDetail.getPrenom()+" "+sportifDetail.getNom());
        description.setText(sportifDetail.getDescription());
        String allSports="Je pratique les sports suivants : ";
        for(String sport:sportifDetail.getSport())  {
            allSports+=sport;
            allSports+=", ";
        }
        allSports=allSports.substring(0,allSports.length()-2);
        allSports+=".";
        sports.setText(allSports);
        age.setText(sportifDetail.getAge()+" ans");
        RatingBar note=(RatingBar)findViewById(R.id.note);
        note.setRating(sportifDetail.getNote());
    }

    public static void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

        if (tv.getTag() == null) {
            tv.setTag(tv.getText());
        }
        ViewTreeObserver vto = tv.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @SuppressWarnings("deprecation")
            @Override
            public void onGlobalLayout() {
                String text;
                int lineEndIndex;
                ViewTreeObserver obs = tv.getViewTreeObserver();
                obs.removeGlobalOnLayoutListener(this);
                if (maxLine == 0) {
                    lineEndIndex = tv.getLayout().getLineEnd(0);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                    lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                    text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                } else {
                    lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                    text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                }
                tv.setText(text);
                tv.setMovementMethod(LinkMovementMethod.getInstance());
                tv.setText(
                        addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                viewMore), TextView.BufferType.SPANNABLE);
            }
        });

    }

    private static SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                            final int maxLine, final String spanableText, final boolean viewMore) {
        String str = strSpanned.toString();
        final String des=description;
        SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

        if (str.contains(spanableText)) {


            ssb.setSpan(new MySpannable(false){
                @Override
                public void onClick(View widget) {
                    tv.setLayoutParams(tv.getLayoutParams());
                    tv.setText(/*tv.getTag().toString()*/des, TextView.BufferType.SPANNABLE);
                    tv.invalidate();
                    if (viewMore) {
                        makeTextViewResizable(tv, -1, "Moins", false);
                    } else {
                        makeTextViewResizable(tv, 3, "...Plus", true);
                    }
                }
            }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

        }
        return ssb;

    }
}
