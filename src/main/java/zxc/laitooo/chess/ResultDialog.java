package zxc.laitooo.chess;

/**
 * Created by Laitooo San on 29/06/2019.
 */

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultDialog extends DialogFragment {

    String Text;

    public ResultDialog() {
    }

    @SuppressLint("ValidFragment")
    public ResultDialog(String text) {
        Text = text;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.result_dialog, null, false);
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);



        TextView score = (TextView)v.findViewById(R.id.text_result);
        Button playAgain = (Button)v.findViewById(R.id.button_result);

        score.setText(Text);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                getActivity().finish();
                getActivity().startActivity(getActivity().getIntent().
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });


        return builder.create();
    }


}
